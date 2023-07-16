package com.suxton.kunmall.pojo;


import java.math.BigDecimal;
import java.util.Date;


public class UserConsumed {
    private Long userID;
    private Date latestOrder;
    private Integer consumeTime;
    private BigDecimal money;
    private String userName;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(Date latestOrder) {
        this.latestOrder = latestOrder;
    }

    public Integer getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Integer consumeTime) {
        this.consumeTime = consumeTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

   public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
