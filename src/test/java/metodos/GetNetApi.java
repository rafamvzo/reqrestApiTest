package metodos;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.core.StringContains;

public class GetNetApi {

	private Response response;
	public void criarUsuario(Usuario usuario) {
		this.response = given()
				.contentType(ContentType.JSON)
				.log().all()
				.body(usuario)
				.when()
				.post("https://reqres.in/api/users")
				.then()
				.extract().response();

		System.out.println("Usuário criado com sucesso: " + response.asString());
	}
	public void validaStatusCode(int expectedStatusCode) {
		this.response.then().statusCode(expectedStatusCode);
	}
	public void validaBodyContemTexto(String texto) {
		String bodyResponse = response.asString();
		assertThat(bodyResponse, StringContains.containsString(texto));
	}

	public void validaCamposObrigatorios(String nomeEsperado, String jobEsperado) {
		this.response.then()
				.body("name", equalTo(nomeEsperado))
				.body("job", equalTo(jobEsperado))
				.body("$", hasKey("id"))
				.body("$", hasKey("createdAt"));
	}
}
