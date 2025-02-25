package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.consumer.LoginUI;
import model.Consumer;
import model.Employee;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Color;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JSpinner deskSpinner, gamingChairSpinner, wardrobeSpinner;
	private JTextArea output_1; 
    private JTextArea payback;
    private JTextField pay;    
    private int deskPrice = 1999, gamingChairPrice = 4999, wardrobePrice = 5799;
    private int deskCount = 0, gamingChairCount = 0, wardrobeCount = 0;
    private static Consumer consumer = (Consumer) Tool.read("consumer.txt");
    private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 426, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("上一頁");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderMainUI porderMainUI=new PorderMainUI();
				porderMainUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_3_1.setBounds(0, 0, 85, 23);
		panel.add(btnNewButton_3_1);
		
		JLabel clock = new JLabel("2025-02-24 09:34:44");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(297, 20, 129, 19);
		panel.add(clock);
		
		JLabel lblNewLabel_5 = new JLabel("會員訂購商品");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_5.setBounds(161, 4, 114, 32);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 59, 103, 284);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		deskSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		deskSpinner.setBounds(64, 62, 35, 26);
		panel_1.add(deskSpinner);
		
		gamingChairSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		gamingChairSpinner.setBounds(64, 98, 35, 26);
		panel_1.add(gamingChairSpinner);
		
		wardrobeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		wardrobeSpinner.setBounds(64, 131, 35, 26);
		panel_1.add(wardrobeSpinner);
		
		JLabel lblNewLabel = new JLabel("書桌");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 67, 31, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("電競椅");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(7, 103, 47, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("衣櫃");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 139, 31, 18);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel(consumer.getName()+"您好");
		lblNewLabel_4.setBounds(0, 10, 90, 25);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				deskSpinner.setValue(0);
				gamingChairSpinner.setValue(0);
				wardrobeSpinner.setValue(0);
				output_1.setText("");
				payback.setText("");
				pay.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(0, 182, 85, 23);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(123, 59, 313, 284);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		output_1 = new JTextArea();	
		output_1.setEditable(false);
		output_1.setBounds(10, 51, 161, 145);
		panel_2.add(output_1);
		
		JTextArea payback = new JTextArea();
		payback.setEditable(false);
		payback.setBounds(179, 51, 124, 145);
		panel_2.add(payback);
		
		JLabel lblNewLabel_3 = new JLabel("購買明細");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 18, 80, 23);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("找零");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(179, 18, 50, 23);
		panel_2.add(lblNewLabel_3_1);
		
		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(121, 206, 87, 21);
		panel_2.add(pay);
		
		JLabel lblNewLabel_2_1 = new JLabel("支付金額");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(39, 206, 72, 24);
		panel_2.add(lblNewLabel_2_1);
		
		JButton backButton = new JButton("確認支付");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Pay = pay.getText();	
				Integer PY = new Integer(Pay);
                                
				deskCount = (int) deskSpinner.getValue();
				gamingChairCount = (int) gamingChairSpinner.getValue();
				wardrobeCount = (int) wardrobeSpinner.getValue();	
				
		        int shirtTotal = deskCount * deskPrice;
		        int trousersTotal = gamingChairCount * gamingChairPrice;
		        int sneakersTotal = wardrobeCount * wardrobePrice;
		        int total = shirtTotal + trousersTotal + sneakersTotal;				
				int change=PY-total;

	
                if(deskCount>=0 && gamingChairCount>=0 && wardrobeCount>=0 )
                {
                	if(change >0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
	                			"\n需找您:"+change+"元"+
	                			"\n1000元:"+change/1000+"張"+
	                			"\n100元:"+change%1000/100+"張"+
	                			"\n10元:"+change%1000%100/10+"個"+
	                			"\n1元:"+change%1000%100%10+"個"
	                			);
                	}
                	else if(change==0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
                				"\n金額剛好,無須找零,感謝您");
                	}
                	else if(change<0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
                				"\n您支付的金額不足喔!");
                	}
                }
			}
		});
		backButton.setFont(new Font("新細明體", Font.BOLD, 13));
		backButton.setBounds(212, 206, 91, 23);
		panel_2.add(backButton);
		
		JButton btnNewButton_2 = new JButton("列印");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					output_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_2.setBounds(66, 237, 85, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("完成交易");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=consumer.getName();				
				int Desk = (int) deskSpinner.getValue();
				int GamingChair = (int) gamingChairSpinner.getValue();
				int Wardrobe = (int) wardrobeSpinner.getValue();
				String Username = consumer.getUsername();

				if(Desk==0 && GamingChair==0 && Wardrobe==0) {
					
					JOptionPane.showMessageDialog(null, "請先購買商品");
				}
				else {
					Porder p=new Porder(Name,Desk,GamingChair,Wardrobe,Username);
					porderserviceimpl.addPorder(p);
					JOptionPane.showMessageDialog(null, "完成交易,已存入管理訂單");
				}
			}
		});
		btnNewButton_5.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_5.setBounds(161, 237, 103, 23);
		panel_2.add(btnNewButton_5);
		
		deskSpinner.addChangeListener(e -> updateTotal());
        gamingChairSpinner.addChangeListener(e -> updateTotal());
        wardrobeSpinner.addChangeListener(e -> updateTotal());
	}
	private void updateTotal() {
        deskCount = (int) deskSpinner.getValue();
        gamingChairCount = (int) gamingChairSpinner.getValue();
        wardrobeCount = (int) wardrobeSpinner.getValue();    

        int deskTotal = deskCount * deskPrice;
        int gamingChairTotal = gamingChairCount * gamingChairPrice;
        int wardrobeTotal = wardrobeCount * wardrobePrice;
        int total = deskTotal + gamingChairTotal + wardrobeTotal;

        output_1.setText(consumer.getName() + " 尊爵感謝您的購買:" +
                "\n------------------------------------------------------" +
                "\n書桌 1999元 " + deskCount + "張 = " + deskTotal + "元" + 
                "\n電競椅 4999元 " + gamingChairCount + "張 = " + gamingChairTotal + "元" +
                "\n衣櫃 5799元 " + wardrobeCount + "個 = " + wardrobeTotal + "元" +
                "\n交易金額: " + total + "元");
    }

}
