package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Admin;

import java.util.Vector;

/*
 * 作者： 许伟程
 * 描述： 管理员的dao接口
 * */

public interface AdminDao {


    /*查询所有管理员*/
    Vector<Admin> selectAllAdmin();

    /*根据管理员编号查询*/
    Admin selectAdminById(int id);

    /*根据管理员角色查询*/
    Vector<Admin> selectAdminByRole(int role);

    /*根据管理员姓名查询*/
    Vector<Admin> selectAdminByName(String username);


    /*根据管理员姓名+身份查询*/
    Vector<Admin> selectAdminByNameAndRole(String username,int role);

    /*管理员登录*/
    Admin AdminLogin(String username ,String password);

    /*修改管理员信息*/
    int updateAdmin(Admin admin);

    /*删除管理员信息*/
    int deleteAdmin(int id);

    /*新增管理员信息*/
    int insertAdmin(Admin admin);
}
