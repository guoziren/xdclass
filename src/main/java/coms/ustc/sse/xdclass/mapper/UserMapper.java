package coms.ustc.sse.xdclass.mapper;

import coms.ustc.sse.xdclass.model.entity.User;


public interface UserMapper {
    int save(User user);

    User findUserByPhoneAndPwd(String phone, String pwd);

    User findUserById(Integer id);
}
