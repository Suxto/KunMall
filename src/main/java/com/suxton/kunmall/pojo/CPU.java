package com.suxton.kunmall.pojo;

import java.math.BigDecimal;

public class CPU {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CPU.id
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CPU.money
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    private BigDecimal money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CPU.name
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CPU.amount
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    private Integer amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CPU.id
     *
     * @return the value of CPU.id
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CPU.id
     *
     * @param id the value for CPU.id
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CPU.money
     *
     * @return the value of CPU.money
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CPU.money
     *
     * @param money the value for CPU.money
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CPU.name
     *
     * @return the value of CPU.name
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CPU.name
     *
     * @param name the value for CPU.name
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CPU.amount
     *
     * @return the value of CPU.amount
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CPU.amount
     *
     * @param amount the value for CPU.amount
     *
     * @mbg.generated Fri Jul 14 19:37:29 CST 2023
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}