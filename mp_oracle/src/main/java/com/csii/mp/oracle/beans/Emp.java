package com.csii.mp.oracle.beans;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
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
public class Emp extends Model<Emp> {

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
        return "Emp{" +
        ", id=" + id +
        ", name=" + name +
        ", logicFlag=" + logicFlag +
        "}";
    }
}
