package projectSem2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class mainPro {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPro window = new mainPro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPro window = new mainPro();
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
	public mainPro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(51, 153, 255));
		frame.setBounds(100, 100, 830, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("WELCOME TO NAMMA METRO");
		title.setForeground(new Color(51, 153, 255));
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(285, 13, 271, 74);
		frame.getContentPane().add(title);
		
		JButton map = new JButton("VIEW MAP");
		map.setBounds(320, 100, 207, 53);
		frame.getContentPane().add(map);
		JFrame frame1 = new JFrame();
		map.addActionListener(new ActionListener() //inorder to implement the button to show the paint function in a new window
				{
					public void actionPerformed(ActionEvent e)
					{
						frame1.getContentPane().add(new map());
						frame1.setVisible(true);
						frame1.setSize(2000, 1000);
					}
				});
		JButton fareCal = new JButton("FARE CALCULATOR");
		fareCal.setBounds(320, 166, 207, 53);
		frame.getContentPane().add(fareCal);
		fareCal.addActionListener(new ActionListener()//which shows the ticketDetails class
				{
					public void actionPerformed(ActionEvent e1)
					{
						ticketDetails td=new ticketDetails();
						td.NewScreen(null);
						frame.dispose();
					}
				});
		JButton reacharge = new JButton("RECHARGE SMART CARD");
		reacharge.setBounds(320, 232, 207, 53);
		frame.getContentPane().add(reacharge);
		reacharge.addActionListener(new ActionListener()//which shows the cardReader class
				{
					public void actionPerformed(ActionEvent e1)
					{
						cardRecharge cr=new cardRecharge();
						cr.NewScreen(null);
						frame.dispose();
					}
				});
		
		JButton bal = new JButton("VIEW BALANCE");
		bal.setBounds(320, 298, 207, 53);
		frame.getContentPane().add(bal);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sai varun\\Downloads\\images.png"));
		lblNewLabel.setBounds(50, 0, 207, 490);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sai varun\\Downloads\\pic1.png"));
		lblNewLabel_1.setBounds(381, 391, 401, 74);
		frame.getContentPane().add(lblNewLabel_1);
		bal.addActionListener(new ActionListener()//which shows the balance class
				{
					public void actionPerformed(ActionEvent e1)
					{
						balance bl=new balance();
						bl.NewScreen(null);
						frame.dispose();
					}
				});
	}
}
