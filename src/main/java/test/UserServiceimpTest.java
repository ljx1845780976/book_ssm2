//package test;
//
//import org.junit.Test;
//import pojo.User;
//import service.UserService;
//import service.UserServiceimp;
//
//import static org.junit.Assert.*;
//
///**
// *
// **/
//public class UserServiceimpTest {
//
//    @Test
//    public void registerUser() {
//        UserService userService=new UserServiceimp();
//        userService.registerUser(new User( null,"rose","ljx123","123@163.com"));
//    }
//
//    @Test
//    public void login() {
//        UserService userService=new UserServiceimp();
//        System.out.println( userService.login(new User(null,"jack","qq123456",null)));
//    }
//
//    @Test
//    public void existsUsername() {
//        UserService userService=new UserServiceimp();
//        System.out.println(userService.existsUsername("rose"));
//    }
//}