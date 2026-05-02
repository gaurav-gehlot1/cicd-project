package com.example.java.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingComponentsDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Components Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new FlowLayout());

        // JLabel
        JLabel label = new JLabel("Enter your name:");
        frame.add(label);

        // JTextField
        JTextField textField = new JTextField(20);
        frame.add(textField);

        // JPasswordField
        JLabel passLabel = new JLabel("Enter password:");
        frame.add(passLabel);
        JPasswordField passwordField = new JPasswordField(20);
        frame.add(passwordField);

        // JButton
        JButton button = new JButton("Submit");
        frame.add(button);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Subscribe to newsletter");
        frame.add(checkBox);

        // JRadioButton
        JLabel genderLabel = new JLabel("Select Gender:");
        frame.add(genderLabel);
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(male);
        frame.add(female);

        // JComboBox
        JLabel countryLabel = new JLabel("Select Country:");
        frame.add(countryLabel);
        String[] countries = {"USA", "India", "UK", "Canada", "Australia"};
        JComboBox<String> comboBox = new JComboBox<>(countries);
        frame.add(comboBox);

        // JTextArea
        JLabel addressLabel = new JLabel("Address:");
        frame.add(addressLabel);
        JTextArea textArea = new JTextArea(5, 30);
        frame.add(new JScrollPane(textArea));

        // JTable
        JLabel tableLabel = new JLabel("Sample Data:");
        frame.add(tableLabel);
        String[] columns = {"ID", "Name", "Score"};
        String[][] data = {
            {"1", "Alice", "85"},
            {"2", "Bob", "90"},
            {"3", "Charlie", "78"}
        };
        JTable table = new JTable(new DefaultTableModel(data, columns));
        frame.add(new JScrollPane(table));

        frame.setVisible(true);
    }
}

