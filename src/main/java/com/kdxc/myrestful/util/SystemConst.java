
package com.kdxc.myrestful.util;

import java.util.HashMap;
import java.util.Map;


public class SystemConst {

	public static final String DEFAULT_ENCODING = "UTF-8";

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	/**
	 * <p>Field errorMap: 错误代码及错误描述关系</p>
	 */
	public static final Map<String, String> errorMap = new HashMap<String, String>();

	/**
	 * <p>Field RESPONSE_SUCCESS: 服务端返回成功的标志</p>
	 */
	public static final String RESPONSE_SUCCESS = "0";

	/**
	 * <p>Field RESPONSE_RESULT_FLAG: 服务端返回结果的标志</p>
	 */
	public static final String RESPONSE_RESULT_FLAG = "returnCode";

	/**
	 * <p>Field RESPONSE_RESULT_MSG: 服务端返回错误信息</p>
	 */
	public static final String RESPONSE_RESULT_MSG = "errorMsg";

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * <p>Field ERR_CODE_1001: 系统错误</p>
	 */
	public static final String ERR_CODE_1001 = "1001";
	/**
	 * <p>Field ERR_CODE_1002: 请求超时</p>
	 */
	public static final String ERR_CODE_1002 = "1002";

	/**
	 * <p>Field ERR_CODE_1003: 点位信息已存在</p>
	 */
	public static final String ERR_CODE_1003 = "1003";

	/**
	 * <p>Field ERR_CODE_1004: Token不存在</p>
	 */
	public static final String ERR_CODE_1004 = "1004";
	/**
	 * <p>Field ERR_CODE_1005: Token已过期</p>
	 */
	public static final String ERR_CODE_1005 = "1005";
	/**
	 * <p>Field ERR_CODE_1007: 短信发送失败短（当天同一类型请求次数超过警戒值）
	 */
	public static final String ERR_CODE_1007 = "1007";
	/**
	 * <p>Field ERR_CODE_1008: 短信发送错误
	 */
	public static final String ERR_CODE_1008 = "1008";
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * <p>Field ERR_CODE_1101: 用户不存在</p>
	 */
	public static final String ERR_CODE_1101 = "1101";
	/**
	 * <p>Field ERR_CODE_1102: 密码错误</p>
	 */
	public static final String ERR_CODE_1102 = "1102";
	/**
	 * <p>Field ERR_CODE_1103: 手机已注册</p>
	 */
	public static final String ERR_CODE_1103 = "1103";

	/**
	 * <p>Field ERR_CODE_1105: 验证码错误</p>
	 */

	public static final String ERR_CODE_1105 = "1105";
	/**
	 * <p>Field ERR_CODE_1106: 验证码超时</p>
	 */
	public static final String ERR_CODE_1106 = "1106";

	/**
	 * <p>Field ERR_CODE_1109: 密码重复无需修改</p>
	 */
	public static final String ERR_CODE_1110 = "1110";
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * <p>Field ERR_CODE_1201: 上传失败</p>
	 */
	public static final String ERR_CODE_1201 = "1201";

	/**
	 * <p>Field ERR_CODE_1202: 文件重复无法上传</p>
	 */
	public static final String ERR_CODE_1202 = "1202";
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	static {
		errorMap.put(RESPONSE_SUCCESS, "操作成功");
		errorMap.put(ERR_CODE_1001, "系统错误（包括数据库、代码处理上的错误）");
		errorMap.put(ERR_CODE_1002, "请求超时");
		errorMap.put(ERR_CODE_1003, "点位信息已存在");
		errorMap.put(ERR_CODE_1004, "Token不存在");
		errorMap.put(ERR_CODE_1005, "Token已过期");
		errorMap.put(ERR_CODE_1007, "短信发送失败");
		errorMap.put(ERR_CODE_1008, "短信发送错误");
		errorMap.put(ERR_CODE_1101, "尚未注册");
		errorMap.put(ERR_CODE_1102, "密码错误");
		errorMap.put(ERR_CODE_1103, "手机已注册");
		errorMap.put(ERR_CODE_1105, "验证码错误");
		errorMap.put(ERR_CODE_1106, "验证码已过期,请重新获取");
		errorMap.put(ERR_CODE_1110, "与原密码相同");
		errorMap.put(ERR_CODE_1201, "上传失败");
		errorMap.put(ERR_CODE_1202, "文件重复无法上传");
	}

	/**
	 * <p>Field GENDER_MALE: 性别男</p>
	 */
	public static final String GENDER_MALE = "1";

	/**
	 * <p>Field GENDER_FEMALE: 性别女</p>
	 */
	public static final String GENDER_FEMALE = "0";

}
