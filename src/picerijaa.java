import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class picerijaa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    picerijaa frame = new picerijaa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public picerijaa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // First panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        JButton nextButton = new JButton("PIRK PIZZA");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Panel2");
            }
        });
        panel1.add(nextButton);

        // Second panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.CYAN);
        JLabel nameLabel = new JLabel("Ievadiet savu vārdu:");
        JTextField nameField = new JTextField(20);
        JButton confirmButton = new JButton("Apstiprināt");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String uzvards = nameField.getText().trim();
                if (uzvards.isEmpty()) {
                    JOptionPane.showMessageDialog(panel2, "Lūdzu, ievadiet savu vārdu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Klienta vārds: " + uzvards);
                }
            }
        });
        JButton backButton = new JButton("Atpakaļ");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Panel1");
            }
        });

        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(confirmButton);
        panel2.add(backButton);

        
        contentPane.add(panel1, "Panel1");
        contentPane.add(panel2, "Panel2");
    }
}
