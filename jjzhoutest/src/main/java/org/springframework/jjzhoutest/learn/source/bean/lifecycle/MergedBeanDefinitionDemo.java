package org.springframework.jjzhoutest.learn.source.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jjzhoutest.domain.User;

/**
 * @author jjzhou
 * @date 2020/11/22 11:25 上午
 * @description
 */
public class MergedBeanDefinitionDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 基于 XML 资源 BeanDefinitionReader 实现
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		String location = "ioc/dependency-lookup-context.xml";
		// 基于 ClassPath 加载 XML 资源
		Resource resource = new ClassPathResource(location);
		// 指定字符编码 UTF-8
		EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
		int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);
		System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
		// 通过 Bean Id 和类型进行依赖查找
		User user = beanFactory.getBean("user", User.class);
		System.out.println(user);

		User superUser = beanFactory.getBean("superUser", User.class);
		System.out.println(superUser);
	}
}
