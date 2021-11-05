package br.com.home.login;

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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.com.classes.TokenDto;
import br.com.classes.UsuarioForm;
import br.com.msg.MensagensJD2;
import br.com.service.UsuarioServiceClient;
import br.sasclient.util.LimiteTxt;
import javax.swing.ImageIcon;

public class LoginJd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField txt_ps;
	private TokenDto token;
	private JFormattedTextField ft_usuario;
	private JButton btnAcessar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginJd dialog = new LoginJd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginJd() {
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 366, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(90, 136, 150));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(45, 113, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(45, 158, 46, 14);
		contentPanel.add(lblNewLabel_1);

		txt_ps = new JPasswordField();
		txt_ps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAcessar.requestFocus();
				}
			}
		});
		txt_ps.setBounds(124, 155, 187, 20);
		contentPanel.add(txt_ps);

		btnAcessar = new JButton("ACESSAR");
		btnAcessar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				acessar();
			}
		});
		btnAcessar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acessar();
			}
		});
		btnAcessar.setBounds(124, 196, 89, 23);
		contentPanel.add(btnAcessar);

		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sair();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sair();
			}
		});
		btnNewButton.setBounds(222, 196, 89, 23);
		contentPanel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Esquece minha Senha");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(146, 230, 135, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lbl_aqui = new JLabel("Aqui");
		lbl_aqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_aqui.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		lbl_aqui.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lbl_aqui.setForeground(new Color(220, 81, 29));
			}
		});
		lbl_aqui.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_aqui.setForeground(Color.WHITE);
		lbl_aqui.setBounds(278, 230, 46, 14);
		contentPanel.add(lbl_aqui);

		ft_usuario = new JFormattedTextField();
		ft_usuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt_ps.requestFocus();
				}
			}
		});
		ft_usuario.setBounds(124, 111, 187, 20);
		ft_usuario.setDocument(new LimiteTxt(150));
		contentPanel.add(ft_usuario);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		lblNewLabel_3.setIcon(new ImageIcon(LoginJd.class.getResource("/br/sasclient/imagens/logo2stima.png")));
		lblNewLabel_3.setBounds(45, 11, 266, 89);
		contentPanel.add(lblNewLabel_3);
	}

	protected void acessar() {
		token = new UsuarioServiceClient()
				.isPreset(new UsuarioForm(ft_usuario.getText().toString(), String.copyValueOf(txt_ps.getPassword())));
		if (token.getToken() != null) {
			msg("Usuário aceito!");
			this.dispose();
		} else {
			limpar();
			msg("Usuário ou senha não existe!");
		}
	}

	public void msg(String msg) {
		MensagensJD2 jd2 = new MensagensJD2(msg, "Login");
		jd2.setVisible(true);
	}

	public TokenDto retornoLogin() {
		if (token == null) {
			token = new TokenDto();
		}
		return token;
	}

	protected void sair() {
		this.dispose();
	}

	public void limpar() {
		txt_ps.setText("");
		ft_usuario.setText("");
	}
}
