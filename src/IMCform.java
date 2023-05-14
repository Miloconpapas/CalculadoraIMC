import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IMCform {
    private JPanel imcPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calcularButton;
    private JTextField textFieldResultado;
    private JTextField textField4;
    private JButton borrarButton;


    public IMCform() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a,b;
                a=textField1.getText();
                b=textField2.getText();
                if(a.equals("") || b.equals("")){
                    JOptionPane.showMessageDialog(null,"El campo no puede estar vacio.");
                }
                double c,d;
                c=Double.parseDouble(a);
                d=Double.parseDouble(b);
                double f;
                f=(d/(c*c));

                 String g;
                g=String.valueOf(f);
                textFieldResultado.setText(g);

                if (f < 18.5) {
                    textField4.setText(/*g + */"Peso bajo");
                } else if (f >= 18.5 && f <= 24.9) {
                    textField4.setText(/*g +*/"Peso normal u óptimo");
                } else if (f >= 25 && f <= 29.9) {
                    textField4.setText(/*g +*/"Sobrepeso");
                } else {
                    textField4.setText(/*g + */"Obesidad");
                }

            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textFieldResultado.setText("");
                textField4.setText("");
            }
        });
       textField1.addActionListener(new ActionListener() { //al apretar enter pasa al siguente text field
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.requestFocusInWindow();
            }
        });


        textField2.addActionListener(new ActionListener() { //al apretar enter otra vez hace el calculo.
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularButton.doClick();
            }
        });
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Calcualdora IMC");
        frame.setContentPane(new IMCform().imcPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
