package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.TicketService;
 import cn.xingyu.domain.entity.Ticket;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 @RestController
 @RequestMapping("/ticket")
 public class TicketController extends BaseController<Ticket> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(TicketController.class);
 
 	public TicketController(TicketService service) {
 		super(service);
 	}
 }

