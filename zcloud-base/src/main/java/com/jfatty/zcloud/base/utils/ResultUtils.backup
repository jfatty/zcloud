package com.jfatty.zcloud.base.utils;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义响应结构
 */
public class ResultUtils implements Serializable {

    /**
     * 描述
     * @author jfatty
     * 创建时间：2018年4月21日
     */
    private static final long serialVersionUID = -7061817421919686187L;

    public static final String SUCCESS = "SUCCESS" ;

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 成功标识：true/false
     */
    private boolean success = false;
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResultUtils _500() {
        return new ResultUtils(500, "服务器错误!", null);
    }

    public static ResultUtils failure(Integer status, String msg) {
        return new ResultUtils(status, msg, null);
    }

    public static ResultUtils success(Object data) {
        return new ResultUtils(200, SUCCESS, data);
    }

    public static ResultUtils success(String msg) {
        return new ResultUtils(200, msg, null);
    }

    public static ResultUtils success(String msg,Object data) {
        return new ResultUtils(200, msg, data);
    }

    public static ResultUtils success(Integer status, String msg, Object data) {
        return new ResultUtils(status, msg, data);
    }

    public static ResultUtils build(Integer status, String msg, Object data) {
        return new ResultUtils(status, msg, data);
    }

    public static ResultUtils ok(Object data) {
        return new ResultUtils(data);
    }

    public static ResultUtils ok() {
        return new ResultUtils(null);
    }

    public ResultUtils() {

    }

    public static ResultUtils build(Integer status, String msg) {
        return new ResultUtils(status, msg, null);
    }

    public ResultUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.success = (status == 200) ;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Object data) {
        this.status = 200 ;
        this.success = true ;
        this.msg = "OK" ;
        this.data = data ;
    }

    public Boolean isOK() {
        return this.status == 200 ;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 将json结果集转化为TaotaoResult对象
     *
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static ResultUtils formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResultUtils.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ResultUtils format(String json) {
        try {
            return MAPPER.readValue(json, ResultUtils.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ResultUtils formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ResultUtils [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }
}
