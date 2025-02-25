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

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LoginCUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameC;
	private JTextField passwordC;

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
	public LoginCUI() {
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
		clock.setBounds(287, 30, 129, 19);
		panel.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
		
		JPanel 顧客登入頁 = new JPanel();
		顧客登入頁.setBackground(Color.LIGHT_GRAY);
		顧客登入頁.setBounds(10, 64, 416, 279);
		contentPane.add(顧客登入頁);
		顧客登入頁.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員登入頁");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(159, 23, 96, 33);
		顧客登入頁.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(95, 83, 42, 33);
		顧客登入頁.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(95, 141, 42, 33);
		顧客登入頁.add(lblNewLabel_2);
		
		usernameC = new JTextField();
		usernameC.setBounds(147, 89, 96, 21);
		顧客登入頁.add(usernameC);
		usernameC.setColumns(10);
		
		passwordC = new JTextField();
		passwordC.setBounds(147, 147, 96, 21);
		顧客登入頁.add(passwordC);
		passwordC.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String UsernameC=usernameC.getText();
				String PasswordC=passwordC.getText();
				
				Consumer consumer=new ConsumerServiceImpl().Login(UsernameC, PasswordC);
				
				if(consumer!=null)
				{
					JOptionPane.showMessageDialog(null, "登入成功，"+consumer.getName()+"歡迎光臨");
					Tool.save(consumer,"consumer.txt");
					PorderMainUI pordermainui=new PorderMainUI();
					pordermainui.setVisible(true);
					dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "請輸入正確的帳號和密碼");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(139, 207, 85, 23);
		顧客登入頁.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("註冊");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddConsumerUI addConsumerUI=new AddConsumerUI();
				addConsumerUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_3.setBounds(252, 207, 85, 23);
		顧客登入頁.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("上一頁");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginUI loginUI=new LoginUI();
                loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(0, 0, 85, 23);
		
		
	}

	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}
}
