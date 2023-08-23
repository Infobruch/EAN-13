import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EANCodeTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("EANCode Tester");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Geben Sie den EAN-13-Code ein:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Überprüfen");
        JLabel resultLabel = new JLabel("");
        JLabel correctLabel = new JLabel("");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = textField.getText();
                if (EANCode.istKorrekt(code)) {
                    resultLabel.setText("Der EAN-13-Code ist korrekt.");
                    correctLabel.setText("");
                } else {
                    resultLabel.setText("Der EAN-13-Code ist nicht korrekt.");
                    int[] feld = new int[12];
                    for (int i = 0; i < 12; i++) {
                        feld[i] = code.charAt(i) - 48;
                    }
                    int correctDigit = EANCode.berechnePruefziffer(feld);
                    correctLabel.setText("Die richtige Prüfziffer sollte " + correctDigit + " sein.");
                }
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(resultLabel);
        frame.add(correctLabel);

        frame.setVisible(true);
    }
}
