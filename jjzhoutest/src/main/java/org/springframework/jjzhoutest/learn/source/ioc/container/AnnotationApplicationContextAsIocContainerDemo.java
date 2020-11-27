package org.springframework.jjzhoutest.learn.source.ioc.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jjzhoutest.domain.User;

import java.util.Map;

/**
 * @author jjzhou
 * @date 2020/11/22 9:25 上午
 * @description
 */
public class AnnotationApplicationContextAsIocContainerDemo {

	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
		applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
		// 启动应用上下文
		applicationContext.refresh();
		// 依赖查找集合对象
		lookupCollectionByType(applicationContext);
		// 关闭应用上下文
		applicationContext.close();
	}

	@Bean
	public User user() {
		User user = new User();
		user.setId(1L);
		user.setName("jjzhou");
		return user;
	}

	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找到的所有的 User 集合对象：" + users);
		}
	}
}
