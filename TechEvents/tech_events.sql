-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2022 a las 09:24:42
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tech_events`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id` int(11) NOT NULL,
  `titulo` varchar(253) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `user_max` int(5) NOT NULL,
  `fecha_hora` varchar(250) NOT NULL,
  `img` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id`, `titulo`, `descripcion`, `user_max`, `fecha_hora`, `img`) VALUES
(1, 'Master en CSS: Responsive, SASS, Flexbox, Grid y Bootstrap', 'Aprende CSS3, Maquetación web, Responsive Web Design, SASS, LESS, Flexbox, CSS Grid, Bootstrap 4 y 5 desde cero +20h', 40, '30/04/2022 17:00', 'https://victorroblesweb.es/wp-content/uploads/2019/12/image-course-master-en-css.png'),
(2, 'Máster Completo en Java de cero a experto 2022 (+127 hrs)', 'Aprende con el mejor curso Java de cero con las mejores prácticas POO, Java EE 9, CDI, JPA, EJB, JSF, Web Services, JAAS', 40, '05/05/2022 17:00', 'https://coursecouponclub.com/wp-content/uploads/2021/02/3078492_1a27_2.jpg'),
(3, 'JavaScript Moderno Guía Definitiva Construye +15 Proyectos', 'Aprende el Lenguaje de Programación Web más popular paso a paso con +15 Proyectos - Incluye Proyecto MERN Full Stack', 40, '07/05/2022 17:00', 'https://external-preview.redd.it/7SdW8xVaQ5DUkvmlzdsFf_6_0vCQBngGhhtAyDq8e7Q.jpg?auto=webp&s=be1c2079f5e582ec7ffdba93942466fcd914c3c0'),
(4, 'Trello Gestión de Proyectos - Curso Completo [2022]', 'Domina la Gestión de Proyectos con Trello y Explota tu Productividad. Olvídate de Microsoft Project. (+1,5 PDUs PMP)', 40, '04/05/2022 17:00', 'https://i1.wp.com/formaciononline.eu/wp-content/uploads/2021/10/curso-trello-gratis.jpg?fit=710%2C373&ssl=1'),
(5, 'Aprende Javascript ES9, HTML, CSS3 y NodeJS desde cero', 'Aprende a programar con javascript sin conocimiento previo en el explorador web y en el servidor con nodeJS', 40, '26/04/2022 17:00', 'https://www.redvirtual.bid/wp-content/uploads/2020/09/Aprende-Javascript-ES9-HTML-CSS3-y-NodeJS-desde-cero.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `nombre` varchar(253) NOT NULL,
  `email` varchar(253) NOT NULL,
  `contraseña` varchar(253) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `contraseña`) VALUES
(1, 'Jesus Otero', 'asohgsc@gmail.com', 'otero'),
(2, 'Lupe Flores', 'dsvsbvd@gmail.com', 'amorenchipiona'),
(3, 'Francisco Dominguez', 'palomocojo@gmail.com', 'eltripode'),
(4, 'Carlos Laurie', 'svsvsdfmhsdhmo@gmail.com', 'carlitos'),
(5, 'Paula de Juan', 'anfscniuscnia@gmail.com', 'paula');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
