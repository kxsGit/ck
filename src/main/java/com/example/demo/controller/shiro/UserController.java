package com.example.demo.controller.shiro;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.shiro.IUserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kx
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService sss;
	@RequestMapping("/queryUser")
	public Map queryUser(){
		Map maps = sss.queryUser();
		return maps;
	}
}
