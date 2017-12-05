/**
 * User.java
 *
 * robgion
 * www.2clever.it
 * 
 * 22 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robgion
 *
 */
public class User {

	private static int counter = 0;
	
	private Integer id;
	private String nome;
	private String cognome;
	private int eta;
	private List<String> groups;
	
	public User(String nome, String cognome, int eta) {
		this.id = ++counter;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		
		this.groups = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public List<String> getGroups() {
		return groups;
	}
	
	public void addGroups(String... groups) {
		for(String group : groups) {
			this.groups.add(group);
		}
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}
	
}
