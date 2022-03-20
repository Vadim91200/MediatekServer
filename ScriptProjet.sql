DROP TABLE IF EXISTS document;
DROP TABLE IF EXISTS user;

CREATE OR REPLACE TABLE user
(
Matricule INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
Name VARCHAR(25) NOT NULL,
Login VARCHAR(30)NOT NULL,
Password VARCHAR(30)NOT NULL,
Typeuser VARCHAR(15) NOT NULL
);

CREATE OR REPLACE TABLE document
(
Numdoc INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
Namedoc VARCHAR(30) NOT NULL,
Typedoc INTEGER NOT NULL,
Ownerdoc INTEGER,
FOREIGN KEY (Ownerdoc) REFERENCES user(Matricule)
);

insert into document (Namedoc , Typedoc)
values('LaBible','3');
insert into document ( Namedoc , Typedoc)
values('Fondation','1');
insert into document ( Namedoc , Typedoc)
values('2001 Odyssée de lespace','2');

insert into user ( Name , Login , Password , Typeuser)
values('Amandier','Aliam','leboos','subscriber');
insert into user ( Name , Login , Password , Typeuser)
values('Soblet','Saled','ortig','librarian');

commit;