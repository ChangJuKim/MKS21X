import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener {
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConversionWindow() {
	//prepares the window
	this.setTitle("Temperature Conversion Time!!!");
	this.setSize(600,400);
	this.setLocation(110,110);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	//buttons
	JButton ctof = new JButton("Celcius to Farenheit");
	//decides who listens to this button
	ctof.addActionListener(this);
	//when pressed, shouts the action -- CtoF
	ctof.setActionCommand("CtoF");
	
	JButton ftoc = new JButton("Farenheit to Celcius");
	ftoc.addActionListener(this);
	ftoc.setActionCommand("FtoC");

	//text field
	t = new JTextField(10);

	//programmer's text
	j = new JLabel("And your desired result is... ");

	//adds buttons in particular order
	pane.add(t);
	pane.add(ctof);
	pane.add(ftoc);
	pane.add(j);
    }

    public double CelciusToFarenheit(double temp) {
	return 9.0 / 5.0 * temp + 32;
    }

    public double FarenheitToCelcius(double temp) {
	return (temp - 32) * 5.0 / 9.0;
    }
    
    //reads an action
    public void actionPerformed(ActionEvent e) {
	j.setText("Your temperature is... ");
	String event = e.getActionCommand();
	if (event.equals("CtoF")) {
	    String s = t.getText();
	    try {
		double d = CelciusToFarenheit(Double.parseDouble(s));
		j.setText(j.getText() + d + " degrees Farenheit!");
	    }
	    catch (NumberFormatException ex) {
		j.setText("Error: Did not input a number!!!!!! RAWR!!!!");
	    }
	}
	if (event.equals("FtoC")) {
	    String s = t.getText();
	    try {
		double d = FarenheitToCelcius(Double.parseDouble(s));
		j.setText(j.getText() + d + " degrees Celcius!");
	    }
	    catch (NumberFormatException ex) {
		j.setText("Error: Did not input a number!!!!!! RAWR!!!!");
	    }
	}
    }
}
