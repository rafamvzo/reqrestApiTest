package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import metodos.GetNetApi;
import metodos.Usuario;

public class Steps {
	GetNetApi metodoapi = new GetNetApi();

	@Given("enviar os dados obrigatorio {string} e {string}")
	public void enviarOsDadosObrigatorioE(String name, String job) {
		Usuario usuario = new Usuario(name, job);
		metodoapi.criarUsuario(usuario);
	}

	@Then("valido o status code {int}")
	public void validoOStatusCode(int status) {
		metodoapi.validaStatusCode(status);
	}

	@Then("valido o primeiro nome {string} e {string}")
	public void validoOPrimeiroNomeE(String nome, String job) {
		metodoapi.validaCamposObrigatorios(nome, job);
	}
}
