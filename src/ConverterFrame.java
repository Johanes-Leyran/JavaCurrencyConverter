import javax.swing.*;

public class ConverterFrame extends JFrame{
    ConverterFrame(){
        this.add(new ConverterPanel());
        this.setTitle("Converter");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
