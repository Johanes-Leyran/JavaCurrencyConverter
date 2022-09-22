import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConverterPanel extends JPanel implements ActionListener{
    final int WIDTH = 500;
    final int HEIGHT = 400;
    final int X_POS = 40;

    ConverterHandler panel;
    Font myFont;
    JButton convert;
    JLabel text1;
    JLabel currency1Label;
    JLabel currency2Label;
    JLabel amountLabel;
    JTextField amount;
    JTextField currency1;
    JTextField currency2;
    
    ConverterPanel(){
        // setting the layout to null so we can freely move the buttons, texts, and etc
        this.setLayout(null);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel = new ConverterHandler();
        this.add(panel);
        myFont = new Font("SansSerif", Font.BOLD, 10);

        text1 = new JLabel("Converting Currency based on google search");
        this.add(text1);

        currency1 = new JTextField();
        this.add(currency1);
        currency1Label = new JLabel("Put a currency to be converted");
        currency1Label.setFont(myFont);
        this.add(currency1Label);

        currency2 = new JTextField();
        this.add(currency2);
        currency2Label = new JLabel("Put a currency you want");
        currency2Label.setFont(myFont);
        this.add(currency2Label);

        amount = new JTextField();
        this.add(amount);
        amountLabel = new JLabel("Amount of the currency");
        amountLabel.setFont(myFont);
        this.add(amountLabel);
        convert = new JButton("Convert");
        convert.addActionListener(this);
        this.add(convert);

        text1.setBounds(110, -25, 300, 100);
        currency1.setBounds(X_POS, 80, 100, 30);
        currency1Label.setBounds(X_POS, 20 , 300, 100);
        currency2.setBounds(X_POS, 130, 100, 30);
        currency2Label.setBounds(X_POS, 70 , 300, 100);
        amount.setBounds(X_POS, 180, 110, 30);
        amountLabel.setBounds(X_POS, 155, 300, 30); 
        convert.setBounds(X_POS, 265, 100, 40);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == convert){
            try{
                //this checks if the input is a number
                Integer.parseInt(amount.getText());
                panel.showResult(currency1.getText(), currency2.getText(), amount.getText());
                amount.setText("");
                currency1.setText("");
                currency2.setText("");   
            } catch(NumberFormatException ex) {
                amount.setText("Must be a number!");
            }  
        }
    }
}
