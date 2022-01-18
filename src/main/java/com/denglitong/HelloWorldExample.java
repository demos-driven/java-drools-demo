/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package com.denglitong;

import java.util.ArrayList;

import com.denglitong.entity.HelloWorld;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static com.denglitong.entity.HelloWorld.HELLO;

public class HelloWorldExample {

  private static final String HELLO_WORLD_KSESSION_NAME = "helloworld";

  public static void main(String[] args) {
    KieServices ks = KieServices.Factory.get();
    KieContainer kc = ks.getKieClasspathContainer();
    execute(kc);
  }

  public static void execute(KieContainer kc) {
    // 获取KieSession，KieSession用来执行规则引擎
    KieSession ksession = kc.newKieSession(HELLO_WORLD_KSESSION_NAME);
    ksession.setGlobal("helloWorldList", new ArrayList<HelloWorld>());

    final HelloWorld helloWorld = new HelloWorld("Hello World", HELLO);

    ksession.insert(helloWorld);
    ksession.fireAllRules();
    ksession.dispose();
  }
}
