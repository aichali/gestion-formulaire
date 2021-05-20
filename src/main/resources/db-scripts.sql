--
-- Structure de la table `client`
--

CREATE SEQUENCE seq_client START 1 INCREMENT 1;

DROP TABLE IF EXISTS client;
CREATE TABLE IF NOT EXISTS client (
  id_client int(10) NOT NULL AUTO_INCREMENT,
  nom varchar(50)  NOT NULL,
  prenom varchar(50)  NOT NULL,
  adresse varchar(110)  NOT NULL,
  cp varchar(5)  NOT NULL,
  adresse_mail varchar(110) NOT NULL,
  tel varchar(10) NOT NULL,
  PRIMARY KEY (id_client)
); 

--
-- Structure de la table `devis`
--

CREATE SEQUENCE seq_devis START 1 INCREMENT 1;

DROP TABLE IF EXISTS devis;
CREATE TABLE IF NOT EXISTS devis (
  id int(10) NOT NULL AUTO_INCREMENT,
  date date NOT NULL,
  expertises varchar(150) NOT NULL,
  message varchar(150) NOT NULL,
  id_client int(10) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

commit;

--ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


