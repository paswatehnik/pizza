import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;

public class picerijaa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                picerijaa frame = new picerijaa();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public picerijaa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // Panel1
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(new Color(255, 228, 181));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 181));
        JButton orderButton = new JButton("Pasūtīt picas");
        orderButton.setFont(new Font("Arial", Font.PLAIN, 18));
        orderButton.setBackground(new Color(60, 179, 113));
        orderButton.setForeground(Color.WHITE);
        orderButton.addActionListener(e -> cardLayout.show(contentPane, "Panel2"));
        buttonPanel.add(orderButton);
        JButton exitButton = new JButton("Iziet");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBackground(new Color(220, 20, 60));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);
        panel1.add(buttonPanel, BorderLayout.CENTER);
        JLabel titleLabel = new JLabel("Welcome to Pizza Shop!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(139, 69, 19));
        panel1.add(titleLabel, BorderLayout.NORTH);

        // Panel2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(233, 200, 167));
        panel2.setLayout(null);
        JLabel nameLabel = new JLabel("Ievadiet jusu vardu:", SwingConstants.CENTER);
        nameLabel.setBounds(23, 134, 186, 22);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel2.add(nameLabel);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(194, 134, 208, 22);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel2.add(nameField);
        JButton confirmButton = new JButton("Apstiprināt");
        confirmButton.setBounds(194, 180, 208, 31);
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmButton.setBackground(new Color(60, 179, 113));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(e -> {
            String vards = nameField.getText().trim();
            if (!vards.isEmpty()) {
                cardLayout.show(contentPane, "Panel3");
            } else {
                JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet savu vārdu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel2.add(confirmButton);
        JButton backButton = new JButton("Atpakal");
        backButton.setBounds(603, 526, 173, 31);
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(e -> cardLayout.show(contentPane, "Panel1"));
        panel2.add(backButton);
        

     // Panel3
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(new Color(200, 233, 167));
        JLabel pizzaLabel = new JLabel("Izvēlieties picu:", SwingConstants.CENTER);
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pizzaLabel.setForeground(new Color(139, 69, 19));
        panel3.add(pizzaLabel, BorderLayout.NORTH);

        List<pica> pizzas = pica.getPizzas();
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        List<JSpinner> quantitySpinners = new ArrayList<>();

        for (pica pizza : pizzas) {
            JPanel pizzaPanel = new JPanel(new BorderLayout(10, 10));
            pizzaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pizzaPanel.setBackground(new Color(255, 255, 255, 200));
            
            ImageIcon icon = new ImageIcon(pizza.picture);
            Image scaledImg = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            JLabel imageLabel = new JLabel(scaledIcon);
            pizzaPanel.add(imageLabel, BorderLayout.WEST);
            
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(new Color(255, 255, 255, 0));
            
            JLabel pizzaNameLabel = new JLabel(pizza.nosaukums.toString());
            pizzaNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            infoPanel.add(pizzaNameLabel);
            
            JPanel sizeQuantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            sizeQuantityPanel.setBackground(new Color(255, 255, 255, 0));
            
            JComboBox<String> sizeCombo = new JComboBox<>();
            for (int i = 0; i < pizza.izmers.size(); i++) {
                sizeCombo.addItem(pizza.izmers.get(i) + " - €" + pizza.cenas.get(i));
            }
            sizeQuantityPanel.add(new JLabel("Izmērs:"));
            sizeQuantityPanel.add(sizeCombo);
            
            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 10, 1); 
            JSpinner quantitySpinner = new JSpinner(spinnerModel);
            quantitySpinner.setPreferredSize(new Dimension(50, 20));
            sizeQuantityPanel.add(new JLabel("Daudzums:"));
            sizeQuantityPanel.add(quantitySpinner);
            quantitySpinners.add(quantitySpinner);
            
            infoPanel.add(sizeQuantityPanel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            
            JTextArea ingredients = new JTextArea("Sastāvdaļas: " + pizza.recepts.toString());
            ingredients.setFont(new Font("Arial", Font.PLAIN, 14));
            ingredients.setEditable(false);
            ingredients.setLineWrap(true);
            ingredients.setWrapStyleWord(true);
            ingredients.setBackground(new Color(255, 255, 255, 0));
            infoPanel.add(ingredients);
            
            pizzaPanel.add(infoPanel, BorderLayout.CENTER);
            
            optionsPanel.add(pizzaPanel);
            optionsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(optionsPanel);
        panel3.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton confirmPizzaButton = new JButton("Apstiprināt izvēli");
        confirmPizzaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPizzaButton.setBackground(new Color(60, 179, 113));
        confirmPizzaButton.setForeground(Color.WHITE);
        confirmPizzaButton.addActionListener(e -> {
            StringBuilder orderDetails = new StringBuilder();
            double totalPrice = 0.0;
            int totalPizzas = 0;
            
            for (int i = 0; i < pizzas.size(); i++) {
                int quantity = (Integer) quantitySpinners.get(i).getValue();
                if (quantity > 0) {
                    pica pizza = pizzas.get(i);
                    String size = pizza.izmers.get(0);
                    double price = pizza.cenas.get(0) * quantity;
                    
                    orderDetails.append(pizza.nosaukums).append(" (").append(size).append(") x").append(quantity).append(" - €").append(String.format("%.2f", price)).append("\n");
                    totalPrice += price;
                    totalPizzas += quantity;
                }
            }
            
            if (totalPizzas == 0) {
                JOptionPane.showMessageDialog(picerijaa.this, 
                    "Lūdzu, izvēlieties vismaz vienu picu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            orderDetails.append("\nKopējā summa: €").append(String.format("%.2f", totalPrice));
            
            JOptionPane.showMessageDialog(picerijaa.this,
                orderDetails.toString(), 
                "Jūsu pasūtījums", JOptionPane.INFORMATION_MESSAGE);
        });

        bottomPanel.add(confirmPizzaButton);

        JButton backButton3 = new JButton("Atpakal");
        backButton3.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton3.addActionListener(e -> cardLayout.show(contentPane, "Panel2"));
        bottomPanel.add(backButton3);

        panel3.add(bottomPanel, BorderLayout.SOUTH);
      
        contentPane.add(panel1, "Panel1");
        contentPane.add(panel2, "Panel2");
        contentPane.add(panel3, "Panel3");
    }
}