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


/*Uloge*/
INSERT INTO ULOGA (naziv) VALUES ('citalac');
INSERT INTO ULOGA (naziv) VALUES ('autor');
INSERT INTO ULOGA (naziv) VALUES ('administrator');


/*Korisnici*/
    /*Citaoci*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga) VALUES ('CITALAC', '2000-07-05', 'petar.markovic@gmail.com', 'Petar', 'Markovic', 'petar.markovic00', 'sifra1234!', 'CITALAC');
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga) VALUES ('CITALAC', '1998-08-25', 'vasic.98@gmail.com', 'Anja', 'Vasic', 'anja.vasic98', 'sifra1234!', 'CITALAC');
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga) VALUES ('CITALAC', '2002-01-12', 'mara.j@yahoo.com', 'Mara', 'Jankovic', 'mara.jankovic02', 'sifra1234!', 'CITALAC');
--UPDATE KORISNIK SET dtype = 'CITALAC', datum_rodjenja = '1982-10-15', email = 'mika.miki@gmail.com', korisnicko_ime = 'mika.mikic82', lozinka = 'sifra1234!', uloga_id = 1 WHERE id = 7;

    /*Autori*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga, aktivan) VALUES ('AUTOR', '1947-09-21', 'stephen.king.author@gmail.com', 'Stephen', 'King', 'stephen.king47', 'sifra1234!', 'AUTOR', true);
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga, aktivan) VALUES ('AUTOR', '1992-10-04', 'authorrupikaur@gmail.com', 'Rupi', 'Kaur', 'rupi.kaur92', 'sifra1234!', 'AUTOR', true);
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga, aktivan) VALUES ('AUTOR', '1972-06-04', 'author.joehill@gmail.com', 'Joe', 'Hill', 'joe.hill72', 'sifra1234!', 'AUTOR', false);

    /*Administratori*/
INSERT INTO KORISNIK (dtype, datum_rodjenja, email, ime, prezime, korisnicko_ime, lozinka, uloga) VALUES ('ADMINISTRATOR', '2000-04-15', 'panic.vaso@yahoo.com', 'Vasilije', 'Panic', 'vasilije.panic00', 'sifra1234!', 'ADMINISTRATOR');


/*Statusi aktivacije*/
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('na cekanju');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odobren');
INSERT INTO STATUS_AKTIVACIJE (naziv) VALUES ('odbijen');


/*Knjige*/
    /*Horor*/
        /*Stephen King*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('It', 'putanja_do_slike', '9780450411434', '1986-09-15', 1138, 'It desc', 1, 4.25);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Carrie', 'putanja_do_slike', '9781416524304', '1974-04-05', 272, 'Carrie desc', 1, 3.98);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Shining', 'putanja_do_slike', '9780450040184', '1980-07-01', 659, 'The Shining desc', 1, 4.26);
        /*Joe Hill*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('NOS4A2', 'putanja_do_slike', '9780062200570', '2013-04-28', 692, 'NOS4A2 desc', 1, 4.08);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Heart-Shaped Box', 'putanja_do_slike', '9780061147937', '2007-02-13', 376, 'Heart-Shaped Box desc', 1, 3.85);

    /*Triler*/
        /*Gillian Flynn*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Gone Girl', 'putanja_do_slike', '9780307588364', '2014-04-22', 415, 'Gone Girl desc', 2, 4.12);
        /*Stieg Larsson*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Girl with the Dragon Tattoo', 'putanja_do_slike', '9780670069019', '2008-09-23', 480, 'The Girl with the Dragon Tattoo desc', 2, 4.16);
        /*Paula Hawkins*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Girl on the Train', 'putanja_do_slike', '9781594633669', '2015-01-01', 336, 'The Girl on the Train desc', 2, 3.95);

    /*Romantika*/
        /*Jane Austen*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Pride and Prejudice', 'putanja_do_slike', '9780333321324', '2000-10-10', 279, 'Pride and Prejudice desc', 3, 4.28);
        /*Nicholas Sparks*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Notebook', 'putanja_do_slike', '9780446520805', '2000-01-05', 227, 'The Notebook desc', 3, 4.14);
        /*André Aciman*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Call Me By Your Name', 'putanja_do_slike', '9781786495259', '2017-09-21', 248, 'Call Me By Your Name desc', 3, 4.12);

    /*Kuvar*/
        /*Julia Child*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Mastering the Art of French Cooking', 'putanja_do_slike', '9780375413407', '2001-10-16', 684, 'Mastering the Art of French Cooking desc', 4, 4.23);
        /*Gabriela Camara*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('My Mexico City Kitchen: Recipes and Convictions', 'putanja_do_slike', '9780399580574', '2019-04-30', 363, 'My Mexico City Kitchen: Recipes and Convictions desc', 9, 4.21);

    /*Komedija*/
        /*Mindy Kaling*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Is Everyone Hanging Out Without Me?', 'putanja_do_slike', '9780307886262', '2011-11-01', 222, 'Is Everyone Hanging Out Without Me? desc', 5, 3.86);
        /*Bob Odenkirk*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Comedy Comedy Comedy Drama', 'putanja_do_slike', '9780399180514', '2022-03-01', 284, 'Comedy Comedy Comedy Drama desc', 5, 3.60);

    /*Biografija*/
        /*Hayden Herrera*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Frida: A Biography of Frida Kahlo', 'putanja_do_slike', '9780060085896', '2002-01-01', 528, 'Frida: A Biography of Frida Kahlo desc', 6, 4.00);
        /*Walter Isaacson*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Steve Jobs', 'putanja_do_slike', '9781451648539', '2011-10-24', 630, 'Steve Jobs desc', 6, 4.16);

    /*Naucna fantastika*/
        /*Frank Herbert*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Dune', 'putanja_do_slike', '9780593099322', '1965-10-01', 658, 'Dune desc', 7, 4.26);
        /*Mary Wollstonecraft Shelley*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('Frankenstein', 'putanja_do_slike', '9780815626404', '1818-03-08', 260, 'Frankenstein desc', 7, 3.85);
        /*H.G. Wells*/
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The Time Machine', 'putanja_do_slike', '9782384370016', '1985-01-01', 157, 'The Time Machine desc', 7, 3.90);
INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, zanr_id, srednja_ocena) VALUES ('The War of the Worlds', 'putanja_do_slike', '9780451522764', '1986-12-02', 215, 'The War of the Worlds desc', 7, 3.83);

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
    /*Citalac id 3*/
        /*WTR*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Want to Read', 3, true);
        /*CR*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Currently Reading', 3, true);
        /*R*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Read', 3, true);
        /*Neprimarne*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Favorites', 3, false);

    /*Citalac id 1*/
        /*WTR*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Want to Read', 1, true);
        /*CR*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Currently Reading', 1, true);
        /*R*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Read', 1, true);
        /*Neprimarne*/
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('Favorites', 1, false);
INSERT INTO POLICA (naziv, korisnik_id, primarna) VALUES ('My recommendations', 1, false);


/*Zahtevi aktivacije autora*/
INSERT INTO ZAHTEV_AKTIVACIJE_AUTORA (autor_id, datum_zahteva, status_aktivacije_id, email, poruka, telefon) VALUES (6, '2023-06-08', 1, 'author.joehill@gmail.com', 'Molimo potvrdite zahtev za aktivaciju', '123456789');

    /*Recenzije*/
    /*Citalac id 3*/
        /*za The Notebook*/
INSERT INTO RECENZIJA (datum_recenzije, ocena, tekst, korisnik_id) VALUES ('2020-05-13', 3, 'Well, i was promised tears and, unfortunately, my eyes are as dry as the sahara.', 3);
        /*za Gone Girl*/
INSERT INTO RECENZIJA (datum_recenzije, ocena, tekst, korisnik_id) VALUES ('2012-08-12', 5, 'I am taking a leisurely drive down the garden path of the story, when BAM – right in the middle it makes a u-turn and we are on the damn highway doing 90 miles an hour', 3);
        /*za Frida*/
INSERT INTO RECENZIJA (datum_recenzije, ocena, tekst, korisnik_id) VALUES ('2019-05-10', 2, 'She was more of a revolutionary than this book makes her out to be. She was also a gender-bending feminist, and a brilliant painter.', 3);
        /*za Carrie*/
INSERT INTO RECENZIJA (datum_recenzije, ocena, tekst, korisnik_id) VALUES ('2021-02-11', 4, 'This remarkable epistolary debut novel by King. When first published it was ahead of its time, and still feels pertinent today. In this work there are so many brave choices for a debut novelist', 3);
    /*Citalac id 1*/
        /*Za Carrie*/
INSERT INTO RECENZIJA (datum_recenzije, ocena, tekst, korisnik_id) VALUES ('2023-05-14', 5, 'Carrie, the debut novel by the legendary Stephen King, remains a timeless classic that delves deep into the dark and twisted realms of the human psyche.', 1);


/*Stavke police*/
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (10, 1);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (6, 2);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (16, 3);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (2, 4);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (2, 5);


/*Pripada*/
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (2, 3);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (3, 1);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (3, 2);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (3, 4);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (4, 1);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (4, 4);

INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (7, 5);
INSERT INTO PRIPADA (polica_id, stavka_police_id) VALUES (9, 5);


/*Korisnik_police*/
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (1, 5);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (1, 6);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (1, 7);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (1, 8);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (1, 9);

INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (3, 1);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (3, 2);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (3, 3);
INSERT INTO KORISNIK_POLICE (korisnik_id, police_id) VALUES (3, 4);


/*Korisnik tj autor_spisak_knjiga*/
    /*Stephen King*/
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (4, 1);
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (4, 2);
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (4, 3);

    /*Rupi Kaur*/
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (5, 25);
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (5, 26);

    /*Joe Hill*/
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (6, 4);
INSERT INTO KORISNIK_SPISAK_KNJIGA (autor_id, spisak_knjiga_id) VALUES (6, 5);