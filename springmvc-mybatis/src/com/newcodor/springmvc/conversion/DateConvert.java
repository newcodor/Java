package com.newcodor.springmvc.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert  implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		try {
			if(null!=source) {
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				System.out.println("source:"+source);
				System.out.println(df.parse(source));
				return df.parse(source);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
