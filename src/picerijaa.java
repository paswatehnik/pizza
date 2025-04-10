import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setBounds(100, 100, 800, 600);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // First panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 228, 181));
        panel1.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Pizza Shop!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(139, 69, 19));
        panel1.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 228, 181));

        JButton orderButton = new JButton("Pasūtīt picas");
        orderButton.setAlignmentY(Component.TOP_ALIGNMENT);
        orderButton.setBounds(320, 204, 150, 31);
        orderButton.setFont(new Font("Arial", Font.PLAIN, 18));
        orderButton.setBackground(new Color(60, 179, 113));
        orderButton.setForeground(Color.WHITE);
        orderButton.addActionListener(e -> cardLayout.show(contentPane, "Panel2"));
        buttonPanel.setLayout(null);
        buttonPanel.add(orderButton);

        JButton exitButton = new JButton("Iziet");
        exitButton.setBounds(683, 485, 80, 31);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBackground(new Color(220, 20, 60)); 
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);

        panel1.add(buttonPanel, BorderLayout.CENTER);

        // Second panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.CYAN);
        panel2.setLayout(null);

        JLabel nameLabel = new JLabel("Enter your name:", SwingConstants.CENTER);
        nameLabel.setBounds(23, 134, 186, 22);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel2.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(194, 134, 208, 22);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel2.add(nameField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(603, 526, 173, 31);
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        backButton.addActionListener(e -> cardLayout.show(contentPane, "Panel1"));
        panel2.add(backButton);

        contentPane.add(panel1, "Panel1");
        contentPane.add(panel2, "Panel2");
    }
}

