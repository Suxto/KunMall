package com.suxton.kunmall.entity;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Users.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Users.isAdmin
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private Boolean isadmin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Users.passwd
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private String passwd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.id
     *
     * @return the value of Users.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.id
     *
     * @param id the value for Users.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.isAdmin
     *
     * @return the value of Users.isAdmin
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public Boolean getIsadmin() {
        return isadmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.isAdmin
     *
     * @param isadmin the value for Users.isAdmin
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Users.passwd
     *
     * @return the value of Users.passwd
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Users.passwd
     *
     * @param passwd the value for Users.passwd
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }
}