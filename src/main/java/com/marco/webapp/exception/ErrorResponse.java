package com.marco.webapp.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse 
{
	private Date data = new Date();
	private int codice;
	private String messaggio;
	
	
	public int setCodice(int value) {
		// TODO Auto-generated method stub
		return codice
				;
	}
	public String setMessaggio(String message) {
		// TODO Auto-generated method stub
		return message ;
	}
}
