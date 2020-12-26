package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.model.entity.User;
import coms.ustc.sse.xdclass.mapper.UserMapper;
import coms.ustc.sse.xdclass.model.request.LoginRequest;
import coms.ustc.sse.xdclass.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(Map<String, String> param) {
        if (param.containsKey("name") && param.containsKey("pwd") && param.containsKey("phone")){
            User user = new User();
            user.setHeadImg(CommonUtil.generateHeadImg());
            user.setName(param.get("name"));
            user.setPwd(CommonUtil.MD5(param.get("pwd")));
            user.setPhone(param.get("phone"));
            user.setCreateTime(new Date());
            return userMapper.save(user);
        }
        System.out.println("缺少参数");
        return -1;
    }

    @Override
    public User login(LoginRequest request) {
        String phone = request.getPhone();
        String pwd = request.getPwd();
        User user = userMapper.findUserByPhoneAndPwd(phone, CommonUtil.MD5(pwd));
        System.out.println(user);
        return user;
    }

    @Override
    public User findUserById(Integer id) {
        return  userMapper.findUserById(id);
    }
}
