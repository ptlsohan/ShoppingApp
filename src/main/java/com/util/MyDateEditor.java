package com.util;


import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDateEditor extends PropertyEditorSupport{
//LocalDate -> String
	public String getAsText() {
		Date date=(Date) getValue();
		return date.toString();
	}
	
	
	//String -> LocalDate
	@Override
	public void setAsText(String text) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate ldate = LocalDate.parse(text, formatter);
		Date date= Date.valueOf(ldate);  
		setValue(date);
	}
}
