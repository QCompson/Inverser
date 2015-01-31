
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class GUI extends JFrame {
	
	
	public GUI() {
	        
		initUI();
	 }
	
	private void initUI() {
	
		Container pane = getContentPane();
        pane.setLayout(new MigLayout(""));
		
		JButton getInverse = new JButton("Get inverse");
		JLabel label = new JLabel("Type in your matrix in the following format:");
		JTextArea input_tf = new JTextArea("1.0 0\n0 1.3");
		JTextArea output_tf = new JTextArea("");
		
		input_tf.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		output_tf.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		
		getInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			    Matrix input = new Matrix(input_tf.getText());
			    input.inverseMatrix();
			    input.writeToTextArea(output_tf);
			    }
		});
		
		pane.add(label, "center, wrap");
		pane.add(input_tf, " w 200!, h 50%, push, align center, wrap");
		pane.add(getInverse, "wrap, center");
		pane.add(output_tf, " w 50%, h 50%, push, center");
		pack();
		
		setTitle("Inverse matrix");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
	    
		EventQueue.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        GUI ex = new GUI();
		        ex.setVisible(true);
		    }
		});
	}

}
