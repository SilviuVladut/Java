import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pb2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pb2 frame = new Pb2();
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
	public Pb2() {
		setTitle("Formatii");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.setBounds(37, 44, 359, 169);
		contentPane.add(list);
		//listModel.addElement("silviu");
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(textField.getText());
				textField.setText("");
			}
		});
		
		textField.setBounds(10, 10, 416, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnStergere = new JButton("Sterge");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indici[] = list.getSelectedIndices();
				System.out.println("Ati sters: ");
				for (int i = indici.length-1; i >=0 ; i--) 
				{
				String sters = (String) list.getModel().getElementAt(indici[i]);
				System.out.println(" " + sters);
				listModel.removeElementAt(indici[i]);
				}
			}
				
		});
		btnStergere.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStergere.setBounds(139, 228, 142, 25);
		contentPane.add(btnStergere);
	}
	
	

	
}
