package com.suzl.mp.auto.service.impl;

import com.suzl.mp.auto.beans.User;
import com.suzl.mp.auto.mapper.UserMapper;
import com.suzl.mp.auto.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenglongsu@163.com
 * @since 2018-08-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
