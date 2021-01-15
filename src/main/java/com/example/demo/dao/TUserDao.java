package com.example.demo.dao;

import com.example.demo.entity.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author kx
 * @since 2019-11-08
 */
public interface TUserDao extends BaseMapper<TUser> {
    Map queryUser();
    Map selectByCcode(String ccode,String id);
}