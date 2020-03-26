package com.ye.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	@org.junit.Test
	public void test() {
		Date date=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		System.out.println(simpleDateFormat.format(date));
		
	}

}
