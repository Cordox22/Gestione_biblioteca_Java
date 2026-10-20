# Gestione biblioteca Java

## Descrizione del progetto
Il progetto `Gestione_biblioteca_Java` è un'applicazione Java console che gestisce i prestiti di libri e altri materiali di una biblioteca scolastica o universitaria, seguendo il pattern MVC (Model-View-Controller). L'applicazione permette all'utente di inserire prestiti, visualizzarli, cercarli e rimuovere il primo elemento dell'elenco.

## Obiettivi
- Gestire in modo semplice i prestiti di libri e materiali della biblioteca.
- Applicare la separazione delle responsabilità tra modello, vista e controller.
- Dedicare l'interazione utente a un'interfaccia testuale basata su `Scanner`.
- Dimostrare la logica del dominio in Java, con collezioni, confronto e ricerca.
- Fornire un esempio didattico di architettura MVC in ambiente Java standard.

## Funzionalità principali
- Inserimento di uno o più prestiti.
- Visualizzazione ordinata dei prestiti per titolo e cognome studente.
- Ricerca di prestiti per cognome dello studente o titolo del libro.
- Eliminazione del primo prestito dall'elenco.
- Menu interattivo su console.

## Architettura
Il progetto è strutturato in tre componenti principali:
- `Model`: `Prestito`, `Elenco`.
- `View`: `MainView`.
- `Controller`: `Controller`.

## Struttura del repository
- `pom.xml` – configurazione Maven del progetto.
- `src/` – classi Java dell'applicazione.
- `README.md` – documentazione introduttiva.
- `DOCUMENTAZIONE.md` – analisi tecnica dettagliata.
- `.gitignore` – configurazioni di esclusione per Java e tool di sviluppo.

## Requisiti
- Java JDK 26 (specificato in `pom.xml`)
- Maven
- Terminale o IDE Java (IntelliJ IDEA, Eclipse, NetBeans)

## Esecuzione
1. Aprire il progetto in un IDE Java o dalla riga di comando.
2. Eseguire il comando:
   ```bash
   mvn clean compile exec:java
   ```
3. Usare il menu console per operare sul sistema di gestione prestiti.

## CRUD implementato
- Create: inserimento di nuovi prestiti.
- Read: recupero e visualizzazione dei prestiti, ricerca per titolo/cognome.
- Update: non implementato esplicitamente nel codice corrente.
- Delete: rimozione del primo prestito dall'elenco.

## Competenze dimostrate
- Architettura MVC in Java.
- Progettazione di classi di dominio e collezioni.
- Gestione di flussi di interazione utente tramite console.
- Confronto e ordinamento di oggetti Java.
- Utilizzo di `record` e `List`/`Set` Java standard.
- Documentazione tecnica e portabilità Maven.

## Note
Il progetto non usa database esterno, file di persistenza o dipendenze aggiuntive. Tutti i dati sono gestiti in memoria durante l'esecuzione del programma.
