package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Min;
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
	@Min(4)
	public String detalhes;

	@Required
	public String sexo;

}