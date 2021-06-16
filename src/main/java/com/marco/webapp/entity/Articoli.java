package com.marco.webapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "ARTICOLI")
@Data
public class Articoli  implements Serializable
{
	private static final long serialVersionUID = 291353626011036772L;
	
	@Id
	@Column(name = "CODART")
	private String codArt;
	
	@Column(name = "DESCRIZIONE")
	private String descrizione;	
	
	@Column(name = "UM")
	private String um;
	
	@Column(name = "CODSTAT")
	private String codStat;
	
	@Column(name = "PZCART")
	private Integer pzCart;
	
	@Column(name = "PESONETTO")
	private double pesoNetto;
	
	@Column(name = "IDSTATOART")
	private String idStatoArt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATACREAZIONE")
	private Date dataCreaz;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "articolo", orphanRemoval = true)
	@JsonManagedReference
	private Set<Barcode> barcode = new HashSet<>();
	
	@OneToOne(mappedBy = "articolo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Ingredienti ingredienti;
	
	@ManyToOne
	@JoinColumn(name = "IDIVA", referencedColumnName = "idIva")
	private Iva iva;
	
	@ManyToOne
	@JoinColumn(name = "IDFAMASS", referencedColumnName = "ID")
	private FamAssort famAssort;

	public String getIdStatoArt() {
		// TODO Auto-generated method stub
		return idStatoArt;
	}

	

	public String getUm() {
		// TODO Auto-generated method stub
		return um;
	}

	public Object setIdStatoArt(String idStatoArt) {
		// TODO Auto-generated method stub
		return idStatoArt;
	}



	public String setUm(String um) {
		// TODO Auto-generated method stub
		return um;
	}



	public String getDescrizione() {
		// TODO Auto-generated method stub
		return descrizione;
	}



	public Object setDescrizione(String descrizione) {
		// TODO Auto-generated method stub
		return descrizione;
	}

	

	
	

}
