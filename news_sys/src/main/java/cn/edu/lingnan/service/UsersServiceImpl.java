package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.UsersDao;
import cn.edu.lingnan.dao.UsersDaoImpl;
import cn.edu.lingnan.pojo.Users;

import java.util.Vector;

public class UsersServiceImpl  implements UsersService{
    UsersDao usersDao = new UsersDaoImpl();

    @Override
    public Vector<Users> selectAllUsers() {
        return usersDao.selectAllUsers();
    }

    @Override
    public Vector<Users> selectUsersById(int userId) {
        return usersDao.selectUsersById(userId);
    }

    @Override
    public Vector<Users> selectUsersByName(String username) {
        return usersDao.selectUsersByName(username);
    }

    @Override
    public Users UsersLogin(String username, String password) {
        return usersDao.UsersLogin(username, password);
    }

    @Override
    public int UserRegister(String username, String password) {
        return usersDao.UserRegister(username,password);
    }

    @Override
    public int updateUsers(Users users) {
        return usersDao.updateUsers(users);
    }

    @Override
    public int deleteUsers(int userId) {
        return usersDao.deleteUsers(userId);
    }

    @Override
    public int insertUsers(Users users) {
        return usersDao.insertUsers(users);
    }
}
