package coms.ustc.sse.xdclass.service;

import coms.ustc.sse.xdclass.model.entity.User;
import coms.ustc.sse.xdclass.model.request.LoginRequest;

import java.util.Map;

public interface UserService {
    int save(Map<String,String> param);

    User login(LoginRequest request);

    User findUserById(Integer id);
}
