import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;

public class FaceMapper extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel mainContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					FaceMapper frame = new FaceMapper();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FaceMapper() {
		setTitle("Code Warriors Threat Detector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
		
		JPanel rawImagePanel = new JPanel();
		rawImagePanel.setBackground(SystemColor.controlHighlight);
		rawImagePanel.setBounds(10, 11, 777, 325);
		mainContentPane.add(rawImagePanel);
		
		JPanel faceMapImagePanel = new JPanel();
		faceMapImagePanel.setBackground(SystemColor.controlHighlight);
		faceMapImagePanel.setBounds(10, 345, 777, 325);
		mainContentPane.add(faceMapImagePanel);
		
		JPanel uploadImagePanel = new JPanel();
		uploadImagePanel.setBackground(SystemColor.controlHighlight);
		uploadImagePanel.setBounds(797, 11, 457, 75);
		mainContentPane.add(uploadImagePanel);
		uploadImagePanel.setLayout(null);
		
		JButton button = new JButton("Upload Image");
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		button.setBounds(187, 11, 260, 50);
		uploadImagePanel.add(button);
		
		JTextPane txtpnClickAboveTo = new JTextPane();
		txtpnClickAboveTo.setBackground(SystemColor.controlHighlight);
		txtpnClickAboveTo.setText("Cliick right to upload the image for detection or to load faces into the threat database.");
		txtpnClickAboveTo.setBounds(10, 11, 167, 50);
		uploadImagePanel.add(txtpnClickAboveTo);
		
		JPanel generateFaceMapPanel = new JPanel();
		generateFaceMapPanel.setBackground(SystemColor.controlHighlight);
		generateFaceMapPanel.setBounds(797, 97, 457, 75);
		mainContentPane.add(generateFaceMapPanel);
		generateFaceMapPanel.setLayout(null);
		
		JButton button_1 = new JButton("Generate Face Map");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_1.setBounds(187, 11, 260, 50);
		generateFaceMapPanel.add(button_1);
		
		JTextPane txtpnClickRightTo = new JTextPane();
		txtpnClickRightTo.setText("Click right to generate a facemap.");
		txtpnClickRightTo.setBackground(SystemColor.controlHighlight);
		txtpnClickRightTo.setBounds(10, 11, 167, 50);
		generateFaceMapPanel.add(txtpnClickRightTo);
		
		JPanel threatNamePanel = new JPanel();
		threatNamePanel.setBackground(SystemColor.controlHighlight);
		threatNamePanel.setBounds(797, 504, 457, 166);
		mainContentPane.add(threatNamePanel);
		threatNamePanel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 437, 144);
		threatNamePanel.add(list);
		
		JPanel threatDetectedImage = new JPanel();
		threatDetectedImage.setBackground(Color.GRAY);
		threatDetectedImage.setBounds(807, 191, 436, 288);
		mainContentPane.add(threatDetectedImage);
	}
}
