package com.yixin.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yixin.constant.UserConstant;
import com.yixin.domain.User;
import com.yixin.service.UserService;
import com.yixin.service.impl.UserServiceImpl;
import com.yixin.utils.UUIDUtils;
import com.yixin.web.servlet.base.BaseServlet;

/**
 * 用户模块
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */

	public String regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			//1、封装对象
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			//1.1 手动封装uid
			user.setUid(UUIDUtils.getId());
			
			//1.2 手动封装激活状态 state
			user.setState(UserConstant.USER_IS_NOT_ACTIVE);
			
			//1.3 手动封装激活码 code
			user.setCode(UUIDUtils.getCode());
			
			//2、调用service完成注册
			UserService us = new UserServiceImpl();
			us.regist(user);
			
			
			//3、页面转发提示信息
			request.setAttribute("msg","恭喜你，注册成功，请登录邮箱完成激活！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","用户注册失败！");
			
		}
		
		return "/jsp/msg.jsp";
	}


	/**
	 * 跳转到注册页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */

	public String registerUI(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/jsp/register.jsp";
		
	}

   

}
