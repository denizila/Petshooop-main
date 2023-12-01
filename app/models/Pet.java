package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Pet extends Model {
	
	@ManyToOne
	public Pessoa dono;

	@ManyToOne
	public Veterinario medico;

	public String especie;
	
	public String idade;

	@Required
	public String nome;

	@Required
	public String sexo;
	
	public String observacoes;
	
	@Required
	public String servicos;
	
}