/**
 * Record che rappresenta un prestito bibliotecario.
 *
 * <p>Ogni istanza contiene i dati del prestito e implementa il confronto
 * naturale tra prestiti in base al titolo e poi al cognome dello studente.</p>
 */
public record Prestito(
    int id,
    String titolo,
    String dataPrestito,
    String tipologia,
    String nomeStudente,
    String cognomeStudente,
    int matricolaStudente) implements Comparable<Prestito>{

    /**
     * Confronta questo prestito con un altro prestito.
     *
     * @param p prestito con cui confrontare l'istanza corrente
     * @return un valore negativo, zero o positivo in base all'ordine naturale
     */
    @Override
    public int compareTo(Prestito p){
        int risultato;

        risultato = this.titolo.compareTo(p.titolo);
        if(risultato == 0){
            risultato = this.cognomeStudente.compareTo(p.cognomeStudente);
        }
        return risultato;
    }

    /**
     * Restituisce la rappresentazione testuale del prestito con i dettagli
     * principali.
     *
     * @return stringa formattata con i dati del prestito
     */
    @Override
    public String toString(){
        String s = String.format("ID: %-4d Titolo: %-40s Data: %-10s Tipologia: %-10s Nome: %-10s Cognome: %-10s Matricola: %-6d",
            id(),
            titolo(),
            dataPrestito(),
            tipologia(),
            nomeStudente(),
            cognomeStudente(),
            matricolaStudente()
        );
    return s;
}
}
