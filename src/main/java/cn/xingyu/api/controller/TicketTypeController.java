package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.TicketTypeService;
 import cn.xingyu.domain.entity.TicketType;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/ticketType")
 public class TicketTypeController extends BaseController<TicketType> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(TicketTypeController.class);
 
 	public TicketTypeController(TicketTypeService service) {
 		super(service);
 	}
 }

