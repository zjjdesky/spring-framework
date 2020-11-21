package org.springframework.jjzhoutest.check;

/**
 * @author jjzhou
 * @date 2020/11/21 3:41 下午
 * @description
 */
public class SysUser {

	private String username;

	private String password;

	public SysUser() {
	}

	public SysUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
