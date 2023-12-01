package controllers;

public class Veterinarios {
    package controllers;
import java.util.List;
import models.Pessoa;
import models.Pet;
import models.Veterinario;
import play.mvc.Controller;

public class Pets extends Controller{
	 public static void form() {
		
	  }
	  public static void cadastrar(Veterinario v) {
	  
	 v.save();
	  listar();
	  }
	  public static void listar() {
		 String buscar = params.get("buscar");
		  
	  	  List<Veterinario> vetLista;
	  	  if(buscar == null) {
	  	 vetLista= Pet.findAll();
	  	} else { 
	  		vetLista = Pet.find("lower(nome) like ?1 or lower(especie) like ?1",
					"%"+ buscar.toLowerCase() +"%").fetch();}
		 render(vetLista);
	  }
	  public static void remover(Long id) {
		  Pet m = Pet.findById(id);
		  m.delete();
		  listar();
	  }
	  public static void editar(Long id) {
		  Veterinario v = Veterinario.findById(id);
		  	List<Pessoa> pessoas = Pessoa.findAll();
		 renderTemplate("Pets/form.html", v, pessoas);
	  }
}
}
