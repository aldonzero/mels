package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.PermissionService;
import cn.xingyu.domain.entity.Pagination;
import cn.xingyu.domain.entity.Permission;
import cn.xingyu.domain.entity.PermissionEVO;
import cn.xingyu.domain.entity.result.PageResult;
import cn.xingyu.infra.mapper.PermissionMapper;
import cn.xingyu.infra.utils.Evo;
import cn.xingyu.infra.utils.Property;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission>
        implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public PageResult list(Pagination<Permission> pagination, Permission permission) {
        Example e = new Example(Permission.class);
        Example.Criteria criteria = e.createCriteria();

        if(permission.getParentid() != null && permission.getParentid() == 0){
            criteria.andCondition("parentid is null");
            criteria.orEqualTo("parentid",0);
        }

        PageResult pageResult = new PageResult();
        Property property = new Property();
        PageHelper.startPage(pagination.getPage(), pagination.getPageSize(), pagination.getSort());
        PageHelper.orderBy(pagination.getOrderBy() == null ? "sort" : pagination.getOrderBy());

        List<Permission> permissionList = permissionMapper.selectByExample(e);

        List<PermissionEVO> permissionEVOS = new ArrayList<>();
        for (Permission permission1: permissionList){
            permissionEVOS.add((PermissionEVO) Evo.toEvo(new PermissionEVO(),permission1));
        }
        pageResult.setList(listToTree(permissionEVOS));

        return pageResult;
    }

    private  List<PermissionEVO> listToTree(List<PermissionEVO> list) {
        List<PermissionEVO> treeList = new ArrayList<PermissionEVO>();
        for (PermissionEVO tree : list) {
            //找到根
            if (tree.getParentid() ==  null || tree.getParentid() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (PermissionEVO treeNode : list) {
                if (treeNode.getParentid() == tree.getId()) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<PermissionEVO>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

}

