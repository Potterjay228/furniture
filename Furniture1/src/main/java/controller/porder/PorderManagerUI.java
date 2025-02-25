package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.consumer.LoginUI;
import dao.impl.PorderDaoImpl;
import model.Consumer;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private static Consumer consumer=(Consumer)Tool.read("consumer.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JSpinner updateId, desk, gamingChair,wardrobe,delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 52, 416, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 40, 385, 107);
		panel.add(scrollPane);
		
		JTextArea checkA = new JTextArea();
		scrollPane.setViewportView(checkA);
		
		JButton checkB = new JButton("查詢");
		checkB.setBounds(21, 7, 85, 23);
		checkB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = (String) user.getText();	
				PorderDaoImpl dao = new PorderDaoImpl();
				List<Porder> l = dao.selectByUsername(username); 
				String show="";
				
				for(Porder p:l)
				{
					int sum=p.getDesk()*1999
							+p.getGamingChair()*4999
							+p.getWardrobe()*5799;
					
					show=show+"訂單:"+p.getId()+
							"\t客戶:"+p.getName()+
							"\t書桌:"+p.getDesk()+
							"\t電競椅:"+p.getGamingChair()+
							"\t衣櫃:"+p.getWardrobe()+
							"\t金額:"+sum+"元\n";
				}								
				checkA.setText(show);
			}
		});
		panel.add(checkB);
		
		user = new JTextField();
		user.setBounds(108, 8, 96, 21);
		panel.add(user);
		user.setColumns(10);
		user.setText(consumer.getUsername());
		user.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 10, 416, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("上一頁");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderMainUI porderMainUI=new PorderMainUI();
				porderMainUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(0, 0, 85, 23);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("會員訂單查詢");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(153, 4, 114, 32);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 212, 416, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JSpinner updateId = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		updateId.setBounds(166, 10, 48, 22);
		panel_2.add(updateId);
		
		JSpinner desk = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		desk.setBounds(302, 10, 48, 22);
		panel_2.add(desk);
		
		JSpinner gamingChair = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		gamingChair.setBounds(166, 42, 48, 22);
		panel_2.add(gamingChair);
		
		JSpinner wardrobe = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		wardrobe.setBounds(302, 42, 48, 22);
		panel_2.add(wardrobe);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1.setBounds(129, 13, 27, 20);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("電競椅");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(97, 45, 59, 20);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("書桌");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(250, 13, 42, 20);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("書櫃");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(250, 45, 42, 20);
		panel_2.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id= (int) updateId.getValue();
				int Desk = (int) desk.getValue();
				int GamingChair = (int) gamingChair.getValue();
				int Wardrobe = (int) wardrobe.getValue();
								
				porderserviceimpl.updatePorder(Desk, GamingChair, Wardrobe, Id);
								
				JOptionPane.showMessageDialog(null, "已修改,請重按查詢確認");
			}
		});
		btnNewButton_1.setBounds(10, 23, 85, 23);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 286, 416, 57);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JSpinner delete = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		delete.setBounds(167, 25, 48, 22);
		panel_3.add(delete);
		
		JLabel lblNewLabel_1_4 = new JLabel("id");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(130, 25, 27, 20);
		panel_3.add(lblNewLabel_1_4);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setBounds(10, 22, 85, 23);
		panel_3.add(btnNewButton_2);
	}
}
