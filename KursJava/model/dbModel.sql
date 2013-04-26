
DROP TABLE Message;
DROP TABLE Result;
DROP TABLE Race;
DROP TABLE Sportsman;
DROP TABLE Country;
DROP TABLE Users;
DROP TABLE Referee;
DROP TABLE Cup;

CREATE TABLE Cup (
       id SERIAL NOT NULL CONSTRAINT UQ_Cup_1 UNIQUE
     , cupName CHARACTER VARYING(30) NOT NULL CONSTRAINT UQ_Cup_2 UNIQUE
     , rating INTEGER DEFAULT 0
     , raceCount INTEGER NOT NULL
     , contryCount INTEGER NOT NULL
     , PRIMARY KEY (id)
);

CREATE TABLE Referee (
       id SERIAL NOT NULL CONSTRAINT UQ_Referee_1 UNIQUE
     , fio CHARACTER VARYING(50) NOT NULL
     , contry CHARACTER VARYING(30) NOT NULL
     , rang CHARACTER VARYING(40)
     , password CHARACTER VARYING(30) NOT NULL
     , PRIMARY KEY (id)
);

CREATE TABLE Users (
       id SERIAL NOT NULL CONSTRAINT UQ_Users_1 UNIQUE
     , "e-mail" CHARACTER VARYING(20) NOT NULL
     , password CHARACTER VARYING(50) NOT NULL
     , login CHARACTER VARYING(30) NOT NULL
     , PRIMARY KEY (id)
);

CREATE TABLE Country (
       id SERIAL NOT NULL CONSTRAINT UQ_Contry_2 UNIQUE
     , name CHARACTER VARYING(40) NOT NULL CONSTRAINT UQ_Contry_1 UNIQUE
     , maxSportsman INTEGER DEFAULT 0 NOT NULL
     , points INTEGER DEFAULT 0 NOT NULL
     , PRIMARY KEY (id)
);

CREATE TABLE Sportsman (
       id SERIAL NOT NULL CONSTRAINT UQ_Sportsman_1 UNIQUE
     , fio CHARACTER VARYING(50) NOT NULL
     , points INTEGER DEFAULT 0 NOT NULL
     , cups INTEGER DEFAULT 0
     , shooting REAL DEFAULT 0 NOT NULL
     , sex BOOLEAN NOT NULL
     , password CHARACTER VARYING(30) NOT NULL
     , idContry INTEGER NOT NULL
     , PRIMARY KEY (id)
     , CONSTRAINT FK_Sportsman_1 FOREIGN KEY (idContry)
                  REFERENCES Country (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Race (
       id SERIAL NOT NULL CONSTRAINT UQ_Race_1 UNIQUE
     , raceName CHARACTER VARYING(30) NOT NULL
     , scene CHARACTER VARYING(40) NOT NULL
     , raceTime TIMESTAMP WITH TIME ZONE NOT NULL
     , startCount INTEGER
     , finishCount INTEGER
     , idReferee INTEGER NOT NULL
     , idCup INTEGER NOT NULL
     , PRIMARY KEY (id)
     , CONSTRAINT FK_Race_1 FOREIGN KEY (idCup)
                  REFERENCES Cup (id) ON DELETE CASCADE ON UPDATE CASCADE
     , CONSTRAINT FK_Race_2 FOREIGN KEY (idReferee)
                  REFERENCES Referee (id)
);

CREATE TABLE Result (
       id SERIAL NOT NULL CONSTRAINT UQ_Result_1 UNIQUE
     , place INTEGER NOT NULL
     , shFalt INTEGER DEFAULT 0 NOT NULL
     , allTime TIME NOT NULL
     , timeWOShotting TIME NOT NULL
     , newPoints INTEGER DEFAULT 0 NOT NULL
     , idSportsman INTEGER NOT NULL
     , idRace INTEGER NOT NULL
     , PRIMARY KEY (id)
     , CONSTRAINT FK_Result_1 FOREIGN KEY (idSportsman)
                  REFERENCES Sportsman (id) ON DELETE CASCADE ON UPDATE CASCADE
     , CONSTRAINT FK_Result_2 FOREIGN KEY (idRace)
                  REFERENCES Race (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Message (
       id SERIAL NOT NULL CONSTRAINT UQ_Message_1 UNIQUE
     , idSportsman INTEGER NOT NULL
     , idReferee INTEGER NOT NULL
     , whoName CHARACTER VARYING(30) NOT NULL
     , whomName CHARACTER VARYING(30) NOT NULL
     , textMsg CHARACTER VARYING(300) NOT NULL
     , PRIMARY KEY (id)
     , CONSTRAINT FK_Message_1 FOREIGN KEY (idReferee)
                  REFERENCES Referee (id) ON DELETE NO ACTION ON UPDATE CASCADE
     , CONSTRAINT FK_Message_2 FOREIGN KEY (idSportsman)
                  REFERENCES Sportsman (id) ON DELETE NO ACTION ON UPDATE CASCADE
);

