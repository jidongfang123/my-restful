package com.kdxc.myrestful.pojo;

public class Users {
    private int uid;

    private String name;

    private String pwd;

    private int sex;

    private int age;

    private String phone;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pwd=" + pwd +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
