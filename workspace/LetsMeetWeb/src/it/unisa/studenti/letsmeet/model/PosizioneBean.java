package it.unisa.studenti.letsmeet.model;

import java.math.BigDecimal;

/**Rappresenta una posizione di un evento
 *
 */
public class PosizioneBean {
	
	


	private int id;
	private BigDecimal longitudine;
	private BigDecimal latitudine;
	private String formattedAdress;
	private String nomeComune;
	private int idComune;
	private String nomeProvincia;
	private int idProvincia;
	private String sigla;
	private String nomeRegione;
	private int idRegione;
	private String nomeNazione;
	private int idNazione;
	
	
	/**
	 * Costruttore vuoto
	 */
	public PosizioneBean() {
		this.formattedAdress = null;
		this.idComune = 0;
		this.idNazione = 0;
		this.idProvincia = 0;
		this.latitudine = null;
		this.longitudine = null;
		this.nomeComune = null;
		this.nomeNazione = null;
		this.nomeProvincia = null;
		this.nomeRegione = null;
		this.sigla = null;
	}
	
	
	
	/**Costruttore
	 * @param id id della poszione
	 * @param longitudine longituidine della posizione 
	 * @param latitudine latitudine della posizione
	 * @param formattedAdress indirizzo dell'evento
	 * @param nomeComune nome del comune della posizione
	 * @param idComune id del comune della posizione
	 * @param nomeProvincia nome della regione della posizione
	 * @param idProvincia id della provincia della posizione
	 * @param sigla sigla della provincia della posizione
	 * @param nomeRegione nome della regione della posizione
	 * @param idRegione id della regione della posizione
	 * @param nomeNazione nome della nazione della posizione
	 * @param idNazione id regione della posizione 
	 */
	public PosizioneBean(int id, BigDecimal longitudine, BigDecimal latitudine, String formattedAdress, String nomeComune,
			int idComune, String nomeProvincia, int idProvincia, String sigla, String nomeRegione, int idRegione,
			String nomeNazione, int idNazione) {
		super();
		this.id = id;
		this.longitudine = longitudine;
		this.latitudine = latitudine;
		this.formattedAdress = formattedAdress;
		this.nomeComune = nomeComune;
		this.idComune = idComune;
		this.nomeProvincia = nomeProvincia;
		this.idProvincia = idProvincia;
		this.sigla = sigla;
		this.nomeRegione = nomeRegione;
		this.idRegione = idRegione;
		this.nomeNazione = nomeNazione;
		this.idNazione = idNazione;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public BigDecimal getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(BigDecimal longitudine) {
		this.longitudine = longitudine;
	}
	public BigDecimal getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(BigDecimal latitudine) {
		this.latitudine = latitudine;
	}
	public String getFormattedAdress() {
		return formattedAdress;
	}
	public void setFormattedAdress(String formattedAdress) {
		this.formattedAdress = formattedAdress;
	}
	public String getNomeComune() {
		return nomeComune;
	}
	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
	public int getIdComune() {
		return idComune;
	}
	public void setIdComune(int idComune) {
		this.idComune = idComune;
	}
	public String getNomeProvincia() {
		return nomeProvincia;
	}
	public void setNomeProvincia(String nomeProvincia) {
		this.nomeProvincia = nomeProvincia;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNomeRegione() {
		return nomeRegione;
	}
	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}
	public int getIdRegione() {
		return idRegione;
	}
	public void setIdRegione(int idRegione) {
		this.idRegione = idRegione;
	}
	public String getNomeNazione() {
		return nomeNazione;
	}
	public void setNomeNazione(String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}
	public int getIdNazione() {
		return idNazione;
	}
	public void setIdNazione(int idNazione) {
		this.idNazione = idNazione;
	}
	
	@Override
	public String toString() {
		return "PosizioneBean [id=" + id + " ,longitudine=" + longitudine + ", latitudine=" + latitudine + ", formattedAdress="
				+ formattedAdress + ", nomeComune=" + nomeComune + ", idComune=" + idComune + ", nomeProvincia="
				+ nomeProvincia + ", idProvincia=" + idProvincia + ", sigla=" + sigla + ", nomeRegione=" + nomeRegione
				+ ", idRegione=" + idRegione + ", nomeNazione=" + nomeNazione + ", idNazione=" + idNazione + "]";
	}
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosizioneBean other = (PosizioneBean) obj;
		if (formattedAdress == null) {
			if (other.formattedAdress != null)
				return false;
		} else if (!formattedAdress.equals(other.formattedAdress))
			return false;
		if (id != other.id)
			return false;
		if (idComune != other.idComune)
			return false;
		if (idNazione != other.idNazione)
			return false;
		if (idProvincia != other.idProvincia)
			return false;
		if (idRegione != other.idRegione)
			return false;
		if (latitudine == null) {
			if (other.latitudine != null)
				return false;
		} else if (latitudine.compareTo(other.latitudine) != 0)
			return false;
		if (longitudine == null) {
			if (other.longitudine != null)
				return false;
		} else if (longitudine.compareTo(other.longitudine) != 0)
			return false;
		if (nomeComune == null) {
			if (other.nomeComune != null)
				return false;
		} else if (!nomeComune.equals(other.nomeComune))
			return false;
		if (nomeNazione == null) {
			if (other.nomeNazione != null)
				return false;
		} else if (!nomeNazione.equals(other.nomeNazione))
			return false;
		if (nomeProvincia == null) {
			if (other.nomeProvincia != null)
				return false;
		} else if (!nomeProvincia.equals(other.nomeProvincia))
			return false;
		if (nomeRegione == null) {
			if (other.nomeRegione != null)
				return false;
		} else if (!nomeRegione.equals(other.nomeRegione))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
}
