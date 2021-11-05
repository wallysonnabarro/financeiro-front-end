package br.com.classes;

public class ProdutoDto {
	private Long id;
	private String produto;
	private String codigoProduto;
	private String categoria;
	private Double valorCusto;
	private Double precoVenda;
	private Double margemContribuicao;
	private Integer controlarEstoque;
	private int estoqueAtual;
	private int estoqueMinimo;
	private String observacao;
	/*
	 * Dados fiscais.
	 */
	private int origem;
	private int referenciaEanGtin;// https://www.fazenda.sp.gov.br/nfe/perguntas_frequentes/respostas_X.asp#:~:text=GTINs%2C%20anteriormente%20chamado%20c%C3%B3digos%20EAN,mat%C3%A9rias%20primas%20at%C3%A9%20produtos%20acabados.
	private Double pesoUnitarioLiquidoKg;
	private Double pesoUnitarioBrutoKg;
	private int ncm;// https://investexportbrasil.dpr.gov.br/ProdutosServicos/frmPesquisaProdutosServicosFull.aspx
	private int exIpi;// https://blog.eficienciafiscal.com.br/o-que-e-ex-tipi/#:~:text=De%20forma%20muito%20simples%2C%20a,tributa%C3%A7%C3%A3o%20de%20um%20item%20espec%C3%ADfico.
	private String cBenef;// https://blog.oobj.com.br/cbenef/
	private String uCom;// unidade de comercializa��o(unidade de medida)
	private String utrib;// unidade tributada(quantidade de unidades tributadas)
	private int qtdTributada;
	private String anotacoesNfe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getMargemContribuicao() {
		return margemContribuicao;
	}

	public void setMargemContribuicao(Double margemContribuicao) {
		this.margemContribuicao = margemContribuicao;
	}

	public Integer getControlarEstoque() {
		return controlarEstoque;
	}

	public void setControlarEstoque(Integer controlarEstoque) {
		this.controlarEstoque = controlarEstoque;
	}

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getOrigem() {
		return origem;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}

	public int getReferenciaEanGtin() {
		return referenciaEanGtin;
	}

	public void setReferenciaEanGtin(int referenciaEanGtin) {
		this.referenciaEanGtin = referenciaEanGtin;
	}

	public Double getPesoUnitarioLiquidoKg() {
		return pesoUnitarioLiquidoKg;
	}

	public void setPesoUnitarioLiquidoKg(Double pesoUnitarioLiquidoKg) {
		this.pesoUnitarioLiquidoKg = pesoUnitarioLiquidoKg;
	}

	public Double getPesoUnitarioBrutoKg() {
		return pesoUnitarioBrutoKg;
	}

	public void setPesoUnitarioBrutoKg(Double pesoUnitarioBrutoKg) {
		this.pesoUnitarioBrutoKg = pesoUnitarioBrutoKg;
	}

	public int getNcm() {
		return ncm;
	}

	public void setNcm(int ncm) {
		this.ncm = ncm;
	}

	public int getExIpi() {
		return exIpi;
	}

	public void setExIpi(int exIpi) {
		this.exIpi = exIpi;
	}

	public String getcBenef() {
		return cBenef;
	}

	public void setcBenef(String cBenef) {
		this.cBenef = cBenef;
	}

	public String getuCom() {
		return uCom;
	}

	public void setuCom(String uCom) {
		this.uCom = uCom;
	}

	public String getUtrib() {
		return utrib;
	}

	public void setUtrib(String utrib) {
		this.utrib = utrib;
	}

	public int getQtdTributada() {
		return qtdTributada;
	}

	public void setQtdTributada(int qtdTributada) {
		this.qtdTributada = qtdTributada;
	}

	public String getAnotacoesNfe() {
		return anotacoesNfe;
	}

	public void setAnotacoesNfe(String anotacoesNfe) {
		this.anotacoesNfe = anotacoesNfe;
	}

}
