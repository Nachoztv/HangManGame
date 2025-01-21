/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author nacho
 */
public class GUIKeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        String word = "";
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introduce palabra:");
        JPasswordField passwordField = new JPasswordField(10);
        panel.add(label);
        panel.add(passwordField);
        passwordField.setEchoChar('*');

        String[] options = new String[]{"Ok", "Cancel"};

        int option = JOptionPane.showOptionDialog(null, panel, "Ingresa la Palabra",
                JOptionPane.NO_OPTION, 1,
                null, options, options[0]);
        if (option == 0) {
            word = new String(passwordField.getPassword());
            if (!isValid(word) || word.isBlank()) {
                JOptionPane.showMessageDialog(null, "La palabra solo puede contener letras minúsculas de a a la z!", "Palabra Incorrecta", 1);
            }
        } else {
            throw new GenerateWordException(false, "sdfds");
        }
        return word;
    }

    private boolean isValid(String word) {
        Pattern pattern = Pattern.compile("^[a-z]*$");
        Matcher matcher = pattern.matcher(word);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

}
