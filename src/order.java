import java.util.ArrayList;
import java.util.List;

public class order {
    private pircejs klients;
    private List<pica> picas;
    private List<dzerieni> dzerieni;
    private List<Integer> picuDaudzums;
    private List<Integer> dzerienuDaudzums;
    double pasutijumaCena;
    private boolean pabeigts;
    private boolean piegade;
    
    public order(pircejs klients) {
        this.klients = klients;
        this.picas = new ArrayList<>();
        this.dzerieni = new ArrayList<>();
        this.picuDaudzums = new ArrayList<>();
        this.dzerienuDaudzums = new ArrayList<>();
        this.pasutijumaCena = 0.0;
        this.pabeigts = false;
        this.piegade = klients.piegade;
    }
    
    public void pievienotPicu(pica pica, int daudzums) {
        picas.add(pica);
        picuDaudzums.add(daudzums);
        pasutijumaCena += pica.cenas.get(0) * daudzums;
    }
    
    public void pievienotDzerienu(dzerieni dzeriens, int daudzums) {
        dzerieni.add(dzeriens);
        dzerienuDaudzums.add(daudzums);
        pasutijumaCena += dzeriens.cena.get(0) * daudzums;
    }
    
    public void pabeigtPasutijumu() {
        if (piegade) {
            pasutijumaCena += 5.0;
        }
        this.pabeigts = true;
        
        faili orderFile = new faili("pasutijumi.txt");
        orderFile.saglabatPasutijumu(this);
    }
    
    public String getPasutijumaKopsavilkums() {
        StringBuilder kopsavilkums = new StringBuilder();
        kopsavilkums.append("=== Klienta informācija ===\n");
        kopsavilkums.append(klients.getKlientaInfo());
        kopsavilkums.append("\n=== Pasūtījuma detaļas ===\n");
        
        if (!picas.isEmpty()) {
            kopsavilkums.append("\nPicas:\n");
            for (int i = 0; i < picas.size(); i++) {
                pica pica = picas.get(i);
                kopsavilkums.append("- ").append(pica.nosaukums.get(0))
                      .append(" (").append(pica.izmers.get(0)).append(")")
                      .append(" x").append(picuDaudzums.get(i))
                      .append(" - €").append(String.format("%.2f", pica.cenas.get(0) * picuDaudzums.get(i))).append("\n");
            }
        }
        
        if (!dzerieni.isEmpty()) {
            kopsavilkums.append("\nDzērieni:\n");
            for (int i = 0; i < dzerieni.size(); i++) {
                dzerieni dzeriens = dzerieni.get(i);
                kopsavilkums.append("- ").append(dzeriens.nosaukums.get(0))
                      .append(" x").append(dzerienuDaudzums.get(i))
                      .append(" - €").append(String.format("%.2f", dzeriens.cena.get(0) * dzerienuDaudzums.get(i))).append("\n");
            }
        }
        
        if (piegade) {
            kopsavilkums.append("\nPiegāde: €5.00\n");
        }
        
        kopsavilkums.append("\n=== KOPĀ ===\n");
        kopsavilkums.append("€").append(String.format("%.2f", pasutijumaCena));
        
        return kopsavilkums.toString();
    }
    
    public pircejs getKlients() { return klients; }
    public List<pica> getPicas() { return picas; }
    public List<dzerieni> getDzerieni() { return dzerieni; }
    public double getPasutijumaCena() { return pasutijumaCena; }
    public boolean isPabeigts() { return pabeigts; }
    public boolean isPiegade() { return piegade; }
}