/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Mentor {

    private int id;
    private String email;
    private String fullname;
    private String address;
    private String phone;
    private Date dob;
    private String sex;
    private String profession;
    private String professionIntro;
    private String serviceDesc;
    private String achievementDesc;
    private String framework;
    private String avatar;
    private String job;
    private String introduction;

    public Mentor(int id, String email, String fullname, String address, String phone, Date dob, String sex, String profession, String professionIntro, String serviceDesc, String achievementDesc, String framework, String avatar, String job, String introduction) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.sex = sex;
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDesc = serviceDesc;
        this.achievementDesc = achievementDesc;
        this.framework = framework;
        this.avatar = avatar;
        this.job = job;
        this.introduction = introduction;
    }

    public Mentor() {
    }

    public Mentor(int id, String fullname, String serviceDesc, String avatar) {
        this.id = id;
        this.fullname = fullname;
        this.serviceDesc = serviceDesc;
        this.avatar = avatar;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessionIntro() {
        return professionIntro;
    }

    public void setProfessionIntro(String professionIntro) {
        this.professionIntro = professionIntro;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getAchievementDesc() {
        return achievementDesc;
    }

    public void setAchievementDesc(String achievementDesc) {
        this.achievementDesc = achievementDesc;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
    
}    