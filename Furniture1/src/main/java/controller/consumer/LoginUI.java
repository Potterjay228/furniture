package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainAllUI;
import controller.porder.PorderMainUI;
import model.Consumer;
import model.Employee;

import service.impl.ConsumerServiceImpl;
import service.impl.EmployeeServiceImpl;

import util.Tool;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("尊爵傢俱登入系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(139, 10, 161, 32);
		panel.add(lblNewLabel);

		JPanel 登入主頁 = new JPanel();
		登入主頁.setLayout(null);
		登入主頁.setBackground(Color.LIGHT_GRAY);
		登入主頁.setBounds(10, 64, 416, 279);
		contentPane.add(登入主頁);
		

		JButton consumerLogin = new JButton("會員登入");
		consumerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		consumerLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginCUI loginCUI=new LoginCUI();
				loginCUI.setVisible(true);
				dispose();
			}
		});
		consumerLogin.setFont(new Font("新細明體", Font.BOLD, 17));
		consumerLogin.setBounds(146, 69, 118, 38);
		登入主頁.add(consumerLogin);
		
		JButton consumerLogin_1 = new JButton("員工登入");
		consumerLogin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginEUI loginEUI=new LoginEUI();
				loginEUI.setVisible(true);
				dispose();
			}
		});
		consumerLogin_1.setFont(new Font("新細明體", Font.BOLD, 17));
		consumerLogin_1.setBounds(146, 128, 118, 38);
		登入主頁.add(consumerLogin_1);
		
		JButton employeeLogin = new JButton("員工登入");
		employeeLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginEUI loginEUI=new LoginEUI();
				loginEUI.setVisible(true);
				dispose();
			}
		});
		employeeLogin.setFont(new Font("新細明體", Font.BOLD, 17));
		employeeLogin.setBounds(146, 132, 118, 38);		
		
	}
}
