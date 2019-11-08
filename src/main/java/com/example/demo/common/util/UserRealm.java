package com.example.demo.common.util;

import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.shiro.IUserService;


public class UserRealm extends AuthorizingRealm{
	/**
	 * @author 97401
	 * 执行授权逻辑
	 */
	@Autowired
	private IUserService sss;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	 * 执行认证逻辑    认证和remerberMe二者选其一，要么是remerberMe登录，或者是认证登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//判断用户名和密码是否正确  参数里面带有穿过来的用户名和密码
		UsernamePasswordToken upt = (UsernamePasswordToken)token;
		
		Map selectByCcode = sss.selectByCcode(upt.getUsername());
		String username = upt.getUsername();
		//循环
		if(selectByCcode==null){
			return null;//shiro底层会自动抛出一个UnkonwnAccountException
		}
		String name = getName();
		Object object = selectByCcode.get("password");
		ByteSource credentialsSalt = ByteSource.Util.bytes(upt.getUsername());
		System.out.println(credentialsSalt);
		//user.getCcode(),
		return new SimpleAuthenticationInfo(selectByCcode, object,credentialsSalt, name);
	}
	/*public static void main(String[] args) {
		String hashAlgorithName = "MD5";
		String password = "123";
		int hashIterations = 1024;//加密次数
		ByteSource credentialsSalt = ByteSource.Util.bytes("zs");
		//Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
		System.out.println(obj);
		}*/
}
