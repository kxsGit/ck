package com.example.demo.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.common.util.UserRealm;

@Configuration
public class ShiroConfig{
	//配置md5的加密
	@Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		//指定加密方式为MD5
		credentialsMatcher.setHashAlgorithmName("MD5");
		//加密次数
		credentialsMatcher.setHashIterations(1024);
		credentialsMatcher.setStoredCredentialsHexEncoded(false);
		return credentialsMatcher;
	}
	//创建ShiroFilterFactoryBean
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("dwsm")DefaultWebSecurityManager dwsm){
		ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
		sffb.setSecurityManager(dwsm);
		Map map = new LinkedHashMap<>();
		/**
		 * 
		 * anon  无需认证就可以访问
		 * authc  必须认证才可访问
		 * user  必须使用remenberMe的功能才可以访问
		 * perms  该资源必须得到资源权限才可以访问
		 * role  该资源必须得到角色权限才可以访问
		 */
		map.put("/dengluye", "anon");//设置访问权限
		map.put("/toRegister", "anon");//设置访问权限
		//map.put("/*", "authc");
		sffb.setUnauthorizedUrl("/toError");
		sffb.setLoginUrl("/dengluye");//设置跳转到登录也面的地址
		sffb.setFilterChainDefinitionMap(map);
		return sffb;
	}
	//创建DefaultWebSecurityManager
	@Bean(name="dwsm")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(userRealm);
		return dwsm;
	}
	//创建Realm
	@Bean(name="userRealm")
	public UserRealm getUserRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher){
		UserRealm userRealm = new UserRealm();
		userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return userRealm;
	}
}
