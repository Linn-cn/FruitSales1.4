package com.zl.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

/** 
* @Description: 集合或实体类操作类
* @Author: ZhuLin
* @Date: 2019/2/27 
*/ 
public class JsonUtils {

	public static String toJsonString(Object ojb) {
		String jsonStr = JSON.toJSONString(ojb, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.WriteMapNullValue);
		return jsonStr;
	}

	/**
	 * @Description: 将不同类型对象数据相同参数的数据赋予给另一个对象
	 * @param ojb2
	 * @param clazz
	 * @return_type T
	 * @author sunp
	 * @time: 2018年7月19日 下午7:57:55
	 */
	public static <T> T parseObjToObj(Object ojb2, Class<T> clazz) {
		String str = JSON.toJSONString(ojb2);
		T bean = JSON.parseObject(str, clazz);
		return bean;
	}

	/**
	 * 
	 * @Function: JsonUtils.java
	 * @Description: 将list换成另一种类型的List
	 * @param:clazz 需要转换的类型
	 * @return：返回结果描述
	 * @throws：异常描述
	 * @version: v1.0.0
	 * @author: SUNP
	 * @date: 2018年10月20日 下午5:16:06 Modification History:
	 */
	public static <T> List<T> parseListToList(List list, Class<T> clazz) {
		return JSONArray.parseArray(JSON.toJSONString(list), clazz);
	}

	/**
	 * @Title: checkIsChage
	 * @Description: 用于比较2个数组是否一致
	 * @param @param strs1
	 * @param @param strs2
	 * @param @return
	 * @return boolean
	 * @date 2018年12月28日
	 * @author SUNP
	 * @throws
	 */
	public static boolean arrayEqualsArray(String[] strs1, String... strs2) {
		if (strs1.length != strs2.length) {
			return false;
		}
		for (int i = 0; i < strs1.length; i++) {
			if (!strs1[i].equals(strs2[i])) {
				return false;
			}
		}
		return true;
	}

	public static String join(String separator, List<?> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return "";
		}
		String idstr = "";
		for (Object obj : ids) {
			idstr += obj + separator;
		}
		return idstr.substring(0, idstr.length() - 1);

	}
}
