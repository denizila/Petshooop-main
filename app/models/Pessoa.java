package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {


	@Required
	public String nome;

	@Required
	public String email;
	
	@Required
	public String senha;
	
	@Required
	public String telefone;

	@Required
	public String endereco;
	
}