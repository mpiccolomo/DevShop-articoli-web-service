package com.marco.webapp.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.marco.webapp.entity.Barcode;
import com.marco.webapp.entity.FamAssort;
import com.marco.webapp.entity.Ingredienti;
import com.marco.webapp.entity.Iva;
import lombok.Data;

@Data
public class ArticoliDto {
	private String codArt;
	private String descrizione;
	private String um;
	private String codStat;
	private Integer pzCart;
	private double pesoNetto;
	private String idStatoArt;
	private Date dataCreaz;
	private double prezzo = 0;
	
	private Set<Barcode> barcode = new HashSet<>();
	private Ingredienti ingredienti;
	private FamAssort famAssort;
	private Iva iva;
	public String getIdStatoArt() {
		// TODO Auto-generated method stub
		return idStatoArt;
	}
	public String getDescrizione() {
		// TODO Auto-generated method stub
		return descrizione;
	}
	public String setIdStatoArt(String trim) {
		// TODO Auto-generated method stub
		return idStatoArt;
	}
	
	public String getUm() {
		// TODO Auto-generated method stub
		return um;
	}
	
	public String setUm(String um) {
		// TODO Auto-generated method stub
		return um;
	}
	public String setDescrizione(String descrizione) {
		// TODO Auto-generated method stub
		return descrizione;
	}
	

}
