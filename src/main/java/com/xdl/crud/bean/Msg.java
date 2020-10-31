package com.xdl.crud.bean;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/28
 * @Time 12:33 上午
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 */
public class Msg {
    //状态码
    private int code;
    //提示信息
    private String msg;
    //返回给浏览器的数据
    private Map<String,Object> extend = new HashMap<>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("成功");
        return msg;
    }
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("失败");
        return msg;
    }
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
