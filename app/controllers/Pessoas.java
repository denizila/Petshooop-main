package controllers;

import java.util.List;

import anotacions.Administrador;
import models.Pessoa;
import models.Pet;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Pessoas extends Controller {
	public static void form() {
		render();
	}

	public static void cadastrar(@Valid Pessoa p) {

		if(validation.hasErrors()) {
			redirecionarErros();
		}
		p.save();
		Logins.login();
	}

	public static void listar() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}

	@Administrador
	public static void remover(Long id) {
		Pessoa p = Pessoa.findById(id);
		p.delete();
		listar();
	}

	public static void editar(Long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}
	
	private static void redirecionarErros() {
		params.flash();
		validation.keep();
		form();
	}

}
