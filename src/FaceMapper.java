import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FaceMapper extends JFrame
{
	private static final long serialVersionUID = 1L;
	Image storedImage;
	private JPanel mainContentPane;

	//Launch the application.
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

	//Create the frame.
	public FaceMapper() {
		//block for main window
		setTitle("Code Warriors Threat Detector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
		
		//image panel for main given image
		JPanel rawImagePanel = new JPanel();
		rawImagePanel.setBackground(SystemColor.controlHighlight);
		rawImagePanel.setBounds(10, 11, 777, 325);
		mainContentPane.add(rawImagePanel);
		rawImagePanel.setLayout(null);
		
		//holder for main given image
		JLabel rawImageLabelHolder = new JLabel("");
		rawImageLabelHolder.setBounds(0, 0, 777, 325);
		rawImagePanel.add(rawImageLabelHolder);
		
		//image panel for facemapped image
		JPanel faceMapImagePanel = new JPanel();
		faceMapImagePanel.setBackground(SystemColor.controlHighlight);
		faceMapImagePanel.setBounds(10, 345, 777, 325);
		mainContentPane.add(faceMapImagePanel);
		faceMapImagePanel.setLayout(null);
		
		//holder for facemapped image
		JLabel faceMapImageLabelHolder = new JLabel("");
		faceMapImageLabelHolder.setBounds(0, 0, 777, 325);
		faceMapImagePanel.add(faceMapImageLabelHolder);
		
		//button panel for uploading an image
		JPanel uploadImagePanel = new JPanel();
		uploadImagePanel.setBackground(SystemColor.controlHighlight);
		uploadImagePanel.setBounds(797, 11, 457, 53);
		mainContentPane.add(uploadImagePanel);
		
		//upload image button
		JButton uploadImageButton = new JButton("Upload Image");
		uploadImageButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				//DEBUG
				//System.out.println("testing mouse events");
				
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(new File("/Users"));
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "JPG", "GIF", "gif", "JPEG", "png", "PNG");
				jFileChooser.setFileFilter(filter);
				
				int result = jFileChooser.showOpenDialog(new JFrame());
				
				File selectedFile;
				if (result == JFileChooser.APPROVE_OPTION)
				{
					selectedFile = jFileChooser.getSelectedFile();
					
					//DEBUG
					//System.out.println(selectedFile.getAbsolutePath());
					
					try
					{
						Image image = ImageIO.read(selectedFile);
						storedImage = image;
						rawImageLabelHolder.setIcon(new ImageIcon(scaleImageHelper(rawImageLabelHolder.getWidth(), rawImageLabelHolder.getHeight(), image)));
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}		
			}
		});
		uploadImageButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		uploadImageButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//DEBUG
				//System.out.println("something happened in the uploadbutton");
			}
		});
		uploadImagePanel.setLayout(null);
		uploadImageButton.setBounds(244, 11, 203, 31);
		uploadImagePanel.add(uploadImageButton);
		//end of upload image button
		
		//information about uploading image
		JTextPane uploadImageTextGuide = new JTextPane();
		uploadImageTextGuide.setBounds(0, 0, 249, 53);
		uploadImagePanel.add(uploadImageTextGuide);
		uploadImageTextGuide.setBackground(SystemColor.controlHighlight);
		uploadImageTextGuide.setText("Click to the right to upload the image for detection or to load faces into the threat database.");
		
		//panel for facemap generation
		JPanel generateFaceMapPanel = new JPanel();
		generateFaceMapPanel.setBackground(SystemColor.controlHighlight);
		generateFaceMapPanel.setBounds(797, 69, 457, 53);
		mainContentPane.add(generateFaceMapPanel);
		generateFaceMapPanel.setLayout(null);
		
		//panel for showing whether a threat has been detected or not
		JPanel threatDetectedImage = new JPanel();
		threatDetectedImage.setBackground(Color.GRAY);
		threatDetectedImage.setBounds(807, 139, 436, 240);
		mainContentPane.add(threatDetectedImage);
		threatDetectedImage.setLayout(null);
		
		//text to say whether a threat has been detected or not, defaults to no image loaded
		JTextPane threatDetectionText = new JTextPane();
		threatDetectionText.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		threatDetectionText.setText("No image loaded yet.");
		threatDetectionText.setBackground(SystemColor.controlHighlight);
		threatDetectionText.setBounds(10, 11, 416, 218);
		threatDetectedImage.add(threatDetectionText);
			
		//panel to hold list of threats by name
		JPanel threatNamePanel = new JPanel();
		threatNamePanel.setBackground(SystemColor.controlHighlight);
		threatNamePanel.setBounds(797, 390, 457, 280);
		mainContentPane.add(threatNamePanel);
		threatNamePanel.setLayout(null);
		
		//default scrollpane, unloaded to hold threat names
		JScrollPane threatListScrollPane = new JScrollPane();
		threatListScrollPane.setBounds(10, 11, 437, 258);
		threatNamePanel.add(threatListScrollPane);
		
		//facemap generation button
		JButton genFaceMapButton = new JButton("Generate Face Map");
		genFaceMapButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//purposefully empty
			}
		});
		genFaceMapButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				//DEBUG
				//System.out.println("testing mouse events on generate facemap");
				
				if (storedImage != null)
				{
					//DEBUG
					//System.out.println("storedImage is not null");
					
					//it begins
					try
					{
						Image facemap = generateFaceMapHelper(threatDetectionText, threatListScrollPane, storedImage);
						try
						{
							Image sizedFaceMap = scaleImageHelper(faceMapImageLabelHolder.getWidth(), faceMapImageLabelHolder.getHeight(), facemap);
						
							faceMapImageLabelHolder.setIcon(new ImageIcon(sizedFaceMap));
						}
						catch(Exception faceMapGenerationException)
						{
							System.out.println("IMPROPER FACEMAP GENERATED");
						}
					}
					catch(Exception storedImageException)
					{
						System.out.println("IMPROPER STORED IMAGE");
					}
				}		
			}
		});
		genFaceMapButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		genFaceMapButton.setBounds(189, 11, 258, 35);
		generateFaceMapPanel.add(genFaceMapButton);
		//end generation of facemap button
		
		//information on generation of facemap
		JTextPane genFaceMapTextGuide = new JTextPane();
		genFaceMapTextGuide.setText("Click right to generate a facemap.");
		genFaceMapTextGuide.setBackground(SystemColor.controlHighlight);
		genFaceMapTextGuide.setBounds(0, 0, 179, 53);
		generateFaceMapPanel.add(genFaceMapTextGuide);
	}
	
	//scales image to label and creates icon
	private Image scaleImageHelper(int labelWidth, int labelHeight, Image image)
	{
		//as a helper method, this should never be null and should be filtered earlier
		assert(image != null);
		
		ImageIcon hWTest = new ImageIcon(image);
		
		//DEBUG
		//System.out.println(hWTest.getIconWidth() + " " + hWTest.getIconHeight());
		
		if((hWTest.getIconWidth()*1.0)/hWTest.getIconHeight() > (labelWidth*1.0)/labelHeight)
		{
			//DEBUG
			//System.out.println("Width > Height");
			
			double scale = 1.0*labelWidth/hWTest.getIconWidth();
			return image.getScaledInstance(labelWidth, (int) Math.round(hWTest.getIconHeight()*scale), Image.SCALE_SMOOTH);
		}
		else
		{
			//DEBUG
			//System.out.println("Height >= Width");
			
			double scale = 1.0*labelHeight/hWTest.getIconHeight();
			return image.getScaledInstance((int) Math.round(hWTest.getIconWidth()*scale), labelHeight, Image.SCALE_SMOOTH);
		}
		//image = image.getScaledInstance(rawImageLabelHolder.getWidth(), rawImageLabelHolder.getHeight(), Image.SCALE_SMOOTH);
	}
	
	//it is in here that the image would be turned into
	private Image generateFaceMapHelper(JTextPane jT, JScrollPane jSP, Image a)
	{		
		//DEBUG
		//threatDetected(jT,true);
		
		/*
		 * It is important to note that it is at this point the project become
		 * a bit too difficult due to technology available.
		 * 
		 * However it is logical at this point to determine what would happen here.
		 * 
		 * The image would be converted and sent to a remote server which would
		 * generate a face map and send us back XML information about the people which
		 * would be parsed here and compared to a database of threats, and those that
		 * match would be added to the list of names below, which would trigger the threat
		 * detection.
		 * 
		 * As mentioned previously no API allowed us to do this within the time given.
		 * Perhaps over a period of a month with multiple developers,
		 * but not a week and change.
		 */		
		
		ArrayList<String> threatNamesInImage = new ArrayList<String>();
		
		//DEBUG
		for(int i = 1; i <= 15; i++)
			threatNamesInImage.add("Ninja #" + i);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(String threatName : threatNamesInImage)
		{
			listModel.addElement(threatName);
		}
		JList<String> list = new JList<String>(listModel);	
		
		//updates warning label
		threatDetected(jT, !threatNamesInImage.isEmpty());
		
		//adds names to viewport in scroll pane
		jSP.setViewportView(list);
		
		//DEBUG
		System.out.println("Returning same image.");
		return a;
	}
	
	//red for detected, green for undetected
	private void threatDetected(JTextPane j, boolean b)
	{
		if(b)
		{
			j.setText("THREAT DETECTED");
			j.setBackground(Color.RED);
			j.setForeground(Color.BLACK);
		}
		else
		{
			j.setText("No threat detected.");
			j.setBackground(Color.GREEN);
			j.setForeground(Color.DARK_GRAY);
		}
	}
}

