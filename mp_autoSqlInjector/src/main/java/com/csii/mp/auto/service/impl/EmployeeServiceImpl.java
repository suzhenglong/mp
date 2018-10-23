package com.csii.mp.auto.service.impl;

import com.csii.mp.auto.beans.Employee;
import com.csii.mp.auto.mapper.EmployeeMapper;
import com.csii.mp.auto.service.EmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
