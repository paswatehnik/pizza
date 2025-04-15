# Telepņevs Pica

Java lietotne ar grafisko saskarni, kas ļauj lietotājiem pasūtīt picas, pievienot dzērienus, izveidot savu pielāgoto picu un saglabāt pasūtījumus failā.

---

## Funkcionalitāte

- Gatavo picu izvēle no saraksta
- Iespēja izveidot savu "Pašizveidotu picu"
- Dzērienu pievienošana pasūtījumam
- Pasūtījuma apstiprināšana un saglabāšana
- Pasūtījumu vēstures apskate
- Pasutijuma uglabāšana failā `pasutijumi.txt`

---

## Projeka struktūra

Telenpevs_pica/               
├── pictures/                 //mape kur glabas visi atteli
│   ├──...                    //atteli
├── src/
│   ├── dzerieni.java         // Dzeriena objekta apraksts
│   ├── picerijaa.java        // Galvenā GUI klase
│   ├── order.java            // Pasūtījuma loģika un dati
│   ├── faili.java            // Pasūtījumu saglabāšana un nolasīšana no faila
│   ├── pica.java             // Picas objekta apraksts
│   └── pircejs.java          // Pirceja dati
├── pasutijumi.txt           // Saglabātie pasūtījumi
└── README.md                // Projekta apraksts
