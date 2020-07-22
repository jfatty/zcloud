package com.jfatty.zcloud.hospital.constants;

/**
 * 描述 建行龙支付 银行常量信息
 *
 * @author jfatty on 2020/7/15
 * @email jfatty@163.com
 */
public class CCBConstants {

    //商户代码
    public static final String MERCHANTID = "105000080621818" ;

    //商户柜台代码
    public static final String POSID = "028473088" ;

    //分行代码
    public static final String BRANCHID = "430000000" ;

    //币种
    public static final String CURCODE = "01" ;

    //交易码 530590
    public static final String TXCODE = "530550";

    //接口类型
    public static final String TYPE = "1";

    //公钥完整字符串
    public static final String PUBLICKEY = "30819d300d06092a864886f70d010101050003818b0030818702818100d4741ed11afaabe9df63c16398919d8af0b5c68e4258aae021b530b32db58fc8195a2ece683e13f61e26198c2a47c2b77345717395723fbdb12bf337cc5788eb5eb462d8ed78fc0c9c47ff780cb76ff91677231c13fd3f16531b5000e493f8e927ca6ef46c303e505cbd236a07ebfce2759f39ef08c39470a4cfb8214de37dd5020111";

    //公钥后30位
    public static final String PUB = "08c39470a4cfb8214de37dd5020111";

    //网关
    public static final String GATEWAY = "0" ;

    //交易类型
    public static final String TRADE_TYPE  = "JSAPI" ;

    //小程序的APPID
    public static final String SUB_APPID  = "" ;

    public static final String RETURNTYPE = "1" ;


    public static final String CCB_CREATE_ORDER_URL = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain" ;


    public static void main(String[] args) {
        String tmp = "30819d300d06092a864886f70d010101050003818b0030818702818100c8df4c79204c4c593a2bf3e131071477e2530f909e567b6de09444e8ea041ca4f1aa9193916770268cc1a8b7ee73db3fa5088791d8099165a2c581869df5a0683bd4b91c7042991baef9a592a4ff5ce53b440c4465ddf138b8b3185271ff608bbf65ef0ce27ccaa1155048c23ec6cad7a3f91362de90484b928db0fa6f4e8985020111" ;

        String str = tmp.substring(tmp.length()-30,tmp.length()) ;

        System.out.println(str.length());
    }

}
