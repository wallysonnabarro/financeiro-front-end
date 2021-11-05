package br.sasclient.util;

public class FuncoesUtil {

	public String getValor(String s) {
		String[] custo = new String[3];
		String t = s.replace(".", "#");
		custo = t.split("#");
		String aux = "";
		if (custo.length > 1) {
			aux = custo[0] + custo[1];
		}
		return aux;
	}
}
