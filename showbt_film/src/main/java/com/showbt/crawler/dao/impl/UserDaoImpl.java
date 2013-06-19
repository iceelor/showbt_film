package com.showbt.crawler.dao.impl;

import org.springframework.stereotype.Repository;

import com.showbt.crawler.bean.User;
import com.showbt.crawler.common.dao.impl.BaseDao;
import com.showbt.crawler.dao.UserDAO;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDAO<User>{

}
