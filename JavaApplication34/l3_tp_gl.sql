-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 10 nov. 2022 à 19:55
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `l3_tp_gl`
--

-- --------------------------------------------------------

--
-- Structure de la table `catégorie`
--

CREATE TABLE `catégorie` (
  `NumCateg` int(11) NOT NULL,
  `Libellé` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `catégorie`
--

INSERT INTO `catégorie` (`NumCateg`, `Libellé`) VALUES
(100, 'PYTHONE');

-- --------------------------------------------------------

--
-- Structure de la table `emprunte`
--

CREATE TABLE `emprunte` (
  `NumLecture` int(11) NOT NULL,
  `ISBN` varchar(30) NOT NULL,
  `dateemp` date DEFAULT NULL,
  `daterout` date DEFAULT NULL,
  `Periode` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emprunte`
--

INSERT INTO `emprunte` (`NumLecture`, `ISBN`, `dateemp`, `daterout`, `Periode`) VALUES
(1, '11-0-0-1', '2021-02-17', '2021-02-24', 7);

-- --------------------------------------------------------

--
-- Structure de la table `lectures`
--

CREATE TABLE `lectures` (
  `NumLecture` int(11) NOT NULL,
  `NomLecture` varchar(50) DEFAULT NULL,
  `AdresseLecture` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lectures`
--

INSERT INTO `lectures` (`NumLecture`, `NomLecture`, `AdresseLecture`) VALUES
(1, 'Amine', 'elkseur');

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

CREATE TABLE `livres` (
  `ISBN` varchar(30) NOT NULL,
  `NomAuteur` varchar(50) DEFAULT NULL,
  `NomEditeur` varchar(50) DEFAULT NULL,
  `NbreExemplaire` tinyint(4) DEFAULT NULL,
  `NumCateg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livres`
--

INSERT INTO `livres` (`ISBN`, `NomAuteur`, `NomEditeur`, `NbreExemplaire`, `NumCateg`) VALUES
('100-100-100-99', 'azer', 'adf', 1, 100),
('11-0-0-1', 'axcel', 'arid', 1, 100),
('11-4444-0-77', 'amine', 'hocine', 3, 100);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `catégorie`
--
ALTER TABLE `catégorie`
  ADD PRIMARY KEY (`NumCateg`);

--
-- Index pour la table `emprunte`
--
ALTER TABLE `emprunte`
  ADD KEY `cle_emp_lec` (`NumLecture`),
  ADD KEY `cle_emp_liv` (`ISBN`);

--
-- Index pour la table `lectures`
--
ALTER TABLE `lectures`
  ADD PRIMARY KEY (`NumLecture`);

--
-- Index pour la table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `cle_liv_cate` (`NumCateg`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `catégorie`
--
ALTER TABLE `catégorie`
  MODIFY `NumCateg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT pour la table `lectures`
--
ALTER TABLE `lectures`
  MODIFY `NumLecture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunte`
--
ALTER TABLE `emprunte`
  ADD CONSTRAINT `cle_emp_lec` FOREIGN KEY (`NumLecture`) REFERENCES `lectures` (`NumLecture`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cle_emp_liv` FOREIGN KEY (`ISBN`) REFERENCES `livres` (`ISBN`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `livres`
--
ALTER TABLE `livres`
  ADD CONSTRAINT `cle_liv_cate` FOREIGN KEY (`NumCateg`) REFERENCES `catégorie` (`NumCateg`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
