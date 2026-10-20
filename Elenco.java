/**
 * La classe {@code Elenco} gestisce la collezione di prestiti della biblioteca
 * in memoria.
 *
 * <p>Rappresenta il modello applicativo del dominio: mantiene la lista dei
 * prestiti, assegna identificatori univoci e implementa le operazioni di
 * inserimento, ricerca, ordinamento e rimozione.</p>
 */
public class Elenco {
    private List<Prestito> prestiti;
    private Set<Integer> ids;

    /**
     * Crea un nuovo elenco vuoto di prestiti.
     */
    public Elenco(){
        this.prestiti = new ArrayList<>();
        this.ids = new HashSet<>();
    }

    /**
     * Inserisce un nuovo prestito nella collezione.
     *
     * @param titolo titolo del libro o materiale
     * @param data data del prestito
     * @param tipologiaPrestito tipologia del prestito
     * @param nome nome dello studente
     * @param cognome cognome dello studente
     * @param matricola matricola dello studente
     */
    public void inserisci_prestito(String titolo, String data, String tipologiaPrestito, String nome, String cognome, int matricola){
        int id = this.generaId();
        this.prestiti.add(new Prestito(id, titolo, data, tipologiaPrestito, nome, cognome, matricola));
    }

    /**
     * Genera un identificativo univoco per il prestito.
     *
     * @return un id numerico univoco
     */
    private int generaId(){
        int id;

        do{
            id = (int) (Math.random() * 9000) + 1000;
        }while(this.ids.contains(id));
        this.ids.add(id);

        return id;
    }

    /**
     * Cerca i prestiti aventi il cognome dello studente o il titolo del libro
     * corrispondenti alla stringa di ricerca.
     *
     * @param cerca testo da utilizzare per la ricerca
     * @return lista dei prestiti trovati
     */
    public List<Prestito> trova_prestito(String cerca){
        List<Prestito> studenti = new ArrayList<>();

        for(Prestito p : this.prestiti){
            if((p.cognomeStudente().equalsIgnoreCase(cerca)) || (p.titolo().equalsIgnoreCase(cerca))){
                studenti.add(p);
            }
        }

        return studenti;
    }

    /**
     * Ordina la collezione dei prestiti in base all'implementazione di
     * {@link Prestito#compareTo(Prestito)}.
     *
     * @return la lista dei prestiti ordinata
     */
    public List<Prestito> ordinamento(){
        this.prestiti.sort(null);

        return this.prestiti;
    }

    /**
     * Elimina il primo prestito presente nella lista specificata.
     *
     * @param prestiti lista di prestiti su cui eseguire la rimozione
     */
    public void elimina_prestito(List<Prestito> prestiti){
        if(!prestiti.isEmpty()){
            prestiti.remove(0);
        }
    }

    /**
     * Restituisce la collezione completa dei prestiti.
     *
     * @return lista di prestiti attualmente in memoria
     */
    public List<Prestito> getPrestiti(){
        return this.prestiti;
    }

    /**
     * Popola il sistema con un set iniziale di dati di esempio per verificare
     * il funzionamento dell'applicazione.
     */
    public void caricaDati(){
        inserisci_prestito("Il nome della rosa", "2024-01-15", "Libro", "Marco", "Rossi", 123456);
        inserisci_prestito("1984", "2024-01-18", "Libro", "Giulia", "Bianchi", 123457);
        inserisci_prestito("National Geographic - Marzo 2024", "2024-02-02", "Rivista", "Luca", "Verdi", 123458);
        inserisci_prestito("Il signore degli Anelli", "2024-02-05", "Libro", "Sara", "Ferrari", 123459);
        inserisci_prestito("Inception", "2024-02-10", "DVD", "Andrea", "Rossi", 123460);
        inserisci_prestito("Cent'anni di solitudine", "2024-02-14", "Libro", "Chiara", "Ricci", 123461);
        inserisci_prestito("Focus - Aprile 2024", "2024-02-20", "Rivista", "Davide", "Marino", 123462);
        inserisci_prestito("Harry Potter e la pietra filosofale", "2024-03-01", "Libro", "Elisa", "Greco", 123463);
        inserisci_prestito("Interstellar", "2024-03-05", "DVD", "Francesco", "Bruno", 123464);
        inserisci_prestito("Se questo e' un uomo", "2024-03-10", "Libro", "Martina", "Galli", 123465);
    }
}
