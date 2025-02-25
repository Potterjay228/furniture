package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class PorderMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderMainUI frame = new PorderMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PorderMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員訂單管理");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(151, 10, 114, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 72, 416, 271);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("訂購商品");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporder=new AddPorderUI();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(158, 73, 106, 35);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManagerUI pordermanagerui=new PorderManagerUI();
				pordermanagerui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(158, 133, 106, 35);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("離開");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(158, 183, 106, 35);
		panel_1.add(btnNewButton_1_1);
	}

}
