package com.example.demo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kx
 * @since 2019-11-08
 */
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 账号
     */
	private String ccode;
    /**
     * 密码
     */
	private String password;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TUser{" +
			", id=" + id +
			", ccode=" + ccode +
			", password=" + password +
			"}";
	}
}
