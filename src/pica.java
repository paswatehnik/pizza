import java.util.ArrayList;
import java.util.List;

public class pica {
	ArrayList<String> nosaukums;
    ArrayList<String> izmers;
    ArrayList<String> merce;
    ArrayList<String> papildinajums;
    ArrayList<String> recepts;
    boolean piegade;
    public String imagePath;

    public pica(boolean piegade) {
    	this.nosaukums = new ArrayList<>();
        this.piegade = piegade;
        this.izmers = new ArrayList<>();
        this.merce = new ArrayList<>();
        this.papildinajums = new ArrayList<>();
        this.recepts = new ArrayList<>();
    }

    public static List<pica> getPredefinedPizzas() {
        List<pica> pizzas = new ArrayList<>();

        pica margherita = new pica(false);
        margherita.nosaukums.add("Margherita");
        margherita.izmers.add("Small");
        margherita.izmers.add("Medium");
        margherita.izmers.add("Large");
        margherita.merce.add("Tomato sauce");
        margherita.papildinajums.add("Mozzarella");
        margherita.recepts.add("Fresh basil, olive oil");
        margherita.imagePath = "pictures\\margherita.jpeg";
        pizzas.add(margherita);

        pica pepperoni = new pica(false);
        pepperoni.nosaukums.add("Pepperoni");
        pepperoni.izmers.add("Small");
        pepperoni.izmers.add("Medium");
        pepperoni.izmers.add("Large");
        pepperoni.merce.add("Tomato sauce");
        pepperoni.papildinajums.add("Mozzarella");
        pepperoni.papildinajums.add("Pepperoni slices");
        pepperoni.recepts.add("Spicy and savory");
        pepperoni.imagePath = "pictures\\pepperoni.jpg";
        pizzas.add(pepperoni);

        pica vegetarian = new pica(false);
        vegetarian.nosaukums.add("Vegetarian");
        vegetarian.izmers.add("Small");
        vegetarian.izmers.add("Medium");
        vegetarian.izmers.add("Large");
        vegetarian.merce.add("Tomato sauce");
        vegetarian.papildinajums.add("Mozzarella");
        vegetarian.recepts.add("Bell peppers, onions, mushrooms, olives");
        vegetarian.imagePath = "pictures\\vegetarian.jpg";
        pizzas.add(vegetarian);

        return pizzas;
    }
}
