package com.suxton.kunmall.pojo;

import java.util.Date;

public class Service {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.userID
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.userName
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.content
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.status
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    private Short status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.lastChat
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    private Date lastchat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.userID
     *
     * @return the value of Service.userID
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Service.userID
     *
     * @param userid the value for Service.userID
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.userName
     *
     * @return the value of Service.userName
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Service.userName
     *
     * @param username the value for Service.userName
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.content
     *
     * @return the value of Service.content
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Service.content
     *
     * @param content the value for Service.content
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.status
     *
     * @return the value of Service.status
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Service.status
     *
     * @param status the value for Service.status
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.lastChat
     *
     * @return the value of Service.lastChat
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public Date getLastchat() {
        return lastchat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Service.lastChat
     *
     * @param lastchat the value for Service.lastChat
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    public void setLastchat(Date lastchat) {
        this.lastchat = lastchat;
    }
}