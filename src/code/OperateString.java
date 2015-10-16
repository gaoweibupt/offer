package code;

import java.util.HashMap;

/**
 *@auther : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月16日下午4:16:08
 */
public class OperateString {
	
	/**
	 * 第八章  习题1.1
	 * <p> 确定一个字符串的所有字符全都不同<br>
	 * 使用HashMap数据结构
	 * @param String s 输入字符串
	 * @return true 为全部同，false为有相同的字符
	 * */
	public static boolean isDifferentChar(String s){
		if (s == null || s.equals("")){
			return true;
		}
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < s.length(); i++){
			if (map.containsKey(s.charAt(i))){
				return false;
			}
			else{
				map.put(s.charAt(i), true);
			}
		}
		return true;
	}
	
	
	/**
	 * 第八章  习题1.1
	 * <p> 确定一个字符串的所有字符全都不同<br>
	 * 不适用额外的数据结构
	 * @param String s 输入字符串
	 * @return true 为全部同，false为有相同的字符
	 * */
	public static boolean isDifferentChar2(String s){
		if (s == null || s.equals("")){
			return true;
		}
		for (int i = 0; i < s.length() - 1; i++){
			for (int j = i + 1; j < s.length(); j++){
				if (s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	
}
