package controllers;

import java.util.Collections;
import java.util.List;

import models.Pessoa;
import models.Pet;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;
@With(Secure.class)
public class Pets extends Controller {
	public static void form() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}

	public static void cadastrar(@Valid Pet m) {

		if(validation.hasErrors()) {
			validation.keep();
			form();
		}
		m.save();
		listar(m.dono.id);
		
	}

	public static void listar(Long id) {
		List<Pet> petsLista = Pet.find("(dono.id) like ?1",id ).fetch();
		
		render(petsLista);
	}
	public static void listarAjax(String buscar) {
		List<Pet> petsLista;
		if (buscar == null || buscar.trim().isEmpty() ) {
			petsLista = Pet.findAll();
		} else {
			petsLista = Pet.find("lower(nome) like ?1 or lower(especie) like ?1", "%" + buscar.toLowerCase() + "%")
					.fetch();
		}
		renderJSON(petsLista);
	}
	
	public static void remover(Long id) {
		Pet m = Pet.findById(id);
		m.delete();
		listar(m.dono.id);
	}

	public static void editar(Long id) {
		Pet m = Pet.findById(id);
		List<Pessoa> pessoas = Pessoa.findAll();
		renderTemplate("Pets/form.html", m, pessoas);
	}
}
