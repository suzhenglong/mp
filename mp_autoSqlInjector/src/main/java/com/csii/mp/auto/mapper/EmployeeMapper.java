package com.csii.mp.auto.mapper;

import com.csii.mp.auto.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhenglongsu@163.com
 * @since 2018-08-16
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    int deleteAll();
}
