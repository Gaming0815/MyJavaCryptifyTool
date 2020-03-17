
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	
	JPanel panel = new JPanel();
	JFrame mainFrame = new JFrame();
	
	public JLabel inputLabel = new JLabel("Input Text: ");
	public JTextArea inputTextArea = new JTextArea(3, 20);
	public JLabel optionsLabel = new JLabel("Options: ");
	public JButton encryptButton = new JButton("Encrypt");
	public JButton decryptButton = new JButton("Decrypt");
	public JLabel keyLabel = new JLabel("Schlüssel: ");
	public JTextField keyText = new JTextField("", 5);
	public JLabel outputLabel = new JLabel("Output Text: ");
	public JTextArea outputTextArea = new JTextArea(3, 20);
	
	public GUI() {
		
		Window();
		
	}
	
	private void Window() {
		
	    panel.add(inputLabel);
	    panel.add(inputTextArea);
	    panel.add(optionsLabel);
	    panel.add(encryptButton);
	    panel.add(decryptButton);
	    panel.add(keyLabel);
	    panel.add(keyText);
	    panel.add(outputLabel);
	    panel.add(outputTextArea);
	    
	    inputTextArea.setLineWrap(true);
		inputTextArea.setWrapStyleWord(true);
		
		outputTextArea.setLineWrap(true);
		outputTextArea.setWrapStyleWord(true);
		
		encryptButton.setEnabled(false);
		decryptButton.setEnabled(false);
		
	    mainFrame.setTitle("SchrifffierenTool");
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.add(panel);
	    mainFrame.pack();
	    mainFrame.setResizable(true);
	    mainFrame.setVisible(true);
	    
	}
	
	public String getInputTextValue() {
		
		return inputTextArea.getText();
	}
	
	public int getKeyTextValue() {
		
		return Integer.parseInt(keyText.getText());
	}
	
	public void setOutputTextValue(String text) {
		
		outputTextArea.setText(text);
		
	}
		
}
