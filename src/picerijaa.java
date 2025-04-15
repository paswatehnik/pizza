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
    private order aktualaisPasutijums;
    
    private List<pica> picuSaraksts;
    private List<dzerieni> dzerienuSaraksts;
    private List<JSpinner> picuDaudzumaSkaititaji;
    private List<JSpinner> dzerienuDaudzumaSkaititaji;   
    private List<String> customIngredients = new ArrayList<>();
    private List<JCheckBox> ingredientCheckboxes = new ArrayList<>();

    private void getingredients() {
        customIngredients.add("Tomātu mērce");
        customIngredients.add("Krējuma mērce");
        customIngredients.add("Mocarellas siers");
        customIngredients.add("Pepperoni");
        customIngredients.add("Šķiņķis");
        customIngredients.add("Sēnes");
        customIngredients.add("Sīpoli");
        customIngredients.add("Ananāsi");
        customIngredients.add("Jalapeno pipari");
        customIngredients.add("Olivas");
        customIngredients.add("Gambas");
    }

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

        picuSaraksts = pica.getPizzas();
        dzerienuSaraksts = dzerieni.getDrinks();
        picuDaudzumaSkaititaji = new ArrayList<>();
        dzerienuDaudzumaSkaititaji = new ArrayList<>();
        
        getingredients();

        // Panel1 pirmais logs
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(new Color(255, 228, 181));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 181));
        JButton orderButton = new JButton("Pasūtīt picas");
        orderButton.setBounds(323, 161, 264, 65);
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
        lblNewLabel.setIcon(new ImageIcon("pictures/mainLabel.png"));
        lblNewLabel.setBounds(586, 71, 288, 172);
        buttonPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("pictures/mainLabel2.png"));
        lblNewLabel_1.setBounds(588, 325, 219, 203);
        buttonPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("pictures/mainLabel3.png"));
        lblNewLabel_2.setBounds(-16, 134, 594, 523);
        buttonPanel.add(lblNewLabel_2);

        // Panel2 vardsa ievads
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
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("pictures/2panel1.png"));
        lblNewLabel_3.setBounds(127, 223, 696, 523); 
            
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
        
        JButton viewOrdersButton_1 = new JButton("Apskatīt pasūtījumus");
        viewOrdersButton_1.setBounds(381, 557, 264, 65);
        viewOrdersButton_1.setFont(new Font("Arial", Font.PLAIN, 24));
        viewOrdersButton_1.setBackground(new Color(100, 149, 237));
        viewOrdersButton_1.setForeground(Color.WHITE);
        viewOrdersButton_1.addActionListener(e -> {
            faili orderFile = new faili("pasutijumi.txt");
            String orders = orderFile.lasitPasutijumus();

            JTextArea textArea = new JTextArea(orders);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 500));

            JOptionPane.showMessageDialog(picerijaa.this, scrollPane,
                "Pasūtījumu vēsture", JOptionPane.INFORMATION_MESSAGE);
        });
        panel2.add(viewOrdersButton_1);

        // Panel3 Pizza
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(new Color(200, 233, 167));
        JLabel pizzaLabel = new JLabel("Izvēlieties picu:", SwingConstants.CENTER);
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pizzaLabel.setForeground(new Color(139, 69, 19));
        panel3.add(pizzaLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (pica pizza : picuSaraksts) {
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
            picuDaudzumaSkaititaji.add(quantitySpinner);
            
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
            
            for (int i = 0; i < picuSaraksts.size(); i++) {
                int daudzums = (Integer) picuDaudzumaSkaititaji.get(i).getValue();
                if (daudzums > 0) {
                    pica pizza = picuSaraksts.get(i);
                    String izmers = pizza.izmers.get(0);
                    double cena = pizza.cenas.get(0) * daudzums;
                    
                    orderDetails.append(pizza.nosaukums.toString())
                               .append(" (").append(izmers).append(")")
                               .append(" x").append(daudzums)
                               .append(" - €").append(String.format("%.2f", cena))
                               .append("\n");
                    totalPrice += cena;
                    totalPizzas += daudzums;
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
        
        JButton customPizzaButton = new JButton("Izveidot savu picu");
        customPizzaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        customPizzaButton.setBackground(new Color(255, 165, 0));
        customPizzaButton.setForeground(Color.WHITE);
        customPizzaButton.addActionListener(e -> cardLayout.show(contentPane, "Panel7"));
        bottomPanel.add(customPizzaButton);

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

        JPanel drinksOptionsPanel = new JPanel();
        drinksOptionsPanel.setLayout(new BoxLayout(drinksOptionsPanel, BoxLayout.Y_AXIS));
        drinksOptionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        for (dzerieni drink : dzerienuSaraksts) {
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
            dzerienuDaudzumaSkaititaji.add(quantitySpinner);
            
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
            if (aktualaisPasutijums == null) {
                aktualaisPasutijums = new order(new pircejs(0, pircejaVards, "", "", false));
            }
            
            aktualaisPasutijums.picuDaudzums.clear();
            aktualaisPasutijums.dzerienuDaudzums.clear();
            
            double pizzasCena = aktualaisPasutijums.getPasutijumaCena();
            aktualaisPasutijums.pasutijumaCena = 0.0;
            
            for (int i = 0; i < dzerienuSaraksts.size(); i++) {
                int daudzums = (Integer) dzerienuDaudzumaSkaititaji.get(i).getValue();
                if (daudzums > 0) {
                    aktualaisPasutijums.pievienotDzerienu(dzerienuSaraksts.get(i), daudzums);
                }
            }
            
            aktualaisPasutijums.pasutijumaCena += pizzasCena;
            
            for (int i = 0; i < picuSaraksts.size(); i++) {
                int daudzums = (Integer) picuDaudzumaSkaititaji.get(i).getValue();
                if (daudzums > 0) {
                    aktualaisPasutijums.pievienotPicu(picuSaraksts.get(i), daudzums);
                }
            }
            
            for (int i = 0; i < dzerienuSaraksts.size(); i++) {
                int daudzums = (Integer) dzerienuDaudzumaSkaititaji.get(i).getValue();
                if (daudzums > 0) {
                    aktualaisPasutijums.pievienotDzerienu(dzerienuSaraksts.get(i), daudzums);
                }
            }
            
            if (aktualaisPasutijums.getPicas().isEmpty() && aktualaisPasutijums.getDzerieni().isEmpty()) {
                JOptionPane.showMessageDialog(picerijaa.this, 
                    "Lūdzu, izvēlieties vismaz vienu produktu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cardLayout.show(contentPane, "Panel5");
        });

        drinksBottomPanel.add(confirmDrinksButton);

        JButton backButton4 = new JButton("Atpakal");
        backButton4.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton4.addActionListener(e -> cardLayout.show(contentPane, "Panel3"));
        drinksBottomPanel.add(backButton4);

        panel4.add(drinksBottomPanel, BorderLayout.SOUTH);        
        
     // Panel5
        JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBackground(new Color(255, 228, 181));

        JPanel infoPanelis = new JPanel();
        infoPanelis.setLayout(null);
        infoPanelis.setBackground(new Color(255, 228, 181));

        JLabel virsrakts5 = new JLabel("Klienta informācija", SwingConstants.CENTER);
        virsrakts5.setBounds(0, 43, 886, 28);
        virsrakts5.setFont(new Font("Arial", Font.BOLD, 24));
        virsrakts5.setForeground(new Color(139, 69, 19));
        infoPanelis.add(virsrakts5);

        JLabel vardaLabel = new JLabel("Vards: " + pircejaVards);
        vardaLabel.setBounds(250, 100, 400, 25);
        vardaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanelis.add(vardaLabel);

        JLabel epastaLabel = new JLabel("E-pasts:");
        epastaLabel.setBounds(250, 140, 100, 25);
        epastaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanelis.add(epastaLabel);

        JTextField epastaLauks = new JTextField();
        epastaLauks.setBounds(350, 140, 300, 25);
        epastaLauks.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanelis.add(epastaLauks);

        JLabel telefonaLabel = new JLabel("Telefona nr:");
        telefonaLabel.setBounds(250, 180, 100, 25);
        telefonaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanelis.add(telefonaLabel);

        JTextField telefonaLauks = new JTextField();
        telefonaLauks.setBounds(350, 180, 300, 25);
        telefonaLauks.setFont(new Font("Arial", Font.PLAIN, 16));
        infoPanelis.add(telefonaLauks);

        JLabel piegadesLabel = new JLabel("Piegades veids:");
        piegadesLabel.setBounds(250, 220, 150, 25);
        piegadesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanelis.add(piegadesLabel);

        JRadioButton uzVietasRadio = new JRadioButton("Parnemt uz vietas");
        uzVietasRadio.setBounds(400, 220, 150, 25);
        uzVietasRadio.setFont(new Font("Arial", Font.PLAIN, 16));
        uzVietasRadio.setBackground(new Color(255, 228, 181));
        uzVietasRadio.setSelected(true);

        JRadioButton piegadeRadio = new JRadioButton("Piegade (+5€)");
        piegadeRadio.setBounds(550, 220, 150, 25);
        piegadeRadio.setFont(new Font("Arial", Font.PLAIN, 16));
        piegadeRadio.setBackground(new Color(255, 228, 181));

        ButtonGroup piegadesGrupa = new ButtonGroup();
        piegadesGrupa.add(uzVietasRadio);
        piegadesGrupa.add(piegadeRadio);
        infoPanelis.add(uzVietasRadio);
        infoPanelis.add(piegadeRadio);

        JLabel adresesLabel = new JLabel("Adrese:");
        adresesLabel.setBounds(250, 260, 100, 25);
        adresesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        adresesLabel.setEnabled(false);
        infoPanelis.add(adresesLabel);

        JTextField adresesLauks = new JTextField();
        adresesLauks.setBounds(350, 260, 300, 25);
        adresesLauks.setFont(new Font("Arial", Font.PLAIN, 16));
        adresesLauks.setEnabled(false);
        infoPanelis.add(adresesLauks);

        piegadeRadio.addActionListener(e -> {
            adresesLabel.setEnabled(true);
            adresesLauks.setEnabled(true);
        });

        uzVietasRadio.addActionListener(e -> {
            adresesLabel.setEnabled(false);
            adresesLauks.setEnabled(false);
            adresesLauks.setText("");
        });

        JButton apstiprinatPoga = new JButton("Apstiprinat");
        apstiprinatPoga.setBounds(350, 320, 150, 40);
        apstiprinatPoga.setFont(new Font("Arial", Font.PLAIN, 18));
        apstiprinatPoga.setBackground(new Color(60, 179, 113));
        apstiprinatPoga.setForeground(Color.WHITE);
        apstiprinatPoga.addActionListener(e -> {
            try {
                String epasts = epastaLauks.getText().trim();
                String telefons = telefonaLauks.getText().trim();
                String adrese = adresesLauks.getText().trim();
                boolean piegade = piegadeRadio.isSelected();
                
                if (epasts.isEmpty() || telefons.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Lūdzu, aizpildiet visus obligātos laukus!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (piegade && adrese.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet piegādes adresi!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int telNum = Integer.parseInt(telefons);
                pircejs klients = new pircejs(telNum, pircejaVards, epasts, adrese, piegade);
                
                order jaunaisPasutijums = new order(klients);

             if (aktualaisPasutijums != null) {
                 List<pica> vecasPicas = aktualaisPasutijums.getPicas();
                 List<Integer> daudzumi = aktualaisPasutijums.picuDaudzums;

                 for (int i = 0; i < vecasPicas.size(); i++) {
                     pica p = vecasPicas.get(i);
                     if (p.nosaukums.get(0).equals("Pašizveidota pica")) {
                         jaunaisPasutijums.pievienotPicu(p, daudzumi.get(i));
                     }
                 }
             }

             aktualaisPasutijums = jaunaisPasutijums;

                
                for (int i = 0; i < picuSaraksts.size(); i++) {
                    int daudzums = (Integer) picuDaudzumaSkaititaji.get(i).getValue();
                    if (daudzums > 0) {
                        aktualaisPasutijums.pievienotPicu(picuSaraksts.get(i), daudzums);
                    }
                }
                
                for (int i = 0; i < dzerienuSaraksts.size(); i++) {
                    int daudzums = (Integer) dzerienuDaudzumaSkaititaji.get(i).getValue();
                    if (daudzums > 0) {
                        aktualaisPasutijums.pievienotDzerienu(dzerienuSaraksts.get(i), daudzums);
                    }
                }
                
                if (piegade) {
                    aktualaisPasutijums.pasutijumaCena += 5.0;
                }
                
                cardLayout.show(contentPane, "Panel6");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Lūdzu, ievadiet pareizu telefona numuru!", "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        });
        infoPanelis.add(apstiprinatPoga);

        JButton atpakalPoga1 = new JButton("Atpakal");
        atpakalPoga1.setBounds(520, 320, 150, 40);
        atpakalPoga1.setFont(new Font("Arial", Font.PLAIN, 18));
        atpakalPoga1.setBackground(new Color(220, 20, 60));
        atpakalPoga1.setForeground(Color.WHITE);
        atpakalPoga1.addActionListener(e -> cardLayout.show(contentPane, "Panel4"));
        infoPanelis.add(atpakalPoga1);

        panel5.add(infoPanelis, BorderLayout.CENTER);

        panel5.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                vardaLabel.setText("Vards: " + pircejaVards);
                epastaLauks.setText("");
                telefonaLauks.setText("");
                adresesLauks.setText("");
                uzVietasRadio.setSelected(true);
                adresesLabel.setEnabled(false);
                adresesLauks.setEnabled(false);
            }
        });

        // Panel6 - Pasutijuma kopsavilkums
        JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBackground(new Color(200, 233, 200));

        JLabel virsrakts6 = new JLabel("Jūsu pasūtījuma kopsavilkums", SwingConstants.CENTER);
        virsrakts6.setFont(new Font("Arial", Font.BOLD, 24));
        virsrakts6.setForeground(new Color(139, 69, 19));
        panel6.add(virsrakts6, BorderLayout.NORTH);

        JTextArea pasutijumaKopsavilkums = new JTextArea();
        pasutijumaKopsavilkums.setFont(new Font("Arial", Font.PLAIN, 16));
        pasutijumaKopsavilkums.setEditable(false);
        pasutijumaKopsavilkums.setLineWrap(true);
        pasutijumaKopsavilkums.setWrapStyleWord(true);
        pasutijumaKopsavilkums.setBackground(new Color(255, 255, 255, 200));
        pasutijumaKopsavilkums.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane kopsavilkumaRitjosla = new JScrollPane(pasutijumaKopsavilkums);
        panel6.add(kopsavilkumaRitjosla, BorderLayout.CENTER);

        JPanel kopsavilkumaPogas = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        kopsavilkumaPogas.setBackground(new Color(200, 233, 200));       
        
        JButton apstiprinatPasutijumuPoga = new JButton("Apstiprinat pasūtījumu");
        apstiprinatPasutijumuPoga.setFont(new Font("Arial", Font.PLAIN, 18));
        apstiprinatPasutijumuPoga.setBackground(new Color(60, 179, 113));
        apstiprinatPasutijumuPoga.setForeground(Color.WHITE);
        apstiprinatPasutijumuPoga.addActionListener(e -> {
            if (aktualaisPasutijums != null) {
                aktualaisPasutijums.pabeigtPasutijumu();
                faili orderFile = new faili("pasutijumi.txt");
                orderFile.saglabatPasutijumu(aktualaisPasutijums.getPasutijumaKopsavilkums());

                JOptionPane.showMessageDialog(picerijaa.this,
                    "Paldies par pasūtījumu! Jūsu pica tiks sagatavota drīz.\n\n" + 
                    aktualaisPasutijums.getPasutijumaKopsavilkums(),
                    "Pasūtījums apstiprināts", JOptionPane.INFORMATION_MESSAGE);
                                
                resetForm();
                cardLayout.show(contentPane, "Panel1");
            }
        });
        kopsavilkumaPogas.add(apstiprinatPasutijumuPoga);

        JButton pievienotVelPoga = new JButton("Pievienot vel produktus");
        pievienotVelPoga.setFont(new Font("Arial", Font.PLAIN, 18));
        pievienotVelPoga.setBackground(new Color(100, 149, 237));
        pievienotVelPoga.setForeground(Color.WHITE);
        pievienotVelPoga.addActionListener(e -> cardLayout.show(contentPane, "Panel3"));
        kopsavilkumaPogas.add(pievienotVelPoga);

        JButton atpakalPoga6 = new JButton("Atpakal");
        atpakalPoga6.setFont(new Font("Arial", Font.PLAIN, 18));
        atpakalPoga6.setBackground(new Color(220, 20, 60));
        atpakalPoga6.setForeground(Color.WHITE);
        atpakalPoga6.addActionListener(e -> cardLayout.show(contentPane, "Panel5"));
        kopsavilkumaPogas.add(atpakalPoga6);

        panel6.add(kopsavilkumaPogas, BorderLayout.SOUTH);

        panel6.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (aktualaisPasutijums != null) {
                    pasutijumaKopsavilkums.setText(aktualaisPasutijums.getPasutijumaKopsavilkums());
                }
            }
        });
            
        JPanel panel7 = new JPanel(new BorderLayout());
        panel7.setBackground(new Color(233, 200, 200));

        JLabel titleLabel1 = new JLabel("Izveidojiet savu picu", SwingConstants.CENTER);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel1.setForeground(new Color(139, 69, 19));
        panel7.add(titleLabel1, BorderLayout.NORTH);

        JPanel customPizzaPanel = new JPanel();
        customPizzaPanel.setLayout(new BoxLayout(customPizzaPanel, BoxLayout.Y_AXIS));
        customPizzaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        customPizzaPanel.setBackground(new Color(255, 255, 255, 200));

        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pricePanel.setBackground(new Color(255, 255, 255, 0));
        JLabel basePriceLabel = new JLabel("Pamata cena: €3.00 (Maza) + €0.50 par katru sastāvdaļu");
        basePriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pricePanel.add(basePriceLabel);
        customPizzaPanel.add(pricePanel);
        customPizzaPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel saucePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        saucePanel.setBackground(new Color(255, 255, 255, 0));
        JLabel sauceLabel = new JLabel("Izvēlieties mērci (obligāti):");
        sauceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        saucePanel.add(sauceLabel);
        
        ButtonGroup sauceGroup = new ButtonGroup();
        JRadioButton tomatoSauce = new JRadioButton("Tomātu mērce");
        JRadioButton creamSauce = new JRadioButton("Krējuma mērce");
        tomatoSauce.setFont(new Font("Arial", Font.PLAIN, 14));
        creamSauce.setFont(new Font("Arial", Font.PLAIN, 14));
        sauceGroup.add(tomatoSauce);
        sauceGroup.add(creamSauce);
        saucePanel.add(tomatoSauce);
        saucePanel.add(creamSauce);
        customPizzaPanel.add(saucePanel);
        customPizzaPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sizePanel.setBackground(new Color(255, 255, 255, 0));
        JLabel sizeLabel = new JLabel("Izvēlieties izmēru:");
        sizeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sizePanel.add(sizeLabel);

        String[] sizes = {"Maza (25cm) €3.00", "Vidēja (30cm) €5.00", "Liela (35cm) €7.00"};
        JComboBox<String> sizeCombo = new JComboBox<>(sizes);
        sizeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        sizePanel.add(sizeCombo);
        customPizzaPanel.add(sizePanel);
        customPizzaPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel ingredientsLabel = new JLabel("Izvēlieties papildinājumus (vismaz 1):");
        ingredientsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        customPizzaPanel.add(ingredientsLabel);
        customPizzaPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] ingredients = {
        	    "Mocarellas siers", "Pepperoni", "Šķiņķis", "Sēnes", 
        	    "Sīpoli", "Ananāsi", "Jalapeno pipari", "Olivas", "Gambas"
        	};

        JPanel ingredientsGrid = new JPanel(new GridLayout(0, 2, 10, 5));
        ingredientsGrid.setBackground(new Color(255, 255, 255, 0));

        for (String ingredient : ingredients) {
            JCheckBox checkBox = new JCheckBox(ingredient);
            checkBox.setFont(new Font("Arial", Font.PLAIN, 14));
            ingredientsGrid.add(checkBox);
            ingredientCheckboxes.add(checkBox);
        }

        customPizzaPanel.add(ingredientsGrid);

        JScrollPane scrollPane7 = new JScrollPane(customPizzaPanel);
        panel7.add(scrollPane7, BorderLayout.CENTER);

        JPanel bottomPanel7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel7.setBackground(new Color(233, 200, 200));

        JButton addToOrderButton = new JButton("Pievienot pasūtījumam");
        addToOrderButton.setFont(new Font("Arial", Font.PLAIN, 18));
        addToOrderButton.setBackground(new Color(60, 179, 113));
        addToOrderButton.setForeground(Color.WHITE);
        addToOrderButton.addActionListener(e -> {
            if (!tomatoSauce.isSelected() && !creamSauce.isSelected()) {
                JOptionPane.showMessageDialog(this, 
                    "Lūdzu, izvēlieties mērci!", 
                    "Kļūda", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            List<String> selectedIngredients = new ArrayList<>();
            if (tomatoSauce.isSelected()) {
                selectedIngredients.add("Tomātu mērce");
            } else {
                selectedIngredients.add("Krējuma mērce");
            }
            
            for (JCheckBox checkBox : ingredientCheckboxes) {
                if (checkBox.isSelected()) {
                    selectedIngredients.add(checkBox.getText());
                }
            }
            
            if (selectedIngredients.size() < 2) {
                JOptionPane.showMessageDialog(this, 
                    "Lūdzu, izvēlieties vismaz vienu papildinājumu!", 
                    "Kļūda", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // izveidot picu
            pica customPizza = new pica(false);
            customPizza.nosaukums.add("Pašizveidota pica");
            customPizza.izmers.add((String) sizeCombo.getSelectedItem());
            
            // cena
            double basePrice = 3.00;
            if (sizeCombo.getSelectedIndex() == 1) basePrice = 5.00;
            if (sizeCombo.getSelectedIndex() == 2) basePrice = 7.00;
            
            double ingredientsPrice = (selectedIngredients.size() - 1) * 0.5; // -1 because sauce is not extra
            double totalPrice = basePrice + ingredientsPrice;
            
            customPizza.cenas.add(totalPrice);
            customPizza.merce.add(selectedIngredients.get(0));
            customPizza.recepts.add(String.join(", ", selectedIngredients));
            customPizza.picture = "pictures/custom_pizza.jpg";
            
            for (int i = 1; i < selectedIngredients.size(); i++) {
                customPizza.papildinajums.add(selectedIngredients.get(i));
            }
            
            if (aktualaisPasutijums == null) {
                aktualaisPasutijums = new order(new pircejs(0, pircejaVards, "", "", false));
            }
            
            aktualaisPasutijums.pievienotPicu(customPizza, 1);
            
            JOptionPane.showMessageDialog(this,
                "Pašizveidotā pica pievienota pasūtījumam!\n" +
                "Nosaukums: Pašizveidota pica\n" +
                "Izmērs: " + sizeCombo.getSelectedItem() + "\n" +
                "Sastāvdaļas: " + String.join(", ", selectedIngredients) + "\n" +
                "Cena: €" + String.format("%.2f", totalPrice),
                "Pica pievienota", JOptionPane.INFORMATION_MESSAGE);
            
            cardLayout.show(contentPane, "Panel4");
        });
        bottomPanel7.add(addToOrderButton);

        JButton backButton7 = new JButton("Atpakaļ");
        backButton7.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton7.setBackground(new Color(220, 20, 60));
        backButton7.setForeground(Color.WHITE);
        backButton7.addActionListener(e -> {
            sauceGroup.clearSelection();
            sizeCombo.setSelectedIndex(0);
            for (JCheckBox checkBox : ingredientCheckboxes) {
                checkBox.setSelected(false);
            }
            cardLayout.show(contentPane, "Panel3");
        });
        bottomPanel7.add(backButton7);

        panel7.add(bottomPanel7, BorderLayout.SOUTH);  
        
        
        
        contentPane.add(panel1, "Panel1");
        contentPane.add(panel2, "Panel2");
        contentPane.add(panel3, "Panel3");
        contentPane.add(panel4, "Panel4");
        contentPane.add(panel5, "Panel5");
        contentPane.add(panel6, "Panel6");  
        contentPane.add(panel7, "Panel7");
    }
        
        private void resetForm() {
            for (JSpinner spinner : picuDaudzumaSkaititaji) {
                spinner.setValue(0);
            }
            for (JSpinner spinner : dzerienuDaudzumaSkaititaji) {
                spinner.setValue(0);
            }
            aktualaisPasutijums = null;
            pircejaVards = "";
        }
    }
