package cn.xingyu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionController {
    @RequestMapping("/404")
    public String catchException() {
        return "404";
    }

    @RequestMapping("/500")
    public String showServerError() {
        return "500";
    }

    @RequestMapping("/403")
    public void authorityException(HttpServletResponse response) throws IOException {
        response.setStatus(403);
        response.getWriter().append("权限不足");
    }

}
