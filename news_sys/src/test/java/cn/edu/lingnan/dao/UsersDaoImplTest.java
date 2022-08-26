package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Users;
import org.junit.Test;

public class UsersDaoImplTest {

    UsersDao usersDao =  new UsersDaoImpl();

    @Test
    public void test1(){
        for (Users user : usersDao.selectAllUsers()) {
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        System.out.println(usersDao.selectUsersById(3));
    }

    @Test
    public void test3(){
        for (Users user : usersDao.selectUsersByName("user")) {
            System.out.println(user);
        }
    }

    @Test
    public void test4(){
        Users users = new Users();
        users.setUserId(2);
        users.setUsername("你好");
        users.setPassword("121321");
        System.out.println(usersDao.updateUsers(users));
    }

    @Test
    public void test5(){
        System.out.println(usersDao.deleteUsers(5));
    }

    @Test
    public void test6(){
        Users users = new Users();
        users.setUserId(5);
        users.setUsername("users5");
        users.setPassword("1213221");
        System.out.println(usersDao.insertUsers(users));
    }
}
