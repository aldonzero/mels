package cn.xingyu.infra.config;

import cn.xingyu.domain.exception.AuthorityException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(AuthorityException.class)
    @ResponseBody
    private void jsonErrorHandler(HttpServletRequest req, AuthorityException e, HttpServletResponse response) throws Exception {
       response.setStatus(403);
       response.getWriter().append("权限不足");
    }
}
