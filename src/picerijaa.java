import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class picerijaa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private String pircejaVards;

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
        setTitle("Picerija");

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // Panel1
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(new Color(255, 228, 181));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 181));
        JButton orderButton = new JButton("Pasūtīt picas");
        orderButton.setBounds(351, 134, 197, 65);
        orderButton.setFont(new Font("Arial", Font.PLAIN, 29));
        orderButton.setBackground(new Color(60, 179, 113));
        orderButton.setForeground(Color.WHITE);
        orderButton.addActionListener(e -> cardLayout.show(contentPane, "Panel2"));
        buttonPanel.setLayout(null);
        buttonPanel.add(orderButton);
        JButton exitButton = new JButton("Iziet");
        exitButton.setBounds(690, 570, 147, 41);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 21));
        exitButton.setBackground(new Color(220, 20, 60));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);
        panel1.add(buttonPanel, BorderLayout.CENTER);
        JLabel titleLabel = new JLabel("Welcome to Pizza Shop!", SwingConstants.CENTER);
        titleLabel.setBounds(10, 43, 886, 28);
        buttonPanel.add(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(139, 69, 19));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\белый\\Desktop\\pizza-testMet\\pictures\\mainLabel.png"));
        lblNewLabel.setBounds(569, 66, 288, 172);
        buttonPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\белый\\Desktop\\pizza-testMet\\pictures\\mainLabel2.png"));
        lblNewLabel_1.setBounds(588, 325, 219, 203);
        buttonPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\белый\\Desktop\\pizza-testMet\\pictures\\mainLabel3.png"));
        lblNewLabel_2.setBounds(-16, 134, 594, 523);
        buttonPanel.add(lblNewLabel_2);

        // Panel2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(233, 200, 167));
        panel2.setLayout(null);
        
        JLabel titleLabel_1 = new JLabel("Welcome to Pizza Shop!", SwingConstants.CENTER);
        titleLabel_1.setForeground(new Color(139, 69, 19));
        titleLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel_1.setBounds(0, 48, 886, 28);
        panel2.add(titleLabel_1);
        JLabel nameLabel = new JLabel("Ievadiet jusu vardu:", SwingConstants.CENTER);
        nameLabel.setBounds(10, 185, 186, 22);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel2.add(nameLabel);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(185, 185, 208, 22);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel2.add(nameField);
        JButton confirmButton = new JButton("Apstiprināt");
        confirmButton.setBounds(403, 181, 208, 31);
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmButton.setBackground(new Color(60, 179, 113));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(e -> {
            String vards = nameField.getText().trim();
            if (!vards.isEmpty()) {
                pircejaVards = vards;
                cardLayout.show(contentPane, "Panel3");
            } else {
                JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet savu vārdu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel2.add(confirmButton);
        JButton backButton = new JButton("Atpakal");
        backButton.setBounds(690, 570, 147, 41);
        backButton.setFont(new Font("Arial", Font.PLAIN, 21));
        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> System.exit(0));
        panel2.add(backButton);

        // Panel3 Pizza
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
            
            cardLayout.show(contentPane, "Panel4");
        });

        bottomPanel.add(confirmPizzaButton);

        JButton drinksButton = new JButton("Dzērieni");
        drinksButton.setFont(new Font("Arial", Font.PLAIN, 18));
        drinksButton.setBackground(new Color(100, 149, 237));
        drinksButton.setForeground(Color.WHITE);
        drinksButton.addActionListener(e -> cardLayout.show(contentPane, "Panel4"));
        bottomPanel.add(drinksButton);

        JButton backButton3 = new JButton("Atpakal");
        backButton3.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton3.addActionListener(e -> cardLayout.show(contentPane, "Panel2"));
        bottomPanel.add(backButton3);

        panel3.add(bottomPanel, BorderLayout.SOUTH);

        // Panel4 dzerieni
        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBackground(new Color(167, 200, 233));
        JLabel drinksLabel = new JLabel("Izvēlieties dzērienus (nav obligāti):", SwingConstants.CENTER);
        drinksLabel.setFont(new Font("Arial", Font.BOLD, 24));
        drinksLabel.setForeground(new Color(139, 69, 19));
        panel4.add(drinksLabel, BorderLayout.NORTH);

        List<dzerieni> drinks = dzerieni.getDrinks();
        JPanel drinksOptionsPanel = new JPanel();
        drinksOptionsPanel.setLayout(new BoxLayout(drinksOptionsPanel, BoxLayout.Y_AXIS));
        drinksOptionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        List<JSpinner> drinksQuantitySpinners = new ArrayList<>();

        for (dzerieni drink : drinks) {
            JPanel drinkPanel = new JPanel(new BorderLayout(10, 10));
            drinkPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            drinkPanel.setBackground(new Color(255, 255, 255, 200));
            
            ImageIcon icon = new ImageIcon(drink.picture);
            Image scaledImg = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            JLabel imageLabel = new JLabel(scaledIcon);
            drinkPanel.add(imageLabel, BorderLayout.WEST);
            
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(new Color(255, 255, 255, 0));
            
            JLabel drinkNameLabel = new JLabel(drink.nosaukums.get(0));
            drinkNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
            infoPanel.add(drinkNameLabel);
            
            JPanel priceQuantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            priceQuantityPanel.setBackground(new Color(255, 255, 255, 0));
            
            JLabel priceLabel = new JLabel("Cena: €" + drink.cena.get(0));
            priceQuantityPanel.add(priceLabel);
            
            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner quantitySpinner = new JSpinner(spinnerModel);
            quantitySpinner.setPreferredSize(new Dimension(50, 20));
            priceQuantityPanel.add(new JLabel("Daudzums:"));
            priceQuantityPanel.add(quantitySpinner);
            drinksQuantitySpinners.add(quantitySpinner);
            
            infoPanel.add(priceQuantityPanel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            
            JTextArea description = new JTextArea("Apraksts: " + drink.apraksts.get(0));
            description.setFont(new Font("Arial", Font.PLAIN, 14));
            description.setEditable(false);
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setBackground(new Color(255, 255, 255, 0));
            infoPanel.add(description);
            
            drinkPanel.add(infoPanel, BorderLayout.CENTER);
            
            drinksOptionsPanel.add(drinkPanel);
            drinksOptionsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane drinksScrollPane = new JScrollPane(drinksOptionsPanel);
        panel4.add(drinksScrollPane, BorderLayout.CENTER);

        JPanel drinksBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton confirmDrinksButton = new JButton("Noformet pasūtījumu");
        confirmDrinksButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmDrinksButton.setBackground(new Color(60, 179, 113));
        confirmDrinksButton.setForeground(Color.WHITE);
        confirmDrinksButton.addActionListener(e -> {
            StringBuilder orderDetails = new StringBuilder("Jūsu pasūtījums:\n\n");
            double totalPrice = 0.0;
            boolean irDzerieni = false;
            
            for (int i = 0; i < drinks.size(); i++) {
                int quantity = (Integer) drinksQuantitySpinners.get(i).getValue();
                if (quantity > 0) {
                	irDzerieni = true;
                    break;
                }
            }
            
            if (irDzerieni) {
                orderDetails.append("Dzērieni:\n");
                for (int i = 0; i < drinks.size(); i++) {
                    int quantity = (Integer) drinksQuantitySpinners.get(i).getValue();
                    if (quantity > 0) {
                        dzerieni drink = drinks.get(i);
                        double price = drink.cena.get(0) * quantity;
                        
                        orderDetails.append("- ").append(drink.nosaukums.get(0)).append(" x").append(quantity)
                                    .append(" - €").append(String.format("%.2f", price)).append("\n");
                        totalPrice += price;
                    }
                }
                orderDetails.append("\n");
            }
            
            if (irDzerieni) {
                orderDetails.append("Kopējā summa par dzērieniem: €").append(String.format("%.2f", totalPrice)).append("\n\n");
            }
            
            JOptionPane.showMessageDialog(picerijaa.this,
                orderDetails.toString(), 
                "Pasūtījums apstiprināts", JOptionPane.INFORMATION_MESSAGE);
			cardLayout.show(contentPane, "Panel5");});

        drinksBottomPanel.add(confirmDrinksButton);

        JButton backButton4 = new JButton("Atpakal");
        backButton4.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton4.addActionListener(e -> cardLayout.show(contentPane, "Panel3"));
        drinksBottomPanel.add(backButton4);

        panel4.add(drinksBottomPanel, BorderLayout.SOUTH);

        
        
     // Panel5 pircejs
        JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBackground(new Color(255, 228, 181));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBackground(new Color(255, 228, 181));

        JLabel titleLabel5 = new JLabel("Klienta informācija", SwingConstants.CENTER);
        titleLabel5.setBounds(0, 43, 886, 28);
        titleLabel5.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel5.setForeground(new Color(139, 69, 19));
        infoPanel.add(titleLabel5);

        JLabel nameDisplayLabel = new JLabel("Vārds: " + pircejaVards);
        nameDisplayLabel.setBounds(250, 100, 400, 25);
        nameDisplayLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(nameDisplayLabel);

        JLabel emailLabel = new JLabel("E-pasts:");
        emailLabel.setBounds(250, 140, 100, 25);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(350, 140, 300, 25);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Telefona nr:");
        phoneLabel.setBounds(250, 180, 100, 25);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(350, 180, 300, 25);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanel.add(phoneField);

        JLabel deliveryLabel = new JLabel("Piegādes veids:");
        deliveryLabel.setBounds(250, 220, 150, 25);
        deliveryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(deliveryLabel);

        JRadioButton pickupRadio = new JRadioButton("Paņemt uz vietas");
        pickupRadio.setBounds(400, 220, 150, 25);
        pickupRadio.setFont(new Font("Arial", Font.PLAIN, 16));
        pickupRadio.setBackground(new Color(255, 228, 181));
        pickupRadio.setSelected(true);

        JRadioButton deliveryRadio = new JRadioButton("Piegāde (+5€)");
        deliveryRadio.setBounds(550, 220, 150, 25);
        deliveryRadio.setFont(new Font("Arial", Font.PLAIN, 16));
        deliveryRadio.setBackground(new Color(255, 228, 181));

        ButtonGroup deliveryGroup = new ButtonGroup();
        deliveryGroup.add(pickupRadio);
        deliveryGroup.add(deliveryRadio);
        infoPanel.add(pickupRadio);
        infoPanel.add(deliveryRadio);

        JLabel addressLabel = new JLabel("Adrese:");
        addressLabel.setBounds(250, 260, 100, 25);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        addressLabel.setEnabled(false);
        infoPanel.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(350, 260, 300, 25);
        addressField.setFont(new Font("Arial", Font.PLAIN, 16));
        addressField.setEnabled(false);
        infoPanel.add(addressField);

        deliveryRadio.addActionListener(e -> {
            addressLabel.setEnabled(true);
            addressField.setEnabled(true);
        });

        pickupRadio.addActionListener(e -> {
            addressLabel.setEnabled(false);
            addressField.setEnabled(false);
            addressField.setText("");
        });

        JButton confirmButton1 = new JButton("Apstiprināt");
        confirmButton1.setBounds(350, 320, 150, 40);
        confirmButton1.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmButton1.setBackground(new Color(60, 179, 113));
        confirmButton1.setForeground(Color.WHITE);
        confirmButton1.addActionListener(e -> {
            try {
                String epasts = emailField.getText().trim();
                String phoneText = phoneField.getText().trim();
                String adresse = addressField.getText().trim();
                boolean piegade = deliveryRadio.isSelected();
                
                if (epasts.isEmpty() || phoneText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Lūdzu, aizpildiet visus obligātos laukus!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (piegade && adresse.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet piegādes adresi!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int telNum = Integer.parseInt(phoneText);
                pircejs customer = new pircejs(telNum, pircejaVards, epasts, adresse, piegade);
                
                cardLayout.show(contentPane, "Panel1");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet pareizu telefona numuru!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        });
        infoPanel.add(confirmButton1);

        JButton backButton1 = new JButton("Atpakaļ");
        backButton1.setBounds(520, 320, 150, 40);
        backButton1.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton1.setBackground(new Color(220, 20, 60));
        backButton1.setForeground(Color.WHITE);
        backButton1.addActionListener(e -> cardLayout.show(contentPane, "Panel4"));
        infoPanel.add(backButton1);

        panel5.add(infoPanel, BorderLayout.CENTER);

        panel5.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                nameDisplayLabel.setText("Vārds: " + pircejaVards);
            }
        });
        
        contentPane.add(panel1, "Panel1");
        contentPane.add(panel2, "Panel2");
        contentPane.add(panel3, "Panel3");
        contentPane.add(panel4, "Panel4");
        contentPane.add(panel5, "Panel5");
    }
}