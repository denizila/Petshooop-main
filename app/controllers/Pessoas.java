package controllers;

import java.util.List;

import models.Pessoa;
import models.Pet;
import models.Veterinario;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Pessoas extends Controller {
	public static void form() {
		render();
	}

	public static void cadastrar(@Valid Pessoa p) {
		if (validation.hasErrors()) {
			validation.keep();
			form();
		}
		p.save();
		Pets.form();
	}

	public static void listar() {
		String buscar = params.get("buscar");

		List<Pessoa> pessoas;
		if (buscar == null) {
			pessoas = Pessoa.findAll();
		} else {
			pessoas = Pessoa
					.find("lower(nome) like ?1 or lower(email) like ?1", "%" + buscar.toLowerCase() + "%")
					.fetch();
		}
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
