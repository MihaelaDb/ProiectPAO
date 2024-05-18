CREATE DATABASE `proiect` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

DROP TABLE IF EXISTS curs_valutar, card, client, cont_bancar, cont_economii, schimb_valutar;

CREATE TABLE IF NOT EXISTS curs_valutar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valuta_baza VARCHAR(255) NOT NULL,
    valuta_cotata VARCHAR(255) NOT NULL,
    rata_schimb DOUBLE NOT NULL,
    data_actualizare DATETIME NOT NULL,
    cod_valutar VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numar_card VARCHAR(30) NOT NULL,
    cvv VARCHAR(20) NOT NULL,
    data_expirarii DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nume VARCHAR(255) NOT NULL,
    prenume VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefon VARCHAR(20) NOT NULL,
    data_nasterii DATE NOT NULL,
    adresa VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS cont_bancar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    iban VARCHAR(255) NOT NULL,
    swift VARCHAR(255) NOT NULL,
    sold DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS cont_economii (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_inceput DATE NOT NULL,
    data_finalizare DATE NOT NULL,
    dobanda DOUBLE NOT NULL,
    suma DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS schimb_valutar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    suma DOUBLE NOT NULL,
    suma_schimbata DOUBLE
);

INSERT INTO curs_valutar (valuta_baza, valuta_cotata, rata_schimb, data_actualizare, cod_valutar) VALUES
('RON', 'EUR', 4.94, '2024-05-18 00:00:00', 'EUR'),
('RON', 'USD', 4.11, '2024-05-18 00:00:00', 'USD'),
('RON', 'GBP', 5.80, '2024-05-18 00:00:00', 'GBP');

INSERT INTO card (numar_card, cvv, data_expirarii) VALUES
('1234-5678-9012-3456', '123', '2024-12-31'),
('9876-5432-1098-7654', '456', '2025-06-30');

INSERT INTO client (nume, prenume, email, telefon, data_nasterii, adresa) VALUES
('Dobromirescu', 'Mihaela', 'mihaelau@example.com', '0721234567', '1980-05-15', 'Str. Libertatii, nr. 1, Bucuresti'),
('Ionescu', 'Maria', 'maria@example.com', '0727654321', '1990-10-25', 'Str. Independentei, nr. 2, Cluj-Napoca');

INSERT INTO cont_bancar (iban, swift, sold) VALUES
('RO49AAAA1B31007593840000', 'BUCUROBU', 1500.75),
('RO49AAAA1B31007593840001', 'BUCUROBU', 3000.50);

INSERT INTO cont_economii (data_inceput, data_finalizare, dobanda, suma)  VALUES
('2024-01-01', '2025-01-01', 4, 10000.00),
('2024-06-01', '2026-06-01', 3.0, 5000.00);

INSERT INTO schimb_valutar (suma, suma_schimbata) VALUES
(1000.00, 202.50),
(2000.00, 437.00);
