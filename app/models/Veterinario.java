package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Veterinario extends Model {

	@Required
	public String nome;

	@Required
	public String especializacao;

	@Required
	public String emailcomercial;
	
	@Required
	public String senha;
}
