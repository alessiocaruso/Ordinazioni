import java.util.ArrayList;
import java.util.Scanner;

public class Autenticazione {
    public ArrayList<String> username = new ArrayList<>();
    public ArrayList<String> password = new ArrayList<>();

    public String currentUser;

    public void registration() {
        // Registrazione
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un nuovo username");
        String usernameString = scanner.nextLine();
        System.out.println("Inserisci una password");
        String passwordString = scanner.nextLine();
        if (username.contains(usernameString)) {
            // Se esiste già un utente con quell'username la registrazione fallirà
            System.out.println("Username già in uso. Registrazione fallita.");
            return;
        }

        username.add(usernameString);
        password.add(passwordString);
    }

    public int verify() {
        // Verifica per il login
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Inserisci il tuo username");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci la tua password");
        String passwordVerify = scanner.nextLine();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && currentPassword.equals(passwordVerify)) {
                // Se le credenziali sono giuste l'utente potrà accedere e impostiamo la
                // booleana a true
                System.out.println("ACCESSO CONSENTITO");
                isValid = true;
                // Salviamo il nome dell'User perchè ci servirà per il database
                currentUser = currentUsername;
                break;
            }
        }
        if (isValid) {
            // Se l'utente si logga ritorniamo il valore 1, altrimenti 0
            return 1;
        } else {
            return 0;
        }
    }

    public void deleteUser() {
        // Verifica per il login
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Inserisci username che vuoi eliminare");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci PIN segreto per l'accesso alla rimozione dell'utente");
        int pinVerify = scannerInt.nextInt();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && pinVerify == 1234) {
                // Se le credenziali sono giuste l'utente potrà accedere e impostiamo la
                // booleana a true
                System.out.println("ACCESSO CONSENTITO");
                // Salviamo il nome dell'User perchè ci servirà per il database
                username.remove(currentUsername);
                password.remove(currentPassword);
                System.out.println("Utente eliminato correttamente");
                break;
            } else if (!currentUsername.equals(usernameVerify) || pinVerify != 1234) {
                System.out.println("ACCESSO NEGATO");

                break;
            }
        }
    }

    public void modifyUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo username");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci la tua password");
        String passwordVerify = scanner.nextLine();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && currentPassword.equals(passwordVerify)) {
                // Se le credenziali sono giuste l'utente potrà accedere e impostiamo la
                // booleana a true
                System.out.println("ACCESSO CONSENTITO");
                System.out.println("Inserisci il nuovo username");
                String newUsername = scanner.nextLine();
                username.set(i, newUsername);
                currentUser = currentUsername;
                System.out.println("Username aggiunto correttamente");
                break;
            } else {
                System.out.println("Accesso non consentito");
                break;
            }
        }

    }

    public void readUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci PIN segreto per la visualizzazione della lista di utenti registrati");
        int pinVerify = scanner.nextInt();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        if (pinVerify == 1234) {
            System.out.println("Accesso consentito");

            for (int i = 0; i < username.size(); i++) {
                String currentUsername = username.get(i);
                System.out.println("Username: " + i + ": " + currentUsername);

            }
        } else {
            System.out.println("Accesso non consentito");

        }
    }

    public void menuAutenticazione() {
        int scelta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cosa vuoi fare?:");
        System.out.println("1. Registrazione");
        System.out.println("2. Login");
        System.out.println("3. Elimina user");
        System.out.println("4. Modifica username");
        System.out.println("5. Visualizza lista utenti");
        System.out.println("6. Uscire");
        System.out.print("Seleziona un'opzione: ");
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                registration();
                System.out.println("LOGIN:");
                verify();
                break;
            case 2:
                verify();
                break;
            case 3:
                deleteUser();
                System.out.println("Procedere alla registrazione o al login?");
                System.out.println("1. Registrazione");
                System.out.println("2. Login");
                int sceltaLog = scanner.nextInt();
                if (sceltaLog == 1) {
                    registration();
                } else if (sceltaLog == 2) {
                    verify();
                }
                break;
            case 4:
                modifyUser();
                System.out.println("Procedere alla registrazione o al login?");
                System.out.println("1. Registrazione");
                System.out.println("2. Login");
                sceltaLog = scanner.nextInt();
                if (sceltaLog == 1) {
                    registration();
                } else if (sceltaLog == 2) {
                    verify();
                }
                break;
            case 5:
                readUser();
                System.out.println("Procedere alla registrazione o al login?");
                System.out.println("1. Registrazione");
                System.out.println("2. Login");
                sceltaLog = scanner.nextInt();
                if (sceltaLog == 1) {
                    registration();
                } else if (sceltaLog == 2) {
                    verify();
                }
                break;

            case 6:
                System.out.println("Grazie per aver usato la nostra app!");
                System.exit(0);

            default:
                System.out.println("Scelta non valida");
                break;
        }

    }
}
