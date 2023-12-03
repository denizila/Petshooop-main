package controllers;

import anotacions.Administrador;
import play.mvc.Before;
import play.mvc.Controller;

public class Secure extends Controller {

	@Before
	static void checkAuthentification() {
		if (session.get("usuarioLogado") == null) {
			Logins.login();
		}
	}
	
	@Before
	static void Verificar() {
		String perfil = session.get("perfilUser");
		Administrador adm = getActionAnnotation(Administrador.class);
	    if(adm != null && ! "adm".equals(perfil)) {
	    	forbidden("Acesso permitido apenas para administradores");
	    	
	    }
	}

}
