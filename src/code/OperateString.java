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
	
	/**
	 * 第八章  习题1.6
	 * <p> 将N*N矩阵数组表示的图像旋转90度<br>
	 * @param int[][]  image要操作的矩阵图像, int n 表示矩阵的维度N*N
	 * @return int[][] result 旋转后的矩阵图像数组
	 * */
	public static int[][] iamgeRotate(int[][] image, int n){
		if (n == 1)return image;
		int length = n / 2 + n % 2;
		for (int i = 0; i < length; i++){
			for (int j = 0; j < n / 2; j++){
				int tmp = image[i][j];
				image[i][j] = image[n-1-j][i];
				image[n-1-j][i] = image[n-1-i][n-1-j];
				image[n-1-i][n-1-j] = image[j][n-1-i];
				image[j][n-1-i] = tmp;
			}
		}
		return image;
	}
	
	/**
	 * 第八章  习题1.7
	 * <p> 清空元素为0 时，其所在的行列<br>
	 * @param int[][]  arr 输入的m*n数组
	 * @return int[][] result 返回的数组
	 * */
	public static int[][] arrayEmpty(int[][] arr){
		boolean[] row = new boolean[arr.length];
		boolean[] column = new boolean[arr[0].length];
		for (int i = 0; i < row.length; i++){
			for (int j = 0; j < column.length; j++){
				if (arr[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for (int i = 0; i < row.length; i++){
			for (int j = 0; j < column.length; j++){
				if (row[i] == true || column[j] == true){
					arr[i][j] = 0;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 第八章  习题1.8
	 * <p> 检查字符串1是否为字符串2旋转而成<br>
	 * @param String s1 为字符串1, String s2字符串2
	 * @return Boolean result为true时正确，为false时错误
	 * */
	public static boolean isRotateString(String s1, String s2){
		if (s1.length() == s2.length()){
			String s = s1 + s1;
			if (s.contains(s2)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	
}
