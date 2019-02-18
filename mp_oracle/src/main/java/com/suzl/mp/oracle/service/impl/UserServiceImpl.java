package com.suzl.mp.oracle.service.impl;

import com.suzl.mp.oracle.beans.User;
import com.suzl.mp.oracle.mapper.UserMapper;
import com.suzl.mp.oracle.service.UserService;
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
