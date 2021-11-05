package br.com.classes;

public class UsuarioDto {
	private Long id;
	private String usuario;
	private String token;
	private String permissoes;

	public UsuarioDto() {
	}
	
	public UsuarioDto(TokenDto dto, String usuario) {
		this.usuario = usuario;
		this.token = dto.getToken();
		this.permissoes = dto.getPermissao();
	}

	public Long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getToken() {
		return token;
	}

	public String getPermissoes() {
		return permissoes;
	}

}
