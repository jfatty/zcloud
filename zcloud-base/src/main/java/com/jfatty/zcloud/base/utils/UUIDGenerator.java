package com.jfatty.zcloud.base.utils;

/**
 * 描述 唯一主键生成办法。从Hibernate中提取出来。
 *
 * @author jfatty on 2019/3/8
 * @email jfatty@163.com
 */
import java.io.Serializable;
import java.net.InetAddress;

public class UUIDGenerator implements Serializable {

    private static final int IP;
    public static int IptoInt( byte[] bytes ) {
        int result = 0;
        for (int i=0; i<4; i++) {
            result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }
    static {
        int ipadd;
        try {
            ipadd = IptoInt( InetAddress.getLocalHost().getAddress() );
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
    private static short counter = (short) 0;
    private static final int JVM = (int) ( System.currentTimeMillis() >>> 8 );

    public UUIDGenerator() {
    }

    /**
     * Unique across JVMs on this machine (unless they load this class
     * in the same quater second - very unlikely)
     */
    protected int getJVM() {
        return JVM;
    }

    /**
     * Unique in a millisecond for this JVM instance (unless there
     * are > Short.MAX_VALUE instances created in a millisecond)
     */
    protected short getCount() {
        synchronized(UUIDGenerator.class) {
            if (counter<0) counter=0;
            return counter++;
        }
    }

    /**
     * Unique in a local network
     */
    protected int getIP() {
        return IP;
    }

    /**
     * Unique down to millisecond
     */
    protected short getHiTime() {
        return (short) ( System.currentTimeMillis() >>> 32 );
    }
    protected int getLoTime() {
        return (int) System.currentTimeMillis();
    }

    private final static String sep = "";

    protected String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace( 8-formatted.length(), 8, formatted );
        return buf.toString();
    }

    protected String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace( 4-formatted.length(), 4, formatted );
        return buf.toString();
    }

    public Serializable generate() {
        return new StringBuffer(36)
                .append( format( getIP() ) ).append(sep)
                .append( format( getJVM() ) ).append(sep)
                .append( format( getHiTime() ) ).append(sep)
                .append( format( getLoTime() ) ).append(sep)
                .append( format( getCount() ) )
                .toString().toUpperCase();
    }

    /**
     * 生成 uuid
     * @return
     */
    public static String  uuid() {
        Serializable uuid = new UUIDGenerator().generate() ;
        return (String) uuid;
    }

    /**
     * 系统生成id
     * @param phone:对象电话号码
     * @return：7位字符串id
     * @throws Exception
     */
    public static String genNum(String phone) {
        //获取手机号中间四位
        String si = phone.substring(3,7);
        //获取手机号最后四位
        String se = phone.substring(7,11);
        //数字加密
        String arg1[] = {"0","1","2","3","4","5","6","7","8",
                "9","a","b","c","d","e","f","g","h",
                "i","j","A","B","C","D","E","F","G","H",
                "I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z"};
        //用户id
        String id_num = "";
        int top = Integer.parseInt(si);
        int x  = top%10;
        top = top/10;
        id_num += arg1[top/32+10];
        id_num += arg1[top%32+10];
        int bot = Integer.parseInt(se);
        for (int i=0;i<4;i++){
            id_num += arg1[(bot%10+1)%10];
            bot = bot/10;
        }
        id_num +=arg1[x];
        //生成的工号
        return id_num;
    }

}
