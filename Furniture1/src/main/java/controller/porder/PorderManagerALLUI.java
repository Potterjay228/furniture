package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Ex1;
import model.Consumer;
import service.impl.PorderServiceImpl;
import util.Tool;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PorderManagerALLUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Consumer consumer=(Consumer)Tool.read("consumer.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerALLUI frame = new PorderManagerALLUI();
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
	public PorderManagerALLUI() {
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
		
		JButton btnNewButton_1_1 = new JButton("上一頁");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderMainAllUI porderMainAllUI=new PorderMainAllUI();
				porderMainAllUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(0, 0, 85, 23);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("員工訂單查詢");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(154, 4, 114, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 59, 416, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 396, 105);
		panel_1.add(scrollPane);
		
		
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 202, 416, 85);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1.setBounds(130, 10, 27, 20);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("電競椅");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(111, 55, 59, 20);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("書桌");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(252, 10, 42, 20);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("書櫃");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(252, 55, 42, 20);
		panel_2.add(lblNewLabel_1_3);
		
		JSpinner updateId = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		updateId.setBounds(176, 11, 48, 22);
		panel_2.add(updateId);
		
		JSpinner gamingChair = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		gamingChair.setBounds(176, 56, 48, 22);
		panel_2.add(gamingChair);
		
		JSpinner desk = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		desk.setBounds(301, 11, 48, 22);
		panel_2.add(desk);
		
		JSpinner wardrobe = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		wardrobe.setBounds(301, 56, 48, 22);
		panel_2.add(wardrobe);
		
		JButton checkB = new JButton("查詢");
		checkB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output.setText(porderserviceimpl.AllPorder());
			}
		});
		checkB.setBounds(10, 0, 85, 23);
		panel_1.add(checkB);
		
		JButton export = new JButton("匯出EXCEL");
		export.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Ex1.exportToExcel();
                JOptionPane.showMessageDialog(null, "Excel 檔案已生成！"); 
			}
		});
		export.setBounds(302, 0, 104, 23);
		panel_1.add(export);
		
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
		btnNewButton_1.setBounds(10, 29, 85, 23);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 290, 416, 63);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("id");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(124, 14, 27, 20);
		panel_3.add(lblNewLabel_1_4);
		
		JSpinner delete = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		delete.setBounds(161, 11, 48, 22);
		panel_3.add(delete);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Delete= (int) delete.getValue();
				porderserviceimpl.deletePorderById(Delete);
				
				JOptionPane.showMessageDialog(null, "已刪除,請重按查詢確認");
			}
		});
		btnNewButton_2.setBounds(10, 10, 85, 23);
		panel_3.add(btnNewButton_2);
	}
	
}
