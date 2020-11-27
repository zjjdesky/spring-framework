package org.springframework.jjzhoutest.domain;

import org.springframework.jjzhoutest.learn.source.ioc.annotation.Super;

/**
 * @author jjzhou
 * @date 2020/11/22 8:26 上午
 * @description
 */
@Super
public class SuperUser extends User {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
