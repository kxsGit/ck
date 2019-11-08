package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author kx
 * @since 2019-09-19
 */
@Component
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 账号
     */
	private String ccode;
    /**
     * 密码
     */
	private String password;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "User{" +
			", id=" + id +
			", ccode=" + ccode +
			", password=" + password +
			"}";
	}
}
