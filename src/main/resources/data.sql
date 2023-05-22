INSERT INTO ZANR (naziv) VALUES ('Horor');
INSERT INTO ZANR (naziv) VALUES ('Triler');
INSERT INTO ZANR (naziv) VALUES ('Romantika');
INSERT INTO ZANR (naziv) VALUES ('Kuvar');
INSERT INTO ZANR (naziv) VALUES ('Komedija');
INSERT INTO ZANR (naziv) VALUES ('Biografija');
INSERT INTO ZANR (naziv) VALUES ('Naucna fantastika');
INSERT INTO ZANR (naziv) VALUES ('Psiholoski');
INSERT INTO ZANR (naziv) VALUES ('Poezija');

INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('na cekanju');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odobren');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odbijen');

INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('It', 'putanja_do_slike', '9780450411434', '1986-09-15', 1138, 'It desc', 1, 4.25);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Carrie', 'putanja_do_slike', '9781416524304', '1974-04-05', 272, 'Carrie desc', 1, 3.98);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Milk and Honey', 'putanja_do_slike', '9781449496364', '2014-11-04', 226, 'Milk and oney desc', 9, 4.00);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Sun and Her Flowers', 'putanja_do_slike', '9781449486792', '2017-10-03', 256, 'The Sun and Her Flowers desc', 9, 4.11);

INSERT INTO ULOGA (naziv) VALUES ('citalac');
INSERT INTO ULOGA (naziv) VALUES ('autor');
INSERT INTO ULOGA (naziv) VALUES ('administrator');

INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('CITALAC', 'Petar', 'Markovic');
INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('CITALAC', 'Anja', 'Vasic');
INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('CITALAC', 'Mara', 'Jankovic');
INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('AUTOR', 'Stephen', 'King');
INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('AUTOR', 'Rupi', 'Kaur');
INSERT INTO KORISNIK (dtype, ime, prezime) VALUES ('ADMINISTRATOR', 'Vasilije', 'Panic');
