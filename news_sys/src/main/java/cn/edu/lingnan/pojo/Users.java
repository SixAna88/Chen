package cn.edu.lingnan.pojo;

import java.sql.Date;


/*
 * 作者： 许伟程
 * 描述： 用户实体对象
 * 方法： 无参构造、有参构造、全参构造、get和set方法、toString方法
 * */

public class Users{
    private Integer userId;
    private String username;
    private String password;
    private String userPhone;
    private Integer userAge;
    private Date birth;
    private String remark;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, String userPhone, Integer userAge, Date birth) {
        this.username = username;
        this.password = password;
        this.userPhone = userPhone;
        this.userAge = userAge;
        this.birth = birth;
    }

    public Users(Integer userId, String username, String password, String userPhone, Integer userAge, Date birth, String remark) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userPhone = userPhone;
        this.userAge = userAge;
        this.birth = birth;
        this.remark = remark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAge=" + userAge +
                ", birth=" + birth +
                ", remark='" + remark + '\'' +
                '}';
    }
}
