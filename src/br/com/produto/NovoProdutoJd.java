package br.com.produto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.classes.ProdutoDto;
import br.com.classes.ProdutoForm;
import br.com.classes.TokenDto;
import br.com.msg.MensagensJD2;
import br.com.service.ProdutoServiceClient;
import br.sasclient.util.FuncoesUtil;
import br.sasclient.util.LimiteNumeros;
import br.sasclient.util.LimiteTxt;
import br.sasclient.util.NumeroFormatoFloat;

public class NovoProdutoJd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798383632333439193L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private List<ProdutoDto> listaProdutos = new ArrayList<ProdutoDto>();
	private JPanel pn_dados_produtos;
	private JButton btn_retorno;
	private JButton btn_dados_fiscais;
	private JButton btn_salvar;
	private String[] origem = new OrigemProdutosVetor().origem;
	private JComboBox<Object> cb_origem;
	private ButtonGroup groupo = new ButtonGroup();
	private JLabel lbl_unidade_tributada;
	private JFormattedTextField fmt_unidade_tributada;
	private JLabel lbl_quantidade_tributada;
	private JFormattedTextField fmt_quantidade_tributada;
	private ProdutoDto produto;
	private JFormattedTextField fmt_produto;
	private JFormattedTextField fmt_codigo_proprio;
	private JFormattedTextField fmt_categoria;
	private JFormattedTextField fmt_preco_de_custo;
	private JFormattedTextField fmt_preco_de_venda;
	private JFormattedTextField fmt_margem_de_contribuicao;
	private JFormattedTextField fmt_estoque_atual;
	private JFormattedTextField fmt_estoque_minimo;
	private JRadioButton rn_controlar_estoque_sim;
	private JRadioButton rb_controlar_estoque_no;
	private JTextArea txtA_anotacoes;
	// Fiscal
	private JFormattedTextField fmt_referencia_ean_gtin;
	private JFormattedTextField fmt_ncm;
	private JFormattedTextField fmt_peso_unitario_liquido;
	private JFormattedTextField fmt_peso_unitario_bruto;
	private JFormattedTextField fmt_unidade_comercial;
	private JRadioButton rb_sim;
	private JRadioButton rb_nao;
	private static ProdutoDto produto2;
	private static TokenDto tokenDto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NovoProdutoJd dialog = new NovoProdutoJd(produto2, tokenDto);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NovoProdutoJd(ProdutoDto produto, TokenDto tokenDto) {
		setModal(true);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 689, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), Color.WHITE));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		NovoProdutoJd.produto2 = produto;
		NovoProdutoJd.tokenDto = tokenDto;

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), Color.WHITE));
		tabbedPane.setBounds(0, 49, 689, 551);
		contentPanel.add(tabbedPane);

		pn_dados_produtos = new JPanel();
		pn_dados_produtos.setBackground(Color.WHITE);
		tabbedPane.addTab("DADOS DO PRODUTO", null, pn_dados_produtos, null);
		pn_dados_produtos.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 664, 138);
		pn_dados_produtos.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome do produto");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 11, 122, 24);
		panel_1.add(lblNewLabel_1);

		fmt_produto = new JFormattedTextField();
		fmt_produto.setBounds(10, 35, 428, 27);
		fmt_produto.setDocument(new LimiteTxt(150));
		panel_1.add(fmt_produto);

		fmt_produto.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_codigo_proprio.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo pr\u00F3prio");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(448, 11, 108, 24);
		panel_1.add(lblNewLabel_2);

		fmt_codigo_proprio = new JFormattedTextField();
		fmt_codigo_proprio.setBounds(448, 35, 206, 27);
		fmt_codigo_proprio.setDocument(new LimiteNumeros(20));
		panel_1.add(fmt_codigo_proprio);

		fmt_codigo_proprio.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_categoria.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 73, 88, 14);
		panel_1.add(lblNewLabel_3);

		fmt_categoria = new JFormattedTextField();
		fmt_categoria.setBounds(10, 98, 206, 27);
		fmt_categoria.setDocument(new LimiteTxt(50));
		panel_1.add(fmt_categoria);

		fmt_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_preco_de_custo.requestFocus();
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 160, 664, 119);
		pn_dados_produtos.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("Pre\u00E7os unit\u00E1rios");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 168, 27);
		panel_2.add(lblNewLabel_3_1);

		fmt_preco_de_custo = new JFormattedTextField(new NumeroFormatoFloat().getFormatNumber());
		fmt_preco_de_custo.setBounds(10, 74, 206, 27);

		panel_2.add(fmt_preco_de_custo);

		fmt_preco_de_custo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_preco_de_venda.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_3_2 = new JLabel("Pre\u00E7o de custo");
		lblNewLabel_3_2.setForeground(Color.GRAY);
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(10, 49, 88, 14);
		panel_2.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("Pre\u00E7o de venda");
		lblNewLabel_3_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_1.setBounds(226, 49, 88, 14);
		panel_2.add(lblNewLabel_3_2_1);

		fmt_preco_de_venda = new JFormattedTextField(new NumeroFormatoFloat().getFormatNumber());
		fmt_preco_de_venda.setBounds(226, 74, 206, 27);
		panel_2.add(fmt_preco_de_venda);

		fmt_preco_de_venda.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_margem_de_contribuicao.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_3_2_1_1 = new JLabel("Margem de contribui\u00E7\u00E3o");
		lblNewLabel_3_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1.setBounds(448, 49, 138, 14);
		panel_2.add(lblNewLabel_3_2_1_1);

		fmt_margem_de_contribuicao = new JFormattedTextField(new NumeroFormatoFloat().getFormatNumber());
		fmt_margem_de_contribuicao.setText("0");
		fmt_margem_de_contribuicao.setBounds(448, 74, 206, 27);
		panel_2.add(fmt_margem_de_contribuicao);

		fmt_margem_de_contribuicao.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_estoque_atual.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("(O que \u00E9 isso?)");
		lblNewLabel_3_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirPainelInformacao();
			}
		});
		lblNewLabel_3_2_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 9));
		lblNewLabel_3_2_1_1_1.setBounds(592, 50, 62, 14);
		panel_2.add(lblNewLabel_3_2_1_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 290, 664, 102);
		pn_dados_produtos.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3_1_1 = new JLabel("Estoque");
		lblNewLabel_3_1_1.setForeground(Color.GRAY);
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(10, 0, 168, 38);
		panel_3.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_2_2 = new JLabel("Estoque atual");
		lblNewLabel_3_2_2.setForeground(Color.GRAY);
		lblNewLabel_3_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_2.setBounds(10, 38, 88, 14);
		panel_3.add(lblNewLabel_3_2_2);

		fmt_estoque_atual = new JFormattedTextField();
		fmt_estoque_atual.setBounds(10, 63, 206, 27);
		panel_3.add(fmt_estoque_atual);

		fmt_estoque_atual.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_estoque_minimo.requestFocus();
				}
			}
		});

		fmt_estoque_minimo = new JFormattedTextField();
		fmt_estoque_minimo.setBounds(237, 63, 206, 27);
		panel_3.add(fmt_estoque_minimo);

		fmt_estoque_minimo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_dados_fiscais.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_3_2_1_2 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_3_2_1_2.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_1_2.setBounds(237, 38, 88, 14);
		panel_3.add(lblNewLabel_3_2_1_2);

		JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Controlar estoque");
		lblNewLabel_3_2_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_1_2_1.setBounds(503, 38, 131, 14);
		panel_3.add(lblNewLabel_3_2_1_2_1);

		rn_controlar_estoque_sim = new JRadioButton("Sim");
		rn_controlar_estoque_sim.setSelected(true);
		rn_controlar_estoque_sim.setBounds(502, 64, 58, 23);
		panel_3.add(rn_controlar_estoque_sim);

		rb_controlar_estoque_no = new JRadioButton("N\u00E3o");
		rb_controlar_estoque_no.setBounds(576, 64, 58, 23);
		panel_3.add(rb_controlar_estoque_no);

		JLabel lblNewLabel_3_2_2_1 = new JLabel("Anota\u00E7\u00F5es internas");
		lblNewLabel_3_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2_2_1.setBounds(10, 400, 121, 14);
		pn_dados_produtos.add(lblNewLabel_3_2_2_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 420, 664, 56);
		pn_dados_produtos.add(panel_4);
		panel_4.setLayout(null);

		txtA_anotacoes = new JTextArea();
		txtA_anotacoes.setLineWrap(true);
		txtA_anotacoes.setWrapStyleWord(true);
		txtA_anotacoes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtA_anotacoes.setBounds(10, 11, 644, 34);
		panel_4.add(txtA_anotacoes);

		btn_salvar = new JButton("SALVAR");
		btn_salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salvar();
			}
		});
		btn_salvar.setBounds(585, 487, 89, 29);
		pn_dados_produtos.add(btn_salvar);

		btn_dados_fiscais = new JButton("DADOS FISCAIS");
		btn_dados_fiscais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dadosFiscais();
			}
		});
		btn_dados_fiscais.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dadosFiscais();
			}
		});
		btn_dados_fiscais.setIcon(
				new ImageIcon(NovoProdutoJd.class.getResource("/br/sasclient/imagens/double_right_26px_laranja.png")));
		btn_dados_fiscais.setBounds(396, 487, 179, 29);
		pn_dados_produtos.add(btn_dados_fiscais);

		JPanel pn_dados_fiscais = new JPanel();
		pn_dados_fiscais.setBackground(Color.WHITE);
		tabbedPane.addTab("DADOS FISCAIS", null, pn_dados_fiscais, null);
		pn_dados_fiscais.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 11, 664, 187);
		pn_dados_fiscais.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Origem");
		lblNewLabel_4.setBounds(10, 11, 46, 22);
		panel_5.add(lblNewLabel_4);

		cb_origem = new JComboBox<Object>(origem);
		cb_origem.setBounds(46, 36, 608, 22);
		panel_5.add(cb_origem);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(90, 136, 150));
		panel_6.setBounds(10, 36, 35, 22);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(NovoProdutoJd.class.getResource("/br/sasclient/imagens/menu_15px.png")));
		lblNewLabel_5.setBounds(0, 0, 35, 22);
		panel_6.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Refer\u00EAncia EAN/GTIN");
		lblNewLabel_6.setBounds(10, 69, 137, 14);
		panel_5.add(lblNewLabel_6);

		fmt_referencia_ean_gtin = new JFormattedTextField();
		fmt_referencia_ean_gtin.setText("0");
		fmt_referencia_ean_gtin.setBounds(10, 90, 111, 25);
		panel_5.add(fmt_referencia_ean_gtin);

		fmt_referencia_ean_gtin.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_ncm.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_6_1 = new JLabel("NCM");
		lblNewLabel_6_1.setBounds(178, 69, 35, 14);
		panel_5.add(lblNewLabel_6_1);

		fmt_ncm = new JFormattedTextField();
		fmt_ncm.setText("0");
		fmt_ncm.setBounds(178, 90, 111, 25);
		panel_5.add(fmt_ncm);

		fmt_ncm.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_peso_unitario_liquido.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_6_2 = new JLabel("Peso unit\u00E1rio l\u00EDquido (Kg)");
		lblNewLabel_6_2.setBounds(333, 69, 163, 14);
		panel_5.add(lblNewLabel_6_2);

		fmt_peso_unitario_liquido = new JFormattedTextField(new NumeroFormatoFloat().getFormatNumber());
		fmt_peso_unitario_liquido.setBounds(333, 90, 137, 25);
		panel_5.add(fmt_peso_unitario_liquido);

		fmt_peso_unitario_liquido.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_peso_unitario_bruto.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_6_3 = new JLabel("Peso unit\u00E1rio bruto (Kg)");
		lblNewLabel_6_3.setBounds(517, 69, 137, 14);
		panel_5.add(lblNewLabel_6_3);

		fmt_peso_unitario_bruto = new JFormattedTextField(new NumeroFormatoFloat().getFormatNumber());
		fmt_peso_unitario_bruto.setBounds(517, 90, 137, 25);
		panel_5.add(fmt_peso_unitario_bruto);

		fmt_peso_unitario_bruto.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					fmt_unidade_comercial.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_6_4 = new JLabel("Unidade comercial");
		lblNewLabel_6_4.setToolTipText("Exemplo: UN, PC...");
		lblNewLabel_6_4.setBounds(10, 121, 111, 14);
		panel_5.add(lblNewLabel_6_4);

		fmt_unidade_comercial = new JFormattedTextField();
		fmt_unidade_comercial.setText("unidade");
		fmt_unidade_comercial.setToolTipText("Exemplo: UN, PC...");
		fmt_unidade_comercial.setBounds(10, 142, 111, 25);
		panel_5.add(fmt_unidade_comercial);

		fmt_unidade_comercial.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_retorno.requestFocus();
				}
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Unidade tribut\u00E1ria diferente");
		lblNewLabel_7.setBounds(145, 121, 178, 14);
		panel_5.add(lblNewLabel_7);

		rb_sim = new JRadioButton("Sim");
		rb_sim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rb_sim.isSelected()) {
					fmt_unidade_tributada.setEditable(true);
					fmt_quantidade_tributada.setEditable(true);
					atualizar();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (rb_sim.isSelected()) {
					fmt_unidade_tributada.setEditable(true);
					fmt_quantidade_tributada.setEditable(true);
					atualizar();
				}
			}
		});
		rb_sim.setBounds(156, 141, 53, 23);
		groupo.add(rb_sim);
		panel_5.add(rb_sim);

		rb_nao = new JRadioButton("N\u00E3o");
		rb_nao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rb_nao.isSelected()) {
					fmt_unidade_tributada.setEditable(false);
					fmt_quantidade_tributada.setEditable(false);
					atualizar();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (rb_nao.isSelected()) {
					fmt_unidade_tributada.setEditable(false);
					fmt_quantidade_tributada.setEditable(false);
					atualizar();
				}
			}
		});
		rb_nao.setSelected(true);
		rb_nao.setBounds(243, 141, 66, 23);
		groupo.add(rb_nao);
		panel_5.add(rb_nao);

		lbl_unidade_tributada = new JLabel("Unidade tributada");
		lbl_unidade_tributada.setBounds(333, 121, 137, 14);
		panel_5.add(lbl_unidade_tributada);

		fmt_unidade_tributada = new JFormattedTextField();
		fmt_unidade_tributada.setToolTipText("Exemplo: UN, PC...");
		fmt_unidade_tributada.setBounds(333, 142, 137, 25);
		if (rb_nao.isSelected()) {
			fmt_unidade_tributada.setEditable(false);
		}
		panel_5.add(fmt_unidade_tributada);

		lbl_quantidade_tributada = new JLabel("Quantidade tributada");
		lbl_quantidade_tributada.setBounds(517, 121, 137, 14);
		panel_5.add(lbl_quantidade_tributada);

		fmt_quantidade_tributada = new JFormattedTextField();
		fmt_quantidade_tributada.setText("1");
		fmt_quantidade_tributada.setBounds(517, 142, 137, 25);
		if (rb_nao.isSelected()) {
			fmt_quantidade_tributada.setEditable(false);
		}
		panel_5.add(fmt_quantidade_tributada);

		btn_retorno = new JButton("DADOS DO PRODUTO");
		btn_retorno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				voltar();
			}
		});
		btn_retorno.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				voltar();
			}
		});
		btn_retorno
				.setIcon(new ImageIcon(NovoProdutoJd.class.getResource("/br/sasclient/imagens/double_left_26px.png")));
		btn_retorno.setBounds(10, 208, 230, 29);
		pn_dados_fiscais.add(btn_retorno);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		panel.setBackground(new Color(90, 136, 150));
		panel.setBounds(0, 0, 689, 38);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Novo produto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 106, 38);
		panel.add(lblNewLabel);

		JLabel lbl_fechar = new JLabel("");
		lbl_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_fechar.setForeground(new Color(255, 255, 255));
				lbl_fechar.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/cancel_25px.png")));
			}

			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				NovoProdutoJd.this.hide();
			}
		});
		lbl_fechar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_fechar.setForeground(new Color(220, 81, 29));
				lbl_fechar.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/cancel_25px_laranja.png")));
			}
		});
		lbl_fechar.setIcon(new ImageIcon(NovoProdutoJd.class.getResource("/br/sasclient/imagens/cancel_25px.png")));
		lbl_fechar.setBounds(654, 0, 35, 38);
		panel.add(lbl_fechar);

		carregarProduto();
	}

	protected void dadosFiscais() {
		tabbedPane.setSelectedIndex(1);
		fmt_referencia_ean_gtin.requestFocus();
	}

	protected void voltar() {
		tabbedPane.setSelectedIndex(0);
		txtA_anotacoes.requestFocus();
	}

	protected void abrirPainelInformacao() {

	}

	protected void atualizar() {
		NovoProdutoJd.this.repaint();
		NovoProdutoJd.this.revalidate();
	}

	protected void salvar() {
		if (produto2.getId() != null) {// atualizar

			produto2.setProduto(fmt_produto.getText().toString());
			produto2.setCodigoProduto(fmt_codigo_proprio.getText().toString());
			produto2.setCategoria(fmt_categoria.getText().toString());
			String c = new FuncoesUtil().getValor(fmt_preco_de_custo.getText().toString().replace(".", "#"));
			if ("".equals(c)) {
				c = fmt_preco_de_custo.getText().toString();
			}
			String v = new FuncoesUtil().getValor(fmt_preco_de_venda.getText().toString().replace(".", "#"));
			if ("".equals(v)) {
				v = fmt_preco_de_venda.getText().toString();
			}
			String m = new FuncoesUtil().getValor(fmt_margem_de_contribuicao.getText().toString().replace(".", "#"));
			if ("".equals(m)) {
				m = fmt_margem_de_contribuicao.getText().toString();
			}
			String pl = new FuncoesUtil().getValor(fmt_peso_unitario_liquido.getText().toString().replace(".", "#"));
			if ("".equals(pl)) {
				pl = fmt_peso_unitario_liquido.getText().toString();
			}
			String pb = new FuncoesUtil().getValor(fmt_peso_unitario_bruto.getText().toString().replace(".", "#"));
			if ("".equals(pb)) {
				pb = fmt_peso_unitario_bruto.getText().toString();
			}

			produto2.setValorCusto(Double.parseDouble(c.replace(",", ".")));
			produto2.setPrecoVenda(Double.parseDouble(v.replace(",", ".")));
			produto2.setMargemContribuicao(Double.parseDouble(m.replace(",", ".")));
			if (rn_controlar_estoque_sim.isSelected()) {
				produto2.setControlarEstoque(1);
			} else {
				produto2.setControlarEstoque(0);
			}
			produto2.setEstoqueAtual(Integer.parseInt(fmt_estoque_atual.getText().toString()));
			produto2.setEstoqueMinimo(Integer.parseInt(fmt_estoque_minimo.getText().toString()));
			produto2.setObservacao(txtA_anotacoes.getText().toString());
			// fiscal
			produto2.setOrigem(cb_origem.getSelectedIndex());
			produto2.setReferenciaEanGtin(Integer.parseInt(fmt_referencia_ean_gtin.getText().toString()));
			produto2.setPesoUnitarioLiquidoKg(Double.parseDouble(pl.replace(",", ".")));
			produto2.setPesoUnitarioBrutoKg(Double.parseDouble(pb.replace(",", ".")));
			produto2.setNcm(Integer.parseInt(fmt_ncm.getText().toString()));
			produto2.setuCom(fmt_unidade_comercial.getText().toString());
			if (rb_sim.isSelected()) {
				produto2.setQtdTributada(Integer.parseInt(fmt_quantidade_tributada.getText().toString()));
				produto2.setUtrib(fmt_unidade_tributada.getText().toString());
			}
			ProdutoForm form = new ProdutoForm(produto2);
			form.setId(produto2.getId());
			ProdutoDto atualizarProduto = new ProdutoServiceClient(tokenDto).atualizarProduto(form);
			if (atualizarProduto.getId() == null) {
				fmt_produto.requestFocus();
				msg("Algo deu errado!");
			} else {
				atualizarForm();
			}
			NovoProdutoJd.this.dispose();
		} else { // salvar
			produto = new ProdutoDto();

			produto.setProduto(fmt_produto.getText().toString());
			produto.setCodigoProduto(fmt_codigo_proprio.getText().toString());
			produto.setCategoria(fmt_categoria.getText().toString());
			String c = new FuncoesUtil().getValor(fmt_preco_de_custo.getText().toString().replace(".", "#"));
			if ("".equals(c)) {
				c = fmt_preco_de_custo.getText().toString();
			}
			String v = new FuncoesUtil().getValor(fmt_preco_de_venda.getText().toString().replace(".", "#"));
			if ("".equals(v)) {
				v = fmt_preco_de_venda.getText().toString();
			}
			String m = new FuncoesUtil().getValor(fmt_margem_de_contribuicao.getText().toString().replace(".", "#"));
			if ("".equals(m)) {
				m = fmt_margem_de_contribuicao.getText().toString();
			}
			String pl = new FuncoesUtil().getValor(fmt_peso_unitario_liquido.getText().toString().replace(".", "#"));
			if ("".equals(pl)) {
				pl = fmt_peso_unitario_liquido.getText().toString();
			}
			String pb = new FuncoesUtil().getValor(fmt_peso_unitario_bruto.getText().toString().replace(".", "#"));
			if ("".equals(pb)) {
				pb = fmt_peso_unitario_bruto.getText().toString();
			}

			produto.setValorCusto(Double.parseDouble(c.replace(",", ".")));
			produto.setPrecoVenda(Double.parseDouble(v.replace(",", ".")));
			produto.setMargemContribuicao(Double.parseDouble(m.replace(",", ".")));
			if (rn_controlar_estoque_sim.isSelected()) {
				produto.setControlarEstoque(1);
			} else {
				produto.setControlarEstoque(0);
			}
			produto.setEstoqueAtual(Integer.parseInt(fmt_estoque_atual.getText().toString()));
			produto.setEstoqueMinimo(Integer.parseInt(fmt_estoque_minimo.getText().toString()));
			produto.setObservacao(txtA_anotacoes.getText().toString());
			// fiscal
			produto.setOrigem(cb_origem.getSelectedIndex());
			produto.setReferenciaEanGtin(Integer.parseInt(fmt_referencia_ean_gtin.getText().toString()));
			produto.setPesoUnitarioLiquidoKg(Double.parseDouble(pl.replace(",", ".")));
			produto.setPesoUnitarioBrutoKg(Double.parseDouble(pb.replace(",", ".")));
			produto.setNcm(Integer.parseInt(fmt_ncm.getText().toString()));
			produto.setuCom(fmt_unidade_comercial.getText().toString());
			if (rb_sim.isSelected()) {
				produto.setQtdTributada(Integer.parseInt(fmt_quantidade_tributada.getText().toString()));
				produto.setUtrib(fmt_unidade_tributada.getText().toString());
			}

			ProdutoDto registrarProduto = new ProdutoServiceClient(tokenDto).registrarProduto(produto);
			if (registrarProduto.getId() == null) {
				fmt_produto.requestFocus();
				msg("Algo deu errado!");
			} else {
				produto.setId(registrarProduto.getId());
				
				atualizarForm();

				listaProdutos.add(produto);
				msg("Registrado!");
			}
		}
	}
	
	public void atualizarForm() {
		fmt_produto.setText("");
		fmt_codigo_proprio.setText("");
		fmt_categoria.setText("");
		fmt_preco_de_custo.setText("0");
		fmt_preco_de_venda.setText("0");
		fmt_margem_de_contribuicao.setText("0");
		rn_controlar_estoque_sim.setSelected(true);
		fmt_estoque_atual.setText("0");
		fmt_estoque_minimo.setText("0");
		txtA_anotacoes.setText("");
		cb_origem.setSelectedIndex(0);
		fmt_referencia_ean_gtin.setText("0");
		fmt_peso_unitario_bruto.setText("0");
		fmt_peso_unitario_liquido.setText("0");
		fmt_ncm.setText("0");
		fmt_unidade_comercial.setText("UNIDADE");
		if (rb_sim.isSelected()) {
			fmt_quantidade_tributada.setText("0");
			fmt_unidade_tributada.setText("1");
		}
	}

	private void msg(String msg) {
		new MensagensJD2(msg, "Produto").setVisible(true);
	}

	public List<ProdutoDto> produto() {
		if (listaProdutos == null) {
			listaProdutos = new ArrayList<ProdutoDto>();
		}
		return listaProdutos;
	}

	public ProdutoDto pegarProdutoAtualizado() {
		return produto2;
	}

	private void carregarProduto() {
		if (produto2.getId() != null) {
			produto = new ProdutoDto();
			produto = produto2;
			fmt_produto.setText(produto2.getProduto());
			fmt_codigo_proprio.setText(produto2.getCodigoProduto());
			fmt_categoria.setText(produto2.getCategoria());
			fmt_preco_de_custo.setText(String.valueOf(produto2.getValorCusto()));
			fmt_preco_de_venda.setText(String.valueOf(produto2.getPrecoVenda()));
			fmt_margem_de_contribuicao.setText(String.valueOf(produto2.getMargemContribuicao()));
			if (produto2.getControlarEstoque() == 1) {
				rn_controlar_estoque_sim.setSelected(true);
			} else {
				rb_controlar_estoque_no.setSelected(true);
			}
			fmt_estoque_atual.setText(String.valueOf(produto2.getEstoqueAtual()));
			fmt_estoque_minimo.setText(String.valueOf(produto2.getEstoqueMinimo()));
			txtA_anotacoes.setText(produto2.getObservacao());
			cb_origem.setSelectedIndex(produto2.getOrigem());
			fmt_referencia_ean_gtin.setText(String.valueOf(produto2.getReferenciaEanGtin()));
			fmt_peso_unitario_bruto.setText(String.valueOf(produto2.getPesoUnitarioBrutoKg()));
			fmt_peso_unitario_liquido.setText(String.valueOf(produto2.getPesoUnitarioLiquidoKg()));
			fmt_ncm.setText(String.valueOf(produto2.getNcm()));
			fmt_unidade_comercial.setText(produto2.getuCom());
			fmt_quantidade_tributada.setText(String.valueOf(produto2.getQtdTributada()));
			fmt_unidade_tributada.setText(produto2.getUtrib());

		}
	}
}
