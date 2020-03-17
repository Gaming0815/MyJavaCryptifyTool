
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Listener {

	public Listener() {
		
		GUI myGUI = new GUI();
		Schriffierer schriffierer = new Schriffierer();
			
		myGUI.encryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						myGUI.setOutputTextValue(schriffierer.schriffierenCA(myGUI.getInputTextValue(), myGUI.getKeyTextValue()));
					
				}
			});
			
		myGUI.decryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						myGUI.setOutputTextValue(schriffierer.deschriffierenCA(myGUI.getInputTextValue(), myGUI.getKeyTextValue()));
					
				}
			});
		
		myGUI.inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(!myGUI.inputTextArea.getText().equals("") && !myGUI.keyText.getText().equals("")) {
					myGUI.encryptButton.setEnabled(true);
					myGUI.decryptButton.setEnabled(true);
				} else {
					myGUI.encryptButton.setEnabled(false);
					myGUI.decryptButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(!myGUI.inputTextArea.getText().equals("") && !myGUI.keyText.getText().equals("")) {
					myGUI.encryptButton.setEnabled(true);
					myGUI.decryptButton.setEnabled(true);
				} else {
					myGUI.encryptButton.setEnabled(false);
					myGUI.decryptButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
		
		myGUI.keyText.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				if(!myGUI.keyText.getText().equals("") && !myGUI.inputTextArea.getText().equals("")) {
					myGUI.encryptButton.setEnabled(true);
					myGUI.decryptButton.setEnabled(true);
				} else {
					myGUI.encryptButton.setEnabled(false);
					myGUI.decryptButton.setEnabled(false);
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(!myGUI.keyText.getText().equals("") && !myGUI.inputTextArea.getText().equals("")) {
					myGUI.encryptButton.setEnabled(true);
					myGUI.decryptButton.setEnabled(true);
				} else {
					myGUI.encryptButton.setEnabled(false);
					myGUI.decryptButton.setEnabled(false);
				}
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
						
		});
	
		myGUI.keyText.addKeyListener(new KeyAdapter() {

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
