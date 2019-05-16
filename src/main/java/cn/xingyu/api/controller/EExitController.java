package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.EExitService;
 import cn.xingyu.domain.entity.EExit;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/eExit")
 public class EExitController extends BaseController<EExit> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(EExitController.class);
 
 	public EExitController(EExitService service) {
 		super(service);
 	}
 }

