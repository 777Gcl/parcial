package ui.custom.grid.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modelproduct.Product;



public class ProductTableModel extends AbstractTableModel {
    private List<Product> products;
    private List<Product> productList;
    private String[] columns = {"Nombre", "Descripción", "Tipo", "Precio"};

    public ProductTableModel(List<Product> products) {
        this.products = products != null ? products : new ArrayList<>();
    }
    /*
    public ProductTableModel(List<Product> productList) {
        this.productList = productList;
    }*/

    public void setProducts(List<Product> products) {
        this.products = products;
        fireTableDataChanged();
    }

    public List<Product> getProducts() {
        return products;
    }

    // Método personalizado para agregar una fila (producto)
    public void addProduct(Product product) {
        products.add(product);
        fireTableRowsInserted(products.size() - 1, products.size() - 1);
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getNombre();
            case 1:
                return product.getDescripcion();
            case 2:
                return product.getTipo();
            case 3:
                return product.getPrecio();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
