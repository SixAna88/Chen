package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Users;

import java.util.Vector;


/*
 * 作者： 许伟程
 * 描述： 用户的dao接口
 * */

public interface UsersDao {
    /*查询所有用户*/
    Vector<Users> selectAllUsers();

    /*根据用户编号查询*/
    Vector<Users> selectUsersById(int userId);

    /*根据用户姓名查询*/
    Vector<Users> selectUsersByName(String username);

    /*用户登录*/
    Users UsersLogin(String username ,String password);

    /*用户注册*/
    int UserRegister(String username,String password);

    /*修改用户信息*/
    int updateUsers(Users users);

    /*删除用户信息*/
    int deleteUsers(int userId);

    /*新增用户信息*/
    int insertUsers(Users users);
}
