package com.eva.sp.h2test.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppCode {

	private static HashMap<String, String> msgMap = new HashMap<>();

	public void setMsgMap(HashMap<String, String> ymlMsgMap) {
		msgMap.putAll(ymlMsgMap);
	}
  
	/**
	 * @description 加入自訂訊息
	 * @param code
	 * @param msg
	 */
	public static void addCustomMsg(String code, String msg) {
		msgMap.put(code, msg);
	}
  
	/**
	 * @description 加入自訂訊息 Map
	 * @param customMsgMap
	 */
	public static void addCustomMsgMap(HashMap<String, String> customMsgMap) {
		msgMap.putAll(customMsgMap);
	}
	  
	  
	/**
	 * @description 取得所有系統訊息 Map
	 * @return
	 */
	public static HashMap<String, String> getMsgMap() {
		return msgMap;
	}
  
	/**
	 * @description 取得系統訊息
	 * @return
	 */
	public static String getMsg(String code) {
		String msg = msgMap.get(code);
		if(msg == null) {
			// TODO
		}
		return msg;
	}
	/**
	 ** 資料存取
	 */
	public static class DATA {
		/**
	     * 網路資源存取
	     */
	    public static enum HTTP implements IAppCode {
	
	    	/**
	    	 * 成功
	    	 */
	    	OK("HTTP_0200"),
	
	    	/**
	    	 * 資料驗證錯誤
	    	 */
	    	BAD_REQUEST("HTTP_0400"),
	
	    	/**
	    	 * 無權限
	    	 */
	    	FORBIDDEN("HTTP_0403"),
	
	    	/**
	    	 * 資源不存在
	    	 */
	    	NOT_FOUND("HTTP_0404"),
	
	    	/**
	    	 * 遠端程式發生未預期的錯誤
	    	 */
	    	INTR_SERVER_ERROR("HTTP_0500");
	
	    	private String code;
	
	    	HTTP(String code) {
	    		this.code = code;
	    	}
	
	    	@Override
	    	public String getCode() {
	    		return this.code;
	    	}
	
	    	@Override
	    	public String getMsg() {
	    		return msgMap.get(this.code);
	    	}
	    }
	}
} 

