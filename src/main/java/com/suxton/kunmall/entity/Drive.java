package com.suxton.kunmall.entity;

import java.math.BigDecimal;

public class Drive {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Drive.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Drive.money
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private BigDecimal money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Drive.name
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Drive.amount
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    private Integer amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Drive.id
     *
     * @return the value of Drive.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Drive.id
     *
     * @param id the value for Drive.id
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Drive.money
     *
     * @return the value of Drive.money
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Drive.money
     *
     * @param money the value for Drive.money
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Drive.name
     *
     * @return the value of Drive.name
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Drive.name
     *
     * @param name the value for Drive.name
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Drive.amount
     *
     * @return the value of Drive.amount
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Drive.amount
     *
     * @param amount the value for Drive.amount
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}