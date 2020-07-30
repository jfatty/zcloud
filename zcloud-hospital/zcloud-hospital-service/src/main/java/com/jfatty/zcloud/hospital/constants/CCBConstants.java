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
    public static final String POSID = "028473089" ;

    //分行代码
    public static final String BRANCHID = "430000000" ;

    //币种
    public static final String CURCODE = "01" ;

    //交易码 530590
    public static final String TXCODE = "530550";

    //接口类型
    public static final String TYPE = "1";

    //公钥完整字符串
    public static final String PUBLICKEY = "30819d300d06092a864886f70d010101050003818b0030818702818100a9fa85d0e343c37a1ca81d7004f361f0a09381c642c88aa5cfab49c5ce6e430a4189baf6a9c3d025df3173731dec63baeb2bbb7b14bdf334d751b4573df1be373557b6176014ed18ef3774679eb7ae798aa84ae0e71d75a613fff04ce1b87c9693e48d46faca200dde18b59030500528f08b39390569acf1faa4767782e77bb1020111";

    //公钥后30位
    public static final String PUB = "0569acf1faa4767782e77bb1020111";

    //网关
    public static final String GATEWAY = "0" ;

    //交易类型
    public static final String TRADE_TYPE  = "JSAPI" ;

    //小程序的APPID
    public static final String SUB_APPID  = "" ;

    //对应微信公众号APPID
    public static final String WX_APPID  = "wxe3336a60d2685379" ;

    public static final String RETURNTYPE = "1" ;


    public static final String CCB_CREATE_ORDER_URL = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain" ;
    //建行聚合支付URL前缀
    public static final String CCB_QR_ORDER_URL_PREFIX = "https://ibsbjstar.ccb.com.cn/CCBIS/QR?QRCODE=" ;


    public static void main(String[] args) {
        String tmp = "30819d300d06092a864886f70d010101050003818b0030818702818100a9fa85d0e343c37a1ca81d7004f361f0a09381c642c88aa5cfab49c5ce6e430a4189baf6a9c3d025df3173731dec63baeb2bbb7b14bdf334d751b4573df1be373557b6176014ed18ef3774679eb7ae798aa84ae0e71d75a613fff04ce1b87c9693e48d46faca200dde18b59030500528f08b39390569acf1faa4767782e77bb1020111" ;
        String str = tmp.substring(tmp.length()-30,tmp.length()) ;
        System.out.println(str);
    }

}
