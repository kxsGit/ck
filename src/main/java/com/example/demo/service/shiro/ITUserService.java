package com.example.demo.service.shiro;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.TUser;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kx
 * @since 2019-11-08
 */
public interface ITUserService  extends IService<TUser> {
    Map selectByCcode(String ccode);
    void testInt(int s);
}
