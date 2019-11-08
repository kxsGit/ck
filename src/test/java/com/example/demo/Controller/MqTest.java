package com.example.demo.Controller;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.controller.simple.MqSender;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.shiro.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MqTest {
	@Autowired
	private MqSender sender;
	@Autowired
	private User user;
	@Autowired
	private IUserService sss;
	@Autowired
	private UserDao userdao;

	/*@Test
	public void hello() throws Exception {
		System.out.println(sender);
		sender.send();
	}*/
	@Test
	public void users() throws Exception {
		Map queryUser = userdao.queryUser();
		//boolean deleteById = sss.deleteById(1);
		System.out.println(queryUser);
	}
}
