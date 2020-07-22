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
    public static final String PUBLICKEY = "30819d300d06092a864886f70d010101050003818b0030818702818100874790210271b04300015186373c8b13be31fa22cf5b50f5274e565d3f47b6f37997c10f550211cf06b9a5066137d9fda3dd28e1aed2b0f89a5602fced30cafc6f61ae087cb59a9391454fa267ba21036e5a45cceb4093fd69f584e4525a1dc142aae1d6597f65c2f577d0c20c4d9be9383f7deff9b6653ceee7a3c4cf2fd03d020111";

    //公钥后30位
    public static final String PUB = "f9b6653ceee7a3c4cf2fd03d020111";

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
        String tmp = "30819d300d06092a864886f70d010101050003818b0030818702818100874790210271b04300015186373c8b13be31fa22cf5b50f5274e565d3f47b6f37997c10f550211cf06b9a5066137d9fda3dd28e1aed2b0f89a5602fced30cafc6f61ae087cb59a9391454fa267ba21036e5a45cceb4093fd69f584e4525a1dc142aae1d6597f65c2f577d0c20c4d9be9383f7deff9b6653ceee7a3c4cf2fd03d020111" ;

        String str = tmp.substring(tmp.length()-30,tmp.length()) ;

        System.out.println(str);
    }

}
