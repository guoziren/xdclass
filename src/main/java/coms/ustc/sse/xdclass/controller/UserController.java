package coms.ustc.sse.xdclass.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import coms.ustc.sse.xdclass.model.entity.User;
import coms.ustc.sse.xdclass.model.request.LoginRequest;
import coms.ustc.sse.xdclass.service.UserService;
import coms.ustc.sse.xdclass.utils.JsonData;
import coms.ustc.sse.xdclass.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
    private UserService userService;
    public static final String USER_ID = "user_id";

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        System.out.println(userInfo);
        int result = userService.save(userInfo);
        if (result == 1) {
            return JsonData.bulidSuccess();
        }else {
            return JsonData.buildError("注册失败");
        }
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest request){
        User user = userService.login(request);
        if (user != null){
            return JsonData.bulidSuccess(JwtUtil.geneJsonWebToken(user));
        } else {
            return JsonData.buildError("登录失败");
        }
    }

    @GetMapping("find_user_by_token")
    public JsonData findUserByToken(HttpServletRequest request){
        Integer id = (Integer) request.getAttribute(USER_ID);
       if (id == null) {
           return JsonData.buildError("登录过期");
       }else{
           User user = userService.findUserById(id);
           if (user != null){
               return JsonData.bulidSuccess(user);
           } else{
               return JsonData.buildError("用户不存在");
           }
       }
    }
}
