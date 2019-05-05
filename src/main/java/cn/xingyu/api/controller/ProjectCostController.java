package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.ProjectCostService;
 import cn.xingyu.domain.entity.ProjectCost;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/projectCost")
 public class ProjectCostController extends BaseController<ProjectCost> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(ProjectCostController.class);
 
 	public ProjectCostController(ProjectCostService service) {
 		super(service);
 	}
 }

