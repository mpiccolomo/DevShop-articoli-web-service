package com.marco.webapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.marco.webapp.entity.Articoli;
                                // PagingAndSortin per la verifica del paging prevista negli UmitTest
public interface ArticoliRepository  extends PagingAndSortingRepository<Articoli, String>
{
	
	//select su uno specifico parametro "descrizione" (Query nativa)
	@Query(value = "SELECT * FROM ARTICOLI WHERE DESCRIZIONE LIKE :desArt", nativeQuery = true)
	List<Articoli> SelByDescrizioneLike(@Param("desArt") String descrizione);
    
	//Query sintassi  jpa
	List<Articoli> findByDescrizioneLike(String descrizione, Pageable pageable);
	
	Articoli findByCodArt(String codArt);
	
	
	//questo metodo ci restituisce la classe Barcode che cerca appunto articoli per Barcode (sintax jpql)
	@Query(value="SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)")
	Articoli SelByEan(@Param("ean")String ean);
}
