package com.zhangyaoxing.text;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

public class Tex {
	
//	 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
//	 * 则返回的结果为2019-05-01 00:00:00

	public static Date getDateByInitMonth(Date src){
		Calendar instance = Calendar.getInstance();
		instance.setTime(src);
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		long timeInMillis = instance.getTimeInMillis();
		return new Date(timeInMillis);
		//TODO 实现代码
		}
		/*
		* 方法2：(10分)
		* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
		* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
		* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
		*/
		public static Date getDateByFullMonth(Date src){
			Calendar instance = Calendar.getInstance();
			instance.setTime(src);
			instance.set(Calendar.DAY_OF_MONTH,instance.getActualMaximum(Calendar.DAY_OF_MONTH));
			instance.set(Calendar.HOUR_OF_DAY,23);
			instance.set(Calendar.MINUTE,59);
			instance.set(Calendar.SECOND,59);
			instance.set(Calendar.MILLISECOND,999);
			long timeInMillis = instance.getTimeInMillis();
			return new Date(timeInMillis);
		//TODO 实现代码
		}

		/*
		* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
		*/
		public static String getExtendName(String fileName){
			String[] split = fileName.split("\\.");
			
				System.out.println(split[0]);

			return "."+split[1];
		//TODO 实现代码
		}
		/* 
		方法1：批量关闭流，参数能传入无限个。(10分)
		* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
		*/
		public static void closeAll(Closeable...closeablelist){
			try {
				for (Closeable closeable : closeablelist) {
					if (closeable!=null) {
						closeable.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
		*/
		public static String readTextFile(InputStream src) throws IOException{
			InputStreamReader inputStreamReader = new InputStreamReader(src,"utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String readLine = bufferedReader.readLine();
			while(readLine!=null) {
				 readLine += bufferedReader.readLine();
			}
			closeAll(inputStreamReader);
			return readLine;
		//TODO 实现代码
		}
		/*
		* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
		*/
		public static String readTextFile(File txtFile) throws IOException{
			FileInputStream fileInputStream = new FileInputStream(txtFile);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String readLine = bufferedReader.readLine();
			while(readLine!=null) {
				 readLine += bufferedReader.readLine();
			}
			readTextFile(fileInputStream);
			return readLine;
		//TODO 实现代码
		}


}
