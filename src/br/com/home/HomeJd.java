package br.com.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.classes.TokenDto;
import br.com.home.login.LoginJd;
import br.com.msg.MensagensJD2;
import br.com.produto.ProdutoJd;

public class HomeJd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private TokenDto tokenDto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HomeJd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeJd dialog = new HomeJd();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public HomeJd() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1350, 760);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 685, 1350, 75);
		panel.setBackground(new Color(90, 136, 150));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome do sistema");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 1350, 30);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(0, 30, 1350, 19);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Telefone");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(0, 56, 1350, 19);
		panel.add(lblNewLabel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1350, 81);
		panel_1.setBackground(new Color(90, 136, 150));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lb_sair = new JLabel("Sair");
		lb_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_sair.setForeground(new Color(255, 255, 255));
				lb_sair.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/exit_25px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		lb_sair.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_sair.setForeground(new Color(220, 81, 29));
				lb_sair.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/exit_25px_laranja.png")));
			}
		});
		lb_sair.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/exit_25px.png")));
		lb_sair.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lb_sair.setForeground(Color.WHITE);
		lb_sair.setBounds(1278, 0, 72, 81);
		panel_1.add(lb_sair);

		JLabel lb_logar = new JLabel("Logar");
		lb_logar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_logar.setForeground(new Color(255, 255, 255));
				lb_logar.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/add_user_male_50px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				logar();
			}
		});
		lb_logar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_logar.setForeground(new Color(220, 81, 29));
				lb_logar.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/add_user_male_50px_laranja.png")));
			}
		});
		lb_logar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lb_logar.setForeground(Color.WHITE);
		lb_logar.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/add_user_male_50px.png")));
		lb_logar.setBounds(24, 0, 178, 81);
		panel_1.add(lb_logar);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 80, 268, 605);
		panel_2.setBackground(new Color(90, 136, 150));
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 268, 35);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Profissional");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 259, 35);
		panel_3.add(lblNewLabel);

		JPanel pn_financeiro = new JPanel();
		pn_financeiro.setBackground(new Color(90, 136, 150));
		pn_financeiro.setBounds(0, 33, 268, 35);
		panel_2.add(pn_financeiro);
		pn_financeiro.setLayout(null);

		JPanel p_lateral_financeiro = new JPanel();
		p_lateral_financeiro.setBackground(new Color(192, 192, 192));
		p_lateral_financeiro.setBounds(0, 0, 4, 35);
		pn_financeiro.add(p_lateral_financeiro);

		JLabel lb_financeiro = new JLabel("Financeiro");
		lb_financeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_financeiro.setForeground(new Color(255, 255, 255));
				pn_financeiro.setBackground(new Color(90, 136, 150));
				p_lateral_financeiro.setBackground(new Color(192, 192, 192));
				lb_financeiro.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/duration_finance_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_financeiro.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_financeiro.setForeground(new Color(220, 81, 29));
				pn_financeiro.setBackground(new Color(52, 52, 52));
				p_lateral_financeiro.setBackground(new Color(220, 81, 29));
				lb_financeiro.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/duration_finance_20px_laranja.png")));
			}
		});
		lb_financeiro
				.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/duration_finance_20px.png")));
		lb_financeiro.setForeground(Color.WHITE);
		lb_financeiro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_financeiro.setBounds(10, 0, 258, 35);
		pn_financeiro.add(lb_financeiro);

		JPanel pn_vendas = new JPanel();
		pn_vendas.setLayout(null);
		pn_vendas.setBackground(new Color(90, 136, 150));
		pn_vendas.setBounds(0, 67, 268, 35);
		panel_2.add(pn_vendas);

		JPanel p_lateral_vendas = new JPanel();
		p_lateral_vendas.setBackground(new Color(192, 192, 192));
		p_lateral_vendas.setBounds(0, 0, 4, 35);
		pn_vendas.add(p_lateral_vendas);

		JLabel lb_vendas = new JLabel("Vendas");
		lb_vendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_vendas.setForeground(new Color(255, 255, 255));
				pn_vendas.setBackground(new Color(90, 136, 150));
				p_lateral_vendas.setBackground(new Color(192, 192, 192));
				lb_vendas.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/checkout_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_vendas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_vendas.setForeground(new Color(220, 81, 29));
				pn_vendas.setBackground(new Color(52, 52, 52));
				p_lateral_vendas.setBackground(new Color(220, 81, 29));
				lb_vendas.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/checkout_20px_laranja.png")));
			}
		});
		lb_vendas.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/checkout_20px.png")));
		lb_vendas.setForeground(Color.WHITE);
		lb_vendas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_vendas.setBounds(10, 0, 258, 35);
		pn_vendas.add(lb_vendas);

		JPanel pn_compras = new JPanel();
		pn_compras.setLayout(null);
		pn_compras.setBackground(new Color(90, 136, 150));
		pn_compras.setBounds(0, 102, 268, 35);
		panel_2.add(pn_compras);

		JPanel p_lateral_compras = new JPanel();
		p_lateral_compras.setBackground(new Color(192, 192, 192));
		p_lateral_compras.setBounds(0, 0, 4, 35);
		pn_compras.add(p_lateral_compras);

		JLabel lb_compras = new JLabel("Compras");
		lb_compras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_compras.setForeground(new Color(255, 255, 255));
				pn_compras.setBackground(new Color(90, 136, 150));
				p_lateral_compras.setBackground(new Color(192, 192, 192));
				lb_compras.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/truck_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_compras.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_compras.setForeground(new Color(220, 81, 29));
				pn_compras.setBackground(new Color(52, 52, 52));
				p_lateral_compras.setBackground(new Color(220, 81, 29));
				lb_compras.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/truck_20px_laranja.png")));
			}
		});
		lb_compras.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/truck_20px.png")));
		lb_compras.setForeground(Color.WHITE);
		lb_compras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_compras.setBounds(10, 0, 258, 35);
		pn_compras.add(lb_compras);

		JPanel pn_clientes = new JPanel();
		pn_clientes.setLayout(null);
		pn_clientes.setBackground(new Color(90, 136, 150));
		pn_clientes.setBounds(0, 137, 268, 35);
		panel_2.add(pn_clientes);

		JPanel p_lateral_clientes = new JPanel();
		p_lateral_clientes.setBackground(new Color(192, 192, 192));
		p_lateral_clientes.setBounds(0, 0, 4, 35);
		pn_clientes.add(p_lateral_clientes);

		JLabel lb_clientes = new JLabel("Clientes");
		lb_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_clientes.setForeground(new Color(255, 255, 255));
				pn_clientes.setBackground(new Color(90, 136, 150));
				p_lateral_clientes.setBackground(new Color(192, 192, 192));
				lb_clientes.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/user_group_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_clientes.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_clientes.setForeground(new Color(220, 81, 29));
				pn_clientes.setBackground(new Color(52, 52, 52));
				p_lateral_clientes.setBackground(new Color(220, 81, 29));
				lb_clientes.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/user_group_20px_laranja.png")));
			}
		});
		lb_clientes.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/user_group_20px.png")));
		lb_clientes.setForeground(Color.WHITE);
		lb_clientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_clientes.setBounds(10, 0, 258, 35);
		pn_clientes.add(lb_clientes);

		JPanel pn_produtos = new JPanel();
		pn_produtos.setLayout(null);
		pn_produtos.setBackground(new Color(90, 136, 150));
		pn_produtos.setBounds(0, 170, 268, 35);
		panel_2.add(pn_produtos);

		JPanel p_lateral_produtos = new JPanel();
		p_lateral_produtos.setBackground(new Color(192, 192, 192));
		p_lateral_produtos.setBounds(0, 0, 4, 35);
		pn_produtos.add(p_lateral_produtos);

		JLabel lb_produtos = new JLabel("Produtos");
		lb_produtos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_produtos.setForeground(new Color(255, 255, 255));
				pn_produtos.setBackground(new Color(90, 136, 150));
				p_lateral_produtos.setBackground(new Color(192, 192, 192));
				lb_produtos.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/box_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				cadastroProdutos();
			}
		});
		lb_produtos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_produtos.setForeground(new Color(220, 81, 29));
				pn_produtos.setBackground(new Color(52, 52, 52));
				p_lateral_produtos.setBackground(new Color(220, 81, 29));
				lb_produtos.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/box_20px_laranja.png")));
			}
		});
		lb_produtos.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/box_20px.png")));
		lb_produtos.setForeground(Color.WHITE);
		lb_produtos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_produtos.setBounds(10, 0, 258, 35);
		pn_produtos.add(lb_produtos);

		JPanel pn_relatorios = new JPanel();
		pn_relatorios.setLayout(null);
		pn_relatorios.setBackground(new Color(90, 136, 150));
		pn_relatorios.setBounds(0, 204, 268, 35);
		panel_2.add(pn_relatorios);

		JPanel p_lateral_relatorios = new JPanel();
		p_lateral_relatorios.setBackground(new Color(192, 192, 192));
		p_lateral_relatorios.setBounds(0, 0, 4, 35);
		pn_relatorios.add(p_lateral_relatorios);

		JLabel lb_realtorios = new JLabel("Relat\u00F3rios");
		lb_realtorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_realtorios.setForeground(new Color(255, 255, 255));
				pn_relatorios.setBackground(new Color(90, 136, 150));
				p_lateral_relatorios.setBackground(new Color(192, 192, 192));
				lb_realtorios.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/add_graph_report_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_realtorios.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_realtorios.setForeground(new Color(220, 81, 29));
				pn_relatorios.setBackground(new Color(52, 52, 52));
				p_lateral_relatorios.setBackground(new Color(220, 81, 29));
				lb_realtorios.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/add_graph_report_20px_laranjapng.png")));
			}
		});
		lb_realtorios
				.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/add_graph_report_20px.png")));
		lb_realtorios.setForeground(Color.WHITE);
		lb_realtorios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_realtorios.setBounds(10, 0, 258, 35);
		pn_relatorios.add(lb_realtorios);

		JPanel pn_configuracoes = new JPanel();
		pn_configuracoes.setLayout(null);
		pn_configuracoes.setBackground(new Color(90, 136, 150));
		pn_configuracoes.setBounds(0, 236, 268, 35);
		panel_2.add(pn_configuracoes);

		JPanel p_lateral_configuracoes = new JPanel();
		p_lateral_configuracoes.setBackground(new Color(192, 192, 192));
		p_lateral_configuracoes.setBounds(0, 0, 4, 35);
		pn_configuracoes.add(p_lateral_configuracoes);

		JLabel lb_configuracoes = new JLabel("Configura\u00E7\u00F5es");
		lb_configuracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_configuracoes.setForeground(new Color(255, 255, 255));
				pn_configuracoes.setBackground(new Color(90, 136, 150));
				p_lateral_configuracoes.setBackground(new Color(192, 192, 192));
				lb_configuracoes.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/admin_settings_male_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_configuracoes.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_configuracoes.setForeground(new Color(220, 81, 29));
				pn_configuracoes.setBackground(new Color(52, 52, 52));
				p_lateral_configuracoes.setBackground(new Color(220, 81, 29));
				lb_configuracoes.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/admin_settings_male_20px_laranja.png")));
			}
		});
		lb_configuracoes
				.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/admin_settings_male_20px.png")));
		lb_configuracoes.setForeground(Color.WHITE);
		lb_configuracoes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_configuracoes.setBounds(10, 0, 258, 35);
		pn_configuracoes.add(lb_configuracoes);

		JPanel pn_nfe = new JPanel();
		pn_nfe.setLayout(null);
		pn_nfe.setBackground(new Color(90, 136, 150));
		pn_nfe.setBounds(0, 269, 268, 35);
		panel_2.add(pn_nfe);

		JPanel p_lateral_nfe = new JPanel();
		p_lateral_nfe.setBackground(new Color(192, 192, 192));
		p_lateral_nfe.setBounds(0, 0, 4, 35);
		pn_nfe.add(p_lateral_nfe);

		JLabel lb_nfe = new JLabel("NF-e");
		lb_nfe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_nfe.setForeground(new Color(255, 255, 255));
				pn_nfe.setBackground(new Color(90, 136, 150));
				p_lateral_nfe.setBackground(new Color(192, 192, 192));
				lb_nfe.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/bill_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_nfe.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_nfe.setForeground(new Color(220, 81, 29));
				pn_nfe.setBackground(new Color(52, 52, 52));
				p_lateral_nfe.setBackground(new Color(220, 81, 29));
				lb_nfe.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/bill_20px_laranja.png")));
			}
		});
		lb_nfe.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/bill_20px.png")));
		lb_nfe.setForeground(Color.WHITE);
		lb_nfe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_nfe.setBounds(10, 0, 258, 35);
		pn_nfe.add(lb_nfe);

		JPanel pn_fiscal = new JPanel();
		pn_fiscal.setLayout(null);
		pn_fiscal.setBackground(new Color(90, 136, 150));
		pn_fiscal.setBounds(0, 301, 268, 35);
		panel_2.add(pn_fiscal);

		JPanel p_lateral_fiscal = new JPanel();
		p_lateral_fiscal.setBackground(new Color(192, 192, 192));
		p_lateral_fiscal.setBounds(0, 0, 4, 35);
		pn_fiscal.add(p_lateral_fiscal);

		JLabel lb_fiscal = new JLabel("Fiscal");
		lb_fiscal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lb_fiscal.setForeground(new Color(255, 255, 255));
				pn_fiscal.setBackground(new Color(90, 136, 150));
				p_lateral_fiscal.setBackground(new Color(192, 192, 192));
				lb_fiscal.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/sasclient/imagens/bill_20px.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lb_fiscal.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lb_fiscal.setForeground(new Color(220, 81, 29));
				pn_fiscal.setBackground(new Color(52, 52, 52));
				p_lateral_fiscal.setBackground(new Color(220, 81, 29));
				lb_fiscal.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/sasclient/imagens/bill_20px_laranja.png")));
			}
		});
		lb_fiscal.setIcon(new ImageIcon(HomeJd.class.getResource("/br/sasclient/imagens/bill_20px.png")));
		lb_fiscal.setForeground(Color.WHITE);
		lb_fiscal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lb_fiscal.setBounds(10, 0, 258, 35);
		pn_fiscal.add(lb_fiscal);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(268, 81, 1082, 604);
		contentPanel.add(panel_4);

	}

	protected void cadastroProdutos() {
		if (tokenDto != null) {
			if (tokenDto.getPermissao() != null) {
				ProdutoJd jd = new ProdutoJd(tokenDto);
				jd.setVisible(true);
			} else {
				msg();
			}
		} else {
			msg();
		}
	}
	
	protected void msg() {
		new MensagensJD2("Acesso inválido!", "Acesso").setVisible(true);;
	}

	protected void logar() {
		new Thread() {
			@Override
			public void run() {
				LoginJd jd = new LoginJd();
				jd.setVisible(true);

				while (jd.isVisible()) {
				}

				tokenDto = jd.retornoLogin();
			}
		}.start();
	}
}
