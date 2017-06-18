package org.seckill.entity;

import java.util.Date;

/**
 * Created by xx on 2017/1/19.
 */
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date creatTime;

    //多对一
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "creatTime=" + creatTime +
                ", seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                '}';
    }
}
