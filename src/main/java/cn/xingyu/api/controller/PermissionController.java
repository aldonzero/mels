package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.PermissionService;
 import cn.xingyu.domain.entity.Permission;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/permission")
 public class PermissionController extends BaseController<Permission> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(PermissionController.class);
 
 	public PermissionController(PermissionService service) {
 		super(service);
 	}
 }

