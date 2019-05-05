package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.WorkingService;
 import cn.xingyu.domain.entity.Working;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/working")
 public class WorkingController extends BaseController<Working> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(WorkingController.class);
 
 	public WorkingController(WorkingService service) {
 		super(service);
 	}
 }

