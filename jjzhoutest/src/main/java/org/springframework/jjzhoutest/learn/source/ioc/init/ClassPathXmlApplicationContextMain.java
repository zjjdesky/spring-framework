package org.springframework.jjzhoutest.learn.source.ioc.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jjzhou
 * @date 2020/11/21 10:01 下午
 * @description
 */
public class ClassPathXmlApplicationContextMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/application.xml");
		MyTestBean myTestBean = (MyTestBean) context.getBean("myTestBean");
		System.out.println(myTestBean.getName());
	}
}
