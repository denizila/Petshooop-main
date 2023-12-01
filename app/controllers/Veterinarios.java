package controllers;
import java.util.List;
import models.Pessoa;
import models.Pet;
import play.mvc.Controller;
public class Veterinarios extends Controller{
    

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
	  	 vetLista= Veterinario.findAll();
	  	} else { 
	  		vetLista = Pet.find("lower(nome) like ?1 or lower(especie) like ?1",
					"%"+ buscar.toLowerCase() +"%").fetch();}
		 render(vetLista);
	  }
	  public static void remover(Long id) {
		  Veterinario v = Veterinario.findById(id);
		  v.delete();
		  listar();
	  }
	  public static void editar(Long id) {
		  Veterinario v = Veterinario.findById(id);
		  	List<Pessoa> pessoas = Pessoa.findAll();
		 renderTemplate("Pets/form.html", v, pessoas);
	  }
}