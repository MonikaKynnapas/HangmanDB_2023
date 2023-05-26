package controllers;

import models.Database;
import models.Model;
import views.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerAdd implements ActionListener {
    private Model model;
    private View view;
    public ButtonListenerAdd(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Clicked Add");
        // New word from form
        String newWord = view.getTxtWord().getText().trim();
        // Selected category
        String category = view.getCmbCategory().getSelectedItem().toString();
        // Selected category index
        int categoryIndex = view.getCmbCategory().getSelectedIndex();
        // New category
        String newCategory = view.getTxtNewCategory().getText().trim();
        if (!newWord.isEmpty() && categoryIndex == 0 && !newCategory.isEmpty()) {
            // New Word, New Category
            new Database(model.getDatabaseFile(), model).insert(newWord, newCategory);
        } else if (!newWord.isEmpty() && categoryIndex > 0 && newCategory.isEmpty()) {
            // New Word, Old Category
            new Database(model.getDatabaseFile(), model).insert(newWord, category);
        } else {
            JOptionPane.showMessageDialog(view, "Something is missing or wrong", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        clearForm();
        view.updateComboBox();
        view.getLblWordTotal().setText("Total: " + model.getDatabaseData().size());
        view.getLblCategoryTotal().setText("Toal: " + (model.getCmbNames().length-1));
        view.updateTable(); // Update table in form
    }

    private void clearForm() {
        view.getTxtWord().setText(""); // clear new word
        view.getTxtNewCategory().setText(""); // clear new category
        view.getCmbCategory().setSelectedIndex(0); // Set combobox to first
    }
}
