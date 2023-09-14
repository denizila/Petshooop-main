package jobs;

import models.Pessoa;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Pessoa.count() == 0) {
			
			Pessoa joao = new Pessoa();
			joao.nome = "Denis E. Silva";
			joao.endereco= "Natal";
			joao.telefone= "99999-9999";
			joao.email = "denden@gmail.com";
			joao.senha = "12345";
			
			joao.save();

			Pessoa maria = new Pessoa();
			maria.nome = "Gabriel R. Silva";
			joao.endereco= "Jardim";
			joao.telefone= "98888-9999";
			maria.email = "gabsrrr@gmail.com";
			maria.senha = "54321";
			maria.save();
		}
	}

}