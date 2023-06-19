import java.util.ArrayList;
import java.util.Scanner;

public class Ordinazione extends Menu {
    private double prezzoTotale = 0;
    ArrayList<Piatto> ordineTotale;

    // Operazioni set e get
    public double getPrezzoTotale() {
        return this.prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public ArrayList<Piatto> getOrdineTotale() {
        return this.ordineTotale;
    }

    public void setOrdineTotale(ArrayList<Piatto> ordineTotale) {
        this.ordineTotale = ordineTotale;
    }

    public Ordinazione() {
        ordineTotale = new ArrayList<>();
    }

    public void effettuaOrdine() {
        boolean volontaOrdine = false;
        Menu menu = new Menu();
        menu.inizializza();
        do {
            Scanner scanner = new Scanner(System.in);
            //Scelta del piatto
            int scelta = scanner.nextInt();
            ArrayList<Piatto> piatti = menu.getPiatti();
            Piatto piattoScelto = piatti.get(scelta);

            //Aggiunta del piatto scelto all'ordine totale
            ordineTotale.add(piattoScelto);

            prezzoTotale += piattoScelto.getPrezzo(); // Aggiunta del prezzo del piatto al prezzo totale
            System.out.println("Carrello attuale: " + prezzoTotale);
            System.out.println("Vuoi aggiungere altro?");
            System.out.println("1. Si");
            System.out.println("2. No");
            scelta = scanner.nextInt();
            if (scelta == 1) {
                volontaOrdine = true;
                menu.stampaMenu();
            } else if (scelta == 2) {
                volontaOrdine = false;
            }
        } while (volontaOrdine != false);

    }

    public void stampaOrdine() {
        for (int i = 0; i < ordineTotale.size(); i++) {
            System.out.println("Piatto " + i + ": " + ordineTotale.get(i));
        }
        System.out.println("Totale: " + prezzoTotale + " euro");
    }
}
