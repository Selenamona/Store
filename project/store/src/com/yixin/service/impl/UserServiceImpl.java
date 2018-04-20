package com.yixin.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.yixin.dao.UserDao;
import com.yixin.dao.impl.UserDaoImpl;
import com.yixin.domain.User;
import com.yixin.service.UserService;

public class UserServiceImpl implements UserService {

	/**
	 * 用户注册
	 */
	public void regist(User user) {
		//1、 调用dao完成注册
		UserDao ud = new UserDaoImpl();
		ud.save(user);
		
		//2、 发送激活邮件
//		String emailMsg = "恭喜"+user.getName()+"成为我们商城的一员，<a href='http://localhost/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
//		try {
//			MailUtils.sendMail(user.getEmail(), emailMsg);
//		} catch(Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
