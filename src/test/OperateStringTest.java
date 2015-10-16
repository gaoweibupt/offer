package test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import code.OperateString;

/**
 *@author : gaoweibupt@gmail.com
 *
 * 创建时间： 2015年10月16日下午4:34:12
 */
public class OperateStringTest {

	
	@Test
	public void testIsDifferentChar(){
		Assert.assertEquals(false, OperateString.isDifferentChar("asdasgkjhjg"));
		Assert.assertEquals(true, OperateString.isDifferentChar("asdfghjk123"));
	}
	
	@Test
	public void testIsDifferentChar2(){
		Assert.assertEquals(false, OperateString.isDifferentChar2("asdasgkjhjg"));
		Assert.assertEquals(true, OperateString.isDifferentChar2("asdfghjk123"));
	}
	
	@Test
	public void testIsResetEqual(){
		Assert.assertEquals(true, OperateString.isResetEqual("hello", "hello"));
		Assert.assertEquals(false, OperateString.isResetEqual("hello", "heloo"));

	}
	
	@Test
	public void testSpaceReplace(){
		Assert.assertEquals("Mr%20John%20Smith", OperateString.spaceReplace("Mr John Smith"));
	}
	
	@Test
	public void testStringCompress(){
		Assert.assertEquals("a2b1c5a3", OperateString.stringCompress("aabcccccaaa"));
	}
	
	@Test
	public void testIamgeRotate(){
		int[][] image = {{0, 1, 2, 3, 4},{5, 6, 7, 8, 9},{10, 11, 12, 13, 14},{15, 16, 17, 18, 19},{20, 21, 22, 23, 24}};
//		int[][] result = {{20, 15, 10, 5, 0},{21, 16, 11, 6, 1},{22, 17, 12, 7, 2},{23, 18, 13, 8, 3},{24, 19, 14, 9, 4}};
		int[][] result1 = OperateString.iamgeRotate(image, 5);
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				System.out.print(result1[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testArrayEmpty(){
		int[][] image = {{0, 1, 2, 3, 4},{5, 6, 7, 8, 9},{10, 11, 12, 13, 14},{15, 16, 17, 18, 19},{20, 21, 22, 23, 24}};
		int[][] result1 = OperateString.arrayEmpty(image);
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				System.out.print(result1[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
}
