package Teme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Prbl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prbl frame = new Prbl();
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
	public Prbl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 416, 192);
		contentPane.add(scrollPane);
		
		XmlJTree myTree = new XmlJTree(null);;
		scrollPane.setViewportView(myTree);
		//clear tree
		DefaultTreeModel model = (DefaultTreeModel) myTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        model.reload();
        model.setRoot(null);
		
		
		JButton btnNewButton = new JButton("Open XML");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFileChooser chooser = new JFileChooser("D:\\Facultate\\LaboratorJava\\Lab9\\Lab9");
	                FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                        "XML file", "xml");
	                chooser.setFileFilter(filter);
	                int returnVal = chooser.showOpenDialog(null);
	                if(returnVal == JFileChooser.APPROVE_OPTION) {
	                    myTree.setPath(chooser.getSelectedFile().getAbsolutePath());
	                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 19, 121, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("hh:mm:ss");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 22, 72, 26);
		contentPane.add(lblNewLabel);
		final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    int interval = 1000; // 1000 ms

	    new Timer(interval, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            lblNewLabel.setText(dateFormat.format(now.getTime()));
	        }
	    }).start();

	}

}
