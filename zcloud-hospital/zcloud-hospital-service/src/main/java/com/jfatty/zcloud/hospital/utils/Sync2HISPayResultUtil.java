package com.jfatty.zcloud.hospital.utils;

import com.jfatty.zcloud.base.holder.ApplicationContextHolder;
import com.jfatty.zcloud.hospital.service.ComplexPayService;
import com.jfatty.zcloud.hospital.vo.ComplexPay;
import com.jfatty.zcloud.hospital.vo.SyncMZPay;
import com.jfatty.zcloud.hospital.vo.SyncZYPay;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 描述 通知  HIS 系统 支付状态
 * @author jfatty on 2019/4/17
 * @email jfatty@163.com
 */
@Slf4j
public class Sync2HISPayResultUtil extends Thread implements Serializable {

    /**
     * 通知 HIS 系统 支付结果(这是一个异步方法) jaftty 2017-11-17
     * @param outTradeNo 本地系统唯一订单号
     * @param feeType 费用类型 门诊支付、住院预付
     * @param brid  病人id  HIS系统中的病人id
     * @param fydh  费用订单   HIS系统中的费用单号
     * @param fkfs  付款方式   支付宝、微信
     * @param rq    日期   异步通知的时间
     * @param ssje  实收金额（元）
     * @param fkzt  付款状态（为1时表示付款成功）
     * @param zybh  住院编号
     * @return
     */
    public static void syncHisFeeResult(String openId,Integer openIdType,String outTradeNo, Integer feeType, Long brid, String fydh, Integer fkfs, String rq, String ssje, Integer fkzt, String zybh,String Ext1,String Ext2,String Ext3){
        switch (feeType) {
            case ComplexPay.FEE_TYPE_MZ:
                Sync2HISPayResultUtil thread_MZ = new Sync2HISPayResultUtil(openId,openIdType,outTradeNo, feeType, brid, fydh, fkfs, rq, ssje, fkzt,Ext1,Ext2,Ext3);
                thread_MZ.start();
                break;
            case ComplexPay.FEE_TYPE_ZY:
                Sync2HISPayResultUtil thread_ZY = new Sync2HISPayResultUtil(openId,openIdType,outTradeNo, feeType, brid, fydh, fkfs, rq, ssje, fkzt, zybh,Ext1,Ext2,Ext3);
                thread_ZY.start();
                break;
            default:
                break;
        }
    }

    private String openId;
    private Integer openIdType ;
    private String outTradeNo;
    private Integer feeType;
    private Long brid;
    //费用单号
    private String fydh;
    //住院编号
    private String zybh ;

    private Integer fkfs;
    private String rq;
    private String ssje;
    private Integer fkzt;

    private String Ext1 ;
    private String Ext2 ;
    private String Ext3 ;

    //private Long zybh;
    /**
     * @param openId  微信支付宝openId
     * @param openIdType  1表示支付宝openId  2表示微信微信openId
     * @param outTradeNo 本地系统唯一订单号
     * @param feeType 费用类型  门诊支付、住院预付、挂号付款
     * @param brid    病人id
     * @param fydh    费用订单
     * @param fkfs    付款方式 支付宝、微信
     * @param rq      日期
     * @param ssje    实收金额
     * @param fkzt    付款状态
     * @param Ext1    扩展字段
     * @param Ext2    扩展字段
     * @param Ext3    扩展字段
     */
    public Sync2HISPayResultUtil(String openId,Integer openIdType,String outTradeNo, Integer feeType, Long brid,//
                         String fydh, Integer fkfs, String rq, String ssje, Integer fkzt,String Ext1,String Ext2,String Ext3) {
        super();
        this.openId = openId ;
        this.openIdType = openIdType ;
        this.outTradeNo = outTradeNo;
        this.feeType = feeType;
        this.brid = brid;
        this.fydh = fydh;//费用单号
        this.fkfs = fkfs;
        this.rq = rq;
        this.ssje = ssje;
        this.fkzt = fkzt;
        this.Ext1 = Ext1;
        this.Ext2 = Ext2;
        this.Ext3 = Ext3;
    }
    /**
     * @param openId  微信支付宝openId
     * @param openIdType  1表示支付宝openId  2表示微信微信openId
     * @param outTradeNo 本地系统唯一订单号
     * @param feeType 费用类型  门诊支付、住院预付、挂号付款
     * @param brid    病人id
     * @param fydh    费用订单
     * @param fkfs    付款方式 支付宝、微信
     * @param rq      日期
     * @param ssje    实收金额
     * @param fkzt    付款状态
     * @param zybh    住院编号
     * @param Ext1    扩展字段
     * @param Ext2    扩展字段
     * @param Ext3    扩展字段
     */
    public Sync2HISPayResultUtil(String openId,Integer openIdType,String outTradeNo,//
                         Integer feeType, Long brid, String fydh, Integer fkfs, String rq,
                         String ssje, Integer fkzt, String zybh,String Ext1,String Ext2,String Ext3) {
        super();
        this.openId = openId ;
        this.openIdType = openIdType ;
        this.outTradeNo = outTradeNo;
        this.feeType = feeType;
        this.brid = brid;
        this.fydh = fydh;
        this.fkfs = fkfs;
        this.rq = rq;
        this.ssje = ssje;
        this.fkzt = fkzt;
        this.zybh = zybh;
        this.Ext1 = Ext1;
        this.Ext2 = Ext2;
        this.Ext3 = Ext3;
    }

    @Override
    public void run() {
        super.run();
        ComplexPayService complexPayService  = ApplicationContextHolder.getBean(ComplexPayService.class);
        switch (feeType) {
            case ComplexPay.FEE_TYPE_MZ:                                                 //门诊缴费
                //[pro_web_zyyj]
                //'oPGot0QAYXg-Y4OiTYUDn55sjRdo',2,'WX201803271608245',561,'20172222,963258',2,0.01,'','',''
                //openType
                try {
                    log.error("门诊缴费， 通知  HIS 系统   exec dbo.pro_web_mzsf '"+openId+"',"+openIdType+",'"+outTradeNo+"',"+brid+",'"+fydh+"',"+fkfs+","+ssje+",'','',''");
                    SyncMZPay syncMZPay  = complexPayService.syncMZPay(openId,openIdType,outTradeNo,brid+"",fydh,fkfs,ssje,Ext1,Ext2,Ext3);
                    if(syncMZPay.success()){                                          //通知成功
                        log.debug("====> 门诊缴费， 通知  HIS 系统 支付状态  通知成功===============");
                        complexPayService.syncHisFeeBack(outTradeNo, ComplexPay.HIS_SYNC_YES,syncMZPay.getSfh());
                    }else{
                        log.error("====> 门诊缴费， 通知  HIS 系统 支付状态 出现问题   === " + syncMZPay.getMsg());
                    }
                } catch (Exception e) {
                    log.error("====> 门诊缴费， 通知  HIS 系统 支付状态 出现问题  异常信息 === " + e.getMessage());
                }
                break;
            case ComplexPay.FEE_TYPE_ZY:                                                 //住院预缴
                //exec dbo.pro_web_zyyj #{openId},#{openIdType},#{outTradeNo},#{brid},#{zybh},#{fkfs},#{yjje},#{Ext1},#{Ext2},#{Ext3}
                try {
                    log.error("住院预缴， 通知  HIS 系统    exec dbo.pro_web_zyyj '"+openId+"',"+openIdType+",'"+outTradeNo+"',"+brid+",'"+fydh+"',"+fkfs+","+ssje+",'','',''");
                    SyncZYPay syncZYPay = complexPayService.syncZYPay(openId,openIdType,outTradeNo,brid+"",fydh,fkfs,ssje,Ext1,Ext2,Ext3);
                    if(syncZYPay.success()){
                        complexPayService.syncHisInHospitalFeeBack(outTradeNo, ComplexPay.HIS_SYNC_YES, syncZYPay.getYjh());//pihpfVO.getOutTradeNo(), PayVO.HIS_SYNC_YES, pihpfVO.getYjh()
                    }else{
                        log.error("====> 住院预缴， 通知  HIS 系统 支付状态 出现问题   ===  [{}]" , syncZYPay.getMsg());
                    }
                } catch (Exception e) {
                    log.error("====> 住院预缴， 通知  HIS 系统 支付状态 出现问题  异常信息  === [{}]" , e.getMessage());
                }
                break;
            case ComplexPay.FEE_TYPE_GH:                                                 //挂号缴费

                break;
            default:
                log.error("====> 通知  HIS 系统 支付状态, 费用类型不存在  feeType=" + feeType);
                break;
        }
    }

}
