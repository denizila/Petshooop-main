package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {


	public String nome;
	public String email;
	public String senha;
	public String telefone;
	public String endereco;
	
}