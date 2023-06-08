/*Zanrovi*/
INSERT INTO ZANR (naziv) VALUES ('Horor');
INSERT INTO ZANR (naziv) VALUES ('Triler');
INSERT INTO ZANR (naziv) VALUES ('Romantika');
INSERT INTO ZANR (naziv) VALUES ('Kuvar');
INSERT INTO ZANR (naziv) VALUES ('Komedija');
INSERT INTO ZANR (naziv) VALUES ('Biografija');
INSERT INTO ZANR (naziv) VALUES ('Naucna fantastika');
INSERT INTO ZANR (naziv) VALUES ('Psiholoski');
INSERT INTO ZANR (naziv) VALUES ('Poezija');

/*Statusi aktivacije*/
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('na cekanju');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odobren');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odbijen');

/*Knjige*/
    /*Horor*/
        /*Stephen King*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('It', 'putanja_do_slike', '9780450411434', '1986-09-15', 1138, 'It desc', 1, 4.25);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Carrie', 'putanja_do_slike', '9781416524304', '1974-04-05', 272, 'Carrie desc', 1, 3.98);

    /*Triler*/

    /*Romantika*/

    /*Kuvar*/
        /*Julia Child*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Mastering the Art of French Cooking', 'putanja_do_slike', '9780375413407', '2001-10-16', 684, 'Mastering the Art of French Cooking desc', 4, 4.23);
        /*Gabriela Camara*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('My Mexico City Kitchen: Recipes and Convictions', 'putanja_do_slike', '9780399580574', '2019-04-30', 363, 'My Mexico City Kitchen: Recipes and Convictions desc', 9, 4.21);

    /*Komedija*/

    /*Biografija*/

    /*Naucna fantastika*/

    /*Psihologija*/
        /*Daniel Kahneman*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Thinking, Fast and Slow', 'putanja_do_slike', '9780374275631', '2011-10-25', 499, 'Thinking, Fast and Slow desc', 8, 4.2);
        /*Daniel Goleman*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Emotional Intelligence', 'putanja_do_slike', '9780553804911', '2006-09-26', 352, 'Emotional Intelligence desc', 8, 4.04);
        /*Barry Schwartz*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Paradox of Choice: Why More Is Less', 'putanja_do_slike', '9780060005696', '2005-01-18', 265, 'The Paradox of Choice: Why More Is Less desc', 8, 3.84);

/*Poezija*/
        /*Rupi Kaur*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Milk and Honey', 'putanja_do_slike', '9781449496364', '2014-11-04', 226, 'Milk and oney desc', 9, 4.00);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Sun and Her Flowers', 'putanja_do_slike', '9781449486792', '2017-10-03', 256, 'The Sun and Her Flowers desc', 9, 4.11);

/*Police*/

/*Stavke police*/

/*Zahtevi aktivacije autora*/

/*Recenzije*/

/*Uloge*/
INSERT INTO ULOGA (naziv) VALUES ('citalac');
INSERT INTO ULOGA (naziv) VALUES ('autor');
INSERT INTO ULOGA (naziv) VALUES ('administrator');

/*Korisnici*/
    /*Citaoci*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('CITALAC', '2000-07-05', 'petar.markovic@gmail.com', 'Petar', 'Markovic', 'petar.markovic00', 'sifra1234!', 1);
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('CITALAC', '1998-08-25', 'vasic.98@gmail.com', 'Anja', 'Vasic', 'anja.vasic98', 'sifra1234!', 1);
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('CITALAC', '2002-01-12', 'mara.j@yahoo.com', 'Mara', 'Jankovic', 'mara.jankovic02', 'sifra1234!', 1);

    /*Autori*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('AUTOR', '1947-09-21', 'stephen.king.author@gmail.com', 'Stephen', 'King', 'stephen.king47', 'sifra1234!', 2);
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('AUTOR', '1992-10-04', 'authorrupikaur@gmail.com', 'Rupi', 'Kaur', 'rupi.kaur92', 'sifra1234!', 2);

    /*Administratori*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga_id) VALUES ('ADMINISTRATOR', '2000-04-15', 'panic.vaso@yahoo.com', 'Vasilije', 'Panic', 'vasilije.panic00', 'sifra1234!', 3);
