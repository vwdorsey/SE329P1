import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		uploadImagePanel.setBounds(797, 11, 457, 53);
		mainContentPane.add(uploadImagePanel);
		
		JButton button = new JButton("Upload Image");
		button.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		uploadImagePanel.setLayout(null);
		button.setBounds(244, 11, 203, 31);
		uploadImagePanel.add(button);
		
		JTextPane txtpnClickAboveTo = new JTextPane();
		txtpnClickAboveTo.setBounds(0, 0, 249, 53);
		uploadImagePanel.add(txtpnClickAboveTo);
		txtpnClickAboveTo.setBackground(SystemColor.controlHighlight);
		txtpnClickAboveTo.setText("Cliick right to upload the image for detection or to load faces into the threat database.");
		
		JPanel generateFaceMapPanel = new JPanel();
		generateFaceMapPanel.setBackground(SystemColor.controlHighlight);
		generateFaceMapPanel.setBounds(797, 69, 457, 53);
		mainContentPane.add(generateFaceMapPanel);
		generateFaceMapPanel.setLayout(null);
		
		JButton button_1 = new JButton("Generate Face Map");
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_1.setBounds(189, 11, 258, 35);
		generateFaceMapPanel.add(button_1);
		
		JTextPane txtpnClickRightTo = new JTextPane();
		txtpnClickRightTo.setText("Click right to generate a facemap.");
		txtpnClickRightTo.setBackground(SystemColor.controlHighlight);
		txtpnClickRightTo.setBounds(0, 0, 179, 53);
		generateFaceMapPanel.add(txtpnClickRightTo);
		
		JPanel threatNamePanel = new JPanel();
		threatNamePanel.setBackground(SystemColor.controlHighlight);
		threatNamePanel.setBounds(797, 390, 457, 280);
		mainContentPane.add(threatNamePanel);
		threatNamePanel.setLayout(null);
		
		ArrayList<String> threatNamesInImage = new ArrayList<String>();
		//DEBUG
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		threatNamesInImage.add("Zombie Hitler");
		DefaultListModel listModel = new DefaultListModel();
		for(String threatName : threatNamesInImage)
		{
			listModel.addElement(threatName);
		}
		JList list = new JList(listModel);	
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 11, 437, 258);
		threatNamePanel.add(scrollPane);
		
		JPanel threatDetectedImage = new JPanel();
		threatDetectedImage.setBackground(Color.GRAY);
		threatDetectedImage.setBounds(807, 139, 436, 240);
		mainContentPane.add(threatDetectedImage);
	}
}
