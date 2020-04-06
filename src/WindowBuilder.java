import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class WindowBuilder {

	private JFrame frmMyCryptifyTool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frmMyCryptifyTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Logic logic;
	private JTextField keyTextField;
	
	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		initialize();
		
		logic = new Logic(this);
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyCryptifyTool = new JFrame();
		frmMyCryptifyTool.setTitle("MyCryptifyTool");
		frmMyCryptifyTool.setResizable(false);
		frmMyCryptifyTool.getContentPane().setBackground(Color.WHITE);
		frmMyCryptifyTool.getContentPane().setLayout(null);
		
		JPanel headlinePanel = new JPanel();
		headlinePanel.setBounds(10, 11, 869, 54);
		headlinePanel.setBackground(SystemColor.control);
		frmMyCryptifyTool.getContentPane().add(headlinePanel);
		headlinePanel.setLayout(null);
		
		JLabel headlineLabel = new JLabel("MyCryptifyTool");
		headlineLabel.setBackground(Color.WHITE);
		headlineLabel.setBounds(0, 0, 869, 54);
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlinePanel.add(headlineLabel);
		
		JPanel inputPane = new JPanel();
		inputPane.setBounds(10, 76, 869, 174);
		frmMyCryptifyTool.getContentPane().add(inputPane);
		inputPane.setLayout(null);
		
		JLabel inputLabel = new JLabel("Input Text");
		inputLabel.setBounds(10, 11, 849, 14);
		inputPane.add(inputLabel);
		
		JScrollPane inputScrollPane = new JScrollPane();
		inputScrollPane.setBounds(10, 37, 849, 126);
		inputPane.add(inputScrollPane);
		
		JTextArea inputTextArea = new JTextArea();
		inputScrollPane.setViewportView(inputTextArea);
		
		JPanel optionsPane = new JPanel();
		optionsPane.setBounds(10, 261, 869, 68);
		frmMyCryptifyTool.getContentPane().add(optionsPane);
		optionsPane.setLayout(null);
		
		JLabel optionsLabel = new JLabel("Options");
		optionsLabel.setBounds(10, 11, 849, 14);
		optionsPane.add(optionsLabel);
		
		JButton encryptButton = new JButton("Encrypt");
		encryptButton.setEnabled(false);
		encryptButton.setBounds(10, 34, 89, 23);
		optionsPane.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setEnabled(false);
		decryptButton.setBounds(109, 34, 89, 23);
		optionsPane.add(decryptButton);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(null);
		outputPanel.setBounds(10, 419, 869, 174);
		frmMyCryptifyTool.getContentPane().add(outputPanel);
		
		JLabel outputLabel = new JLabel("Output Text");
		outputLabel.setBounds(10, 11, 849, 14);
		outputPanel.add(outputLabel);
		
		JScrollPane outputScrollPane = new JScrollPane();
		outputScrollPane.setBounds(10, 37, 849, 126);
		outputPanel.add(outputScrollPane);
		
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setEditable(false);
		outputScrollPane.setViewportView(outputTextArea);
		
		JPanel keyPanel = new JPanel();
		keyPanel.setBounds(10, 340, 869, 68);
		frmMyCryptifyTool.getContentPane().add(keyPanel);
		keyPanel.setLayout(null);
		
		JLabel keyLabel = new JLabel("Your key");
		keyLabel.setBounds(10, 11, 849, 14);
		keyPanel.add(keyLabel);
		
		JScrollPane keyScrollPane = new JScrollPane();
		keyScrollPane.setBounds(10, 36, 849, 20);
		keyScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		keyPanel.add(keyScrollPane);
		
		keyTextField = new JTextField();
		keyScrollPane.setViewportView(keyTextField);
		keyTextField.setColumns(10);
		frmMyCryptifyTool.setBounds(100, 100, 908, 646);
		frmMyCryptifyTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/**
		 * Event Listeners
		 */
		
		inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
				} else {
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
				} else {
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		keyTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
				} else {
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {

				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
				} else {
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		
		encryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputTextArea.setText(logic.encryptInputText(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
				inputTextArea.setText("");
				keyTextField.setText("");
				
			}
		});
		
		decryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputTextArea.setText(logic.decryptInputText(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
				inputTextArea.setText("");
				keyTextField.setText("");
				
			}
		});
		
		keyTextField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					
					e.consume();
					
				}
				
			}
			
		});
		
	}
	
	
}
