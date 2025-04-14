import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
}