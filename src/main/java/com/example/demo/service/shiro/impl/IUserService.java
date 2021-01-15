package com.example.demo.service.shiro.impl;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kx
 * @since 2019-09-19
 */
@Service
public interface IUserService extends IService<User> {
	List<Map> queryUser();
	Map selectByCcode(String ccode);
}
