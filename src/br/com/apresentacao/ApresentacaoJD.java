package br.com.apresentacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.home.HomeJd;

public class ApresentacaoJD extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7749512543680856205L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ApresentacaoJD dialog = new ApresentacaoJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ApresentacaoJD() {
		setUndecorated(true);
		setType(Type.POPUP);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setBounds(100, 100, 487, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		Toolkit toolkit = getToolkit();
		Dimension d = toolkit.getScreenSize();
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				ApresentacaoJD.class.getResource("/br/com/apresentacao/Apresenta\u00E7\u00E3o_entrada.png")));
		lblNewLabel.setBounds(0, 0, 488, 459);
		contentPanel.add(lblNewLabel);

		tempoApresentacao();
	}

	private void tempoApresentacao() {
		new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				try {
					Thread.sleep(4000);
					ApresentacaoJD.this.hide();
					HomeJd home = new HomeJd();
					home.setVisible(true);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
}
