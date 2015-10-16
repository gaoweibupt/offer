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
}
