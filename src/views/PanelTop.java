package views;

import models.Model;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JPanel {
    private final Model model;
    private final JPanel pnlComponents = new JPanel(new GridBagLayout());
    private final GridBagConstraints gbc = new GridBagConstraints();
    private JLabel lblWordTotal, lblCategoryTotal;
    private JTextField txtWord, txtNewCategory;
    private JButton btnAdd, btnEdit, btnUpdate;
    private JComboBox<String> cmbCategory;

    public PanelTop(Model model) {
        this.model = model;
        setupPanel(); // Setup PanelTop
        setupConstraints(); // global settings for cell
        setupLineFirst(); // First line on pnlComponents
        setupLineSecond(); // Second line on pnlComponents
        setupLineThird(); // Third line on pnlComponents
        setupLineFourth(); // Fourth line on pnlComponents

        this.add(pnlComponents); // add pnlComponents on Panel top
    }
    private void setupPanel() {
        this.setBackground(new Color(250, 245, 215));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    private void setupConstraints() {
        gbc.anchor = GridBagConstraints.WEST; // Cell contents align left
        gbc.insets = new Insets(2,2,2,2); // All around 2px space
        gbc.fill = GridBagConstraints.BOTH; // Stretches the contents a sell to a width
    }

    private void setupLineFirst() {
        JLabel lblWord = new JLabel("Word");
        gbc.gridx = 0; // Column
        gbc.gridy = 0; // Row
        pnlComponents.add(lblWord, gbc); // on pnlComponents lblWord and settings

        txtWord = new JTextField("", 14);
        gbc.gridx = 1; // Column
        gbc.gridy = 0; // Row
        pnlComponents.add(txtWord, gbc); // on pnlComponents txtWord and settings

        lblWordTotal = new JLabel("Total: " + model.getDatabaseData().size());
        gbc.gridx = 2; // Column
        gbc.gridy = 0; // Row
        pnlComponents.add(lblWordTotal, gbc);// on pnlComponents lblWordTotal and settings
    }
    private void setupLineSecond() {
        JLabel lblCategory = new JLabel("Category");
        gbc.gridx = 0; // Column
        gbc.gridy = 1; // Row
        pnlComponents.add(lblCategory, gbc); // on pnlComponents lblCategory and settings

        cmbCategory = new JComboBox<>(model.getCmbNames()); // not empty combobox
        gbc.gridx = 1; // Column
        gbc.gridy = 1; // Row
        pnlComponents.add(cmbCategory, gbc); // on pnlComponents cmbCategory and settings

        lblCategoryTotal = new JLabel("Total: " + (model.getCmbNames().length-1));
        gbc.gridx = 2; // Column
        gbc.gridy = 1; // Row
        pnlComponents.add(lblCategoryTotal, gbc); // on pnlComponents cmbCategory and settings
    }

    private void setupLineThird() {
        JLabel lblNewCategory = new JLabel("New category");
        gbc.gridx = 0; // Column
        gbc.gridy = 2; // Row
        pnlComponents.add(lblNewCategory, gbc);

        txtNewCategory = new JTextField("", 14);
        gbc.gridx = 1; // Column
        gbc.gridy = 2; // Row
        pnlComponents.add(txtNewCategory, gbc);
    }
    private void setupLineFourth() {
        btnEdit = new JButton("Edit record");
        btnEdit.setEnabled(false);
        gbc.gridx = 0; // Column
        gbc.gridy = 3; // Row
        pnlComponents.add(btnEdit, gbc);

        btnAdd = new JButton("Add new word");
        gbc.gridx = 1; // Column
        gbc.gridy = 3; // Row
        pnlComponents.add(btnAdd, gbc);

        btnUpdate = new JButton("Update record");
        btnUpdate.setEnabled(false);
        gbc.gridx = 2; // Column
        gbc.gridy = 3; // Row
        pnlComponents.add(btnUpdate, gbc);
    }

    public JLabel getLblWordTotal() {
        return lblWordTotal;
    }

    public JLabel getLblCategoryTotal() {
        return lblCategoryTotal;
    }

    public JTextField getTxtWord() {
        return txtWord;
    }

    public JTextField getTxtNewCategory() {
        return txtNewCategory;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JComboBox<String> getCmbCategory() {
        return cmbCategory;
    }
}
