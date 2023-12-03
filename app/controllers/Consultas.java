package controllers;

import java.util.List;

import models.Consulta;

import play.mvc.Controller;

public class Consultas extends Controller {

	public static void form() {
		render();
	}

	public static void cadastrar(Consulta c) {
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
