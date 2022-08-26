package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.AdminDao;
import cn.edu.lingnan.dao.AdminDaoImpl;
import cn.edu.lingnan.pojo.Admin;

import java.util.Vector;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Vector<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    @Override
    public Admin selectAdminById(int id) {
        return adminDao.selectAdminById(id);
    }

    @Override
    public Vector<Admin> selectAdminByRole(int role) {
        return adminDao.selectAdminByRole(role);
    }

    @Override
    public Vector<Admin> selectAdminByName(String username) {
        return adminDao.selectAdminByName(username);
    }

    @Override
    public Vector<Admin> selectAdminByNameAndRole(String username, int role) {
        return adminDao.selectAdminByNameAndRole(username,role);
    }

    @Override
    public Admin AdminLogin(String username, String password) {
        return adminDao.AdminLogin(username,password);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminDao.deleteAdmin(id);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }
}
