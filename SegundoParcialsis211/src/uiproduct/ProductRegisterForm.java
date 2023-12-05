package uiproduct;

import ui.custom.grid.GridTable;
import ui.custom.grid.table.ProductTableModel;
import modelproduct.Product;
import ui.custom.events.*;
import javax.swing.*;
import utils.*;
import custom.ButtonComponent;
import modelproduct.*;
import uiproduct.ProductGUI;
import custom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import custom.PanelBox;

public class ProductRegisterForm extends JFrame {
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField typeField;
    private JTextField priceField;
    private ProductTableModel productTableModel;
    private GridTable gridTable;
    private List<Product> productList;

    public ProductRegisterForm(ProductTableModel productTableModel, GridTable gridTable, List<Product> productList) {
        this.productTableModel = productTableModel;
        this.gridTable = gridTable;
        this.productList = productList;

        setTitle("Register Product");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(350, 400));
        panel.setLayout(null);

        nameField = new JTextFieldComponent("Product Name", panel);
        ;
        nameField.setSize(new Dimension(260, 40));
      
        panel.add(nameField);

        descriptionField = new TextFieldComponent("Product Description", panel);
       
        descriptionField.setSize(new Dimension(260, 40));
       
        panel.add(descriptionField);

        typeField = new TextFieldComponent("Product Type", panel);
        ;
        typeField.setSize(new Dimension(260, 40));
        
        panel.add(typeField);

        priceField = new TextFieldComponent("Product Price", panel);
        
        priceField.setSize(new Dimension(260, 40));
       
        panel.add(priceField);

        ButtonComponent registerButton = new ButtonComponent("Register Product", panel);
        registerButton.setPosition(200);
        registerButton.setSize(new Dimension(260, 40));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct();
            }
        });
        panel.add(registerButton);

        add(panel);
    }

    private void registerProduct() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        String type = typeField.getText();
        double price = Double.parseDouble(priceField.getText());

        Product product = new Product(name, description, type, price);

        productList.add(product);
        productTableModel.addProduct(product);

        
        saveProductsToFile();

       
        clearFields();
    }

    private void saveProductsToFile() {
        
    }

    private void clearFields() {
        nameField.setText("");
        descriptionField.setText("");
        typeField.setText("");
        priceField.setText("");
    }

    public void showWindow() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void hideWindow() {
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Product> productList = new ArrayList<>();
            ProductTableModel productTableModel = new ProductTableModel(productList);

            GridTable gridTable = new GridTable(productTableModel);
            new ProductRegisterForm(productTableModel, gridTable, productList).showWindow();
        });
    }
}