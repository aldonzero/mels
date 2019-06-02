package cn.xingyu.api.service.impl;


import cn.xingyu.api.service.ProjectService;
import cn.xingyu.domain.entity.Project;
import cn.xingyu.infra.utils.ServletUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project>
        implements ProjectService {
    @Override
    public Example getExample(Example e, Project project) {
        Example.Criteria criteria = e.createCriteria();
        if (project.getNo() != null && project.getNo().length() != 0){
            criteria.andLike("no","%"+project.getNo()+"%");
        }

        return super.getExample(e,project);
    }

    @Override
    public Integer audit(Project project) {
        Long userId = (Long) ServletUtil.getRequest().getSession().getAttribute("userId");
        if(userId == null){
            throw new cn.xingyu.domain.exception.LoginException(401,"未登录或登录已经过期");
        }
        project.setAuditUser(userId);
        project.setAuditDate(new Date());
        return super.audit(project);
    }

}
