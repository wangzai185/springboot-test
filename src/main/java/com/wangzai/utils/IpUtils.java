/**
 * 
 */
package com.wangzai.utils;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: IpUtils
 * @Description: TODO
 * @author zhangw
 * @date 2018-9-28 上午9:27:15
 */
public class IpUtils {

	/**
	 * 获取本机IP
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getLocalIp() throws Exception {
		String ip = null;
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			ip = inetAddress.getHostAddress().toString();
		} catch (Exception e) {
			throw new Exception("get local ip error", e);
		}
		if (StringUtils.isEmpty(ip)) {
			return null;
		}
		return ip.trim();
	}

	/**
	 * IP过滤
	 * 
	 * @param source
	 * @param compare
	 * @return
	 */
	public static List<String> ipFilter(List<String> source,
			List<String> compare) {
		List<String> ipList = new ArrayList<String>();
		if (null == source || source.size() <= 0 || null == compare
				|| compare.size() <= 0) {
			return ipList;
		}
		for (String ip : source) {
			if (compare.contains(ip)) {
				ipList.add(ip);
			}
		}
		return ipList;
	}

}
