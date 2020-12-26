package coms.ustc.sse.xdclass.exception;

import coms.ustc.sse.xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class XDExceptionHandler {
  @ExceptionHandler( value = Exception.class)
  @ResponseBody
  public JsonData handler(Exception e) {
        if (e instanceof XDException) {
            XDException xdException = (XDException) e;
            return JsonData.buildError(xdException.getCode(), xdException.getMsg());
        } else {
            return JsonData.buildError(" 全局异常 未知错误");
        }
  }
}
