package com.mycryptifytool;

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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class WindowBuilder {

	Crypto crypto = new Crypto();
	private JFrame frmMyCryptifyTool;
	private JTextField keyTextField;

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

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyCryptifyTool = new JFrame();
		frmMyCryptifyTool.setBackground(Color.WHITE);
		frmMyCryptifyTool.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowBuilder.class.getResource("/com/mycryptifytool/Key.png")));
		frmMyCryptifyTool.setTitle("MyCryptifyTool");
		frmMyCryptifyTool.setResizable(false);
		frmMyCryptifyTool.getContentPane().setBackground(Color.DARK_GRAY);
		frmMyCryptifyTool.getContentPane().setLayout(null);
		
		JPanel headlinePanel = new JPanel();
		headlinePanel.setBounds(10, 11, 869, 54);
		headlinePanel.setBackground(Color.DARK_GRAY);
		frmMyCryptifyTool.getContentPane().add(headlinePanel);
		headlinePanel.setLayout(null);
		
		JLabel headlineLabel = new JLabel("MyCryptifyTool");
		headlineLabel.setForeground(Color.WHITE);
		headlineLabel.setBackground(Color.WHITE);
		headlineLabel.setBounds(0, 0, 869, 54);
		headlineLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlinePanel.add(headlineLabel);
		
		JPanel inputPane = new JPanel();
		inputPane.setBackground(Color.DARK_GRAY);
		inputPane.setBounds(10, 76, 869, 174);
		frmMyCryptifyTool.getContentPane().add(inputPane);
		inputPane.setLayout(null);
		
		JLabel inputLabel = new JLabel("Your text");
		inputLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		inputLabel.setForeground(Color.WHITE);
		inputLabel.setBounds(10, 11, 849, 14);
		inputPane.add(inputLabel);
		
		JScrollPane inputScrollPane = new JScrollPane();
		inputScrollPane.setBounds(10, 37, 849, 126);
		inputPane.add(inputScrollPane);
		
		JTextArea inputTextArea = new JTextArea();
		inputTextArea.setWrapStyleWord(true);
		inputTextArea.setToolTipText("The text you want to encrypt or decrypt.");
		inputTextArea.setLineWrap(true);
		inputScrollPane.setViewportView(inputTextArea);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBackground(Color.DARK_GRAY);
		outputPanel.setLayout(null);
		outputPanel.setBounds(10, 419, 869, 174);
		frmMyCryptifyTool.getContentPane().add(outputPanel);
		
		JLabel outputLabel = new JLabel("Output Text");
		outputLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		outputLabel.setForeground(Color.WHITE);
		outputLabel.setBounds(10, 11, 849, 14);
		outputPanel.add(outputLabel);
		
		JScrollPane outputScrollPane = new JScrollPane();
		outputScrollPane.setBounds(10, 37, 849, 126);
		outputPanel.add(outputScrollPane);
		
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setWrapStyleWord(true);
		outputTextArea.setToolTipText("The encrypted or decrypted text.");
		outputTextArea.setLineWrap(true);
		outputTextArea.setEditable(false);
		outputScrollPane.setViewportView(outputTextArea);
		
		JPanel keyPanel = new JPanel();
		keyPanel.setBackground(Color.DARK_GRAY);
		keyPanel.setBounds(10, 261, 869, 68);
		frmMyCryptifyTool.getContentPane().add(keyPanel);
		keyPanel.setLayout(null);
		
		JLabel keyLabel = new JLabel("Your secret key");
		keyLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		keyLabel.setForeground(Color.WHITE);
		keyLabel.setBounds(10, 11, 849, 14);
		keyPanel.add(keyLabel);
		
		keyTextField = new JTextField();
		keyTextField.setToolTipText("The key to be used to encrypt or decrypt the text.");
		keyTextField.setBounds(10, 36, 114, 21);
		keyTextField.setColumns(10);
		keyPanel.add(keyTextField);
		
		JPanel optionsPane = new JPanel();
		optionsPane.setBackground(Color.DARK_GRAY);
		optionsPane.setBounds(10, 340, 869, 68);
		frmMyCryptifyTool.getContentPane().add(optionsPane);
		optionsPane.setLayout(null);
		
		JLabel optionsLabel = new JLabel("Options");
		optionsLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		optionsLabel.setForeground(Color.WHITE);
		optionsLabel.setToolTipText("");
		optionsLabel.setBounds(10, 11, 849, 14);
		optionsPane.add(optionsLabel);
		
		JButton encryptButton = new JButton("Encrypt");
		encryptButton.setFont(new Font("Arial", Font.PLAIN, 13));
		encryptButton.setBackground(Color.WHITE);
		encryptButton.setForeground(Color.BLACK);
		encryptButton.setToolTipText("Encrypts the text with the given key.");
		encryptButton.setEnabled(false);
		encryptButton.setBounds(10, 34, 89, 23);
		optionsPane.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setFont(new Font("Arial", Font.PLAIN, 13));
		decryptButton.setBackground(Color.WHITE);
		decryptButton.setForeground(Color.BLACK);
		decryptButton.setToolTipText("Decrypts the text with the given key.");
		decryptButton.setEnabled(false);
		decryptButton.setBounds(109, 34, 89, 23);
		optionsPane.add(decryptButton);
		encryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputTextArea.setText(crypto.caesarCipherEncrypt(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
				inputTextArea.setText("");
				keyTextField.setText("");
				
			}
			
		});
		decryptButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				outputTextArea.setText(crypto.caesarCipherDecrypt(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
				inputTextArea.setText("");
				keyTextField.setText("");
			}
			
		});
		frmMyCryptifyTool.setBounds(100, 100, 908, 646);
		frmMyCryptifyTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/**
		 * Event Listeners
		 */
		
		/**
		 * Enables or Disables the Encrypt/Decrypt Buttons if inputTextArea or keyTextField are emtpy
		 * 
		 * Eventlister is attached inputTextArea
		 */
		inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
			
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
				
				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
					
					
				} else {
					
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
					
				}
				
			}
			
		});
		
		/**
		 * Enables or Disables the Encrypt/Decrypt Buttons if inputTextArea or keyTextField are emtpy
		 * 
		 * Eventlister is attached keyTextField
		 */
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
				
				if(inputTextArea.getText().trim().equals("") || keyTextField.getText().trim().equals("")) {
					
					encryptButton.setEnabled(false);
					decryptButton.setEnabled(false);
					
				} else {
					
					encryptButton.setEnabled(true);
					decryptButton.setEnabled(true);
					
				}
				
			}
			
		});
		
		/**
		 * Eventlistener on encryptButton
		 */
		
		/**
		 * Eventlistener on decryptButton
		 */
		
		/**
		 * Consumes everything other than Digits in keyTextField
		 */
		keyTextField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					
					e.consume();
					
				}
				
				if(keyTextField.getText().length() >= 6) {
					
					e.consume();
					
				}
				
			}
			
		});
		
	}
	
	
}
