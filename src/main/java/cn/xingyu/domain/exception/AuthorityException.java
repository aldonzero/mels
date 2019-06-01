package cn.xingyu.domain.exception;

public class AuthorityException extends RuntimeException {
    private Integer status;

    public AuthorityException(Integer status,String message){
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
