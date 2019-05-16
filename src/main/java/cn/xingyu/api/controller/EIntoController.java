package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.EIntoService;
 import cn.xingyu.domain.entity.EInto;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/eInto")
 public class EIntoController extends BaseController<EInto> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(EIntoController.class);
 
 	public EIntoController(EIntoService service) {
 		super(service);
 	}
 }

