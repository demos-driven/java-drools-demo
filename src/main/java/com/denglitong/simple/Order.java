/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package com.denglitong.simple;

public class Order {

  private String userName;
  private Integer amount;
  private Integer score;

  public Order(String userName, Integer amount, Integer score) {
    this.userName = userName;
    this.amount = amount;
    this.score = score;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Order{" +
        "userName='" + userName + '\'' +
        ", amount=" + amount +
        '}';
  }
}
