package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author kx
 * @since 2019-09-19
 */
public interface UserDao extends BaseMapper<User> {
	List<Map> queryUser();
	Map selectByCcode(String ccode);
}