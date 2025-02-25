package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Consumer;
import service.impl.ConsumerServiceImpl;
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

public class AddConsumerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-20,15
	 */
	private final JPanel panel = new JPanel();
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
					AddConsumerUI frame = new AddConsumerUI();
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
	public AddConsumerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 10, 416, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊新會員");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(152, 10, 123, 29);
		panel_1.add(lblNewLabel);
		
		JLabel clock = new JLabel("2025-02-25 09:45:38");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(285, 16, 129, 19);
		panel_1.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		
		JButton btnNewButton_1_1_1 = new JButton("回登入");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginCUI loginCUI=new LoginCUI();
                loginCUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(0, 0, 85, 27);
		panel_1.add(btnNewButton_1_1_1);
		timer.start();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 60, 416, 283);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(114, 34, 96, 21);
		panel_2.add(name);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(114, 65, 96, 21);
		panel_2.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(114, 96, 96, 21);
		panel_2.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(114, 127, 96, 21);
		panel_2.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(114, 158, 96, 21);
		panel_2.add(phone);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(50, 37, 45, 20);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(50, 65, 45, 20);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(50, 96, 45, 20);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(50, 127, 45, 20);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話:");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(50, 158, 45, 20);
		panel_2.add(lblNewLabel_1_4);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				if(new ConsumerServiceImpl().isUsernameBeenUse(Username))
				{
					JOptionPane.showMessageDialog(null, "帳號重複註冊");
				}
				else if(isValidUsername(Username) && isValidPassword(Password) && isValidName(Name)) {
		
					Consumer consumer=new Consumer(Name,Username,Password,Address,Phone);
					
					new ConsumerServiceImpl().addConsumer(consumer);
															
                    JOptionPane.showMessageDialog(null, "註冊成功,請重新登入");
                    
                    LoginCUI loginCUI=new LoginCUI();
                    loginCUI.setVisible(true);
					dispose();
                } 
				
				else
				{
					JOptionPane.showMessageDialog(null, "請依照規則輸入帳號密碼");
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(93, 219, 85, 27);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("必填");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(220, 37, 38, 15);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("英文+數字,5至7字");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_3.setBounds(220, 68, 125, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("只能數字,5至7字");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_4.setBounds(220, 99, 114, 15);
		panel_2.add(lblNewLabel_4);
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
