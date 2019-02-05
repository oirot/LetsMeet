package it.unisa.studenti.letsmeet.model;

/**Rappresenta una partecipazione ad un evento
 *
 */
public class PartecipazioneBean {
	
	
	private int idUtente;
	private boolean verificato;
	private int idEvento;
	
	
	/**
	 * Costruttore vuotio
	 */
	public PartecipazioneBean() {
		this.idEvento = 0;
		this.idUtente = 0;
		this.verificato = false;
	}
	
	/**Costruttore
	 * @param idUtente id dell'utente che effettua la partecipazione
	 * @param verificato stato di verificazione della partecipazione
	 * @param idPartecipazione ide della partecipazione
	 */
	public PartecipazioneBean(int idUtente, boolean verificato, int idPartecipazione) {
		this.idUtente = idUtente;
		this.verificato = verificato;
		this.idEvento = idPartecipazione;
	}
	
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public boolean isVerificato() {
		return verificato;
	}
	public void setVerificato(boolean verificato) {
		this.verificato = verificato;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idPartecipazione) {
		this.idEvento = idPartecipazione;
	}
	@Override
	public String toString() {
		return "PartecipazioneBean [idUtente=" + idUtente + ", verificato=" + verificato + ", idPartecipazione="
				+ idEvento + "]";
	}
	
	
	
	
}
