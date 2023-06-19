import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Autenticazione contiene il menù per le operazioni CRUD dell'user
        Autenticazione auth = new Autenticazione();
        auth.menuAutenticazione();
        int scelta = 0;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Ordinazione ordine = new Ordinazione();
        menu.inizializza();
        do {
            // Menu
            System.out.println("Cosa vuoi fare?:");
            System.out.println("1. Fai un nuovo ordine");
            System.out.println("2. Stampa il tuo ordine");
            System.out.println("3. Menu autenticazione");
            System.out.println("4. Esci");
            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    // Stampiamo il menu e facciamo fare l'ordine all'utente
                    menu.stampaMenu();
                    System.out.println("Cosa vuoi ordinare? Premi un numero per la scelta!");
                    ordine.effettuaOrdine();
                    break;
                case 2:
                    // Stampiamo ordine che ha effettuato l'utente
                    ordine.stampaOrdine();
                    break;

                case 3:
                    // Stampiamo il menu per l'autenticazione
                    auth.menuAutenticazione();
                    break;
                case 4:
                    System.out.println("Grazie per aver usato la nostra app");
                    return;

                default:
                    System.out.println("Non hai inserito una scelta giusta");
                    break;
            }
        } while (scelta != 7);
    }

}