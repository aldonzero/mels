package cn.xingyu.domain.entity.result;

public enum ResultStatus {
    INSERT_SUCCESS(201, "新增成功"),
    UPDATE_SUCCESS(201, "修改成功"),
    AUDIT_SUCCESS(201, "审核成功"),
    DELETE_SUCCESS(204, "删除成功"),
    GET_SUCCESS(200,"获取数据成功");

    /**
     * 返回状态码
     */
    private int statusCode;
    /**
     * 返回状态信息
     */
    private String statusMsg;

    ResultStatus(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return the statusMsg
     */
    public String getStatusMsg() {
        return statusMsg;
    }
}
