package com.mycryptifytool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class WindowBuilder {

	private JFrame frmMyCryptifyTool;
	private JTextField keyTextField;
	private JTextArea inputTextArea;
	private JTextArea outputTextArea;

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
		frmMyCryptifyTool.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMyCryptifyTool.getContentPane().setLayout(null);
		
		JPanel headlinePanel = new JPanel();
		headlinePanel.setBounds(10, 11, 869, 54);
		headlinePanel.setBackground(Color.LIGHT_GRAY);
		frmMyCryptifyTool.getContentPane().add(headlinePanel);
		headlinePanel.setLayout(null);
		
		JLabel headlineLabel = new JLabel("MyCryptifyTool");
		headlineLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		headlineLabel.setForeground(Color.DARK_GRAY);
		headlineLabel.setBackground(Color.WHITE);
		headlineLabel.setBounds(0, 0, 869, 54);
		headlineLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlinePanel.add(headlineLabel);
		
		JPanel inputPane = new JPanel();
		inputPane.setAutoscrolls(true);
		inputPane.setFont(new Font("Arial", Font.PLAIN, 11));
		inputPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "1. Your text input", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		inputPane.setBackground(Color.LIGHT_GRAY);
		inputPane.setBounds(10, 77, 869, 174);
		frmMyCryptifyTool.getContentPane().add(inputPane);
		inputPane.setLayout(null);
		
		JScrollPane inputScrollPane = new JScrollPane();
		inputScrollPane.setBounds(10, 21, 849, 142);
		inputPane.add(inputScrollPane);
		
		inputTextArea = new JTextArea();
		inputTextArea.setFont(new Font("Arial", Font.PLAIN, 13));
		inputTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		inputTextArea.setWrapStyleWord(true);
		inputTextArea.setToolTipText("The text you want to encrypt or decrypt.");
		inputTextArea.setLineWrap(true);
		inputScrollPane.setViewportView(inputTextArea);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setFont(new Font("Arial", Font.PLAIN, 11));
		outputPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "4. En-/Decrypted text output", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		outputPanel.setBackground(Color.LIGHT_GRAY);
		outputPanel.setLayout(null);
		outputPanel.setBounds(10, 419, 869, 174);
		frmMyCryptifyTool.getContentPane().add(outputPanel);
		
		JScrollPane outputScrollPane = new JScrollPane();
		outputScrollPane.setFont(new Font("Arial", Font.PLAIN, 11));
		outputScrollPane.setBounds(10, 25, 849, 138);
		outputPanel.add(outputScrollPane);
		
		outputTextArea = new JTextArea();
		outputTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		outputTextArea.setWrapStyleWord(true);
		outputTextArea.setToolTipText("The encrypted or decrypted text.");
		outputTextArea.setLineWrap(true);
		outputTextArea.setEditable(false);
		outputScrollPane.setViewportView(outputTextArea);
		
		JPanel keyPanel = new JPanel();
		keyPanel.setFont(new Font("Arial", Font.PLAIN, 11));
		keyPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "2. Your secret key", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		keyPanel.setBackground(Color.LIGHT_GRAY);
		keyPanel.setBounds(10, 280, 869, 54);
		frmMyCryptifyTool.getContentPane().add(keyPanel);
		keyPanel.setLayout(null);
		
		keyTextField = new JTextField();
		keyTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		keyTextField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		keyTextField.setToolTipText("The key to be used to encrypt or decrypt the text.");
		keyTextField.setBounds(10, 23, 114, 21);
		keyTextField.setColumns(10);
		keyPanel.add(keyTextField);
		
		JLabel keyToLongWarningLabel = new JLabel("Max length for key is 6");
		keyToLongWarningLabel.setVisible(false);
		keyToLongWarningLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		keyToLongWarningLabel.setForeground(Color.RED);
		keyToLongWarningLabel.setBounds(131, 26, 114, 14);
		keyPanel.add(keyToLongWarningLabel);
		
		JPanel optionsPane = new JPanel();
		optionsPane.setFont(new Font("Arial", Font.PLAIN, 11));
		optionsPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "3. Options", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		optionsPane.setBackground(Color.LIGHT_GRAY);
		optionsPane.setBounds(10, 335, 869, 82);
		frmMyCryptifyTool.getContentPane().add(optionsPane);
		optionsPane.setLayout(null);
		
		JButton encryptButton = new JButton("Encrypt");
		encryptButton.setFont(new Font("Arial", Font.PLAIN, 13));
		encryptButton.setBackground(Color.WHITE);
		encryptButton.setForeground(Color.DARK_GRAY);
		encryptButton.setToolTipText("Encrypts the text with the given key.");
		encryptButton.setEnabled(false);
		encryptButton.setBounds(142, 34, 89, 23);
		optionsPane.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setFont(new Font("Arial", Font.PLAIN, 13));
		decryptButton.setBackground(Color.WHITE);
		decryptButton.setForeground(Color.DARK_GRAY);
		decryptButton.setToolTipText("Decrypts the text with the given key.");
		decryptButton.setEnabled(false);
		decryptButton.setBounds(225, 34, 89, 23);
		optionsPane.add(decryptButton);
		
		JRadioButton caesarCipherRadioButton = new JRadioButton("Caesar cipher");
		caesarCipherRadioButton.setToolTipText("Use the caesar cipher");
		caesarCipherRadioButton.setForeground(Color.DARK_GRAY);
		caesarCipherRadioButton.setBackground(Color.LIGHT_GRAY);
		caesarCipherRadioButton.setFont(new Font("Arial", Font.PLAIN, 13));
		caesarCipherRadioButton.setBounds(16, 23, 134, 23);
		optionsPane.add(caesarCipherRadioButton);
		
		JRadioButton polyalphabeticRadioButton = new JRadioButton("Polyalphabetic");
		polyalphabeticRadioButton.setToolTipText("Use polyalphabetic encryption");
		polyalphabeticRadioButton.setForeground(Color.DARK_GRAY);
		polyalphabeticRadioButton.setBackground(Color.LIGHT_GRAY);
		polyalphabeticRadioButton.setFont(new Font("Arial", Font.PLAIN, 13));
		polyalphabeticRadioButton.setBounds(16, 49, 120, 23);
		optionsPane.add(polyalphabeticRadioButton);
		
		JButton loadFileButton = new JButton("Load file");
		loadFileButton.setToolTipText("Load text from textfile");
		loadFileButton.setBounds(751, 252, 117, 29);
		frmMyCryptifyTool.getContentPane().add(loadFileButton);
		
		JButton safeFileButton = new JButton("Safe as file");
		safeFileButton.setToolTipText("Safe output to file");
		safeFileButton.setBounds(751, 594, 117, 29);
		frmMyCryptifyTool.getContentPane().add(safeFileButton);
		
		JLabel loadedFileLabel = new JLabel("");
		loadedFileLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		loadedFileLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		loadedFileLabel.setVisible(false);
		loadedFileLabel.setBounds(470, 257, 269, 16);
		frmMyCryptifyTool.getContentPane().add(loadedFileLabel);
		frmMyCryptifyTool.setBounds(100, 100, 890, 664);
		frmMyCryptifyTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		enableDragAndDrop();
		
		/*
		 * Event Listeners
		 */
		
		// Encrypt inputtext on encryptButton press
				encryptButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caesarCipherRadioButton.isSelected() == true) {
							Boolean isDigit = false;
							for(int i = 0; i < keyTextField.getText().length(); i++) {
								if(Character.isDigit(keyTextField.getText().charAt(i))) {
									isDigit = true;
								} else {
									isDigit = false;
									break;
								}
							}
												
							if(isDigit == true) {
								outputTextArea.setText(Crypto.encryptCaesarCipher(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
								inputTextArea.setText("");
								keyTextField.setText("");
							} else {
								JOptionPane.showMessageDialog(frmMyCryptifyTool, "The caesar cipher does only allow numbers to be used as a key", null, JOptionPane.ERROR_MESSAGE);
							}					
							
						} else if(polyalphabeticRadioButton.isSelected() == true) {
							outputTextArea.setText(Crypto.encryptPolyalphabetic(inputTextArea.getText().trim(), keyTextField.getText()));
							inputTextArea.setText("");
							keyTextField.setText("");
						} else {
							JOptionPane.showMessageDialog(frmMyCryptifyTool, "Please choose an En-/Decryption method!", null, JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
				// Decrypt inputtext on decryptButton press
				decryptButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(caesarCipherRadioButton.isSelected() == true) {
							Boolean isDigit = false;
							for(int i = 0; i < keyTextField.getText().length(); i++) {
								if(Character.isDigit(keyTextField.getText().charAt(i))) {
									isDigit = true;
								} else {
									isDigit = false;
									break;
								}
							}
							if(isDigit == true) {
								outputTextArea.setText(Crypto.decryptCaesarCipher(inputTextArea.getText().trim(), Integer.parseInt(keyTextField.getText())));
								inputTextArea.setText("");
								keyTextField.setText("");
							} else {
								JOptionPane.showMessageDialog(frmMyCryptifyTool, "The caesar cipher does only allow numbers to be used as a key", null, JOptionPane.ERROR_MESSAGE);
							}
						} else if(polyalphabeticRadioButton.isSelected() == true) {
							outputTextArea.setText(Crypto.decryptPolyalphabetic(inputTextArea.getText().trim(), keyTextField.getText()));
							inputTextArea.setText("");
							keyTextField.setText("");
						} else {
							JOptionPane.showMessageDialog(frmMyCryptifyTool, "Please choose an En-/Decryption method!", null, JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		
		/*
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
		
		/*
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
		
		/*
		 * Checks what radio button is selected and disables the other one
		 */
		caesarCipherRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caesarCipherRadioButton.setSelected(true);
				if(caesarCipherRadioButton.isSelected() == true) {
					polyalphabeticRadioButton.setSelected(false);
				} 
			}
		});
		
		polyalphabeticRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polyalphabeticRadioButton.setSelected(true);
				if(polyalphabeticRadioButton.isSelected() == true) {
					caesarCipherRadioButton.setSelected(false);
				} 
			}
		});
		
		/*
		 * Consumes everything thats longer than 6 chars and shows warning message
		 */
		keyTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyToLongWarningLabel.setVisible(false);
				if(keyTextField.getText().length() > 5) {
					e.consume();
					keyToLongWarningLabel.setVisible(true);
				}
			}
		});
		
		keyTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(keyToLongWarningLabel.isVisible()) {
					keyToLongWarningLabel.setVisible(false);
				}
			}
		});
		
		// Load text from file into inputtextarea
		loadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frmMyCryptifyTool);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    try {
				        Scanner myReader = new Scanner(selectedFile);
				        while (myReader.hasNextLine()) {
				          String data = myReader.nextLine();
				          loadedFileLabel.setText("Selected file: \"" + selectedFile.getName() + "\"");
				          loadedFileLabel.setVisible(true);
				          inputTextArea.setText(data);
				        }
				        myReader.close();
				      } catch (FileNotFoundException error) {
				    	JOptionPane.showMessageDialog(frmMyCryptifyTool, "The file \"" + selectedFile.getName() + "\" could not be read properly!", "Error", JOptionPane.ERROR_MESSAGE);
				        error.printStackTrace();
				      }
				}
			}
		});
		
		// Safe text from outputtextarea to file
		safeFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Save file");   
				int userSelection = fileChooser.showSaveDialog(frmMyCryptifyTool);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    try {
				        if (fileToSave.createNewFile() == true) {
				        	try {
						        FileWriter myWriter = new FileWriter(fileToSave);
						        myWriter.write(outputTextArea.getText());
						        myWriter.close();
						        loadedFileLabel.setVisible(false);
						        JOptionPane.showMessageDialog(frmMyCryptifyTool, "The file: \"" + fileToSave.getName() + "\" was successfully saved \nto: " + fileToSave.getAbsolutePath(), "Info", JOptionPane.INFORMATION_MESSAGE);
				        	} catch (IOException error) {
				        		loadedFileLabel.setVisible(false);
						    	JOptionPane.showMessageDialog(frmMyCryptifyTool, "The file: \"" + fileToSave.getName() + "\" could not be saved \nto: " + fileToSave.getAbsolutePath(), "Error", JOptionPane.ERROR_MESSAGE);
						        error.printStackTrace();
						      }
				        } else {
				        	int reply = JOptionPane.showConfirmDialog(frmMyCryptifyTool, "The file: \"" + fileToSave.getName() + "\" already exists \nin " + fileToSave.getAbsolutePath() + " \n\n Want to overwrite the existing file?", "Choose", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				        	if (reply == JOptionPane.YES_OPTION) {
				        		try {
							        FileWriter myWriter = new FileWriter(fileToSave);
							        myWriter.write(outputTextArea.getText());
							        myWriter.close();
							        loadedFileLabel.setVisible(false);
							        JOptionPane.showMessageDialog(frmMyCryptifyTool, "The new file: \"" + fileToSave.getName() + "\" was successfully saved \nto: " + fileToSave.getAbsolutePath(), "Info", JOptionPane.INFORMATION_MESSAGE);
							      } catch (IOException error) {
							    	  loadedFileLabel.setVisible(false);
							    	JOptionPane.showMessageDialog(frmMyCryptifyTool, "The new file: \"" + fileToSave.getName() + "\" could not be saved \nto: " + fileToSave.getAbsolutePath(), "Error", JOptionPane.ERROR_MESSAGE);
							        error.printStackTrace();
							      }
				        		loadedFileLabel.setVisible(false);
				        	} else {
				        		loadedFileLabel.setVisible(false);
				        	}
				        }
				      } catch (IOException error) {
				    	  loadedFileLabel.setVisible(false);
				    	  JOptionPane.showMessageDialog(frmMyCryptifyTool, "The file \"" + fileToSave.getName() + "\" could not be created!", "Error", JOptionPane.ERROR_MESSAGE);
				    	  error.printStackTrace();
				      }
				}
			}
		});
	}
	
	/*
	 * Getters and setters (May be used later)
	 */
	
	public String getInputText() {
		return inputTextArea.getText();
	}
	
	public void setInputText(String text) {
		inputTextArea.setText(text);
	}
	
	public String getOutputText() {
		return outputTextArea.getText();
	}
	
	public void setOutputText(String text) {
		outputTextArea.setText(text);
	}
	
	/*
	 * Enable Drag and Drop for inputTextArea
	 */
	
	private void enableDragAndDrop() {
		new DropTarget(inputTextArea, new DropTargetListener() {
		    @SuppressWarnings("rawtypes")
			@Override
		    public void drop(DropTargetDropEvent dtde) {
			    dtde.acceptDrop(dtde.getDropAction());
					java.util.List list;
					try {
						list = (java.util.List) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
						File file=(File)list.get(0);
						try {
							inputTextArea.read(new FileReader(file), null);
						} catch (IOException error) {
							error.printStackTrace();
						}
					} catch (UnsupportedFlavorException error) {
						error.printStackTrace();
					} catch (IOException error) {
						error.printStackTrace();
					}
				    dtde.dropComplete(true);
			}
		    @Override
		    public void dragEnter(DropTargetDragEvent dtde) {
		    }
		    @Override
		    public void dragOver(DropTargetDragEvent dtde) {
		    }
		    @Override
		    public void dropActionChanged(DropTargetDragEvent dtde) {
		    }
		    @Override
		    public void dragExit(DropTargetEvent dte) {
		    }

		});
	}
}
