package dentaku1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class dentaku1 extends JFrame implements ActionListener
{
	JTextField display;
	
	double num1 = 0;
	String operator = "";
	boolean startNewNumber = true;
	
	final int MAX_DIGITS = 12;
	final double MAX_RESULT_VALUE = 999999999999.0;
	final String OVERFLOW_TEXT = "オーバーフロー";
	
	public dentaku1()
	{
		setTitle("簡易電卓");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		display = new JTextField("0");
		display.setFont(new Font("Arial",Font.BOLD,28));
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,4,5,5));
		
		String[] buttons = 
			{
					"7","8","9","/",
					"4","5","6","*",
					"1","2","3","-",
					"0",".","=","+",
					"C"
			};
		for(String text : buttons)
		{
			JButton button = new JButton(text);
			button.setFont(new Font("Arial",Font.BOLD,24));
			
			button.addActionListener(this);
			
			panel.add(button);
		}
		
		add(display,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if(command.matches("[0-9]"))
		{
			String currentText = display.getText();
			if(startNewNumber || currentText.equals("0") || currentText.equals("Error"))
			{
				display.setText(command);
				startNewNumber = false;
			} else 
			{
				if(countDigits(currentText) < MAX_DIGITS)
				{
					display.setText(currentText + command);
				}
				
			}
		}else if(command.equals("."))
		{
			if(startNewNumber)
			{
				display.setText("0.");
				startNewNumber = false;
			}else if(!display.getText().contains("."))
			{
				display.setText(display.getText() + ".");
			}
		}else if(command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/"))
		{
			num1 = Double.parseDouble(display.getText());
			operator = command;
			startNewNumber = true;
		}else if(command.equals("="))
		{
			double num2 = Double.parseDouble(display.getText());
			double result = 0;
			
			switch(operator)
			{
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if(num2 == 0)
				{
					display.setText("Error");
					startNewNumber = true;
					return;
				}
				result = num1 / num2;
				break;
			}
			showResult(result);
			startNewNumber = true;
		}else if(command.equals("C"))
		{
			display.setText("0");
			num1 = 0;
			operator = "";
			startNewNumber = true;
		}
	}
	
	private String formatResult(double result)
	{
		DecimalFormat df = new DecimalFormat("0.#######");
		String text = df.format(result);
		if(text.length() > 12)
		{
			return"オーバーフロー";
		}
		return text;
	}
	
	private void showResult(double result)
	{
		if(Double.isInfinite(result) || Double.isNaN(result) || Math.abs(result) > MAX_RESULT_VALUE)
		{
			display.setText(OVERFLOW_TEXT);
			startNewNumber = true;
			operator = "";
			return;
		}
		display.setText(formatResult(result));
	}
	
	private int countDigits(String text)
	{
		int count = 0;
		for(int i = 0; i < text.length(); i++)
		{
			if(Character.isDigit(text.charAt(i)))
			{
				count++;
			}
		}
		return count;
	}
	
public static void main(String[] args)
{
	new dentaku1();
}
}
