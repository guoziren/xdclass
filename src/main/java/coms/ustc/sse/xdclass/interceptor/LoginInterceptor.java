package coms.ustc.sse.xdclass.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import coms.ustc.sse.xdclass.controller.UserController;
import coms.ustc.sse.xdclass.utils.JsonData;
import coms.ustc.sse.xdclass.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======================================================>拦截");
        String token = request.getHeader("token");
        try {
            if (StringUtils.isEmpty(token)) {
                token = (String) request.getAttribute("token");
            }
            if (!StringUtils.isEmpty(token)) {

                Claims claims = JwtUtil.checkJWT(token);
                if (claims != null) {
                    request.setAttribute(UserController.USER_ID, claims.get(UserController.USER_ID));
                    request.setAttribute("name", claims.get("name"));
                    return true;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        sendJsonMsg(response, JsonData.buildError("登录失败， 请重试"));
        return false;
    }

    private void sendJsonMsg(HttpServletResponse response, Object o) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(o);
        response.setContentType("application/json;charset=utf8");
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.close();
        response.flushBuffer();
    }
}
