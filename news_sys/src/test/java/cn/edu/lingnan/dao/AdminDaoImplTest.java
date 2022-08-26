package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Admin;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
public class AdminDaoImplTest {


    AdminDao adminDao = new AdminDaoImpl();

    @Test
    public void test1() {
        for (Admin admin : adminDao.selectAllAdmin()) {
            System.out.println(admin.toString());
        }
    }

    @Test
    public void test2(){
        System.out.println(adminDao.selectAdminById(1));
    }

    @Test
    public void test3(){
        for (Admin admin : adminDao.selectAdminByRole(1)) {
            System.out.println(admin.toString());
        }
    }

    @Test
    public void test4(){
        for (Admin admin : adminDao.selectAdminByName("管理员")) {
            System.out.println(admin.toString());
        }
    }

    @Test
    public void test5() throws ParseException {
        Admin admin = new Admin();
        admin.setId(2);
        admin.setUsername("admin2");
        admin.setPassword("111");
        admin.setRole(0);
        admin.setCreateDate(Date.valueOf("2022-04-10"));
        System.out.println(adminDao.updateAdmin(admin));
    }

    @Test
    public void test6(){
        System.out.println(adminDao.deleteAdmin(4));
    }


    @Test
    public void test7(){
        Admin admin = new Admin();
        admin.setId(5);
        admin.setUsername("admin5");
        admin.setPassword("111");
        admin.setRole(1);
        admin.setCreateDate(Date.valueOf("2022-04-10"));
        System.out.println(adminDao.insertAdmin(admin));
    }

    @Test
    public void test8(){
        System.out.println(adminDao.AdminLogin("admin", "111"));
    }
}
