package com.suxton.kunmall.pojo;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Comment.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Comment.user_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Comment.user_name
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Comment.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private Integer momentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Comment.content
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Comment.id
     *
     * @return the value of Comment.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Comment.id
     *
     * @param id the value for Comment.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Comment.user_id
     *
     * @return the value of Comment.user_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Comment.user_id
     *
     * @param userId the value for Comment.user_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Comment.user_name
     *
     * @return the value of Comment.user_name
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Comment.user_name
     *
     * @param userName the value for Comment.user_name
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Comment.moment_id
     *
     * @return the value of Comment.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public Integer getMomentId() {
        return momentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Comment.moment_id
     *
     * @param momentId the value for Comment.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Comment.content
     *
     * @return the value of Comment.content
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Comment.content
     *
     * @param content the value for Comment.content
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}