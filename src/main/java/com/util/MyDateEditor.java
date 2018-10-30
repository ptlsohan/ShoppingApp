package com.util;


import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
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
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/yy");
		 LocalDate ldate= YearMonth.parse(text, formatter).atDay(1); 
//			LocalDate ldate = LocalDate.parse(text, formatter);
			Date date= Date.valueOf(ldate);  
			setValue(date);
			
	}
}
