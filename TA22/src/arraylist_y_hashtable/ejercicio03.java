package arraylist_y_hashtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ejercicio03 {

	private Map<String, Double> stock = new HashMap<>();
    private JFrame frame;

    public ejercicio03() {
        frame = new JFrame("Gestión de Stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nombre del artículo:");
        JTextField nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Cantidad:");
        JTextField quantityField = new JTextField(10);

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                
                if (stock.containsKey(name)) {
                    double existingPrice = stock.get(name);
                    stock.put(name, existingPrice + (price * quantity));
                } else {
                    stock.put(name, price * quantity);
                }
                
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                System.out.println("Artículo agregado: " + name);
            }
        });

        JButton listButton = new JButton("Listar Stock");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarInformacion();
            }
        });

        JButton queryButton = new JButton("Consultar");
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queryItem = JOptionPane.showInputDialog(frame, "Nombre del artículo a consultar:");
                if (stock.containsKey(queryItem)) {
                    JOptionPane.showMessageDialog(frame, "Artículo: " + queryItem + "\nCantidad: " + stock.get(queryItem));
                } else {
                    JOptionPane.showMessageDialog(frame, "El artículo no existe en el stock.");
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(addButton);
        panel.add(listButton);
        panel.add(queryButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void listarInformacion() {
        System.out.println("Lista de artículos en stock:");
        for (Map.Entry<String, Double> entry : stock.entrySet()) {
            System.out.println("Artículo: " + entry.getKey() + ", Precio Total: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ejercicio03();
            }
        });
    }
}