package com.example.demo.controller;

import com.example.demo.common.util.IdWorker;
import com.example.demo.entity.TUser;
import com.example.demo.service.shiro.ITUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
public class ShiroLogin {
	@Autowired
	private ITUserService sss;
	@RequestMapping("/dengluye")
    public String index() {
        return "cqmap";
    }
	@RequestMapping("/toSuccess")
    public String toSuccess(Model model) {
		model.addAttribute("user", "时有凉意不是风");

        return "success";//成功
    }
	@RequestMapping("/toError")
    public String toError(Model model) {
		model.addAttribute("user", "没得权限");

        return "error";//失败
    }
	@RequestMapping("/toRegister")//跳转到注册页面
    public String toRegister(Model model) {

        return "zhuce";
    }
	@RequestMapping("/register")//注册
	@ResponseBody
    public String register(@RequestBody TUser user) {
		//参数1234   1.加密的名称   2.要加密的密码  3.盐  4.加密的次数
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getCcode());
		//System.out.println(credentialsSalt);
		//Object md5 = new SimpleHash("MD5", user.getPassword(), user.getCcode(),1024);
		Md5Hash md5 = new Md5Hash(user.getPassword(),user.getCcode(),1024);
		user.setPassword(md5.toBase64());
		IdWorker idWorker=new IdWorker(0,0);
		user.setId(idWorker.nextId());
		boolean insert = sss.insert(user);
        return "1";
    }
	@ResponseBody
	@RequestMapping("/login")
    public String login(Model model,@RequestBody TUser user) {
		/*Map selectByCcode = sss.selectByCcode(user.getCcode());
		model.addAttribute("user", selectByCcode.get("ccode"));
		if(!user.getPassword().equals((String)selectByCcode.get("password"))){
			return "0";//失败
		}*/
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getCcode(),user.getPassword());
		try {
			token.setRememberMe(true);//设置RememberMe，一般敏感页面要设置认证，非敏感操作可以设置
			subject.login(token);//执行登录的时候会执行UserRealm.java里面的认证逻辑
			boolean b = subject.hasRole("admin");

		} catch (UnknownAccountException e) {
			return "2";//账号不存在
		}catch (IncorrectCredentialsException e){
			return "3";//密码错误
		}
        return "1";//成功
    }
}
