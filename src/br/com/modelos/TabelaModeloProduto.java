package br.com.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.com.classes.ProdutoDto;

public class TabelaModeloProduto extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<ProdutoDto> lista;
	private String[] colunas = {"Código", "Produto", "Categoria", "Preço Venda", "Estoque"};
	
	public TabelaModeloProduto(ArrayList<ProdutoDto> lista) {
		this.lista = lista;
	}
	

	public void addProduto(ProdutoDto produto) {
		this.lista.add(produto);
		fireTableDataChanged();
	}

	public void removerProduto(int rowIndex) {
		this.lista.remove(rowIndex);
		fireTableDataChanged();
	}

	public ProdutoDto getProduto(int rowIndex) {
		return this.lista.get(rowIndex);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.lista.get(rowIndex).getId();
		case 1:
			return this.lista.get(rowIndex).getProduto();
		case 2:
			return this.lista.get(rowIndex).getCategoria();
		case 3:
			return this.lista.get(rowIndex).getPrecoVenda();
		case 4:
			return this.lista.get(rowIndex).getEstoqueAtual();
		default:
			return this.lista.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

}
