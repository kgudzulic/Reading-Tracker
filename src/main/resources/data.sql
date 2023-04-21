INSERT INTO ZANR (naziv) VALUES ('Horor');
INSERT INTO ZANR (naziv) VALUES ('Triler');
INSERT INTO ZANR (naziv) VALUES ('Romantika');
INSERT INTO ZANR (naziv) VALUES ('Kuvar');
INSERT INTO ZANR (naziv) VALUES ('Komedija');
INSERT INTO ZANR (naziv) VALUES ('Biografija');
INSERT INTO ZANR (naziv) VALUES ('Naucna fantastika');
INSERT INTO ZANR (naziv) VALUES ('Psiholoski');
INSERT INTO ZANR (naziv) VALUES ('Poezija');

INSERT INTO STATUSAKTIVACIJE (naziv) VALUES ('na cekanju');
INSERT INTO STATUSAKTIVACIJE (naziv) VALUES ('odobren');
INSERT INTO STATUSAKTIVACIJE (naziv) VALUES ('odbijen');

INSERT INTO KNJIGA (naslov, naslovnaFotografija, ISBN, datumObjavljivanja, brojStrana, opis, zanr_id, srednjaOcena) VALUES ('It', '???', '9780670813025', '1986-09-15', 1138, 'someDesc', 1, 9.1);