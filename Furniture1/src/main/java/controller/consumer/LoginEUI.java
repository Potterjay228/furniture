package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.employee.AddEmployeeUI;
import controller.porder.PorderMainAllUI;
import controller.porder.PorderMainUI;
import model.Consumer;
import model.Employee;
import service.impl.ConsumerServiceImpl;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

public class LoginEUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameE;
	private JTextField passwordE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEUI frame = new LoginEUI();
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
	public LoginEUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(0, 0, 85, 23);
		panel.add(btnNewButton_1);
		
		JLabel clock = new JLabel("2025-02-25 10:43:42");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(287, 29, 129, 19);
		panel.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 68, 416, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工登入頁");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(146, 30, 96, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(95, 83, 42, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(95, 139, 42, 33);
		panel_1.add(lblNewLabel_2);
		
		usernameE = new JTextField();
		usernameE.setColumns(10);
		usernameE.setBounds(146, 89, 96, 21);
		panel_1.add(usernameE);
		
		passwordE = new JTextField();
		passwordE.setColumns(10);
		passwordE.setBounds(146, 145, 96, 21);
		panel_1.add(passwordE);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String UsernameE=usernameE.getText();
				String PasswordE=passwordE.getText();
				
				Employee employee=new EmployeeServiceImpl().Login(UsernameE, PasswordE);
				
				if(employee!=null)
				{
					JOptionPane.showMessageDialog(null, "登入成功，"+employee.getName()+"歡迎光臨");
					Tool.save(employee,"employee.txt");
					PorderMainAllUI porderMainAllUI=new PorderMainAllUI();
					porderMainAllUI.setVisible(true);
					dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "請輸入正確的帳號和密碼");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(146, 200, 85, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("註冊");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddEmployeeUI addEmployeeUI=new AddEmployeeUI();
				addEmployeeUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_2.setBounds(262, 200, 85, 23);
		panel_1.add(btnNewButton_2);
	}

	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}

}
