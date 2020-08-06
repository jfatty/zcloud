package com.jfatty.zcloud.base.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述 雪花算法(snowflake) ：分布式环境，生成全局唯一的订单号
 *
 * @author jfatty on 2020/7/17
 * @email jfatty@163.com
 */
public class SnowflakeIdUtils implements Serializable {

    // 最近的时间戳
    private long lastTimestamp=0;
    //机器id 2位
    private final String machineId;
    // 0，并发控制
    private long sequence = 0L;
    // 序列号的最大值
    private final int sequenceMax = 9999;


    public SnowflakeIdUtils(String machineId) {
        this.machineId = machineId;
    }

    /**
     * 生成订单OR主键ID
     */
    public synchronized String nextId(){
        Date now=new Date();
        String time= DateFormatUtils.format(now,"yyMMddHHmmssSSS");
        long timestamp = now.getTime();
        if (this.lastTimestamp == timestamp) {
            // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环);
            // 对新的timestamp，sequence从0开始
            this.sequence = this.sequence + 1 % this.sequenceMax;
            if (this.sequence == 0) {
                // 重新生成timestamp
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        this.lastTimestamp= timestamp;
        StringBuilder sb=new StringBuilder(time).append(machineId).append(leftPad(sequence,4));
        return sb.toString();
    }

    /**
     * 补码
     * @param i
     * @param n
     * @return
     */
    private String leftPad(long i,int n){
        String s = String.valueOf(i);
        StringBuilder sb=new StringBuilder();
        int c=n-s.length();
        c=c<0?0:c;
        for (int t=0;t<c;t++){
            sb.append("0");
        }
        return sb.append(s).toString();
    }

    /**
     * 等待下一个毫秒的到来, 保证返回的毫秒数在参数lastTimestamp之后
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    // 这里读取的是配置文件
    // 机器id(我这里是01,正式环境建议使用机器IP)
    // 注意：分布式环境,注意每台机器的id要保证不同;也可以使用机器ip,映射成一个数字编号（如01:192.168.55.12）
    private static String myid = "192168126111";

    // 示例
    private static SnowflakeIdUtils instance = new SnowflakeIdUtils(myid);
    public static SnowflakeIdUtils getInstance() {
        return instance;
    }



    /**
     *
     * @Title: 获取订单OR主键ID
     * @return String
     * @Description:
     *
     * @date: 2018年3月22日 下午7:56:56
     */
    public static  String getOrderNumber() {

        SnowflakeIdUtils orderId = SnowflakeIdUtils.getInstance();
        String nextId = orderId.nextId();

        return nextId;
    }

    /**
     * 调用
     */
    public static void main(String[] args) {
        SnowflakeIdUtils orderId= SnowflakeIdUtils.getInstance();
        String nextId = orderId.nextId();
        int length = nextId.length();
        System.out.println(nextId);
        System.out.println(length);

    }

}
