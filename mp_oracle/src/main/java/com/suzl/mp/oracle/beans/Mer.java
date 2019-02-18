package com.suzl.mp.oracle.beans;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商户控制表
 * </p>
 *
 * @author zhenglongsu@163.com
 * @since 2018-08-16
 */
public class Mer extends Model<Mer> {

    private static final long serialVersionUID = 1L;

    /**
     * 商户号
     */

    private Long id;
    /**
     * 开通状态:0-关1-开
     */
    private Integer merstatus;
    /**
     * 失效时间:YYYYMMDDhhmmss按照GMT+8时间返回
     */
    private String merbegin;
    /**
     * 生效时间:YYYYMMDDhhmmss按照GMT+8时间返回
     */
    private String merend;
    /**
     * 备注1
     */
    private String memo1;
    /**
     * 备注2
     */
    private String memo2;
    /**
     * 备注3
     */
    private String memo3;
    /**
     * 最后更新时间
     */
    private Date datelastmaint;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMerstatus() {
        return merstatus;
    }

    public void setMerstatus(Integer merstatus) {
        this.merstatus = merstatus;
    }

    public String getMerbegin() {
        return merbegin;
    }

    public void setMerbegin(String merbegin) {
        this.merbegin = merbegin;
    }

    public String getMerend() {
        return merend;
    }

    public void setMerend(String merend) {
        this.merend = merend;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    public Date getDatelastmaint() {
        return datelastmaint;
    }

    public void setDatelastmaint(Date datelastmaint) {
        this.datelastmaint = datelastmaint;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Mer{" +
        ", id=" + id +
        ", merstatus=" + merstatus +
        ", merbegin=" + merbegin +
        ", merend=" + merend +
        ", memo1=" + memo1 +
        ", memo2=" + memo2 +
        ", memo3=" + memo3 +
        ", datelastmaint=" + datelastmaint +
        "}";
    }
}
