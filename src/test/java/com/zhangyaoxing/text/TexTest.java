package com.zhangyaoxing.text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class TexTest {

	@Test
	public void test() {
		
		String extendName = Tex.getExtendName("1.2");
		System.out.println(extendName);
	}
	@Test
	public void test2() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateByInitMonth = Tex.getDateByInitMonth(new Date());
		String format = simpleDateFormat.format(dateByInitMonth);
		System.out.println(format);
	}
	@Test
	public void test3() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateByInitMonth = Tex.getDateByFullMonth(new Date());
		String format = simpleDateFormat.format(dateByInitMonth);
		System.out.println(format);
	}
	@Test
	public void test4() {
		InputStream inputStreamReader = new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Tex.closeAll(inputStreamReader);
	}
	@Test
	public void test5() throws IOException {
		InputStream inputStreamReader = new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Tex.readTextFile(inputStreamReader);
	}
	@Test
	public void test6() throws IOException {
		Tex.readTextFile(new File(""));
	}

}
