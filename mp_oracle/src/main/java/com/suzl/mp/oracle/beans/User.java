package com.suzl.mp.oracle.beans;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhenglongsu@163.com
 * @since 2018-08-16
 */
@KeySequence(value = "SEQ_MER",clazz = Long.class)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long logicFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Long logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", name=" + name +
        ", logicFlag=" + logicFlag +
        "}";
    }
}
