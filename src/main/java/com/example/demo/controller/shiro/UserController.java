package com.example.demo.controller.shiro;


import com.example.demo.entity.TUser;
import com.example.demo.service.shiro.ITUserService;
import com.example.demo.task.TestTask;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

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
	private ITUserService sss;
	@RequestMapping("/queryUser")
	public Map queryUser(String ccode){
		Map maps = sss.selectByCcode(ccode);
		return maps;
	}
	@RequestMapping("/batchInsertUser")
	public void batchInsertUser(){
		new TestTask(sss);
	}
}
