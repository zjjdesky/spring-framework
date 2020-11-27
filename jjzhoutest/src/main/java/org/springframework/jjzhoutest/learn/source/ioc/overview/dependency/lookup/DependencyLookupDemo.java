package org.springframework.jjzhoutest.learn.source.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jjzhoutest.domain.User;
import org.springframework.jjzhoutest.learn.source.ioc.annotation.Super;

import java.util.Map;

/**
 * @author jjzhou
 * @date 2020/11/27 7:57 上午
 * @description 依赖查找
 */
public class DependencyLookupDemo {

	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/ioc/dependency-lookup-context.xml");
		// 按照类型查找
		lookupByType(beanFactory);
		// 按照类型查找结合对象
		lookupCollectionByType(beanFactory);
		// 通过注解查找对象
		lookupByAnnotationType(beanFactory);

//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
	}


	@SuppressWarnings("unchecked")
	private static void lookupByAnnotationType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
			System.out.println("查找标注 @Super 所有的 User 集合对象：" + users);
		}
	}

	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找到的所有的 User 集合对象：" + users);
		}
	}

	private static void lookupByType(BeanFactory beanFactory) {
		User user = beanFactory.getBean(User.class);
		System.out.println("实时查找：" + user);
	}

	@SuppressWarnings("unchecked")
	private static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
		User user = objectFactory.getObject();
		System.out.println("延迟查找：" + user);
	}

	private static void lookupInRealTime(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user");
		System.out.println("实时查找：" + user);
	}
}
