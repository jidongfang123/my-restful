
package com.kdxc.myrestful.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {

	private String returnCode;

	private String errorMsg;


	private Map<String, Object> datas = null;


	public ResponseData() {
		this.returnCode = "0";
		this.datas = new HashMap<String, Object>();
	}

	public ResponseData(String returnCode, String errorMsg) {
		this.returnCode = "0";
		this.errorMsg = SystemConst.errorMap.get(returnCode);
	}


	public ResponseData(String returnCode) {
		this.returnCode = returnCode;
		this.errorMsg = SystemConst.errorMap.get(returnCode);
		this.datas = new HashMap<String, Object>();
	}


	public void putVal(String key, Object val) {
		this.datas.put(key, val);
	}

	public String getReturnCode() {
		return this.returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> getDatas() {
		return this.datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

}
