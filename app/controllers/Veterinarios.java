package controllers;

import java.util.List;

import models.Consulta;
import models.Pessoa;
import models.Pet;
import models.Veterinario;
import play.mvc.Controller;

public class Veterinarios extends Controller {

	public static void form() {
		render();
	}

	public static void cadastrar(Veterinario v) {

		v.save();
		listar();
	}

	public static void listar() {
		String buscar = params.get("buscar");

		List<Veterinario> vetLista;
		if (buscar == null) {
			vetLista = Veterinario.findAll();
		} else {
			vetLista = Pet
					.find("lower(nome) like ?1 or lower(emailcomercial) like ?1", "%" + buscar.toLowerCase() + "%")
					.fetch();
		}
		render(vetLista);
	}
	
	public static void agenda(Long id ) {
		List<Consulta> consultas = Consulta.find("(consulta.doutor.id) like ?1",id).fetch();
		render(consultas);
	}

	public static void remover(Long id) {
		Veterinario v = Veterinario.findById(id);
		v.delete();
		listar();
	}

	public static void editar(Long id) {
		Veterinario v = Veterinario.findById(id);
		renderTemplate("Veterinarios/form.html", v);
	}
}