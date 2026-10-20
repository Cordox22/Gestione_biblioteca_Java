# DOCUMENTAZIONE TECNICA - Gestione biblioteca Java

## 1. Panoramica del progetto

Il repository `Cordox22/Gestione_biblioteca_Java` contiene un'applicazione Java console per la gestione dei prestiti di libri e materiali della biblioteca, organizzata secondo il pattern MVC (Model-View-Controller).

Il sistema permette di:
- inserire nuovi prestiti;
- visualizzare l'elenco dei prestiti;
- cercare prestiti per titolo del libro o cognome dello studente;
- eliminare il primo prestito presente nell'elenco;
- interagire con un menu testuale a riga di comando.

La logica applicativa è implementata in Java standard, senza framework esterni, con un uso minimale di Maven per la definizione del progetto e dell'esecuzione principale.

## 2. Descrizione professionale del repository

Questo repository rappresenta una soluzione didattica e pratica per la gestione dei prestiti in una biblioteca, costruita in Java con architettura MVC. Il progetto dimostra la separazione delle responsabilità tra dominio applicativo, logica di presentazione e coordinamento delle operazioni. È utile come esempio di sviluppo Java console, gestione delle collezioni, interazioni utente, uso di `record` e progettazione orientata agli oggetti.

## 3. Obiettivi del sistema

- Gestire in memoria un elenco di prestiti di libri e materiali.
- Rendere l'interazione semplice e coerente tramite una vista console.
- Mantenere la logica di business separata dall'interfaccia utente.
- Applicare la modellazione di un dominio realistico usando classi e dati.
- Dimostrare concetti fondamentali di Java e programmazione ad oggetti.

## 4. Struttura del progetto

Il repository contiene i seguenti file principali:

- `pom.xml` – configurazione del progetto Maven.
- `Controller.java` – controller dell'applicazione.
- `Elenco.java` – modello della raccolta e logica di business.
- `MainView.java` – componente di interfaccia utente.
- `Prestito.java` – modello del singolo prestito.
- `Esame10_12_2025.java` – classe principale con metodo `main`.
- `README.md` – sintesi del progetto.
- `DOCUMENTAZIONE.md` – documentazione tecnica completa.
- `.gitignore` – file di esclusione del repository.

## 5. Analisi dettagliata delle classi

### 5.1 `Esame10_12_2025`
Questa è la classe di bootstrap del programma.

Responsabilità:
- creare un'istanza di `Controller`;
- avviare il ciclo applicativo tramite `c.avvia()`.

Funzione principale:
- `main(String[] args)`

### 5.2 `Controller`
La classe `Controller` è il punto di coordinamento tra la vista e il modello.

Responsabilità:
- inizializzare `MainView` e `Elenco`;
- caricare i dati iniziali;
- leggere la scelta dell'utente;
- invocare le operazioni del modello;
- mostrare i risultati tramite la vista.

Flusso principale:
- `new MainView()`
- `new Elenco()`
- `e.caricaDati()`
- `do...while` per il menu

Le operazioni disponibili dal menu sono:
1. Inserimento di uno o più prestiti
2. Visualizzazione dei prestiti
3. Ricerca per cognome o titolo
4. Eliminazione del primo prestito
5. Uscita

### 5.3 `MainView`
La vista gestisce tutte le comunicazioni testuali con l'utente.

Responsabilità:
- mostrare il menu;
- leggere input da console;
- stampare messaggi di errore;
- visualizzare la lista dei prestiti.

Metodi pubblici:
- `String inserimentoDati(String s)`
- `String scelta()`
- `void messaggioErrore(String s)`
- `void visualizza_prestiti(List<Prestito> pres)`

### 5.4 `Prestito`
La classe `Prestito` rappresenta il dominio del prestito bibliotecario.

Attributi del record:
- `id`
- `titolo`
- `dataPrestito`
- `tipologia`
- `nomeStudente`
- `cognomeStudente`
- `matricolaStudente`

Metodi principali:
- `compareTo(Prestito p)`
- `toString()`

Il record implementa `Comparable<Prestito>`, quindi è confrontabile in base a:
1. titolo;
2. cognome dello studente in caso di titolo uguale.

### 5.5 `Elenco`
La classe `Elenco` rappresenta il modello applicativo del sistema di gestione prestiti.

Responsabilità:
- mantenere un elenco in memoria di prestiti;
- generare identificatori univoci;
- inserire nuovi prestiti;
- ricercare prestiti in base al titolo o al cognome;
- ordinare la collezione;
- eliminare il primo elemento;
- inizializzare un set di dati demo.

Campi:
- `prestiti`: `List<Prestito>`
- `ids`: `Set<Integer>`

## 6. Architettura MVC implementata

L'architettura del progetto segue il pattern MVC in modo classico:

- Model:
  - `Prestito`
  - `Elenco`
- View:
  - `MainView`
- Controller:
  - `Controller`

### 6.1 Ruolo del Model
Il modello contiene la logica di dominio e i dati. In questo progetto, la parte di business è centralizzata in `Elenco`, che gestisce l'insieme di prestiti e le regole di inserimento, ricerca e ordinamento.

### 6.2 Ruolo della View
La vista si occupa esclusivamente di I/O: lettura dei dati inseriti dall'utente e stampa dei messaggi e delle liste. Non contiene logica di business.

### 6.3 Ruolo del Controller
Il controller coordina le interazioni: riceve la scelta del menu, valida alcuni input, richiama le operazioni del modello e restituisce i risultati alla vista.

Questo approccio rende il codice facile da estendere e mantenere, anche se non è presente una separazione completa in package e interfacce multi-layer.

## 7. CRUD implementato

### Create
La funzione `inserisci_prestito(...)` di `Elenco` crea un nuovo oggetto `Prestito` e lo aggiunge alla lista. Ogni prestito riceve un `id` generato casualmente tra `1000` e `9999`, controllando di non duplicare un identificativo già esistente.

### Read
Sono presenti due modalità di lettura:
- `ordinamento()`: restituisce la lista dei prestiti ordinata.
- `trova_prestito(String cerca)`: filtra i prestiti per titolo o cognome.

### Update
Non è presente una funzionalità di aggiornamento esplicita dei prestiti esistenti. Il codice non implementa un metodo `modifica_prestito` o una logica di update del record.

### Delete
La funzione `elimina_prestito(List<Prestito> prestiti)` rimuove il primo elemento della lista passata come parametro. Nella pratica viene usato sul `List<Prestito>` ottenuto da `ordinamento()`, motivo per cui il primo elemento della lista ordinata viene eliminato.

## 8. Flusso dell'applicazione

### 8.1 Avvio
Il programma inizia in `Esame10_12_2025.main()`:
- crea un `Controller`;
- chiama `avvia()`.

### 8.2 Inizializzazione
`Controller.avvia()` esegue:
- `this.e.caricaDati();`
- inizializza rapidamente un set di dati di esempio in memoria.

### 8.3 Menu
La vista mostra un menu con cinque opzioni. L'utente inserisce una scelta tramite `MainView.scelta()`.

### 8.4 Validazione input
Nel controller, il valore inserito viene convertito in `int`.
- Se il parsing non riesce, viene gestita un'eccezione e viene mostrato un messaggio di errore.
- Per il caso di inserimento nuovo prestito, il codice valida anche:
  - titolo non vuoto;
  - data nel formato `dd-MM-yyyy`;
  - tipologia prestito valida (`semestrale` oppure `annuale`);
  - nome e cognome non vuoti;
  - matricola numerica.

### 8.5 Operazioni principali
- Caso 1: inserimento di uno o più prestiti
- Caso 2: visualizzazione dei prestiti
- Caso 3: ricerca per cognome o titolo
- Caso 4: eliminazione del primo prestito
- Caso 5: messaggio di uscita
- Default: scelta non riconosciuta

### 8.6 Ciclo di esecuzione
Il programma mantiene un ciclo `do...while(scelta != 0)`. In pratica, l'uscita dal menu è legata al valore `0`, non all'opzione `5`; l'opzione `5` stampa solo un messaggio di saluto ma non termina automaticamente il ciclo.

## 9. Gestione dei dati e file di configurazione

### 9.1 Persistenza dati
Il progetto non usa database relazionale né database NoSQL. I dati sono gestiti solamente in memoria tramite `ArrayList` e `HashSet`.

### 9.2 File di configurazione
Il file `pom.xml` contiene la configurazione principale del progetto Maven, con:
- `groupId`: `com.mycompany`
- `artifactId`: `esame10_12_2025`
- versione `1.0-SNAPSHOT`
- packaging `jar`
- encoding UTF-8
- JDK target `maven.compiler.release` con valore `26`
- classe principale `com.mycompany.esame10_12_2025.Esame10_12_2025`

### 9.3 Dipendenze
Il progetto non include dipendenze esterne nel `pom.xml`. L'applicazione usa esclusivamente le librerie standard del JDK, in particolare:
- `java.util.List`
- `java.util.ArrayList`
- `java.util.HashSet`
- `java.util.Set`
- `java.util.Scanner`

## 10. Inizializzazione dati di esempio
La classe `Elenco` contiene un metodo `caricaDati()` che inserisce 10 prestiti iniziali per testare facilmente il sistema. Esempi di record popolati:
- "Il nome della rosa"
- "1984"
- "National Geographic - Marzo 2024"
- "Il signore degli Anelli"
- "Inception"
- "Cent'anni di solitudine"
- "Focus - Aprile 2024"
- "Harry Potter e la pietra filosofale"
- "Interstellar"
- "Se questo e' un uomo"

## 11. Validazioni implementate
Nel controller, durante l'inserimento dei dati, vengono controllati i seguenti aspetti:
- campi non vuoti;
- formato data `dd-MM-yyyy`;
- tipologia prestito valida (`semestrale` o `annuale`);
- matricola numerica;
- numero totale di prestiti da inserire numerico.

## 12. Limitazioni e osservazioni

- Non esiste un database vero e proprio.
- Non esiste persistenza tra esecuzioni.
- Non è presente un'operazione di aggiornamento di un prestito.
- L'opzione `5` del menu non termina automaticamente il ciclo, poiché la condizione di uscita controlla `scelta != 0`.
- Il progetto è una soluzione console didattica, non una web app o un'applicazione enterprise.

## 13. Competenze dimostrate per portfolio GitHub

- Progettazione orientata agli oggetti in Java.
- Architettura MVC applicata a un sistema reale di gestione.
- Gestione delle collezioni e delle strutture dati standard.
- Validazione input utente e meccanismi di controllo errore.
- Uso di `record` e comparatori Java.
- Sviluppo di applicazioni console con Maven.
- Documentazione tecnica e manutenzione del codice.

## 14. Conclusione

Questo progetto rappresenta un esempio chiaro e funzionale di gestione di un dominio bibliotecario in Java. La sua forza principale è la chiarezza della separazione tra Model, View e Controller, oltre alla semplicità di utilizzo e alla completezza del flusso applicativo console.

È ideale come base per esercitazioni didattiche, progetti accademici e dimostrazioni di architettura software Java.
