package controllers;

import models.Pessoa;
import models.Veterinario;
import play.mvc.Controller;

public class Logins extends Controller {

	public static void login() {
		render();
	}

	public static void logar(String email, String senha) {

		Pessoa pessoalog = Pessoa.find("email = ?1 and senha = ?2", email, senha).first();
		Veterinario doutor = Veterinario.find("emailcomercial = ?1 and senha = ?2", email, senha).first();
		if (pessoalog != null) {
			session.put("UsuarioLogado", pessoalog.nome);
			session.put("usuarioId", pessoalog.id);
			flash.success("Login realizado com sucesso!");
			Pets.form();
		} else if(doutor != null) {
			session.put("usuarioLogado", doutor.nome);
			session.put("usuarioId", doutor.id);
			flash.success("Login realizado com sucesso");
			Veterinarios.agenda(doutor.id);
		}

		flash.error("Credenciais inválidas ");
		login();
	}

	public static void logout() {
		session.clear();
		flash.success("Você saiu do sistema");
		login();
	}

}
