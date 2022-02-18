package projectSem2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class cardRecharge {

	private JFrame frame;
	private JTextField cnoText;
	private JTextField varNo;
	private JTextField amt;
	private JTextField upBal;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardRecharge window = new cardRecharge();
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
					cardRecharge window = new cardRecharge();
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
	public cardRecharge() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("SMART CARD RECHARGE (VARSHIK)");
		title.setFont(new Font("Tahoma", Font.BOLD, 21));
		title.setBounds(176, 13, 416, 73);
		frame.getContentPane().add(title);
		
		JLabel crdNolab = new JLabel("Enter your credit/debit card no.:");
		crdNolab.setBounds(51, 205, 225, 16);
		frame.getContentPane().add(crdNolab);
		
		cnoText = new JTextField();
		cnoText.setBounds(276, 202, 240, 22);
		frame.getContentPane().add(cnoText);
		cnoText.setColumns(10);
		
		JLabel varshikLabel = new JLabel("Enter your varshik card no.:");
		varshikLabel.setBounds(51, 166, 190, 16);
		frame.getContentPane().add(varshikLabel);
		
		varNo = new JTextField();
		varNo.setBounds(276, 163, 240, 22);
		frame.getContentPane().add(varNo);
		varNo.setColumns(10);
		
		JLabel lblEnterAmount = new JLabel("Enter amount:");
		lblEnterAmount.setBounds(51, 125, 129, 16);
		frame.getContentPane().add(lblEnterAmount);
		
		amt = new JTextField();
		amt.setBounds(276, 122, 116, 22);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
		
		JLabel lblExpiry = new JLabel("Expiry(mm/yyyy):");
		lblExpiry.setBounds(51, 246, 177, 16);
		frame.getContentPane().add(lblExpiry);
		
		String[] mm= {"(mm)","01","02","03","04","05","06","07","08","09","10","11","12"};
		JComboBox m = new JComboBox(mm);
		m.setBounds(276, 243, 68, 22);
		frame.getContentPane().add(m);
		
		String[] yy= {"(yyyy)","2021","2022","2023","2024","2025"};
		JComboBox y = new JComboBox(yy);
		y.setBounds(369, 243, 68, 22);
		frame.getContentPane().add(y);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(212, 342, 156, 33);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae)
			{
				String no=varNo.getText();
				String no2=cnoText.getText();	
				String AM=amt.getText();
				//System.out.println("month"+month);
				//System.out.println("year"+year);
				if(no.equals("12345678910")&&no2.equals("1234567891234567"))
				{
					JFrame frame=new JFrame("password");
	                frame.setVisible(true);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setSize(400,100);
	                JLabel p= new JLabel("enter otp:");
	                JPanel panel=new JPanel();
	                frame.add(panel);
	                JPasswordField pass=new JPasswordField(6);
	                pass.setEchoChar('*');
	                pass.addActionListener(new ActionListener()
	                {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                        //final String otp="123456";
	                        JPasswordField input=(JPasswordField) e.getSource();
	                        char[] p=input.getPassword();
	                        String pa=new String(p);
	                        if(pa.equals("123456"))
	                        {
	                            JOptionPane.showMessageDialog(null, "recharge done..");
	                        }
	                        else
	                            JOptionPane.showMessageDialog(null, "incorrect otp");
	                        String upbal=amt.getText();
	                        try
	                        {
	                            File myFile = new File("D:\\\\cardBalance.txt");
	                            //PrintStream file = new PrintStream("D:\\\\cardBalance.txt");
	                            FileWriter file= new FileWriter("D:\\\\cardBalance.txt",true);
	                            String n1=amt.getText();
	                            file.append("\n"+n1);
	                            file.close();
	                            transactionSheet list=new transactionSheet();
	                            list.getStore();
	                            upBal.setText(list.peek());
	                        }
	                        catch(Exception e2)
	                        {
	                            System.out.println("error");
	                        }
	                        frame.dispose();   
	                    }
	                });
	                panel.add(p, BorderLayout.WEST);
	                panel.add(pass,BorderLayout.WEST);   
				}
				else if(no.equals("")&&no2.equals("")&&AM.equals(""))
				{
					JOptionPane.showMessageDialog(null, "you have entered nothing try again.....");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "incorrect credentials are entered.....");
				}
			}
		});
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBounds(411, 342, 156, 33);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener()//which shows the ticketDetails class
				{
					public void actionPerformed(ActionEvent e1)
					{
						mainPro mp=new mainPro();
						mp.NewScreen(null);
						frame.dispose();
					}
				});
				
		JLabel lblUpdatedBalance = new JLabel("UPDATED BALANCE:");
		lblUpdatedBalance.setBounds(51, 416, 177, 16);
		frame.getContentPane().add(lblUpdatedBalance);
		
		upBal = new JTextField();
		upBal.setBounds(176, 413, 116, 22);
		frame.getContentPane().add(upBal);
		upBal.setColumns(10);
	}
}
