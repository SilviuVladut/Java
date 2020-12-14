import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Pb1 extends JFrame {

	private JPanel contentPane;
	private JTextField tF_nr1;
	private JTextField tF_nr2;
	private JTextField tF_rez;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pb1 frame = new Pb1();
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
	public Pb1() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numar 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 10, 90, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumar = new JLabel("Numar 2");
		lblNumar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumar.setBounds(148, 10, 90, 22);
		contentPane.add(lblNumar);
		
		tF_nr1 = new JTextField();
		tF_nr1.setToolTipText("");
		tF_nr1.setBounds(29, 45, 96, 30);
		contentPane.add(tF_nr1);
		tF_nr1.setColumns(10);
		
		tF_nr2 = new JTextField();
		tF_nr2.setToolTipText("");
		tF_nr2.setColumns(10);
		tF_nr2.setBounds(142, 45, 96, 30);
		contentPane.add(tF_nr2);
		
		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdunare.setBounds(298, 74, 128, 30);
		contentPane.add(btnAdunare);
		btnAdunare.addActionListener(new BtnAdunare(tF_nr1,tF_nr2));
		
		JButton btnScadere = new JButton("Scadere");
		btnScadere.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnScadere.setBounds(298, 118, 128, 30);
		contentPane.add(btnScadere);
		btnScadere.addActionListener(new BtnScadere(tF_nr1,tF_nr2));

		
		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInmultire.setBounds(298, 166, 128, 30);
		contentPane.add(btnInmultire);
		btnInmultire.addActionListener(new BtnInmultire(tF_nr1,tF_nr2));

		
		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnImpartire.setBounds(298, 211, 128, 30);
		contentPane.add(btnImpartire);
		btnImpartire.addActionListener(new BtnImp(tF_nr1,tF_nr2));

		
		JLabel lblNewLabel_1 = new JLabel("Rezultat");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(75, 93, 110, 30);
		contentPane.add(lblNewLabel_1);
		
		tF_rez = new JTextField();
		tF_rez.setBounds(66, 122, 131, 27);
		contentPane.add(tF_rez);
		tF_rez.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(75, 176, 110, 43);
		contentPane.add(btnClear);
		btnClear.addActionListener(new BtnClr(tF_nr1,tF_nr2));
	}
	
	class BtnAdunare implements ActionListener {

		private JTextField nr1,nr2;
		public BtnAdunare(JTextField tF_nr1,JTextField tF_nr2) {
			this.nr1 = tF_nr1;
			this.nr2 = tF_nr2;
		}
		public void actionPerformed(ActionEvent e) {
			  //tF_rez.setText(nr1.getText());
			String x1,x2;
			x1 = nr1.getText();
			x2 = nr2.getText();
			int y1 = Integer.parseInt(x1);
			int y2 = Integer.parseInt(x2);
			int rez = y1+y2;
			tF_rez.setText(" "+rez);
			  
			}
		
	}
	
	class BtnScadere implements ActionListener {

		private JTextField nr1,nr2;
		public BtnScadere(JTextField tF_nr1,JTextField tF_nr2) {
			this.nr1 = tF_nr1;
			this.nr2 = tF_nr2;
		}
		public void actionPerformed(ActionEvent e) {
			  //tF_rez.setText(nr1.getText());
			String x1,x2;
			x1 = nr1.getText();
			x2 = nr2.getText();
			int y1 = Integer.parseInt(x1);
			int y2 = Integer.parseInt(x2);
			int rez = y1-y2;
			tF_rez.setText(" "+rez);
			  
			}
		
	}

	class BtnInmultire implements ActionListener {

		private JTextField nr1,nr2;
		public BtnInmultire(JTextField tF_nr1,JTextField tF_nr2) {
			this.nr1 = tF_nr1;
			this.nr2 = tF_nr2;
		}
		public void actionPerformed(ActionEvent e) {
			  //tF_rez.setText(nr1.getText());
			String x1,x2;
			x1 = nr1.getText();
			x2 = nr2.getText();
			int y1 = Integer.parseInt(x1);
			int y2 = Integer.parseInt(x2);
			int rez = y1*y2;
			tF_rez.setText(" "+rez);
			  
			}
		
	}
	

class BtnImp implements ActionListener {

		private JTextField nr1,nr2;
		float y2;
		public BtnImp(JTextField tF_nr1,JTextField tF_nr2) {
			this.nr1 = tF_nr1;
			this.nr2 = tF_nr2;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			
			String x1,x2;
			x1 = nr1.getText();
			x2 = nr2.getText();
			float y1 = Float.parseFloat(x1);
			y2 = Float.parseFloat(x2);
			if(y2==0)
			{
				tF_rez.setText("Invalid imp. la 0");
			}
			else
			{
			float rez = y1/y2;	
			tF_rez.setText(" "+rez);
			}
		}
	}
		
	
	
	class BtnClr implements ActionListener {

		private JTextField nr1,nr2;
		public BtnClr(JTextField tF_nr1,JTextField tF_nr2) {
			this.nr1 = tF_nr1;
			this.nr2 = tF_nr2;
		}
		public void actionPerformed(ActionEvent e) {
			  //tF_rez.setText(nr1.getText());
			nr1.setText("");	
			nr2.setText("");	
			tF_rez.setText("");
			  
			}

		
	}
}
