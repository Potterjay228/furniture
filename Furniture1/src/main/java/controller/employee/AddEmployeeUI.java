package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.consumer.LoginEUI;
import controller.consumer.LoginUI;
import model.Consumer;
import model.Employee;
import service.impl.ConsumerServiceImpl;
import service.impl.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeUI frame = new AddEmployeeUI();
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
	public AddEmployeeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊新員工");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(156, 10, 123, 29);
		panel.add(lblNewLabel);
		
		JLabel clock = new JLabel("2025-02-25 10:03:51");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(289, 26, 129, 19);
		panel.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		
		JButton btnNewButton_1_1_1 = new JButton("回登入");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginEUI loginEUI=new LoginEUI();
                loginEUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(0, 0, 85, 27);
		panel.add(btnNewButton_1_1_1);
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 65, 416, 278);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 31, 45, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(71, 61, 45, 20);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(71, 91, 45, 20);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(71, 121, 45, 20);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話:");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(71, 151, 45, 20);
		panel_1.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(121, 31, 96, 21);
		panel_1.add(name);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(121, 61, 96, 21);
		panel_1.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(121, 91, 96, 21);
		panel_1.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(121, 121, 96, 21);
		panel_1.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(121, 151, 96, 21);
		panel_1.add(phone);
		
		JLabel lblNewLabel_4_1 = new JLabel("必填");
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(227, 34, 38, 15);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("英文+數字,5至7字");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_3.setBounds(227, 64, 125, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("只能數字,5至7字");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_4.setBounds(227, 94, 114, 15);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				if(new EmployeeServiceImpl().isUsernameBeenUse(Username))
				{
					JOptionPane.showMessageDialog(null, "帳號重複註冊");
				}
				else if(isValidUsername(Username) && isValidPassword(Password) && isValidName(Name)) {
		
					Employee employee=new Employee(Name,Username,Password,Address,Phone);
					
					new EmployeeServiceImpl().addEmployee(employee);
															
                    JOptionPane.showMessageDialog(null, "註冊成功,請重新登入");
                    
                    LoginEUI loginEUI=new LoginEUI();
                    loginEUI.setVisible(true);
					dispose();
                } 
				
				else
				{
					JOptionPane.showMessageDialog(null, "請依照規則輸入帳號密碼");
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(84, 201, 85, 27);
		panel_1.add(btnNewButton_1);
	}
	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}

	private boolean isValidUsername(String Username) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{5,7}$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Username);
        return matcher.matches();
    }
       
    private boolean isValidPassword(String Password) {
        String regex = "^[0-9]{5,7}$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Password);
        return matcher.matches();
    }
    
    private boolean isValidName(String Name) {
    	String regex = "^(?!\\s*$).+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Name);
        return matcher.matches();
    }

}
