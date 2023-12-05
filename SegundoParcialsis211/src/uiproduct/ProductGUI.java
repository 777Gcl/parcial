package uiproduct;
import modelproduct.Product;

import ui.custom.grid.GridTable;
import ui.custom.grid.table.ProductTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductGUI {
    private JFrame frame;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField tipoField;
    private JTextField precioField;
    private ProductTableModel productTableModel;
    private GridTable gridTable;
    private List<Product> productList;

    public ProductGUI(ProductTableModel productTableModel, GridTable gridTable, List<Product> productList) {
        this.productTableModel = productTableModel;
        this.gridTable = gridTable;
        this.productList = productList;

        frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nombreField = new JTextField();
        descripcionField = new JTextField();
        tipoField = new JTextField();
        precioField = new JTextField();

        JButton addProductButton = new JButton("Agregar Producto");
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Descripci�n:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Tipo:"));
        panel.add(tipoField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(addProductButton);
        panel.add(new JScrollPane(gridTable));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addProduct() {
        String nombre = nombreField.getText();
        String descripcion = descripcionField.getText();
        String tipo = tipoField.getText();
        double precio = Double.parseDouble(precioField.getText());

        Product product = new Product(nombre, descripcion, tipo, precio);

        productList.add(product);
        productTableModel.addProduct(product);

        saveProductsToFile(); 
    }

    private void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                List<Product> productList = new ArrayList<>();
                ProductTableModel productTableModel = new ProductTableModel(productList);

                GridTable gridTable = new GridTable(productTableModel);
                new ProductGUI(productTableModel, gridTable, productList);
            }
        });
    }
}





