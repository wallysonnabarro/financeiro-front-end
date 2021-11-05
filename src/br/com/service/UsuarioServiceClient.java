package br.com.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.classes.TokenDto;
import br.com.classes.UsuarioForm;

public class UsuarioServiceClient {
	/**
	 * GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO CLIENTE PARA EXECUTAR AS
	 * SOLICITAÇÕES REALIZADAS
	 */
	private Client client;

	/**
	 * ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource
	 * Identifier/Identificador Uniforme de Recursos)
	 */
	private WebTarget webTarget;

	/** URL DO SERVIÇO REST QUE VAMOS ACESSAR */
	// private final String URL_SERVICE =
	private final String URL_SERVICE = "http://localhost:8080/usuario/";
	// private final String URL_SERVICE_PDF =
	// "http://localhost:7201/web-rest-sas/conta/geraPdf/";

	/** CONSTRUTOR DA NOSSA CLASSE */
	public UsuarioServiceClient() {
		this.client = ClientBuilder.newClient();
	}

	public TokenDto isPreset(UsuarioForm usuarioForm) {

		this.webTarget = this.client.target(URL_SERVICE).path("isUsuario");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(usuarioForm, "application/json;charset=UTF-8"));

		if(response.getStatus() == 404) {
			return new TokenDto();
		}
		
		return response.readEntity(TokenDto.class);
	}
}
