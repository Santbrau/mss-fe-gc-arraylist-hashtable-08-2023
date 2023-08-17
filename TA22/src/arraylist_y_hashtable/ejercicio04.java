package arraylist_y_hashtable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ejercicio04 {

    private Map<String, Double> stock = new HashMap<>();
    private Map<String, Integer> cart = new HashMap<>();
    private JFrame frame;

    public ejercicio04() {
        frame = new JFrame("Gestión de Ventas y Stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel stockPanel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nombre del artículo:");
        JTextField nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField(10);
        JLabel stockLabel = new JLabel("Cantidad en Stock:");
        JTextField stockField = new JTextField(10);

        JButton addButton = new JButton("Agregar Stock");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stockQuantity = Integer.parseInt(stockField.getText());

                stock.put(name, price);
                cart.put(name, stockQuantity);

                nameField.setText("");
                priceField.setText("");
                stockField.setText("");
                System.out.println("Artículo agregado al stock: " + name);
            }
        });

        stockPanel.add(nameLabel);
        stockPanel.add(nameField);
        stockPanel.add(priceLabel);
        stockPanel.add(priceField);
        stockPanel.add(stockLabel);
        stockPanel.add(stockField);
        stockPanel.add(addButton);

        JPanel salesPanel = new JPanel(new GridLayout(3, 2));

        JLabel salesItemLabel = new JLabel("Artículo a vender:");
        JTextField salesItemField = new JTextField(15);
        JLabel quantityLabel = new JLabel("Cantidad:");
        JTextField quantityField = new JTextField(10);

        JButton sellButton = new JButton("Vender");
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = salesItemField.getText();
                int quantity = Integer.parseInt(quantityField.getText());

                if (stock.containsKey(name) && stock.get(name) > 0) {
                    if (cart.containsKey(name) && cart.get(name) >= quantity) {
                        cart.put(name, cart.get(name) - quantity);
                        stock.put(name, stock.get(name) - quantity);
                        System.out.println("Venta realizada: " + name + ", Cantidad: " + quantity);
                    } else {
                        System.out.println("No hay suficiente cantidad en el carrito.");
                    }
                } else {
                    System.out.println("El artículo no existe en el stock.");
                }

                salesItemField.setText("");
                quantityField.setText("");
            }
        });

        JButton listStockButton = new JButton("Listar Stock");
        listStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarStock();
            }
        });

        stockPanel.add(listStockButton);

        salesPanel.add(salesItemLabel);
        salesPanel.add(salesItemField);
        salesPanel.add(quantityLabel);
        salesPanel.add(quantityField);
        salesPanel.add(sellButton);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(stockPanel);
        mainPanel.add(salesPanel);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void listarStock() {
        System.out.println("Lista de artículos en stock:");
        for (Map.Entry<String, Double> entry : stock.entrySet()) {
            System.out.println("Artículo: " + entry.getKey() + ", Precio: " + entry.getValue() +
                               ", Cantidad en Stock: " + cart.getOrDefault(entry.getKey(), 0));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ejercicio04();
            }
        });
    }
}
