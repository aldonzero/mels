package cn.xingyu.domain.exception;

public class LoginException extends RuntimeException {
    private Integer status;

    public LoginException(Integer status,String message){
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
