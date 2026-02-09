# Portofoliu Dezvoltare Java

Acest repository conține o colecție de proiecte Java , care demonstrează competențe în Programare Orientată pe Obiecte (OOP), Structuri de Date, Algoritmi, lucru cu Fișiere (I/O) și Rețelistică.

## Prezentare Proiecte

### 1. VehicleManagementSystem (Sistem de Gestiune Flotă Auto)
Un sistem complet pentru administrarea unei flote de vehicule.
- **Funcționalități Cheie**: Utilizează Generics pentru gestionarea flotei, Moștenire pentru tipurile de vehicule (Autobuz, Camion, Mașină) și Interfețe pentru comportamente specifice.
- **Tehnologii**: Java Core, OOP, Generics.

### 2. LibraryManagementSystem (Sistem de Bibliotecă)
O aplicație pentru gestionarea operațiunilor dintr-o bibliotecă, incluzând autori, cărți și împrumuturi.
- **Funcționalități Cheie**:
    - Modelare complexă a datelor (Cărți legate de Autori).
    - Urmărirea împrumuturilor folosind `LocalDate`.
    - Utilizare extensivă a **Java Streams** pentru filtrare și rapoarte.
- **Tehnologii**: Java 8+ Streams, Date/Time API.

### 3. ProjectCostsManager (Manager Costuri Proiect)
Un instrument financiar pentru urmărirea cheltuielilor pe proiecte.
- **Funcționalități Cheie**:
    - Citește și parsează date despre proiecte și cheltuieli din fișiere text.
    - Calculează costurile totale și generează sumare financiare.
    - Demonstrează concepte de programare funcțională.
- **Tehnologii**: Java IO, Interfețe Funcționale.

### 4. BookStatisticsApp (Analiză Statistică Cărți)
Un instrument analitic pentru procesarea metadatelor despre cărți.
- **Funcționalități Cheie**:
    - Colectori avansați (Stream Collectors) pentru grupare și analiză statistică.
    - Generează rapoarte despre numărul de pagini și distribuția autorilor.
- **Tehnologii**: Java Streams, Collectors.

### 5. AutoServiceSystem (Sistem Service Auto Client-Server)
O aplicație client-server pentru un centru de service auto.
- **Funcționalități Cheie**:
    - **Arhitectură Client-Server**: Comunicare prin socket-uri TCP/IP.
    - **Procesare Date**: Gestionează fișiere JSON pentru jurnale de service și Text pentru inventar.
    - **Raportare**: Generează automat rapoarte de cost.
- **Tehnologii**: Java Networking (Sockets), Procesare JSON, File I/O.

### 6. DataPersistencyHub (Centru de Persistență Date)
O demonstrație a capacităților de persistență și schimb de date.
- **Funcționalități Cheie**:
    - Citește/Scrie date în formate **SQL (SQLite)**, **XML**, **JSON**, **Binar** și **Text**.
    - Arată versatilitatea în manipularea diferitelor mecanisme de stocare.
- **Tehnologii**: JDBC, DOM Parser, Fluxuri Binare.

### 7. PersonnelActivityManager (Manager Activitate Personal)
Un sistem de gestionare a resurselor pentru urmărirea activităților personalului și a costurilor.
- **Funcționalități Cheie**:
    - Corelează datele angajaților cu jurnalele de activitate.
    - Calculează eficiența și costurile totale per angajat.
    - Exportă rapoarte detaliate.
- **Tehnologii**: Java Streams, Parsare Fișiere.

## Instalare și Rulare
Fiecare proiect se află în propriul director. Se pot importa individual în IntelliJ IDEA sau Eclipse ca proiecte Java standard.
