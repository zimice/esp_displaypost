import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	public static boolean isValidIPAddress(String ip) {

		String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

		Pattern p = Pattern.compile(regex);
		if (ip == null) {
			return false;
		}
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String ip=null;
					while(ip ==null) {
					 ip = JOptionPane.showInputDialog("Enter a path");
					 System.out.println(isValidIPAddress(ip));
					 if(!isValidIPAddress(ip)) {
						 ip = null;
					 	JOptionPane.showMessageDialog(null,"Wrong format of ip address.Example: 10.10.1.1");
					 }
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
