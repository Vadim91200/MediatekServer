DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS document;

CREATE OR REPLACE TABLE document
(
Numdoc INTEGER PRIMARY KEY,
Namedoc VARCHAR(30) NOT NULL,
Typedoc VARCHAR(10) NOT NULL
);

CREATE OR REPLACE TABLE user
(
Matricule INTEGER PRIMARY KEY,
Name VARCHAR(25) NOT NULL,
Login VARCHAR(30)NOT NULL,
Password VARCHAR(30)NOT NULL,
Typeuser VARCHAR(15) NOT NULL
);

CREATE OR REPLACE TABLE loan
(
Nubloan INTEGER PRIMARY KEY,
Matricule INTEGER, 
Numdoc INTEGER 
);

ALTER TABLE loan
ADD CONSTRAINT fk_user
FOREIGN KEY(Matricule)
REFERENCES user(Matricule)
ON DELETE CASCADE;

ALTER TABLE loan
ADD CONSTRAINT fk_document
FOREIGN KEY(Numdoc)
REFERENCES document(Numdoc)
ON DELETE CASCADE;

insert into document (Numdoc , Namedoc , Typedoc)
values(1,'LaBible','LIVRE');
insert into document (Numdoc , Namedoc , Typedoc)
values(2,'Fondation','LIVRE');
insert into document (Numdoc , Namedoc , Typedoc)
values(3,'2001Odyssée de lespace','DVD');

insert into user (Matricule , Name , Login , Password , Typeuser)
values(10,'Amandier','Aliam','leboos','abonné');
insert into user (Matricule , Name , Login , Password , Typeuser)
values(20,'Soblet','Saled','ortig','bibliothécaire');

commit;