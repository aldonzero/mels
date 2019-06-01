package cn.xingyu.api.controller;
 
 import ch.qos.logback.classic.Logger;
 import cn.xingyu.api.service.TicketService;
 import cn.xingyu.domain.entity.Pagination;
 import cn.xingyu.domain.entity.Ticket;
 import cn.xingyu.domain.entity.result.PageResult;
 import cn.xingyu.domain.entity.result.Result;
 import cn.xingyu.domain.entity.result.ResultStatus;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import javax.servlet.http.HttpServletRequest;
 import java.util.HashMap;

@RestController
 @RequestMapping("/ticket")
 public class TicketController extends BaseController<Ticket> {
 	private Logger logger = (Logger) LoggerFactory.getLogger(TicketController.class);

 	private TicketService service;

 	public TicketController(TicketService service) {
 		super(service);
 		this.service = service;
 	}

    @Override
    public Result list(Pagination<Ticket> pagination, Ticket ticket, HttpServletRequest request) {
        pagination.setT(ticket);
        HashMap<String, Object> params = new HashMap<>();
        params.put("pageSize", pagination.getPageSize());
        params.put("projectName", request.getParameter("projectName"));
        params.put("ticketType", request.getParameter("ticketType"));


        Result result = new Result();
        PageResult pageResult = service.list(pagination, params);
        pageResult.setCurrent(pagination.getPage());
        pageResult.setPageSize(pagination.getPageSize());
        result.setData(pageResult);
        result.setCode(ResultStatus.GET_SUCCESS.getStatusCode());
        result.setMsg(ResultStatus.GET_SUCCESS.getStatusMsg());
        return result;
    }

 }

