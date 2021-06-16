package com.marco.webapp.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.marco.webapp.dtos.ArticoliDto;
import com.marco.webapp.entity.Articoli;

public interface ArticoliService 
{
	public Iterable<Articoli> SelTutti();
	
	public List<ArticoliDto> SelByDescrizione(String descrizione);
		
	public List<Articoli> SelByDescrizione(String descrizione, Pageable pageable);
	
	public ArticoliDto SelByBarcode(String barcode);
	
	public ArticoliDto SelByCodArt(String codArt);
	
	public void DelArticolo(Articoli articolo);
	
	public void InsArticolo(Articoli articolo);
}
