-- //create the tables
--  // Team(ID_E,Nom,Pays)
--     //Compettion(Ncomp,Nom,Pays,annee)
--     //participer(ID_E,Ncomp,CL(Classement))


CREATE TABLE Team(ID_E int NOT NULL ,Nom varchar(20),Pays varchar(20),PRIMARY KEY(ID_E));
CREATE TABLE Competition(Ncomp int NOT NULL ,Nom varchar(20),Pays varchar(20),annee int,PRIMARY KEY(Ncomp));
CREATE TABLE Participer(ID_E int NOT NULL,Ncomp int NOT NULL,CL int,PRIMARY KEY(ID_E,Ncomp),FOREIGN KEY(ID_E) REFERENCES Team(ID_E),FOREIGN KEY(Ncomp) REFERENCES Competition(Ncomp));