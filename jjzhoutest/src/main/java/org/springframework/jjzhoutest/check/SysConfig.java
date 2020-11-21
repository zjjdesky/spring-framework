package org.springframework.jjzhoutest.check;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jjzhou
 * @date 2020/11/21 3:42 下午
 * @description
 */
@Configuration
public class SysConfig {

	@Bean
	public SysUser sysUser() {
		return new SysUser("jjzhou", "test");
	}
}
