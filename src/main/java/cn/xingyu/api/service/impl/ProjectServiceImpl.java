package cn.xingyu.api.service.impl;


import cn.xingyu.api.service.ProjectService;
import cn.xingyu.domain.entity.Project;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

}
