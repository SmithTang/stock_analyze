package com.citi.gunrose.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter(autoApply = false)
public class StringDateConverter implements AttributeConverter<Date, String> {

	@Override
	public String convertToDatabaseColumn(Date date) {
		if(date == null)
			return "";
		return new SimpleDateFormat("yyyyMMddHHmm").format(date);
	}

	@Override
	public Date convertToEntityAttribute(String s) {
		if(s == null)
			return null;

		try {
			Date date = new SimpleDateFormat("yyyyMMddHHmm").parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}