package controllers;
import java.util.List;
import models.Pessoa;
import models.Pet;
import play.mvc.Controller;

public class Pets extends Controller{
	 public static void form() {
		List<Pessoa> pessoas = Pessoa.findAll();
		 render(pessoas);
	  }
	  public static void cadastrar(Pet m) {
	  
	 m.save();
	  listar();
	  }
	  public static void listar() {
		 String buscar = params.get("buscar");
		  
	  	  List<Pet> petsLista;
	  	  if(buscar == null) {
	  	 petsLista= Pet.findAll();
	  	} else { 
	  		petsLista = Pet.find("lower(nome) like ?1 or lower(especie) like ?1",
					"%"+ buscar.toLowerCase() +"%").fetch();}
		 render(petsLista);
	  }
	  public static void remover(Long id) {
		  Pet m = Pet.findById(id);
		  m.delete();
		  listar();
	  }
	  public static void editar(Long id) {
		  Pet m = Pet.findById(id);
		  	List<Pessoa> pessoas = Pessoa.findAll();
		 renderTemplate("Pets/form.html", m, pessoas);
	  }
}
