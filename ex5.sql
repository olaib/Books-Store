-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2023 at 01:28 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ex5`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book`
(
    `discount` double     NOT NULL,
    `price`    double     NOT NULL,
    `quantity` int(11)    NOT NULL,
    `id`       bigint(20) NOT NULL,
    `author`   varchar(255) DEFAULT NULL,
    `image`    varchar(255) DEFAULT NULL,
    `title`    varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`discount`, `price`, `quantity`, `id`, `author`, `image`, `title`)
VALUES (0.01, 18.107129236288817, 8, 1, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Pride and Prejudice'),
       (0.13, 6.023291010374385, 3, 2, 'Lewis Carroll', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Alice\'s Adventures in Wonderland'),
       (0.31, 13.52256477224635, 20, 3, 'Mark Twain', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Adventures of Huckleberry Finn'),
       (0.41, 8.030282439575837, 10, 4, 'Mary Wollstonecraft Shelley',
        'http://pngimg.com/uploads/book/book_PNG2116.png', 'Frankenstein; or, The Modern Prometheus'),
       (0.12, 19.283528987979274, 12, 5, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png', 'Emma'),
       (0.11, 16.324792041402013, 12, 6, 'Oscar Wilde', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Picture of Dorian Gray'),
       (0.25, 16.583235593994765, 20, 7, 'Robert Louis Stevenson', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Treasure Island'),
       (0.29, 19.9626435851533, 1, 8, 'Emily Brontë', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Wuthering Heights'),
       (0.26, 11.943271580055075, 11, 9, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Sense and Sensibility'),
       (0.09, 13.592241616332647, 14, 10, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'A Tale of Two Cities'),
       (0.26, 11.903802788848711, 7, 11, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'A Christmas Carol'),
       (0.4, 17.978917700354344, 11, 12, 'Jonathan Swift', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Gulliver\'s Travels'),
       (0.11, 13.184446121446236, 11, 13, 'Louisa May Alcott', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Little Women'),
       (0.05, 6.779660704641705, 11, 14, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Oliver Twist'),
       (0.31, 5.763721963147103, 3, 15, 'Arthur Conan Doyle', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'A Study in Scarlet'),
       (0.34, 11.644043506720562, 16, 16, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Hamlet'),
       (0.36, 10.875357077387621, 2, 17, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Great Expectations'),
       (0.46, 6.811630611843146, 8, 18, 'Miguel de Cervantes Saavedra',
        'http://pngimg.com/uploads/book/book_PNG2116.png', 'El ingenioso hidalgo Don Quijote de la Mancha'),
       (0.11, 14.981074049668994, 17, 19, 'F. Scott Fitzgerald', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Great Gatsby'),
       (0.36, 6.62223480925405, 8, 20, 'Arthur Conan Doyle', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Adventures of Sherlock Holmes [12 stories]'),
       (0.29, 14.05031615088894, 11, 21, 'Όμηρος', 'http://pngimg.com/uploads/book/book_PNG2116.png', 'Ιλιάδα / Iliad'),
       (0.37, 6.6664530327707405, 20, 22, 'Όμηρος', 'http://pngimg.com/uploads/book/book_PNG2116.png', 'Ὀδύσσεια'),
       (0.2, 17.510571780522767, 12, 23, 'Lewis Carroll', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Through the Looking-Glass'),
       (0.41, 7.340854130439956, 20, 24,
        'L. Frank Baum, R. D. Kori, Kenneth Grahame, J. T. Barbarese, Pablo Pino, Jenny Sánchez, Michael Foreman, Sébastien Perez, Benjamin Lacombe, David Guerra, pablo perez, Ezio Sposato, Alejandro lucas matias sanchez alonso, federico alonso, alejandro sanchez,',
        'http://pngimg.com/uploads/book/book_PNG2116.png', 'The Wonderful Wizard of Oz'),
       (0.07, 9.413263502982279, 3, 25, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Romeo and Juliet'),
       (0.28, 18.385862409781886, 15, 26, 'Arthur Conan Doyle', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Sign of Four'),
       (0.03, 14.882721498319082, 8, 27, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Macbeth'),
       (0, 19.047087116750305, 16, 28, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Mansfield Park'),
       (0.08, 12.485809245987694, 8, 29, 'Agatha Christie', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Mysterious Affair at Styles'),
       (0.13, 15.357379678866652, 14, 30, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Persuasion'),
       (0.25, 6.302259329379924, 18, 31, 'Voltaire', 'http://pngimg.com/uploads/book/book_PNG2116.png', 'Candide'),
       (0.27, 8.08792141639447, 5, 32, 'Jane Austen', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Northanger Abbey'),
       (0.5, 10.25090159792446, 14, 33, 'James Fenimore Cooper', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Last of the Mohicans'),
       (0.1, 11.654113058042949, 1, 34, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Hard Times'),
       (0.27, 15.32110364516858, 8, 35, 'Mark Twain', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Adventures of Tom Sawyer'),
       (0.2, 13.908525589744709, 19, 36, 'Nathanial Hawthorne, Austin Warren',
        'http://pngimg.com/uploads/book/book_PNG2116.png', 'Scarlet Letter'),
       (0.11, 5.77530944085219, 4, 37, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Tempest'),
       (0.05, 18.821416701650584, 9, 38, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Merchant of Venice'),
       (0.25, 14.121282247783965, 18, 39, 'Gustave Flaubert', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Madame Bovary'),
       (0.48, 10.208904143919469, 1, 40, 'Arthur Conan Doyle', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Valley of Fear'),
       (0, 6.569750065095061, 2, 41, 'Arthur Conan Doyle', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Lost World'),
       (0.4, 16.336972645529038, 6, 42, 'Thomas Hardy', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Tess of the d\'Urbervilles'),
       (0.33, 10.842985240068053, 16, 43, 'Franz Kafka', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Die Verwandlung'),
       (0.02, 15.423922101259784, 14, 44, 'Bram Stoker', 'http://pngimg.com/uploads/book/book_PNG2116.png', 'Dracula'),
       (0.03, 8.423602175587673, 10, 45, 'Edith Wharton', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Ethan Frome'),
       (0.31, 11.188786192419137, 19, 46, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Othello'),
       (0.36, 17.92328950813991, 9, 47, 'Charles Dickens', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'David Copperfield'),
       (0.31, 8.225320692482047, 3, 48, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'Julius Caesar'),
       (0.42, 19.14442623195548, 2, 49, 'William Shakespeare', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'King Lear'),
       (0.11, 11.946672752543215, 4, 50, 'John Bunyan', 'http://pngimg.com/uploads/book/book_PNG2116.png',
        'The Pilgrim\'s Progress');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
