import java.util.ArrayList;
import java.util.List;

public class pica {
    ArrayList<String> nosaukums;
    ArrayList<String> izmers;
    ArrayList<Double> cenas;
    ArrayList<String> merce;
    ArrayList<String> papildinajums;
    ArrayList<String> recepts;
    boolean piegade;
    public String picture;

    public pica(boolean piegade) {
        this.nosaukums = new ArrayList<>();
        this.piegade = piegade;
        this.izmers = new ArrayList<>();
        this.cenas = new ArrayList<>();
        this.merce = new ArrayList<>();
        this.papildinajums = new ArrayList<>();
        this.recepts = new ArrayList<>();
    }

    public static List<pica> getPizzas() {
        List<pica> pizzas = new ArrayList<>();

        // 1. Margherita
        pica margherita = new pica(false);
        margherita.nosaukums.add("Margherita");
        margherita.izmers.add("Maza (25cm)");
        margherita.izmers.add("Vidēja (30cm)");
        margherita.izmers.add("Liela (35cm)");
        margherita.cenas.add(5.99);
        margherita.cenas.add(7.99);
        margherita.cenas.add(9.99);
        margherita.merce.add("Tomātu mērce");
        margherita.papildinajums.add("Mocarellas siers");
        margherita.recepts.add("Svaigi bazilikas lapas, olīvu eļļa");
        margherita.picture = "pictures/margherita.jpeg";
        pizzas.add(margherita);

        // 2. Pepperoni
        pica pepperoni = new pica(false);
        pepperoni.nosaukums.add("Pepperoni");
        pepperoni.izmers.add("Maza (25cm)");
        pepperoni.izmers.add("Vidēja (30cm)");
        pepperoni.izmers.add("Liela (35cm)");
        pepperoni.cenas.add(6.99);
        pepperoni.cenas.add(8.99);
        pepperoni.cenas.add(10.99);
        pepperoni.merce.add("Tomātu mērce");
        pepperoni.papildinajums.add("Mocarellas siers");
        pepperoni.papildinajums.add("Pepperoni desa");
        pepperoni.recepts.add("Asi un pikanti");
        pepperoni.picture = "pictures/pepperoni.jpg";
        pizzas.add(pepperoni);

        // 3. Vegetāra
        pica vegetarian = new pica(false);
        vegetarian.nosaukums.add("Vegetāra");
        vegetarian.izmers.add("Maza (25cm)");
        vegetarian.izmers.add("Vidēja (30cm)");
        vegetarian.izmers.add("Liela (35cm)");
        vegetarian.cenas.add(6.49);
        vegetarian.cenas.add(8.49);
        vegetarian.cenas.add(10.49);
        vegetarian.merce.add("Tomātu mērce");
        vegetarian.papildinajums.add("Mocarellas siers");
        vegetarian.recepts.add("Salātpeļļi, sīpoli, sēnes, olīvas");
        vegetarian.picture = "pictures/vegetarian.jpg";
        pizzas.add(vegetarian);

        // 4. Četru siers
        pica fourCheese = new pica(false);
        fourCheese.nosaukums.add("Četru siers");
        fourCheese.izmers.add("Maza (25cm)");
        fourCheese.izmers.add("Vidēja (30cm)");
        fourCheese.izmers.add("Liela (35cm)");
        fourCheese.cenas.add(7.99);
        fourCheese.cenas.add(9.99);
        fourCheese.cenas.add(11.99);
        fourCheese.merce.add("Krējuma mērce");
        fourCheese.papildinajums.add("Mocarellas siers");
        fourCheese.papildinajums.add("Gorgonzola");
        fourCheese.papildinajums.add("Parmezāns");
        fourCheese.papildinajums.add("Čedars");
        fourCheese.recepts.add("Četri dažādi sieri ar krējuma mērci");
        fourCheese.picture = "pictures/cetrisieru.jpg";
        pizzas.add(fourCheese);

        // 5. Havaju
        pica hawaiian = new pica(false);
        hawaiian.nosaukums.add("Havaju");
        hawaiian.izmers.add("Maza (25cm)");
        hawaiian.izmers.add("Vidēja (30cm)");
        hawaiian.izmers.add("Liela (35cm)");
        hawaiian.cenas.add(7.49);
        hawaiian.cenas.add(9.49);
        hawaiian.cenas.add(11.49);
        hawaiian.merce.add("Tomātu mērce");
        hawaiian.papildinajums.add("Mocarellas siers");
        hawaiian.papildinajums.add("Šķiņķis");
        hawaiian.papildinajums.add("Ananāsi");
        hawaiian.recepts.add("Salds un sāļš garšu kombinācija");
        hawaiian.picture = "pictures/hawaii.png";
        pizzas.add(hawaiian);

        // 6. BBQ
        pica bbqChicken = new pica(false);
        bbqChicken.nosaukums.add("BBQ vistas");
        bbqChicken.izmers.add("Maza (25cm)");
        bbqChicken.izmers.add("Vidēja (30cm)");
        bbqChicken.izmers.add("Liela (35cm)");
        bbqChicken.cenas.add(8.49);
        bbqChicken.cenas.add(10.49);
        bbqChicken.cenas.add(12.49);
        bbqChicken.merce.add("BBQ mērce");
        bbqChicken.papildinajums.add("Mocarellas siers");
        bbqChicken.papildinajums.add("Vistas fileja");
        bbqChicken.papildinajums.add("Sīpoli");
        bbqChicken.recepts.add("Smalka vistas garša ar BBQ mērci");
        bbqChicken.picture = "pictures/bbqpica.png";
        pizzas.add(bbqChicken);

        // 7. Meksikāņu
        pica mexican = new pica(false);
        mexican.nosaukums.add("Meksikāņu");
        mexican.izmers.add("Maza (25cm)");
        mexican.izmers.add("Vidēja (30cm)");
        mexican.izmers.add("Liela (35cm)");
        mexican.cenas.add(7.99);
        mexican.cenas.add(9.99);
        mexican.cenas.add(11.99);
        mexican.merce.add("Salsa mērce");
        mexican.papildinajums.add("Mocarellas siers");
        mexican.papildinajums.add("Asi desa");
        mexican.papildinajums.add("Jalapeno pipari");
        mexican.papildinajums.add("Skābais krējums");
        mexican.recepts.add("Asi un pikanti meksikāņu stilā");
        mexican.picture = "pictures/mexican.png";
        pizzas.add(mexican);

        // 8. Jūras
        pica seafood = new pica(false);
        seafood.nosaukums.add("Jūras");
        seafood.izmers.add("Maza (25cm)");
        seafood.izmers.add("Vidēja (30cm)");
        seafood.izmers.add("Liela (35cm)");
        seafood.cenas.add(9.99);
        seafood.cenas.add(11.99);
        seafood.cenas.add(13.99);
        seafood.merce.add("Krējuma mērce");
        seafood.papildinajums.add("Mocarellas siers");
        seafood.papildinajums.add("Kalmāri");
        seafood.papildinajums.add("Gambas");
        seafood.papildinajums.add("Mīdijas");
        seafood.recepts.add("Jūras garšas ar krējuma mērci");
        seafood.picture = "pictures/seafood.jpg";
        pizzas.add(seafood);

        // 9. Karbonara
        pica carbonara = new pica(false);
        carbonara.nosaukums.add("Karbonāra");
        carbonara.izmers.add("Maza (25cm)");
        carbonara.izmers.add("Vidēja (30cm)");
        carbonara.izmers.add("Liela (35cm)");
        carbonara.cenas.add(8.49);
        carbonara.cenas.add(10.49);
        carbonara.cenas.add(12.49);
        carbonara.merce.add("Krējuma mērce");
        carbonara.papildinajums.add("Mocarellas siers");
        carbonara.papildinajums.add("Šķiņķis");
        carbonara.papildinajums.add("Sīpoli");
        carbonara.papildinajums.add("Jēra siers");
        carbonara.recepts.add("Klasiskā karbonāras garša");
        carbonara.picture = "pictures/carbonara.jpg";
        pizzas.add(carbonara);

        return pizzas;
    }
}
