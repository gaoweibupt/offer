package code;

import java.util.HashMap;

/**
 *@author : gaoweibupt@gmail.com
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
	 * 
	 * 改进：如果String 是ASCII字符串，s.length()>256 就可以返回false
	 * */
	public static boolean isDifferentChar(String s){
		if (s == null || s.equals("")){
			return true;
		}
//		if (s.length() > 256)return false;
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
	
	/**
	 * 第八章  习题1.3
	 * <p> 给定两个字符串，判断经过重排能否相等<br>
	 * @param s1 输入字符串1， s2 输入字符串2
	 * @return true 为可以，false为不可以
	 * */
	public static boolean isResetEqual(String s1, String s2){
		if (s1.length() != s2.length()){
			return false;
		}
		int[] map = new int[256];
		for (int i = 0; i < s1.length(); i++){
			map[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++){
			map[s2.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++){
			if (map[i] != 0)return false;
		}
		return true;
	}
	
	/**
	 * 第八章  习题1.4
	 * <p> 将字符串中的空格替换成%20<br>
	 * @param String s 要替换的字符串
	 * @return String result 替换后的字符串
	 * */
	public static String spaceReplace(String s){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == ' '){
				stringBuffer.append("%20");
			}else{
				stringBuffer.append(s.charAt(i));
			}
		}
		return stringBuffer.toString();	
	}
	
	/**
	 * 第八章  习题1.5
	 * <p> 实现基本的字符串压缩<br>
	 * @param String s 要压缩的字符串
	 * @return String result 压缩后的字符串
	 * */
	public static String stringCompress(String s){
		StringBuffer stringBuffer = new StringBuffer();
		char flag = s.charAt(0);
		int num = 1;
		for (int i = 1; i < s.length(); i++){
			if (flag == s.charAt(i)){
				num++;
			}else{
				stringBuffer.append(flag);
				stringBuffer.append(new Integer(num).toString());
				num = 1;
				flag = s.charAt(i);
			}
		}
		stringBuffer.append(flag);
		stringBuffer.append(new Integer(num).toString());
		if (stringBuffer.length() < s.length()){
			return stringBuffer.toString();
		}
		else{
			return s;
		}
	}
	
}
