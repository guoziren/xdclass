package coms.ustc.sse.xdclass.exception;

public class XDException extends RuntimeException{
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "XDException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
