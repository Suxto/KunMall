package com.suxton.kunmall.pojo;

import java.util.Date;

public class Service {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.userID
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.lastChat
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private Date lastchat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Service.content
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.userID
     *
     * @return the value of Service.userID
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
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
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.lastChat
     *
     * @return the value of Service.lastChat
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
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
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setLastchat(Date lastchat) {
        this.lastchat = lastchat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Service.content
     *
     * @return the value of Service.content
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
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
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}