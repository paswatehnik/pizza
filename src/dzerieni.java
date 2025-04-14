import java.util.ArrayList;
import java.util.List;

public class dzerieni {
    ArrayList<String> nosaukums;
    ArrayList<Double> cena;
    ArrayList<String> apraksts;
    public String picture;

    public dzerieni() {
        this.nosaukums = new ArrayList<>();
        this.cena = new ArrayList<>();
        this.apraksts = new ArrayList<>();
    }

    public static List<dzerieni> getDrinks() {
        List<dzerieni> drinks = new ArrayList<>();

        // 1. Coca-Cola
        dzerieni cola = new dzerieni();
        cola.nosaukums.add("Coca-Cola");
        cola.cena.add(1.99);
        cola.apraksts.add("Klassiska gāzēta dzēriena garša");
        cola.picture = "pictures/cola.jpg";
        drinks.add(cola);

        // 2. Fanta
        dzerieni fanta = new dzerieni();
        fanta.nosaukums.add("Fanta");
        fanta.cena.add(1.99);
        fanta.apraksts.add("Apersinu garša ar gāzi");
        fanta.picture = "pictures/fanta.jpg";
        drinks.add(fanta);

        // 3. Sprite
        dzerieni sprite = new dzerieni();
        sprite.nosaukums.add("Sprite");
        sprite.cena.add(1.99);
        sprite.apraksts.add("Atsvaidzinošs citronu-laima garša");
        sprite.picture = "pictures/sprite.jpg";
        drinks.add(sprite);

        // 4. Ūdens
        dzerieni udens = new dzerieni();
        udens.nosaukums.add("Mineralūdens");
        udens.cena.add(1.49);
        udens.apraksts.add("Dabīgs minerālūdens");
        udens.picture = "pictures/udens.png";
        drinks.add(udens);

        // 5. Sula
        dzerieni sula = new dzerieni();
        sula.nosaukums.add("Ābolu sula");
        sula.cena.add(2.49);
        sula.apraksts.add("Svaigi spiesta ābolu sula");
        sula.picture = "pictures/sula.jpg";
        drinks.add(sula);

        return drinks;
    }
}