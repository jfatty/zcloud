package com.jfatty.zcloud.base.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述
 *
 * @author jfatty on 2019/12/19
 * @email jfatty@163.com
 */
@Slf4j
public class WePayUtil implements Serializable {

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * 唯一序列防止重复
     */
    private static int seq = 0;

    public static synchronized int getSeq() {
        seq++;
        if(seq >= 10000) {
            seq = 1;
        }
        return seq;
    }

    /**
     * 获取商户订单号  jfatty  2017-10-27
     * @return
     */
    public static String getOutTradeNo(){
        SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
        int iSeq = getSeq();
        String seq = iSeq < 10 ? "000" + iSeq : ( iSeq < 100 ? "00" + iSeq : ( iSeq < 1000 ? "0" + iSeq : "" + iSeq ) );
        String timeString = FORMAT.format(new Date());
        return  timeString + seq;
    }

    public static String getOutTradeNo(String prefix) {
        return prefix + getOutTradeNo();
    }

    public static String getNonceStr() {
        Random random = new Random();
        return WePayUtil.MD5Encode(String.valueOf(random.nextInt(10000)), "GBK");
    }

    /**
     * 将元转化为分  jfatty 2017-11-17
     * @param yuan
     * @return
     */
    public static Integer yuan2fen(String yuan){
        //（重点）Double直接转BigDecimal丢失精度，此处需要将Double转换为String
        //double tem = Double.valueOf(yuan);
        //Long res = (long) (tem*100);
        //return res;
        return new BigDecimal(yuan).movePointRight(2).intValue();
    }

    /**
     * 校验用户输入的费用是否合法  jfatty 2017-11-28
     * 1.为数字，保留两位小数， 2.大于0
     * @param str
     * @return
     */
    public static String checkFee(String str){
        try {
            double val = Double.valueOf(str);
            if(val <= 0){
                return "请输入大于0的金额!";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

    /**
     * 判断订单的生成时间是否在10分钟之内
     * @param createdTime yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static boolean orderLessThan10min(String createdTime) {
        try {
            Long TEN_MIN = 600000L;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long tem = sdf.parse(createdTime).getTime();
            Long now = new Date().getTime();
            if(now - tem < TEN_MIN){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            log.error("====> orderLessThan10min 转换时间时出现异常!============");
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将json字符串转map
     * @param jsonString
     * @return
     * @throws Exception
     */
    public static Map<String, String> jsonStringToMap(String jsonString) throws Exception {
        if (jsonString != null) {
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(jsonString, new TypeToken<Map<String, String>>() {
            }.getType());
            return map;
        } else {
            return null;
        }
    }


    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));
        return resultSb.toString();
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    /**
     * 获取编码字符集
     * @param request
     * @param response
     * @return String
     */
    public static String getCharacterEncoding(HttpServletRequest request,HttpServletResponse response) {
        if(null == request || null == response) {
            return "gbk";
        }
        String enc = request.getCharacterEncoding();
        if(null == enc || "".equals(enc)) {
            enc = response.getCharacterEncoding();
        }
        if(null == enc || "".equals(enc)) {
            enc = "gbk";
        }
        return enc;
    }

    /**
     * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public static String createSign(String key, SortedMap<String, String> sortedMap, HttpServletRequest request, HttpServletResponse response) {
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, String>> es = sortedMap.entrySet();
        Iterator<Map.Entry<String, String>> it = es.iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        log.debug("====> 签名：  拼接字符串为   " + sb.toString());
        String enc = getCharacterEncoding(request, response);
        log.debug("====> 获取编码字符集  " + enc);
        String sign = WePayUtil.MD5Encode(sb.toString(), enc).toUpperCase();
        log.debug("====> MD5签名字符串为   " + sign);
        return sign;
    }

    /**
     * 将 map 转化为 xml jfatty 2017-10-27
     * @param map
     * @return
     */
    public static String mapToXml(Map<String, String> map){
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, String>> es = map.entrySet();
        Iterator<Map.Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"appkey".equals(k)) {
                sb.append("<" + k + ">" + v + "</" + k + ">" + "\r\n");
            }
        }
        String str = "<xml>"+sb.toString()+"</xml>";
        log.debug("====> " + str);
        return str;
    }

    /**
     * 将 sortedMap 转化为 xml jfatty 2017-10-27
     * @param sortedMap
     * @return
     */
    public static String mapToXml(SortedMap<String, String> sortedMap){
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<String, String>> es = sortedMap.entrySet();
        Iterator<Map.Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"appkey".equals(k)) {
                sb.append("<" + k + ">" + v + "</" + k + ">" + "\r\n");
            }
        }
        String str = "<xml>"+sb.toString()+"</xml>";
        log.debug("====> " + str);
        return str;
    }

    public static HttpURLConnection getHttpURLConnection(String strUrl)throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        return httpURLConnection;
    }

    protected static InputStream doPost(HttpURLConnection conn, byte[] postData)throws IOException {
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        BufferedOutputStream out = new BufferedOutputStream(conn.getOutputStream());
        log.debug("====> doPost out=" + out);
        final int len = 1024;
        WePayUtil.doOutput(out, postData, len);
        out.close();
        InputStream inputStream = conn.getInputStream();
        return inputStream;
    }

    public static void doOutput(OutputStream out, byte[] data, int len)throws IOException {
        int dataLen = data.length;
        int off = 0;
        while (off < data.length) {
            if (len >= dataLen) {
                out.write(data, off, dataLen);
                off += dataLen;
            } else {
                out.write(data, off, len);
                off += len;
                dataLen -= len;
            }
            out.flush();
        }
    }

    public static byte[] inputStreamToByte(InputStream in) throws IOException{
        int BUFFER_SIZE = 4096;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);
        data = null;
        byte[] outByte = outStream.toByteArray();
        outStream.close();
        return outByte;
    }

    public static String inputStreamToString(InputStream in,String encoding) throws IOException{
        return new String(inputStreamToByte(in),encoding);
    }

    public static Map<String, String> doXMLParse(String strxml) throws JDOMException, IOException {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if(null == strxml || "".equals(strxml)) {
            return null;
        }
        Map<String, String> m = new HashMap<String, String>();
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List<Element> list = root.getChildren();
        Iterator<Element> it = list.iterator();
        while(it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List<Element> children = e.getChildren();
            if(children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = WePayUtil.getChildrenText(children);
            }
            m.put(k, v);
        }
        in.close();
        return m;
    }

    public static String getChildrenText(List<Element> children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator<Element> it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List<Element> list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(WePayUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }

    /**
     * 获取 prepayId jfatty 2017-10-27
     * @param url
     * @param xml
     * @return
     * @throws JDOMException
     */
    public static String getPrepayId(String url, String xml) throws JDOMException {
        byte[] postData;
        String prepayid = null;
        try {
            postData = xml.getBytes("UTF-8");
            HttpURLConnection conn = getHttpURLConnection(url);
            InputStream inputStream =  doPost(conn, postData);
            String resContent = inputStreamToString(inputStream, "UTF-8");
            log.debug("====> 获取 prepayId resContent=" + resContent);
            Map<String, String> map =  doXMLParse(resContent);
            if (map.get("prepay_id")!=null) {
                prepayid = map.get("prepay_id").toString();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return prepayid;
    }

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }


    public static String objectToString(Object object){
        Gson gson = new Gson();
        String str = gson.toJson(object);
        log.debug("====> objectToString = " + str);
        return str;
    }

    /**
     * @Description 微信支付异步通知 参数校验
     * @author LiaoYun 2017年11月1日
     * @param resultMap
     * @param wechatPayKey
     * @param response
     * @param request
     * @return
     * @return String
     */
    public static String getSign(Map<String, String> resultMap, String wechatPayKey, HttpServletRequest request, HttpServletResponse response) {
        SortedMap<String, String> signParams = new TreeMap<String, String>();
        for (Map.Entry<String, String> stringStringEntry : resultMap.entrySet()) {
            signParams.put(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        signParams.remove("sign");
        String sign = createSign(wechatPayKey, signParams, request, response);
        return sign;
    }

    /**
     * 回调时间转换
     * @param timeEnd
     * @return
     */
    public static String getTimeStandard(String timeEnd){
        if(StringUtils.isEmptyOrBlank(timeEnd)){
            return null;
        }
        String year = timeEnd.substring(0,4);
        String month = timeEnd.substring(4, 6);
        String day = timeEnd.substring(6, 8);
        String hour = timeEnd.substring(8, 10);
        String minu = timeEnd.substring(10, 12);
        String sec = timeEnd.substring(12, 14);
        String str = year+"-"+month+"-"+day+" "+hour+":"+minu+":"+sec;
        return str;
    }

    public static String doRefund(String mchId, String certPath ,String url, String data ) throws Exception {
        /**
         * 注意PKCS12证书 是从微信商户平台-》账户设置-》 API安全 中下载的
         */
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        try {
            //这里写密码..默认是你的MCHID
            keyStore.load(certStream, mchId.toCharArray());
        } finally {
            certStream.close();
        }
        SSLContext sslcontext = SSLContexts.custom()
                //这里也是写密码的
                .loadKeyMaterial(keyStore, mchId.toCharArray())
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        try {
            HttpPost httpost = new HttpPost(url);
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();
                //接受到返回信息
                String resultStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
                return resultStr;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}