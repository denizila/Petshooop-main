package controllers;
import java.util.List;

import models.Pessoa;
import models.Pet;
import play.mvc.Controller;

public class Pessoas extends Controller{
	 public static void form() {
		  render();
	  }
	  public static void cadastrar(Pessoa p) {
	  p.save();
	  Pets.form();
	  }
	  public static void listar() {
		 List<Pessoa> pessoas = Pessoa.findAll();
		 render(pessoas);
	  }
	  public static void remover(Long id) {
		  Pessoa p = Pessoa.findById(id);
		  p.delete();
		  listar();
	  }
	  public static void editar(Long id) {
		  Pessoa p = Pessoa.findById(id);
		 renderTemplate("Pessoas/form.html", p);
	  }
	  
}
