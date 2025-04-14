import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class faili {
    ArrayList<String> pabOrder;
    ArrayList<String> nepabOrder;
    File orderFile;
    
    public faili(String failaNS) {
        this.pabOrder = new ArrayList<>();
        this.nepabOrder = new ArrayList<>();
        this.orderFile = new File(failaNS);
        
        try {
            if (!orderFile.exists()) {
                orderFile.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Kļūda izveidojot failu: " + e.getMessage());
        }
    }
    
    public void saglabatPasutijumu(order pasutijums) {
        try (FileWriter writer = new FileWriter(orderFile, true)) {
            String orderData = pasutijums.getPasutijumaKopsavilkums();
            writer.write("=== Pasūtījums ===\n");
            writer.write(orderData);
            writer.write("\n\n");
            
            if (pasutijums.isPabeigts()) {
                pabOrder.add(orderData);
            } else {
                nepabOrder.add(orderData);
            }
        } catch (IOException e) {
            System.err.println("Kļūda saglabājot pasūtījumu: " + e.getMessage());
        }
    }
    
    public void saglabatPasutijumu(String pasutijumaTeksts) {
        try (FileWriter writer = new FileWriter(orderFile, true)) {
            writer.write("=== Pasūtījums ===\n");
            writer.write(pasutijumaTeksts);
            writer.write("\n\n");
        } catch (IOException e) {
            System.err.println("Kļūda saglabājot pasūtījumu: " + e.getMessage());
        }
    }
    
    public String lasitPasutijumus() {
        try {
            if (orderFile.exists() && orderFile.length() > 0) {
                List<String> allLines = Files.readAllLines(orderFile.toPath());
                return String.join("\n", allLines);
            } else {
                return "Nav neviena pasūtījuma vēstures.";
            }
        } catch (IOException e) {
            System.err.println("Kļūda lasot pasūtījumus: " + e.getMessage());
            return "Kļūda ielādējot pasūtījumu vēsturi.";
        }
    }
    
}