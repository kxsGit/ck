package com.example.demo.Controller;

import java.util.Map;

import com.example.demo.entity.TUser;
import com.example.demo.service.shiro.ITUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.controller.simple.MqSender;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MqTest {
	@Autowired
	private MqSender sender;
	@Autowired
	private ITUserService sss;

	@Test
	public void users() throws Exception {
        Map map = sss.selectByCcode("7");
		TUser t= new TUser();
		t.setId("1");
		t.setPassword("12");
		t.setCcode("45");
		sss.insert(t);
        System.out.println(map);
	}
}
