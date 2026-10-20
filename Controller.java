/**
 * La classe {@code Controller} coordina le interazioni tra la vista e il modello
 * del sistema di gestione dei prestiti della biblioteca.
 *
 * <p>Implementa il ruolo di controller nel pattern MVC: riceve le scelte
 * dell'utente dalla console, invoca le operazioni del modello e presenta i
 * risultati tramite la vista.</p>
 */
public class Controller {

    private MainView mv;
    private Elenco e;

    /**
     * Costruisce un nuovo controller inizializzando la vista e il modello.
     */
    public Controller() {
        this.mv = new MainView();
        this.e = new Elenco();
    }

    /**
     * Avvia il ciclo principale dell'applicazione e gestisce il menu della
     * biblioteca.
     */
    public void avvia(){
        int  scelta;
        String scel;
        this.e.caricaDati();
        do{
            try{
                scel = this.mv.scelta();
                scelta = Integer.parseInt(scel);
            }
            catch(IllegalArgumentException e){
                scelta = -1;
                this.mv.messaggioErrore("\nInserire una scelta valida\n");
            }

            if(scelta != -1){
                switch (scelta) {
                    case 1 -> {
                        String num;
                        int numero;
                        num = this.mv.inserimentoDati("\nInserisci il numero di prestiti da inserire: ");
                        try{
                            numero = Integer.parseInt(num);
                            for(int i = 0; i < numero; i++){
                                String titolo = null, data = null, tipologiaPrestito, nome = null, cognome = null, mat;
                                int matricolaStudente;

                                while((titolo == null) || (titolo.isEmpty())){
                                    titolo = this.mv.inserimentoDati("\nInserisci il titolo del libro: ");
                                }

                                boolean flag = true;
                                while((data == null) || (data.isEmpty() || (flag))){
                                    data = this.mv.inserimentoDati("Inserisci la data del prestito: ");
                                    if(data.isEmpty()){
                                        this.mv.messaggioErrore("La data non deve essere vuota");
                                    }
                                    else if((data.indexOf('-') != 2) && (data.lastIndexOf('-') != 5)){
                                        flag = true;
                                        this.mv.messaggioErrore("Usare il formato dd-MM-yyyy");
                                    }
                                    else{
                                        flag = false;
                                    }
                                }

                                do{
                                    tipologiaPrestito = this.mv.inserimentoDati("Inserisci la tipologia del prestito(semestrale/annuale): ");
                                }while(!((tipologiaPrestito.equalsIgnoreCase("semestrale")) || (tipologiaPrestito.equalsIgnoreCase("annuale"))));

                                while((nome == null) || (nome.isEmpty())){
                                    nome = this.mv.inserimentoDati("Inserisci il nome dello studente: ");
                                }

                                while((cognome == null) || (cognome.isEmpty())){
                                    cognome = this.mv.inserimentoDati("Inserisci il cognome dello studente: ");
                                }

                                do{
                                    matricolaStudente = -1;
                                    mat = this.mv.inserimentoDati("Inserisci la matricola dello studente: ");
                                    try{
                                        matricolaStudente = Integer.parseInt(mat);
                                    }
                                    catch(NumberFormatException e){
                                        this.mv.messaggioErrore("Inserire la matricola in formato numerico");
                                    }
                                }while(matricolaStudente != -1);

                                this.e.inserisci_prestito(titolo, data, tipologiaPrestito, nome, cognome, matricolaStudente);
                                System.out.println("Prestito inserito correttamente\n");
                            }
                        }
                        catch(NumberFormatException e){
                            this.mv.messaggioErrore("\nInserire un numero valido");
                        }
                    }
                    case 2 -> {
                        List<Prestito> prestiti = this.e.ordinamento();
                        this.mv.visualizza_prestiti(prestiti);
                    }
                    case 3 -> {
                        String cerca = this.mv.inserimentoDati("\nInserisci il Cognome dello Studente,"
                            + " o il Titolo del libro per trovare un prestito: ");
                        List<Prestito> studenti = this.e.trova_prestito(cerca);
                        if(studenti.isEmpty()){
                            this.mv.messaggioErrore("\nUtente non trovato");
                        }
                        else{
                            this.mv.visualizza_prestiti(studenti);
                        }
                    }
                    case 4 -> {
                        List<Prestito> prestiti = this.e.ordinamento();
                        this.e.elimina_prestito(prestiti);
                        this.mv.visualizza_prestiti(prestiti);
                    }
                    case 5 -> {
                        this.mv.messaggioErrore("\nArrivederci");
                    }
                    default -> {
                        this.mv.messaggioErrore("\nScelta non riconosciuta");
                    }
                }
            }
        }while(scelta != 0);
    }
}
