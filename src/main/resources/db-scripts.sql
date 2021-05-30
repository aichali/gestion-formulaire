--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS Client;
CREATE TABLE IF NOT EXISTS Client (
  id_client int(10) NOT NULL AUTO_INCREMENT,
  nom varchar(50)  NOT NULL,
  prenom varchar(50)  NOT NULL,
  adresse varchar(110)  NOT NULL,
  cp varchar(5)  NOT NULL,
  mail varchar(110) NOT NULL,
  tel varchar(10) NOT NULL,
  PRIMARY KEY (id_client)
); 

--
-- Structure de la table `devis`
--

DROP TABLE IF EXISTS Devis;
CREATE TABLE IF NOT EXISTS Devis (
  id int(10) NOT NULL AUTO_INCREMENT,
  date date NOT NULL,
  expertises varchar(150) NOT NULL,
  message varchar(150) NOT NULL,
  id_client int(10) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

commit;