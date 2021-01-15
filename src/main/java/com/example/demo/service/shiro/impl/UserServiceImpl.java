package com.example.demo.service.shiro.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kx
 * @since 2019-09-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
	@Autowired
	private UserDao userdao;

	@Override
	public List<Map> queryUser() {
		List<Map> queryUser = userdao.queryUser();
		return queryUser;
	}

	@Override
	public Map selectByCcode(String ccode) {
		Map queryUser = userdao.selectByCcode(ccode);
		return queryUser;
	}
	
}
