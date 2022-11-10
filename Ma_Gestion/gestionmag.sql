-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 06 juin 2022 à 21:41
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
-- Base de données :  `gestionmag`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE `achat` (
  `N_achat` int(11) NOT NULL,
  `nom_fourn` varchar(30) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix_total` float NOT NULL,
  `prix_unitaire` double NOT NULL,
  `date_achat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`N_achat`, `nom_fourn`, `designation`, `quantite`, `prix_total`, `prix_unitaire`, `date_achat`) VALUES
(1, 'karim', 'ggggg', 50, 5000, 100, '2021-09-27'),
(2, 'null', 'ggggg', 50, 5000, 100, '2022-05-25');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `N_fourn` int(11) NOT NULL,
  `nom_prenom` varchar(30) NOT NULL,
  `N_telephone` varchar(20) DEFAULT NULL,
  `Adresse` varchar(60) NOT NULL,
  `Ville` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`N_fourn`, `nom_prenom`, `N_telephone`, `Adresse`, `Ville`) VALUES
(1, '', '', '', ''),
(2, 'karim', '+213561203984', 'toudja', 'Béjaïa'),
(4, 'KENZA AK', '353637373', 'AKB0U', 'Chlef'),
(5, 'karim', '+213561203984', 'toudja', 'Béjaïa');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE `stock` (
  `N_prod` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `categorie` varchar(80) DEFAULT NULL,
  `unite` varchar(10) NOT NULL,
  `date_exp` date DEFAULT NULL,
  `qte_totale` int(11) NOT NULL,
  `qte_vente` int(11) NOT NULL,
  `qte_reste` int(11) NOT NULL,
  `prix_unt` float NOT NULL,
  `prix_vent` float NOT NULL,
  `gain` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`N_prod`, `designation`, `categorie`, `unite`, `date_exp`, `qte_totale`, `qte_vente`, `qte_reste`, `prix_unt`, `prix_vent`, `gain`) VALUES
(1, 'ggggg', 'jjjjj', 'Piéce', NULL, 50, 8, 42, 100, 105, 5);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(30) NOT NULL,
  `cle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `type`, `cle`) VALUES
(1, 'g', '123', 'Gérant', 'azerty'),
(2, 'v', 'ven', 'Vendeur', ''),
(4, 'k', '12', 'vendeur', ''),
(12, 'k', '12', 'vendeur', ''),
(14, 'aa', 'ferhat', 'Vendeur', ''),
(15, 'Lydia', '123', 'Vendeur', '');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `N_vente` int(11) NOT NULL,
  `marchandise` varchar(50) NOT NULL,
  `prix_a_payer` float NOT NULL,
  `benefice` float NOT NULL,
  `date_vente` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`N_vente`, `marchandise`, `prix_a_payer`, `benefice`, `date_vente`) VALUES
(1, 'N° 1 DES : ggggg pr : 105.0 qte : 2\n', 210, 10, '2021-09-27 10:17:48');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`N_achat`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`N_fourn`);

--
-- Index pour la table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`N_prod`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`N_vente`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `N_achat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `N_fourn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `stock`
--
ALTER TABLE `stock`
  MODIFY `N_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `N_vente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
