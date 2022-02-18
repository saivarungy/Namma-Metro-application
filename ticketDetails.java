package projectSem2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ticketDetails extends JFrame {

	private JFrame frame;
	private JTextField stn1;
	private JTextField stn2;
	private JTextField frmStnName;
	private JTextField toStnName;
	private JTextField tokenText;
	private JTextField varText;

	/**
	 * Launch the application.
	 */
	//NewScreen
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketDetails window = new ticketDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void NewScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketDetails window = new ticketDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ticketDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("FARE CALCULATOR");
		title.setFont(new Font("Tahoma", Font.BOLD, 28));
		title.setBounds(266, 0, 277, 75);
		frame.getContentPane().add(title);
		
		JLabel labelStn1 = new JLabel("Enter from station no.:");
		labelStn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStn1.setBounds(111, 132, 153, 31);
		frame.getContentPane().add(labelStn1);
		
		stn1 = new JTextField();
		stn1.setBounds(276, 137, 45, 22);
		frame.getContentPane().add(stn1);
		stn1.setColumns(10);
		
		JLabel labelStn2 = new JLabel("Enter to station no.:");
		labelStn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStn2.setBounds(132, 185, 153, 31);
		frame.getContentPane().add(labelStn2);
		
		stn2 = new JTextField();
		stn2.setColumns(10);
		stn2.setBounds(276, 190, 45, 22);
		frame.getContentPane().add(stn2);
		
		JButton mapButton = new JButton("View Map");
		mapButton.setBounds(379, 163, 97, 25);
		frame.getContentPane().add(mapButton);
		JFrame frame1 = new JFrame();
		mapButton.addActionListener(new ActionListener() //inorder to implement the button to show the paint function in a new window
				{
					public void actionPerformed(ActionEvent e)
					{
						frame1.getContentPane().add(new map());
						frame1.setVisible(true);
						frame1.setSize(2000, 1000);
						//dispose();
					}
				});
		
		JLabel labelNote = new JLabel("note: refer map for station nos.");
		labelNote.setBounds(379, 140, 190, 16);
		frame.getContentPane().add(labelNote);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(286, 229, 153, 45);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				try
				{
					stnNameFrmNo sl=new stnNameFrmNo ();
					sl.insertStations();
					Double n1=Double.parseDouble(stn1.getText());
					Double n2=Double.parseDouble(stn2.getText());
					
					String tokenPrice,result1,result2;
					String varshikPrice;
					dataForTicketGen dt=new dataForTicketGen();
					dt.insertTicketdata();
						result1=sl.retStnNamne(n1);
						result2=sl.retStnNamne(n2);
						n1=Double.parseDouble(stn1.getText());
						n2=Double.parseDouble(stn2.getText());
						tokenPrice=dt.displayDataForTokken(n1, n2);
						varshikPrice=dt.displayDataForVarshik(n1, n2);
						frmStnName.setText(result1);
						toStnName.setText(result2);
						tokenText.setText(tokenPrice);
						varText.setText(varshikPrice);
				}
				catch(Exception e)
				{
					System.out.println("input errors");
				}
				
			}
		});
		
		JLabel from = new JLabel("From Station:");
		from.setBounds(111, 309, 86, 16);
		frame.getContentPane().add(from);
		
		frmStnName = new JTextField();
		frmStnName.setBounds(217, 306, 170, 22);
		frame.getContentPane().add(frmStnName);
		frmStnName.setColumns(10);
		
		JLabel lblToStation = new JLabel("To station:");
		lblToStation.setBounds(111, 344, 86, 16);
		frame.getContentPane().add(lblToStation);
		
		toStnName = new JTextField();
		toStnName.setBounds(217, 341, 170, 22);
		frame.getContentPane().add(toStnName);
		toStnName.setColumns(10);
		
		JLabel labToken = new JLabel("Token Price:");
		labToken.setBounds(111, 395, 86, 16);
		frame.getContentPane().add(labToken);
		
		tokenText = new JTextField();
		tokenText.setBounds(217, 389, 116, 22);
		frame.getContentPane().add(tokenText);
		tokenText.setColumns(10);
		
		JLabel varLab = new JLabel("Varshik Price:");
		varLab.setBounds(111, 436, 86, 16);
		frame.getContentPane().add(varLab);
		
		varText = new JTextField();
		varText.setColumns(10);
		varText.setBounds(217, 433, 116, 22);
		frame.getContentPane().add(varText);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnHome.setBounds(497, 372, 158, 59);
		frame.getContentPane().add(btnHome);
		JFrame frame2 = new JFrame();
		//mainPro mp=new mainPro();
		btnHome.addActionListener(new ActionListener()//which shows the ticketDetails class
				{
					public void actionPerformed(ActionEvent e1)
					{
						mainPro mp=new mainPro();
						mp.NewScreen(null);
						frame.dispose();
					}
				});
	}
}
