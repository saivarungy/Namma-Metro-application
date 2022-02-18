package projectSem2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
class traNode
{
	double data;
	traNode next;
	traNode()
	{
		next=null;
	}
	traNode(double d)
	{
		data=d;
		next=null;
	}
}
class transactionSheet
{	
	traNode head;
	transactionSheet()
	{
		head=new traNode();
	}
	transactionSheet(double d)
	{
		head=new traNode(d);
	}
	void push(double ele)
	{
		//similar to insert first function
		if(head==null)
		{
			head=new traNode(ele);
		}
		else
		{
			traNode t=new traNode(ele+head.data);
			t.next=head;
			head=t;
		}
	}
	void display()
	{
		//similar to display function
		traNode t=head;
		if(t==null)
		{
			return;
		}
		System.out.println("transaction history:");
		while(t!=null)
		{
			System.out.println(t.data);
			t=t.next;
		}
	}
	void getStore()
	{
		String data;
		double d;
		try
		{
			Scanner read=new Scanner(new File("D:\\\\cardBalance.txt"));
			while(read.hasNext())
			{
				data=read.next();
				d=Double.parseDouble(data);
				this.push(d);
			}
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		
	}
	String peek()
	{
		traNode t=head;
		String da=Double.toString(t.data);
		return(da);
	}
}
public class balance {

	private JFrame frame;
	private JTextField cnoText;
	private JTextField balAmtText;

	/**
	 * Launch the application.
	 */
	//NewScreen
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balance window = new balance();
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
					balance window = new balance();
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
	public balance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("BALANCE");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(195, 13, 93, 58);
		frame.getContentPane().add(title);
		
		JLabel lblEnterCardNo = new JLabel("Enter card No:");
		lblEnterCardNo.setBounds(51, 109, 83, 16);
		frame.getContentPane().add(lblEnterCardNo);
		
		cnoText = new JTextField();
		cnoText.setBounds(159, 106, 170, 22);
		frame.getContentPane().add(cnoText);
		cnoText.setColumns(10);
		
		JButton sub = new JButton("Submit");
		sub.setBounds(181, 162, 132, 48);
		frame.getContentPane().add(sub);
		sub.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e1)
					{
						String no=cnoText.getText();
						if(no.equals("12345678910"))
						{
							transactionSheet t=new transactionSheet();
							t.getStore();
							t.display();
							String data=t.peek();
							balAmtText.setText(data);
						}
						else
						{
								JOptionPane.showMessageDialog(null, "incorrect credentials are entered.....");
						}
					}
				});
		
		JLabel BalAmt = new JLabel("Balance amount:");
		BalAmt.setBounds(51, 249, 110, 16);
		frame.getContentPane().add(BalAmt);
		
		balAmtText = new JTextField();
		balAmtText.setBounds(159, 246, 177, 22);
		frame.getContentPane().add(balAmtText);
		balAmtText.setColumns(10);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBounds(181, 291, 132, 41);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener()//which shows the main page
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