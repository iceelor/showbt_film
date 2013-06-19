package com.showbt.crawler.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showbt.crawler.bean.User;
import com.showbt.crawler.common.service.impl.BaseServiceImpl;
import com.showbt.crawler.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

}
