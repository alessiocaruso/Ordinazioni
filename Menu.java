import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Piatto> piatti = new ArrayList<>();
    // Inseriamo i piatti
    Piatto piatto1 = new Piatto("Spaghetti aglio e olio", 10, "Alessio");
    Piatto piatto2 = new Piatto("Spaghetti alla nerano", 12, "Nicola");
    Piatto piatto3 = new Piatto("Carbonara", 15, "Alessio");
    Piatto piatto4 = new Piatto("Lasagna", 10, "Nicola");
    String ordine;

    public void inizializza() {
        // Aggiungiamo piatti all'arrayList piatti
        piatti.add(piatto1);
        piatti.add(piatto2);
        piatti.add(piatto3);
        piatti.add(piatto4);

    }

    public ArrayList<Piatto> getPiatti() {
        //get per ottenere i vari piatti inizializzati
        return piatti;
    }

    public void stampaMenu() {
        //Stampa menu
        int count = 0;
        for (Piatto piatto : piatti) {
            System.out.println(count + ". " + piatto);
            count++;
        }

    }

}
