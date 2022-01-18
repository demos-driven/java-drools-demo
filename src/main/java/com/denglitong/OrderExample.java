/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package com.denglitong;

import java.util.Arrays;
import java.util.List;

import com.denglitong.entity.Order;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class OrderExample {

  private static final String ORDER_KSESSION_NAME = "order";

  public static void main(String[] args) {
    KieServices ks = KieServices.Factory.get();
    KieContainer kc = ks.getKieClasspathContainer();
    execute(kc);
  }

  public static void execute(KieContainer kc) {
    // 获取KieSession，KieSession用来执行规则引擎
    KieSession ksession = kc.newKieSession(ORDER_KSESSION_NAME);
    List<Order> orderList = getInitData();
    for (int i = 0; i < orderList.size(); i++) {
      Order order = orderList.get(i);
      ksession.insert(order);
      ksession.fireAllRules();
      addScore(order);
    }
    ksession.dispose();
  }

  private static List<Order> getInitData() {
    return Arrays.asList(
        new Order("user-1", 100, 0),
        new Order("user-2", 200, 0),
        new Order("user-3", 500, 0),
        new Order("user-4", 1000, 0),
        new Order("user-5", 1200, 0)
    );
  }

  private static void addScore(Order o) {
    System.out.println("订单 " + o + " 享受额外增加积分: " + o.getScore());
  }
}
