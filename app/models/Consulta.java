package models;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import play.data.validation.Required;
import play.db.jpa.Model;

public class Consulta extends Model {

	@ManyToOne
	public Pet animal;

	@ManyToOne
	public Veterinario doutor;

	@Required
	public String servicos;

	public String observacoes;

	@Required
	public Date data;
}