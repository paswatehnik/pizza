public class pircejs {
    int telNum;
    String vards, epasts, adresse;
    boolean piegade;
    
    public pircejs(int telNum, String vards, String epasts, String adresse, boolean piegade) {
        this.telNum = telNum;
        this.vards = vards;
        this.epasts = epasts;
        this.adresse = adresse;
        this.piegade = piegade;
    }
    
    public String getKlientaInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Vārds: ").append(vards).append("\n");
        info.append("E-pasts: ").append(epasts).append("\n");
        info.append("Telefona nr: ").append(telNum).append("\n");
        if (piegade) {
            info.append("Piegādes adrese: ").append(adresse).append("\n");
        } else {
            info.append("Paņemšana uz vietas\n");
        }
        return info.toString();
    }
}