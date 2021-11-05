package br.com.produto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.classes.DeletarProdutoForm;
import br.com.classes.ProdutoDto;
import br.com.classes.TokenDto;
import br.com.modelos.TabelaModeloProduto;
import br.com.msg.MensagemProgresJd;
import br.com.service.ProdutoServiceClient;

public class ProdutoJd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable tb_produtos;
	private ArrayList<ProdutoDto> listaProduto;
	private TabelaModeloProduto modeloProduto;
	private ProdutoDto produto;
	private int linhaSelecionada;
	private static TokenDto tokenDto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProdutoJd dialog = new ProdutoJd(tokenDto);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProdutoJd(TokenDto tokenDto) {
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setBounds(268, 81, 1082, 604);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ProdutoJd.tokenDto = tokenDto;

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(553 / 2, d.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(23, 163, 152));
		panel.setBounds(0, 0, 1082, 62);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Produto ou Servi\u00E7o");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 213, 62);
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
				ProdutoJd.this.hide();
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
		lbl_fechar.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/cancel_25px.png")));
		lbl_fechar.setBounds(1050, 0, 32, 62);
		panel.add(lbl_fechar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(10, 89, 1072, 504);
		contentPanel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Produto", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel pn_novo = new JPanel();
		pn_novo.setBackground(new Color(23, 163, 152));
		pn_novo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		pn_novo.setBounds(20, 23, 84, 32);
		panel_1.add(pn_novo);
		pn_novo.setLayout(null);

		JLabel lbl_novo = new JLabel("  Novo");
		lbl_novo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_novo.setForeground(new Color(255, 255, 255));
				pn_novo.setBackground(new Color(23, 163, 152));
				lbl_novo.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/abrir_15px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				novo();
			}
		});
		lbl_novo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_novo.setForeground(new Color(220, 81, 29));
				pn_novo.setBackground(new Color(19, 147, 63));
				lbl_novo.setIcon(
						new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/abrir_15px_laranja.png")));
			}
		});
		lbl_novo.setForeground(Color.WHITE);
		lbl_novo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_novo.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/abrir_15px.png")));
		lbl_novo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_novo.setBounds(0, 0, 84, 32);
		pn_novo.add(lbl_novo);

		JPanel pn_excluir = new JPanel();
		pn_excluir.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		pn_excluir.setBackground(new Color(90, 136, 150));
		pn_excluir.setBounds(114, 23, 34, 32);
		panel_1.add(pn_excluir);
		pn_excluir.setLayout(null);

		JLabel lbl_deletar = new JLabel("");
		lbl_deletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_deletar.setForeground(new Color(255, 255, 255));
				pn_excluir.setBackground(new Color(90, 136, 150));
				lbl_deletar.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/trash_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				linhaSelecionada = tb_produtos.getSelectedRow();
				int status = new ProdutoServiceClient(tokenDto)
						.deletarProduto(new DeletarProdutoForm(listaProduto.get(linhaSelecionada).getId()));

				MensagemProgresJd jd = new MensagemProgresJd();
				jd.setVisible(true);

				if (status == 200) {
					listaProduto.remove(linhaSelecionada);
					atualizarTela();
				}
			}
		});
		lbl_deletar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_deletar.setForeground(new Color(220, 81, 29));
				pn_excluir.setBackground(new Color(19, 147, 63));
				lbl_deletar.setIcon(
						new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/trash_25px_laranja.png")));
			}
		});
		lbl_deletar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_deletar.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/trash_25px.png")));
		lbl_deletar.setBounds(0, 0, 34, 32);
		pn_excluir.add(lbl_deletar);

		JPanel pn_print_out = new JPanel();
		pn_print_out.setBackground(new Color(90, 136, 150));
		pn_print_out.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		pn_print_out.setBounds(154, 23, 34, 32);
		panel_1.add(pn_print_out);
		pn_print_out.setLayout(null);

		JLabel lbl_imprimir = new JLabel("");
		lbl_imprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_imprimir.setForeground(new Color(255, 255, 255));
				pn_print_out.setBackground(new Color(90, 136, 150));
				lbl_imprimir
						.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/print_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lbl_imprimir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_imprimir.setForeground(new Color(220, 81, 29));
				pn_print_out.setBackground(new Color(19, 147, 63));
				lbl_imprimir.setIcon(
						new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/print_25px_laranja.png")));
			}
		});
		lbl_imprimir.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imprimir.setBounds(0, 0, 34, 32);
		lbl_imprimir.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/print_25px.png")));
		pn_print_out.add(lbl_imprimir);

		textField = new JTextField();
		textField.setBounds(775, 23, 239, 26);
		panel_1.add(textField);
		textField.setColumns(10);

		JPanel pn_buscar_produto = new JPanel();
		pn_buscar_produto.setBackground(new Color(90, 136, 150));
		pn_buscar_produto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		pn_buscar_produto.setBounds(1013, 23, 24, 26);
		panel_1.add(pn_buscar_produto);
		pn_buscar_produto.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/search_more_20px.png")));
		lblNewLabel_4.setBounds(0, 0, 24, 25);
		pn_buscar_produto.add(lblNewLabel_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 86, 1032, 375);
		panel_1.add(scrollPane);

		/*
		 * Lista de produtos
		 */
		listaProduto = new ProdutoServiceClient(tokenDto).listaProduto();
		this.modeloProduto = new TabelaModeloProduto(listaProduto);

		tb_produtos = new JTable();
		tb_produtos.setModel(modeloProduto);
		scrollPane.setViewportView(tb_produtos);

		JPanel pn_atualizar_produto = new JPanel();
		pn_atualizar_produto.setBackground(new Color(23, 163, 152));
		pn_atualizar_produto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		pn_atualizar_produto.setBounds(199, 23, 149, 32);
		panel_1.add(pn_atualizar_produto);
		pn_atualizar_produto.setLayout(null);

		JLabel lbl_atualizar = new JLabel("Atualizar Produto");
		lbl_atualizar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_atualizar.setForeground(new Color(220, 81, 29));
				pn_atualizar_produto.setBackground(new Color(19, 147, 63));
				lbl_atualizar.setIcon(
						new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/box_20px_laranja.png")));
			}
		});
		lbl_atualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_atualizar.setForeground(new Color(255, 255, 255));
				pn_atualizar_produto.setBackground(new Color(90, 136, 150));
				lbl_atualizar.setIcon(
						new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/box_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				retornaProdutoSelecionadoNaLista();
				new Thread() {
					public void run() {
						NovoProdutoJd jd = new NovoProdutoJd(produto, tokenDto);
						jd.setVisible(true);

						while (jd.isVisible()) {
						}

						produto = jd.pegarProdutoAtualizado();

						listaProduto.set(linhaSelecionada, produto);
						atualizarTela();
					};
				}.start();
			}
		});
		lbl_atualizar.setIcon(new ImageIcon(ProdutoJd.class.getResource("/br/sasclient/imagens/box_20px.png")));
		lbl_atualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_atualizar.setForeground(Color.WHITE);
		lbl_atualizar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_atualizar.setBounds(0, 0, 149, 32);
		pn_atualizar_produto.add(lbl_atualizar);
	}

	protected void novo() {
		produto = new ProdutoDto();
		new Thread() {
			public void run() {
				NovoProdutoJd jd = new NovoProdutoJd(produto, tokenDto);
				jd.setVisible(true);

				while (jd.isVisible()) {
				}

				List<ProdutoDto> transferencia = jd.produto();
				if (transferencia.size() != 0) {
					for (ProdutoDto produto2 : transferencia) {
						listaProduto.add(produto2);
					}
					modeloProduto = new TabelaModeloProduto(listaProduto);
					tb_produtos.setModel(modeloProduto);
				}
			};
		}.start();
	}

	protected void retornaProdutoSelecionadoNaLista() {

		produto = new ProdutoDto();

		linhaSelecionada = tb_produtos.getSelectedRow();
		produto.setId(listaProduto.get(linhaSelecionada).getId());
		produto.setProduto(listaProduto.get(linhaSelecionada).getProduto());
		produto.setCodigoProduto(listaProduto.get(linhaSelecionada).getCodigoProduto());
		produto.setCategoria(listaProduto.get(linhaSelecionada).getCategoria());
		produto.setPrecoVenda(listaProduto.get(linhaSelecionada).getPrecoVenda());
		produto.setValorCusto(listaProduto.get(linhaSelecionada).getValorCusto());
		produto.setMargemContribuicao(listaProduto.get(linhaSelecionada).getMargemContribuicao());
		produto.setControlarEstoque(listaProduto.get(linhaSelecionada).getControlarEstoque());
		produto.setEstoqueAtual(listaProduto.get(linhaSelecionada).getEstoqueAtual());
		produto.setEstoqueMinimo(listaProduto.get(linhaSelecionada).getEstoqueMinimo());
		produto.setObservacao(listaProduto.get(linhaSelecionada).getObservacao());
		produto.setOrigem(listaProduto.get(linhaSelecionada).getOrigem());
		produto.setReferenciaEanGtin(listaProduto.get(linhaSelecionada).getReferenciaEanGtin());
		produto.setPesoUnitarioBrutoKg(listaProduto.get(linhaSelecionada).getPesoUnitarioBrutoKg());
		produto.setPesoUnitarioLiquidoKg(listaProduto.get(linhaSelecionada).getPesoUnitarioLiquidoKg());
		produto.setNcm(listaProduto.get(linhaSelecionada).getNcm());
		produto.setuCom(listaProduto.get(linhaSelecionada).getuCom());
		produto.setQtdTributada(listaProduto.get(linhaSelecionada).getQtdTributada());
		produto.setUtrib(listaProduto.get(linhaSelecionada).getUtrib());

	}

	private void atualizarTela() {
		ProdutoJd.this.repaint();
		ProdutoJd.this.revalidate();
		ProdutoJd.this.update(getGraphics());
	}
}
