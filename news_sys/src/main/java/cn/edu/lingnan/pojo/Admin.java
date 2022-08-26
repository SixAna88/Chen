package cn.edu.lingnan.pojo;

import java.sql.Date;

/*
* 作者： 许伟程
* 描述： 管理员实体对象
* 方法： 无参构造、有参构造、全参构造、get和set方法、toString方法
* */

public class Admin {
    private Integer id;        //管理员编号
    private String username;  //管理员姓名
    private String password;  //管理员密码
    private Integer role;     //管理员角色
    private java.sql.Date createDate; //管理员创建日期
    private String mail;      //管理员邮箱
    private String phone;     //管理员电话号码
    private Integer age;      //管理员年龄
    private String remark1;  //备注1
    private String remark2;  //备注2
    private String remark3;  //备注3

    public Admin() {
    }

    /*通过用户名跟密码实例化一个管理员对象*/
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*通过用户名、密码、角色、创建日期实例化一个管理员对象*/
    public Admin(String username, String password, Integer role, Date createDate) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
    }

    /*通过编号、用户名、密码、角色、创建日期实例化一个管理员对象*/
    public Admin(Integer id, String username, String password, Integer role, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
    }

    /*全参的构造方法*/
    public Admin(Integer id, String username, String password, Integer role, Date createDate, String mail, String phone, Integer age, String remark1, String remark2, String remark3) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
        this.mail = mail;
        this.phone = phone;
        this.age = age;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", createDate=" + createDate +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", remark3='" + remark3 + '\'' +
                '}';
    }
}
