package controllers;

import java.util.List;

import models.Consulta;
import models.Pet;
import models.Veterinario;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Consultas extends Controller {

	public static void form() {
		List<Pet> pets = Pet.findAll();
		List<Veterinario> veterinarios = Veterinario.findAll();
		render(pets, veterinarios);
	}

	public static void cadastrar(@Valid Consulta c) {
		if(validation.hasErrors()) {
			validation.keep();
			form();
		}
		c.save();
		listar();
	}

	public static void listar() {
		List<Consulta> consultas = Consulta.findAll();
		render(consultas);
	}

	public static void remover(Long id) {
		Consulta c = Consulta.findById(id);
		c.delete();
		listar();
	}

	public static void editar(Long id) {
		Consulta c = Consulta.findById(id);
		renderTemplate("Consultas/form.html", c);
	}

}
