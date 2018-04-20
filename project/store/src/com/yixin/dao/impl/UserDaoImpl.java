package com.yixin.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yixin.dao.UserDao;
import com.yixin.domain.User;
import com.yixin.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {
	/**
	 * 用户注册
	 */
	public void save(User user) {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		/*
		 * `uid` varchar(32) NOT NULL,
			  `username` varchar(20) DEFAULT NULL,
			  `password` varchar(20) DEFAULT NULL,
			  `name` varchar(20) DEFAULT NULL,
			  `email` varchar(30) DEFAULT NULL,
			  `telephone` varchar(20) DEFAULT NULL,
			  `birthday` date DEFAULT NULL,
			  `sex` varchar(10) DEFAULT NULL,
			  `state` int(11) DEFAULT NULL,
			  `code` varchar(64) DEFAULT NULL,
		*/ 
		System.out.print("11111");
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?);";
		try {
			qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
					user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
					user.getSex(),user.getState(),user.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
