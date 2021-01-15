package com.example.demo.service.shiro.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.TUserDao;
import com.example.demo.entity.TUser;
import com.example.demo.service.shiro.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kx
 * @since 2019-11-08
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUser> implements ITUserService {
    @Autowired
    private TUserDao tm;
    @Override
    public Map selectByCcode(String ccode) {
        String id = "7";
        ccode = "kx";
        Map map = tm.selectByCcode(ccode,id);
        return map;
    }

    @Override
    public void testInt(int s) {
        s++;
        System.out.println(s);
    }
}
