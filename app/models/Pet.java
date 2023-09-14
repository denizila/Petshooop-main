package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Pet extends Model {
	
	@ManyToOne
	public Pessoa dono;
	
	public String especie;
	public String idade;
	public String nome;
	public String sexo;
	public String observacoes;
	
}