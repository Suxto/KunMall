package com.suxton.kunmall.pojo;

import java.math.BigDecimal;

public class Memory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Memory.id
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Memory.money
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    private BigDecimal money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Memory.name
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Memory.amount
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    private Integer amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Memory.id
     *
     * @return the value of Memory.id
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Memory.id
     *
     * @param id the value for Memory.id
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Memory.money
     *
     * @return the value of Memory.money
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Memory.money
     *
     * @param money the value for Memory.money
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Memory.name
     *
     * @return the value of Memory.name
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Memory.name
     *
     * @param name the value for Memory.name
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Memory.amount
     *
     * @return the value of Memory.amount
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Memory.amount
     *
     * @param amount the value for Memory.amount
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}