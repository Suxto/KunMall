package com.suxton.kunmall.pojo;

import java.math.BigDecimal;

public class GPU {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GPU.id
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GPU.money
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private BigDecimal money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GPU.name
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GPU.amount
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    private Integer amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GPU.id
     *
     * @return the value of GPU.id
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GPU.id
     *
     * @param id the value for GPU.id
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GPU.money
     *
     * @return the value of GPU.money
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GPU.money
     *
     * @param money the value for GPU.money
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GPU.name
     *
     * @return the value of GPU.name
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GPU.name
     *
     * @param name the value for GPU.name
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GPU.amount
     *
     * @return the value of GPU.amount
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GPU.amount
     *
     * @param amount the value for GPU.amount
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}