package jobs;

import models.Pessoa;
import models.Veterinario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Pessoa.count() == 0) {

			Pessoa denis = new Pessoa();
			denis.nome = "Denis E. Silva";
			denis.endereco = "Natal";
			denis.telefone = "99999-9999";
			denis.email = "denden@gmail.com";
			denis.senha = "12345";

			denis.save();

			Pessoa gabriel = new Pessoa();
			
			gabriel.nome = "Gabriel R. Silva";
			gabriel.endereco = "Jardim";
			gabriel.telefone = "98888-9999";
			gabriel.email = "gabrielrichard@gmail.com";
			gabriel.senha = "123456";
			
			gabriel.save();
		}
		
		if (Veterinario.count() == 0) {
			Veterinario joao = new Veterinario();
			joao.nome = "João da Silva";
			joao.especializacao = "Graduado em cães";
			joao.emailcomercial = "joaosilva@gmail.com";
			joao.senha = "1234";
			
			joao.save();
		}
	}

}