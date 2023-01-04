package com.calclator.app;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ButtonGroup;
//Main class
public class CalculatorApp {
	//Declaring the variables 
	private JFrame frmCalculator;
	private JTextField textField;
	double firstNumber;
	double secondNumber;
	double result;
	String operation;
	String number;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean showingAnswer;
	private javax.swing.JButton button0, button1,button2, button3,button4,button5,button6,
								button7,button8,button9,button00,buttonClear,buttonDot,
								buttonBackspace,buttonEquals,addition,subtraction,
								multiplication,division,modulus;
	private JRadioButton radioButtonOn,radioButtonOff;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public CalculatorApp() {
		initialize();	
	}
	public void enable() {                    
		textField.setEnabled(true);
		radioButtonOn.setEnabled(true);
		button0.setEnabled(true);
		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
		button5.setEnabled(true);
		button6.setEnabled(true);
		button7.setEnabled(true);
		button8.setEnabled(true);
		button9.setEnabled(true);
		buttonBackspace.setEnabled(true);
		buttonClear.setEnabled(true);
		button00.setEnabled(true);
		addition.setEnabled(true);
		subtraction.setEnabled(true);
		multiplication.setEnabled(true);
		division.setEnabled(true);
		buttonDot.setEnabled(true);
		buttonEquals.setEnabled(true);
		modulus.setEnabled(true);
}
	public void disable() {   //Disable method which disables the buttons
		textField.setEnabled(false);
		radioButtonOff.setEnabled(true);
		button0.setEnabled(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
		buttonBackspace.setEnabled(false);
		buttonClear.setEnabled(false);
		button00.setEnabled(false);
		addition.setEnabled(false);
		subtraction.setEnabled(false);
		multiplication.setEnabled(false);
		division.setEnabled(false);
		buttonDot.setEnabled(false);
		buttonEquals.setEnabled(false);
		modulus.setEnabled(false);
	}
	private void clearAnswer() {  //Clears the result after the operation has completed when we want to perform new operation
		if (showingAnswer) {
			textField.setText("");
			showingAnswer = false;	
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCalculator = new JFrame(); //Create instance of JFrame               
		frmCalculator.setResizable(false);  // Prevent the user from resizing it      
		frmCalculator.setTitle("Calculator"); //Set the title to the frame  
		frmCalculator.setBounds(100, 100, 299, 312); //x axis,y axis,width,height  
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close the operation 
		frmCalculator.getContentPane().setLayout(null); //using no Layout managers      
		
		textField = new JTextField();  //Create instance of Text Field      
		textField.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set the font  
		textField.setBounds(10, 11, 264, 30);//x axis, y axis, width, height  
		frmCalculator.getContentPane().add(textField);//Add text field to the frame 
		textField.setColumns(10);  //Set the columns 
		showingAnswer = false;
		
		radioButtonOn = new JRadioButton("on"); 
		radioButtonOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable();
			}
		});
		buttonGroup.add(radioButtonOn);
		radioButtonOn.setBounds(6, 48, 63, 23);
		frmCalculator.getContentPane().add(radioButtonOn);
		
		radioButtonOff = new JRadioButton("off");
		radioButtonOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disable();
			}
		});
		buttonGroup.add(radioButtonOff);
		radioButtonOff.setBounds(81, 48, 83, 23);
		frmCalculator.getContentPane().add(radioButtonOff);
		 
		buttonBackspace = new JButton("<-"); //Creating instance of JButton   
		buttonBackspace.addActionListener(new ActionListener() {   //Registering the component with the Listener
			//Overriding the actionPerformed method
			public void actionPerformed(ActionEvent e) {  //Overriding the actionPerformed method
				
				//Clear the number one by one when we click this button
				String backspace = " ";
				if (textField.getText().length() > 0) {
					StringBuilder string = new StringBuilder(textField.getText());//getting the text
					string.deleteCharAt(textField.getText().length()-1);
					backspace = string.toString();
					textField.setText(backspace);
				}
			}
		});
		buttonBackspace.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonBackspace.setBounds(10, 78, 59, 30);
		frmCalculator.getContentPane().add(buttonBackspace);
		
		button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button7.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button7.setFont(new Font("Tahoma", Font.BOLD, 18));
		button7.setBounds(10, 116, 59, 30);
		frmCalculator.getContentPane().add(button7);
		
		button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button8.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button8.setFont(new Font("Tahoma", Font.BOLD, 18));
		button8.setBounds(80, 116, 59, 30);
		frmCalculator.getContentPane().add(button8);
		
		buttonClear = new JButton("C");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");  //set the empty string to textField	 
			}
		});
		buttonClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonClear.setBounds(81, 78, 58, 30);
		frmCalculator.getContentPane().add(buttonClear);
		
		button00 = new JButton("00");
		button00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button00.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button00.setFont(new Font("Tahoma", Font.BOLD, 18));
		button00.setBounds(152, 78, 56, 30);
		frmCalculator.getContentPane().add(button00);
		
		button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button9.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button9.setFont(new Font("Tahoma", Font.BOLD, 18));
		button9.setBounds(152, 116, 56, 30);
		frmCalculator.getContentPane().add(button9);
		
		addition = new JButton("+");
		addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber=Double.parseDouble(textField.getText()); //get the first number on the frame
				textField.setText(""); //set the text on the frame
				operation="+";
				
			}
		});
		addition.setFont(new Font("Tahoma", Font.BOLD, 18));
		addition.setBounds(218, 75, 56, 30);
		frmCalculator.getContentPane().add(addition);
		
		subtraction = new JButton("-");
		subtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber=Double.parseDouble(textField.getText()); //get the first number on the frame
				textField.setText("");  //set the first number on the frame
				operation="-";		
			}
		});
		subtraction.setFont(new Font("Tahoma", Font.BOLD, 18));
		subtraction.setBounds(218, 116, 56, 30);
		frmCalculator.getContentPane().add(subtraction);
		
		button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button4.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button4.setFont(new Font("Tahoma", Font.BOLD, 18));
		button4.setBounds(10, 156, 59, 30);
		frmCalculator.getContentPane().add(button4);
		
		button1 = new JButton("1");
		button1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button1.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button1.setBounds(10, 198, 59, 30);
		frmCalculator.getContentPane().add(button1);
		
		button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button0.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button0.setFont(new Font("Tahoma", Font.BOLD, 18));
		button0.setBounds(10, 239, 59, 30);
		frmCalculator.getContentPane().add(button0);
		
		button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button5.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button5.setFont(new Font("Tahoma", Font.BOLD, 18));
		button5.setBounds(81, 157, 59, 30);
		frmCalculator.getContentPane().add(button5);
		
		button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button2.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 18));
		button2.setBounds(80, 198, 59, 30);
		frmCalculator.getContentPane().add(button2);
		
		buttonDot = new JButton(".");
		buttonDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+buttonDot.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		buttonDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonDot.setBounds(80, 239, 59, 30);
		frmCalculator.getContentPane().add(buttonDot);
		
		button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button6.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button6.setFont(new Font("Tahoma", Font.BOLD, 18));
		button6.setBounds(152, 156, 56, 30);
		frmCalculator.getContentPane().add(button6);
		
		button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAnswer();  //Invoking clearAnswer method	      
				String number=textField.getText()+button3.getText(); //get the text
				textField.setText(number); //set the text
			}
		});
		button3.setFont(new Font("Tahoma", Font.BOLD, 18));
		button3.setBounds(152, 198, 56, 30);
		frmCalculator.getContentPane().add(button3);
		
		buttonEquals = new JButton("=");
		buttonEquals.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer = null;
				DecimalFormat format = new DecimalFormat("0.########");// It formats the decimal number
				
				secondNumber=Double.parseDouble(textField.getText());
				
				//Addition
				if(operation=="+") {
					result=firstNumber+secondNumber;
					answer=String.format(format.format(result));
					textField.setText(answer);	
				}
				//Subtraction
				else if(operation=="-") {
					result=firstNumber-secondNumber;
					answer=String.format(format.format(result));
					textField.setText(answer);
					
				}
				//Multiplication
				else if(operation=="*") {
					result=firstNumber*secondNumber;
					answer=String.format(format.format(result));
					textField.setText(answer);	
				}
				//Division
				else if(operation=="/") {
					result=firstNumber/secondNumber;
					if (Double.isInfinite(result)) {
						JOptionPane.showMessageDialog(textField, "Not divisible by zero"+"," +"Please try entering the other number" );//Giving the pop up when divisible by zero
						}
					else {
					answer=String.format(format.format(result));
					textField.setText(answer);
				}
				}
				
				//Modulus
				else if(operation=="%") {
					result=firstNumber%secondNumber;
					answer=String.format(format.format(result));
					textField.setText(answer);	
				}
				showingAnswer = true;
			}
			
		});
		buttonEquals.setBounds(152, 239, 56, 30);
		frmCalculator.getContentPane().add(buttonEquals);
		
		multiplication = new JButton("*");
		multiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber=Double.parseDouble(textField.getText()); //get the first number on the frame
				textField.setText("");  //set the first number on the frame
				operation="*";		
			}
		});
		multiplication.setFont(new Font("Tahoma", Font.BOLD, 18));
		multiplication.setBounds(218, 156, 56, 30);
		frmCalculator.getContentPane().add(multiplication);
		
		division = new JButton("/");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber=Double.parseDouble(textField.getText()); //get the first number on the frame
				textField.setText("");  //set the first number on the frame
				operation="/";		
			}
		});
		division.setFont(new Font("Tahoma", Font.BOLD, 18));
		division.setBounds(218, 198, 56, 30);
		frmCalculator.getContentPane().add(division);
		
		modulus = new JButton("%");
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber=Double.parseDouble(textField.getText()); //get the first number on the frame
				textField.setText("");  //set the first number on the frame
				operation="%";		
			}
		});
		modulus.setFont(new Font("Tahoma", Font.BOLD, 18));
		modulus.setBounds(218, 236, 56, 30);
		frmCalculator.getContentPane().add(modulus);
	}
}
