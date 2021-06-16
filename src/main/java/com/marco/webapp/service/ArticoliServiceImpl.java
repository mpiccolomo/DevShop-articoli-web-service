package com.marco.webapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.marco.webapp.dtos.ArticoliDto;
import com.marco.webapp.entity.Articoli;
import com.marco.webapp.repository.ArticoliRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional(readOnly = true)
public class ArticoliServiceImpl implements ArticoliService
{
	@Autowired
	ArticoliRepository articoliRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Iterable<Articoli> SelTutti()
	{
		return articoliRepository.findAll();
	}

	@Override
	public List<Articoli> SelByDescrizione(String descrizione, Pageable pageable)
	{
		return articoliRepository.findByDescrizioneLike(descrizione, pageable);
	}

	@Override
	public List<ArticoliDto> SelByDescrizione(String descrizione)
	{
		List<Articoli> articoli = articoliRepository.SelByDescrizioneLike(descrizione);
		
		articoli.forEach(e -> e.setIdStatoArt(e.getIdStatoArt().trim()));
		articoli.forEach(e -> e.setUm(e.getUm().trim()));
		articoli.forEach(e -> e.setDescrizione(e.getDescrizione().trim())); 
		
		List<ArticoliDto> retVal = articoli
		        .stream()
		        .map(source -> modelMapper.map(source, ArticoliDto.class))
		        .collect(Collectors.toList());
		
		return retVal;
	}
	
	private ArticoliDto ConvertToDto(Articoli articoli)
	{
		ArticoliDto articoliDto = null;
		
		
		if (articoli != null)
		{
			articoliDto =  modelMapper.map(articoli, ArticoliDto.class);
			
			articoliDto.setUm(articoliDto.getUm().trim());
			articoliDto.setIdStatoArt(articoliDto.getIdStatoArt().trim());
			articoliDto.setDescrizione(articoliDto.getDescrizione().trim());
		}
		
		return articoliDto;
	}
	
	@Override
	public ArticoliDto SelByBarcode(String barcode) 
	{
		Articoli articoli = articoliRepository.SelByEan(barcode);
		
		return this.ConvertToDto(articoli);
		
	}
	
	@Override
	public ArticoliDto SelByCodArt(String codArt)
	{
		Articoli articoli = articoliRepository.findByCodArt(codArt);
		
		
		return this.ConvertToDto(articoli);
	}

	@Override
	@Transactional
	public void DelArticolo(Articoli articolo)
	{
		articoliRepository.delete(articolo);
	}

	@Override
	@Transactional
	public void InsArticolo(Articoli articolo)
	{
		articoliRepository.save(articolo);
	}

	
}
