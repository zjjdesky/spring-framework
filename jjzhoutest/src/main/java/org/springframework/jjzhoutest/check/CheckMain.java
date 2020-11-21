package org.springframework.jjzhoutest.check;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jjzhou
 * @date 2020/11/21 3:43 下午
 * @description
 */
public class CheckMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SysConfig.class);
		SysUser sysUser = (SysUser) ac.getBean("sysUser");
		System.out.println(sysUser.getUsername());
		System.out.println(sysUser.getPassword());
	}
}
