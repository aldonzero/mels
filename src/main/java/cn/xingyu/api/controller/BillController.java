package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.BillService;
 import cn.xingyu.domain.entity.Bill;
 import cn.xingyu.domain.entity.Pagination;
 import cn.xingyu.domain.entity.result.PageResult;
 import cn.xingyu.domain.entity.result.Result;
 import cn.xingyu.domain.entity.result.ResultStatus;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.Date;

@RestController
 @RequestMapping("/bill")
 public class BillController extends BaseController<Bill> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(BillController.class);

 	private BillService service;

 	public BillController(BillService service) {
 		super(service);
 		this.service = service;
 	}

     @GetMapping("/chart/{year}")
     public Result listChart(@PathVariable("year") String year) {
 	    logger.info("list chart year is :"+year);
         Result result = new Result();
         result.setData(service.listChart(year));
         result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
         result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
         return result;
     }
 }

