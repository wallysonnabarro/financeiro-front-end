package br.com.classes;

public class UsuarioForm {
	private String usuario;
	private String senha;
	
	public UsuarioForm(String u, String s) {
		this.senha = s;
		this.usuario = u;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	
}
