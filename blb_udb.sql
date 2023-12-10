-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-12-2023 a las 22:06:44
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `blb_udb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administracion`
--

DROP TABLE IF EXISTS `administracion`;
CREATE TABLE IF NOT EXISTS `administracion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dia_estudiante` int NOT NULL,
  `mora_estudiante` double NOT NULL,
  `material_estudiante` int NOT NULL,
  `dia_profesor` int NOT NULL,
  `mora_profesor` double NOT NULL,
  `material_profesor` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cds`
--

DROP TABLE IF EXISTS `cds`;
CREATE TABLE IF NOT EXISTS `cds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cod_Cd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Titulo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Autor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Pais` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Año_Publicacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Volumen` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Idioma` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Genero` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ubicacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Unidades` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cds`
--

INSERT INTO `cds` (`id`, `Cod_Cd`, `Titulo`, `Autor`, `Pais`, `Año_Publicacion`, `Volumen`, `Idioma`, `Genero`, `Ubicacion`, `Unidades`) VALUES
(1, 'CDA4777', 'LOS TEMERARIOS', 'LUIS ORTIZ', 'MEXICO', '1977', '45', 'SPANISH', 'BANDA', 'ZACATECAS', 6),
(2, 'CDA4778', 'THRILLER', '	MICHAEL JACKSON', 'ESTADOS UNIDOS', '1982', '70', 'ENGLISH', 'POP', 'ESTADOS UNIDOS', 17),
(3, 'CDA4779', 'BACK IN BLACK', 'AC/DC', 'AUSTRALIA', ' 1980', '50', 'ENGLISH', 'ROCK', 'AUSTRALIA', 9),
(4, 'CDA4780', 'NEVERMIND', 'NIRVANA', 'ESTADOS UNIDOS', '1991', '75', 'ENGLISH', 'ROCK', 'ESTADOS UNIDOS', 25),
(5, 'CDA4781', 'LOS BUKIS', 'MARCO ANTONIO SOLÃ­S', 'MEXICO', '1971', '100', 'SPANISH', 'ROMANTICA', 'MICHOACAN', 43);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE IF NOT EXISTS `libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cod_Lib` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Titulo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Autor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `No_Paginas` int NOT NULL,
  `Editorial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Pais` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ISBN` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Año_Publicacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Idioma` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ubicacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Unidades` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `Cod_Lib`, `Titulo`, `Autor`, `No_Paginas`, `Editorial`, `Pais`, `ISBN`, `Año_Publicacion`, `Idioma`, `Ubicacion`, `Unidades`) VALUES
(2, 'LIB1234', 'EL PRINCIPITO', 'ANTOINE DE SAINT', 8, 'GALAXIA GUTENBERG', 'FRANCIA', '234', '1943 ', 'SPANISH', 'ESTADOS UNIDOS', 5),
(3, 'LIB1235', 'LOS CANTANTES', 'MANUEL VAZQUEZ ', 9, 'GALAXIA GUTENBERG', 'SPAIN', '235', ' 1987', 'SPANISH', 'MADRID', 21),
(4, 'LIB1236', 'LA ODISEA', 'HOMERO', 108, 'SUDAMERICANA', 'GRECIA', '236', '2022', 'SPANISH', 'GRECIA', 38),
(5, 'LIB1237', '	HARRY POTTER Y LA PIEDRA FILOSOFAL', 'J.K. ROWLING', 50, '	BLOOMSBURY ', 'REINO UNIDO', '237', '1997', 'ENGLISH', 'REINO UNIDO', 42),
(6, 'LIB1238', 'EL PODER DEL HABITO', 'CHARLES DUHIGG', 4, 'RANDOM HOUSE', 'ESTADOS UNIDOS', '238', '2012', 'ENGLISH', 'ESTADOS UNIDOS', 46);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obras`
--

DROP TABLE IF EXISTS `obras`;
CREATE TABLE IF NOT EXISTS `obras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cod_Ob` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Titulo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Autor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `No_Paginas` int NOT NULL,
  `Editorial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Pais` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ISBN` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Año_Publicacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Idioma` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Genero` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ubicacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Unidades` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `obras`
--

INSERT INTO `obras` (`id`, `Cod_Ob`, `Titulo`, `Autor`, `No_Paginas`, `Editorial`, `Pais`, `ISBN`, `Año_Publicacion`, `Idioma`, `Genero`, `Ubicacion`, `Unidades`) VALUES
(1, 'OBR3211', 'DON QUIJOTE DE LA MANCHA', 'MIGUEL DE CERVANTES SAAVEDRA', 54, 'IMPRENTA DE JUAN DE LA CUESTA', 'SPAIN', '111', '1605 ', 'SPANISH', 'NOVELA', 'SPAIN', 10),
(2, 'OBR3212', 'EL FIN DE LA ETERNIDAD', 'ISAAC ASIMOV', 78, 'DOUBLEDAY', 'ESTADOS UNIDOS', '112', '1955', 'ENGLISH', 'CIENCIA FICCION', 'ESTADOS UNIDOS', 82),
(3, 'OBR3213', 'EL CODIGO DA VINCI', 'DAN BROWN', 49, 'RANDOM HOUSE', 'ESTADOS UNIDOS', '113', '2003', 'SPANISH', 'NOVELA', 'PARIS', 10),
(4, 'OBR3214', 'EL ARTE DE AMAR', 'ERICH FROMM', 20, 'RINEHART & COMPANY', 'ESTADOS UNIDOS', '114', '1956', 'SPANISH', 'ENSAYO', 'ESTADOS UNIDOS', 10),
(5, 'OBR3215', 'EN BUSCA DEL TIEMPO PERDIDO', 'MARCEL PROUST', 5, 'GRASSET', 'FRANCIA', '115', '1913', 'SPANISH', 'NOVELA', 'PARIS', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE IF NOT EXISTS `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_lib` int DEFAULT NULL,
  `id_obr` int DEFAULT NULL,
  `id_rev` int DEFAULT NULL,
  `id_cds` int DEFAULT NULL,
  `id_tsi` int DEFAULT NULL,
  `No_Carnet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Cod_Material` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Material` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `f_prestamo` date NOT NULL,
  `f_devolucion` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_user` (`id_user`),
  KEY `fk_id_lib` (`id_lib`),
  KEY `fk_id_obr` (`id_obr`),
  KEY `fk_id_rev` (`id_rev`),
  KEY `fk_id_cds` (`id_cds`),
  KEY `fk_id_tsi` (`id_tsi`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id`, `id_user`, `id_lib`, `id_obr`, `id_rev`, `id_cds`, `id_tsi`, `No_Carnet`, `Nombre`, `Cod_Material`, `Material`, `f_prestamo`, `f_devolucion`) VALUES
(1, 1, 5, NULL, NULL, NULL, NULL, 'RA223357', 'FERNANDO RUIZ', 'LIB1237', '	HARRY POTTER Y LA PIEDRA FILOSOFAL', '2023-12-07', '2023-12-07'),
(2, 1, 2, NULL, NULL, NULL, NULL, 'RA223357', 'FERNANDO RUIZ', 'LIB1234', 'EL PRINCIPITO', '2023-12-07', '2023-12-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revistas`
--

DROP TABLE IF EXISTS `revistas`;
CREATE TABLE IF NOT EXISTS `revistas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cod_Re` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Titulo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Editorial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ISBN` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Periodicidad` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_Publicacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Tamaño` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Idioma` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ubicacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Unidades` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `revistas`
--

INSERT INTO `revistas` (`id`, `Cod_Re`, `Titulo`, `Editorial`, `ISBN`, `Periodicidad`, `Fecha_Publicacion`, `Tamaño`, `Idioma`, `Ubicacion`, `Unidades`) VALUES
(1, 'REV2240', 'WIRED', 'CONDE NAST', '2250', '30', '	1993', 'Standar', 'SPANISH', 'EUROPA', 6),
(2, 'REV2241', ' VOGUE', ' CONDE NAST', '2251', '15', '1892', 'Standar', 'SPANISH', 'ESTADOS UNIDOS', 7),
(3, 'REV2242', '	ROLLING STONE', 'WENNER MEDIA', '2252', '15', ' 1967', 'Standar', 'SPANISH', 'ESTADOS UNIDOS', 6),
(4, 'REV2243', 'TIME', 'TIME INC', '2253', '8', '	1923', 'Standar', 'ESPAÃ±OL', 'ESTADOS UNIDOS', 5),
(5, 'REV2244', 'THE ECONOMIST', 'THE ECONOMIST GROUP', '2254', '8', '1843', 'Standar', 'ENGLISH', 'REINO UNIDO', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tesis`
--

DROP TABLE IF EXISTS `tesis`;
CREATE TABLE IF NOT EXISTS `tesis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cod_Ts` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Titulo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Autor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Pais` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ciudad` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Universidad` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `No_Paginas` int NOT NULL,
  `Fecha_Publicacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Idioma` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Ubicacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Unidades` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tesis`
--

INSERT INTO `tesis` (`id`, `Cod_Ts`, `Titulo`, `Autor`, `Pais`, `Ciudad`, `Universidad`, `No_Paginas`, `Fecha_Publicacion`, `Idioma`, `Ubicacion`, `Unidades`) VALUES
(1, 'TSI5045', 'EL DESARROLLO DE TECNOLOGIAS', 'STEVEN DIAZ', ' COLOMBIA', 'SANTA MARTA', 'UNIVERSIDAD DE AMERICA', 8, '1892', 'SPANISH', 'MEDELLIN', 8),
(2, 'TSI5046', 'NARRATIVAS DE GENERO EN LA LITERATURA', 'WALTER LOPEZ', 'ARGENTINA', 'BUENOS AIRES', 'UNIVERSIDAD SAN JUAN', 16, '1934', 'SPANISH', 'SAN RAFAEL', 20),
(3, 'TSI5047', 'LA CONTAMINACION', 'STEVEN DIAZ', ' COLOMBIA', 'SANTA MARTA', 'UNIVERSIDAD DE AMERICA', 8, '1892', 'SPANISH', 'MEDELLIN', 8),
(4, 'TSI5048', 'INPACTO DE LAS REDES', 'KARLA HERNADEZ', 'FRANCIA', 'PARIS', 'UNIVERSIDAD DEL SUR', 15, '1934', 'SPANISH', 'LYON', 26),
(5, 'TSI5049', 'SEGURIDAD EN REDES', 'RICARDO CUBIAS', 'EL SALVADOR', 'SAN SALVADOR', 'UNIVERSIDAD DON BOSCO', 14, '2023', 'SPANISH', 'SOYAPANGO', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `No_Carnet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Apellido` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Oficio` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Recargo_Mora` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `No_Carnet`, `Nombre`, `Apellido`, `Oficio`, `Username`, `Password`, `Recargo_Mora`) VALUES
(1, 'RA223357', 'FERNANDO', 'RUIZ', 'ADMINISTRADOR', 'FERR007', 'SELECTA82', 0),
(3, 'GC223008', 'RICARDO', 'GARCIA', 'PROFESOR', 'RICKY', '123UDB', 0),
(4, 'DV223062', 'ALVARO', 'DIAZ', 'ESTUDIANTE', 'ALVARO845', 'ALVARO845', 0),
(5, 'LH222201', 'FREDY', 'LOPEZ', 'PROFESOR', 'FREDY2000', '8915A', 0),
(6, 'QA222131', 'ELIAS', 'QUIJANO', 'ESTUDIANTE', 'ELIAS2002', 'ELIAS007', 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `fk_id_cds` FOREIGN KEY (`id_cds`) REFERENCES `cds` (`id`),
  ADD CONSTRAINT `fk_id_lib` FOREIGN KEY (`id_lib`) REFERENCES `libros` (`id`),
  ADD CONSTRAINT `fk_id_obr` FOREIGN KEY (`id_obr`) REFERENCES `obras` (`id`),
  ADD CONSTRAINT `fk_id_rev` FOREIGN KEY (`id_rev`) REFERENCES `revistas` (`id`),
  ADD CONSTRAINT `fk_id_tsi` FOREIGN KEY (`id_tsi`) REFERENCES `tesis` (`id`),
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
