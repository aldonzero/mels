package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.BillService;
 import cn.xingyu.domain.entity.Bill;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/bill")
 public class BillController extends BaseController<Bill> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(BillController.class);
 
 	public BillController(BillService service) {
 		super(service);
 	}
 }

