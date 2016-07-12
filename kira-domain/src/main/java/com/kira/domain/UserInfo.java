package com.kira.domain;
import com.kira.domain.SexEnum;


import java.io.Serializable;

public class UserInfo implements Serializable{
    private static final long serialVersionUID = -4802112918807753650L;
    /**
     * 自增id
     */
    private int id;
    /**
     * 登陆账号
     */
    private String username;
    /**
     *密码
     */
    private String password;
    /**
     * 验证码
     */
    private String verificationCode;
    /**
     * 移动电话
     */
    private String phoneNumber;
    /**
     *性别
     */
    private int sex = SexEnum.MALE.key;
    /**
     * 生日
     */
    private String birthday = "1900-01-01";
    /**
     * 邮箱
     */
    private  String email;
    /**
     * 生肖
     */
    private int Chinese_Zodiac;
    /**
     * 星座
     */
    private int constellation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChinese_Zodiac() {
        return Chinese_Zodiac;
    }

    public void setChinese_Zodiac(int chinese_Zodiac) {
        Chinese_Zodiac = chinese_Zodiac;
    }

    public int getConstellation() {
        return constellation;
    }

    public void setConstellation(int constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", Chinese_Zodiac=" + Chinese_Zodiac +
                ", constellation=" + constellation +
                '}';
    }
}