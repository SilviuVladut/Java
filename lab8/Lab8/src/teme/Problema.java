package teme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.security.util.Length;

import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;


class Persoana {
	private String nume;
	private int id, varsta;
	public Persoana(Integer id,String nume,Integer varsta) {
		this.id=id;
		this.nume=nume;
		this.varsta=varsta;
	}
	@Override
	public String toString() {
		return "Persoane [id=" + id + ", nume=" + nume + ", varsta=" + varsta + "]";
	}
	public String getNume() {
		return nume;
	}
	public int getId() {
		return id;
	}
	public int getVarsta() {
		return varsta;
	}
}

public class Problema extends JFrame {
	
	private static List<Persoana> persoane= new ArrayList<Persoana>();
	private JPanel contentPane;
	private JTextField txtELEMENTE;
	private JTextField txtID;
	private JTextField txtNUME;
	private JTextField txtVARSTA;
	private static int index=1;
	private boolean update_add=false;
	/**
	 * Launch the application.
	 * @return 
	 * @return 
	 * @return 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */

	
	
	
	public static void getPersoane()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",""); 
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from persoane");
			persoane.clear();
			while(rs.next())  
				persoane.add(new Persoana(rs.getInt(1),rs.getString(2),rs.getInt(3)));  
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void DeletePersoane(int index)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");    
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			stmt.executeUpdate("DELETE from persoane where ID="+persoane.get(index-1).getId());
			ResultSet rs=stmt.executeQuery("Select * from persoane");
			persoane.clear();
			while(rs.next())  
				persoane.add(new Persoana(rs.getInt(1),rs.getString(2),rs.getInt(3)));  
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void UpdatePersoane(String id,String nume,String varsta)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");   
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			stmt.executeUpdate("UPDATE `persoane` SET `Nume`='"+nume+"',`Varsta`="+varsta+" WHERE ID="+id+";");
			ResultSet rs=stmt.executeQuery("Select * from persoane");
			persoane.clear();
			while(rs.next())  
				persoane.add(new Persoana(rs.getInt(1),rs.getString(2),rs.getInt(3)));  
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void AddPersoane(String id,String nume,String varsta)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			stmt.executeUpdate("INSERT INTO persoane (`ID`, `Nume`, `Varsta`) VALUES ("+id+",'"+nume+"',"+varsta+")");
			ResultSet rs=stmt.executeQuery("Select * from persoane");
			persoane.clear();
			while(rs.next())  
				persoane.add(new Persoana(rs.getInt(1),rs.getString(2),rs.getInt(3)));  
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
    
public static void main(String[] args) throws SQLException  {	
	
	
	
	
	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getPersoane();
					Problema frame = new Problema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Problema() throws SQLException {
		
		
		setTitle("Aplicatie MYSQL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(20, 10, 416, 35);
		contentPane.add(toolBar);
		
		txtELEMENTE = new JTextField();
		toolBar.add(txtELEMENTE);
		txtELEMENTE.setHorizontalAlignment(SwingConstants.LEFT);
		txtELEMENTE.setColumns(10);
		txtELEMENTE.setText("x/ " + persoane.size());
		
		Icon icon = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\MoveFirst.png");
		final JButton btnPrimaInreg = new JButton(icon);
		btnPrimaInreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=1;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
				
			}
		});
		toolBar.add(btnPrimaInreg);
		
		Icon icon2 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\MovePrevious.png");
		final JButton btnInapoi = new JButton(icon2);
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index>1)
					index=index-1;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
			}
		});
		toolBar.add(btnInapoi);
		
		
		
		Icon icon3 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\MoveNext.png");
		JButton btnInainte = new JButton(icon3);
		btnInainte.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(index<persoane.size())
				index=index+1;
			txtID.setText(String.valueOf(persoane.get(index-1).getId()));
			txtNUME.setText(persoane.get(index-1).getNume());
			txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
			txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
		}
		});
		toolBar.add(btnInainte);
		
		Icon icon4 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\MoveLast.png");
		JButton btnUltimul = new JButton(icon4);
		btnUltimul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=persoane.size();
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
			}
		});
		toolBar.add(btnUltimul);
		
		
		Icon icon5 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\Add.png");
		JButton btnAdauga = new JButton(icon5);
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_add=true;
				txtID.setText(Integer.toString(persoane.get(persoane.size()-1).getId()+1));
				txtNUME.setText("");
				txtNUME.setEditable(true);
				txtVARSTA.setText("");
				txtVARSTA.setEditable(true);
			}
		});
		toolBar.add(btnAdauga);
		
		Icon icon6 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\Edit.png");
		JButton btnEditare = new JButton(icon6);
		btnEditare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update_add=false;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setEditable(true);
				txtVARSTA.setEditable(true);
			}
		});
		toolBar.add(btnEditare);
		
		Icon icon7 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\Delete.png");
		JButton btnStergere = new JButton(icon7);
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(contentPane, "Stergem persoana curenta?",
				        "alert", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION)
				{DeletePersoane(index);
				index=1;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
			}
			}});
		toolBar.add(btnStergere);
		
		Icon icon8 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\find.jpg");
		JButton btnCautare = new JButton(icon8);
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String m = JOptionPane.showInputDialog("Numele?");
				for(Persoana p : persoane)
				{
					if(p.getNume().equals(m))
					{
						index=persoane.indexOf(p)+1;
						txtID.setText(String.valueOf(persoane.get(index-1).getId()));
						txtNUME.setText(persoane.get(index-1).getNume());
						txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
					}
				}
			}
		});
		toolBar.add(btnCautare);
		
		Icon icon9 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\save.jpg");
		JButton btnSalvare = new JButton(icon9);
		btnSalvare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(update_add)
					AddPersoane(txtID.getText(), txtNUME.getText(), txtVARSTA.getText());
				else
					UpdatePersoane(txtID.getText(), txtNUME.getText(), txtVARSTA.getText());
				index=1;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
		}});
		toolBar.add(btnSalvare);
		
		Icon icon10 = new ImageIcon("D:\\Facultate\\LaboratorJava\\lab8\\Lab8\\Imagini\\undo.jpg");
		JButton btnRenuntare = new JButton(icon10);
		btnRenuntare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index=1;
				txtID.setText(String.valueOf(persoane.get(index-1).getId()));
				txtNUME.setText(persoane.get(index-1).getNume());
				txtVARSTA.setText(String.valueOf(persoane.get(index-1).getVarsta()));
				txtELEMENTE.setText(Integer.toString(index)+"/"+persoane.size());
			}
		});
		toolBar.add(btnRenuntare);
		
		
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(81, 77, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNume = new JLabel("NUME:");
		lblNume.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNume.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNume.setBounds(34, 103, 92, 13);
		contentPane.add(lblNume);
		
		JLabel lblVarsta = new JLabel("VARSTA:");
		lblVarsta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVarsta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVarsta.setBounds(44, 130, 82, 13);
		contentPane.add(lblVarsta);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtID.setBounds(148, 76, 119, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNUME = new JTextField();
		txtNUME.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNUME.setColumns(10);
		txtNUME.setBounds(148, 102, 119, 19);
		contentPane.add(txtNUME);
		
		txtVARSTA = new JTextField();
		txtVARSTA.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtVARSTA.setColumns(10);
		txtVARSTA.setBounds(148, 129, 119, 19);
		contentPane.add(txtVARSTA);
		
		
		
		
	
	}
}
