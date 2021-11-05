package br.com.service;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import br.com.arrays.Produtos;
import br.com.classes.DeletarProdutoForm;
import br.com.classes.ProdutoDto;
import br.com.classes.ProdutoForm;
import br.com.classes.TokenDto;

public class ProdutoServiceClient {

	/**
	 * GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO CLIENTE PARA EXECUTAR AS
	 * SOLICITAÇÕES REALIZADAS
	 */
	private Client client;

	private String token;

	/**
	 * ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource
	 * Identifier/Identificador Uniforme de Recursos)
	 */
	private WebTarget webTarget;

	/** URL DO SERVIÇO REST QUE VAMOS ACESSAR */
	// private final String URL_SERVICE =
	private final String URL_SERVICE = "http://localhost:8080/produto/";
	// private final String URL_SERVICE_PDF =
	// "http://localhost:7201/web-rest-sas/conta/geraPdf/";

	/** CONSTRUTOR DA NOSSA CLASSE */
	public ProdutoServiceClient(TokenDto tokenDto) {
		this.client = ClientBuilder.newClient();
		this.token = tokenDto.getTipo() + " " + tokenDto.getToken();
	}

	/*
	 * Início das funções de PRODUTOS
	 */

	public ProdutoDto registrarProduto(ProdutoDto produto) {

		ProdutoForm form = new ProdutoForm(produto);

		this.webTarget = this.client.target(URL_SERVICE);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8")
				.header(HttpHeaders.AUTHORIZATION, token);

		Response response = invocationBuilder.post(Entity.entity(form, "application/json;charset=UTF-8"));

		return response.readEntity(ProdutoDto.class);
	}

	public ArrayList<ProdutoDto> listaProduto() {
		this.webTarget = this.client.target(URL_SERVICE);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8")
				.header(HttpHeaders.AUTHORIZATION, token);

		Response response = invocationBuilder.get();

		return response.readEntity(Produtos.class);
	}

	public ProdutoDto atualizarProduto(ProdutoForm produto) {
		this.webTarget = this.client.target(URL_SERVICE);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8")
				.header(HttpHeaders.AUTHORIZATION, token);

		Response response = invocationBuilder.put(Entity.entity(produto, "application/json;charset=UTF-8"));

		return response.readEntity(ProdutoDto.class);
	}

	public int deletarProduto(DeletarProdutoForm produto) {
		this.webTarget = this.client.target(URL_SERVICE).path(String.valueOf(produto.getId()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8")
				.header(HttpHeaders.AUTHORIZATION, token);

		Response response = invocationBuilder.delete();

		return response.getStatus();
	}

	/*
	 * Fim das funções de PRODUTOS
	 */

}
