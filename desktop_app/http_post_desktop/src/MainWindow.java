import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import http.HttpPost;
import url.urlParser;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private static String url;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String input_url=null;
					while(input_url ==null) {
					 input_url = JOptionPane.showInputDialog("Enter a path");
					 System.out.println(urlParser.isValidinput_urlAddress(input_url));
					 if(!urlParser.isValidinput_urlAddress(input_url)) {
						 input_url = null;
					 	JOptionPane.showMessageDialog(null,"Wrong format of input_url address.Example: 10.10.1.1");
					 }
					 url = input_url;

					}
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTextArea txt_area = new JTextArea();
		txt_area.setBounds(12, 12, 290, 179);
		contentPane.add(txt_area);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			String mes = txt_area.getText();
			HttpPost p = new HttpPost();
			p.sendPost(mes);
				
			}
			
		});
		btnSubmit.setBounds(311, 26, 117, 25);
		contentPane.add(btnSubmit);
	}

}
