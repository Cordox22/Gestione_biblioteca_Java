/**
 * La classe {@code MainView} rappresenta la vista del pattern MVC e gestisce
 * l'interazione con l'utente tramite console.
 *
 * <p>Si occupa di mostrare il menu, leggere le informazioni inserite e
 * stampare i messaggi di errore e i prestiti.</p>
 */
public class MainView {
    static Scanner input = new Scanner(System.in);

    /**
     * Legge un valore inserito dall'utente tramite la console.
     *
     * @param s messaggio visualizzato prima della lettura
     * @return testo inserito dall'utente
     */
    public String inserimentoDati(String s){
        String n;

        System.out.print(s);
        n = MainView.input.nextLine();

        return n;
    }

    /**
     * Mostra il menu principale e restituisce la scelta dell'utente.
     *
     * @return scelta dell'utente come stringa
     */
    public String scelta(){
        String scelta;

        System.out.println("\nPremi 1 per inserire uno o piu' prestiti");
        System.out.println("Premi 2 per visualizzare i prestiti");
        System.out.println("Premi 3 per visualizzare un prestito in base al Cognome dello studente, o titolo del libro");
        System.out.println("Premi 4 per eliminare il primo prestito dell'elenco");
        System.out.println("Premi 5 per uscire");
        System.out.print("Scelta: ");
        scelta = MainView.input.nextLine();

        return scelta;
    }

    /**
     * Stampa un messaggio di errore o informativo sul terminale.
     *
     * @param s testo da mostrare
     */
    public void messaggioErrore(String s){
        System.out.println(s);
    }

    /**
     * Visualizza la lista dei prestiti passata come parametro.
     *
     * @param pres elenco di prestiti da stampare
     */
    public void visualizza_prestiti(List<Prestito> pres){
        System.out.println();
        for(Prestito p : pres){
            System.out.println(p);
        }
    }
}
