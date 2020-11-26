package service;

import pojo.User;

/**
 *
 **/
public interface UserService {
    //1.注册用户
    public  void registerUser(User user);
    //2.登录用户
    public User login(User user);
    //3.注册时判断是否已存在用户名
    public boolean existsUsername(String username);
}
