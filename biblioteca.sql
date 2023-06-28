--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: area_conocimiento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.area_conocimiento (
    codigo_area character varying(2000) NOT NULL,
    nombre character varying(2000),
    descripcion character varying(2000)
);


--
-- Name: autor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.autor (
    codigo_autor character varying(2000) NOT NULL,
    primer_apellido character varying(2000),
    segundo_apellido character varying(2000),
    primer_nombre character varying(2000),
    segundo_nombre character varying(2000)
);


--
-- Name: descarga; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.descarga (
    isbn character varying(2000) NOT NULL,
    usuario_id character varying(2000) NOT NULL,
    fecha date NOT NULL,
    hora time without time zone,
    ip character varying(2000)
);


--
-- Name: digital; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.digital (
    isbn character varying(2000) NOT NULL,
    url character varying(2000) NOT NULL,
    formato character varying(2000),
    "tamaño" integer
);


--
-- Name: editorial; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.editorial (
    codigo character varying(2000) NOT NULL,
    pagina_web character varying(2000),
    nombre character varying(2000),
    pais_origen character varying(2000)
);


--
-- Name: ejemplar_fisico; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.ejemplar_fisico (
    isbn character varying(2000),
    numero integer NOT NULL
);


--
-- Name: empleado; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.empleado (
    id_empleado character varying(2000) NOT NULL,
    cargo character varying(2000),
    nombre character varying(2000),
    contrasena character varying(20)
);


--
-- Name: estudiante; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.estudiante (
    usuario_id character varying(2000) NOT NULL,
    carrera character varying(255),
    universidad character varying(255)
);


--
-- Name: interes; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.interes (
    usuario_id character varying(2000) NOT NULL,
    codigo_area character varying(2000) NOT NULL
);


--
-- Name: libro; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.libro (
    isbn character varying(2000) NOT NULL,
    titulo character varying(2000),
    ano_publicacion integer,
    idioma character varying(2000),
    codigo_area character varying(2000),
    numero_pag integer,
    codigo_autor character varying(2000),
    codigo character varying(2000)
);


--
-- Name: multa; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.multa (
    usuario_id character varying(2000) NOT NULL,
    isbn character varying(2000) NOT NULL,
    fecha date,
    valor integer
);


--
-- Name: peticion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.peticion (
    isbn character varying(2000) NOT NULL,
    usuario_id character varying(2000) NOT NULL,
    titulo character varying(2000),
    descripcion character varying(2000),
    fecha date
);


--
-- Name: prestamo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.prestamo (
    numero integer NOT NULL,
    usuario_id character varying(2000),
    id_empleado character varying(2000),
    fecha_realizacion date,
    fecha_devolucion date,
    isbn character varying(2000)
);


--
-- Name: profesor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.profesor (
    usuario_id character varying(2000) NOT NULL,
    dependencia character varying(2000),
    titulo character varying(2000)
);


--
-- Name: subarea; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.subarea (
    codigo_area character varying(2000) NOT NULL,
    nombre character varying(2000) NOT NULL,
    descripcion character varying(2000)
);


--
-- Name: ubicacion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.ubicacion (
    isbn character varying(2000) NOT NULL,
    nombre_sala character varying(2000) NOT NULL,
    numero_pasillo integer NOT NULL,
    estante character varying(2000) NOT NULL,
    numero_cajon integer NOT NULL
);


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuario (
    usuario_id character varying(2000) NOT NULL,
    nombre character varying(2000),
    telefono character varying(2000),
    email character varying(2000),
    direccion character varying(2000),
    contrasena character varying(20)
);


--
-- Data for Name: area_conocimiento; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.area_conocimiento (codigo_area, nombre, descripcion) FROM stdin;
10012	Ciencias_Naturales	ciencias estudio de la naturaleza
20001	Ciencias_Sociales	ciencia relacionadas con la sociedad
40085	Ingenieria	uso de principios científicos 
47851	salud	mantener y mejorar la salud
\.


--
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.autor (codigo_autor, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre) FROM stdin;
2122	Miguel	Cervantes	zerbantes	\N
2556	Donatien	Alphonse	François	Sade
2788	Mary	Wollstonecraft	Godwin	\N
2478	Charles	John	Huffam	Dickens
2998	Fiódor	Mijáilovich	Dostoievski	\N
2336	Jules	Gabriel	Verne	\N
2112	Lev	Nikoláievich	Tolstói	\N
2233	José	Rafael	Pombo	Robolledo
2741	Gabriel	Jose	Garcia	Márquez
2999	Stephen	Edwin	King	\N
\.


--
-- Data for Name: descarga; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.descarga (isbn, usuario_id, fecha, hora, ip) FROM stdin;
A-0010-Z	1010D	2019-09-03	10:00:00	192.168.1.1
A-0020-Z	2020D	2020-04-12	14:30:00	192.168.1.2
A-0030-Z	3030D	2018-11-27	08:45:00	192.168.1.3
A-0040-Z	4040D	2017-06-08	16:20:00	192.168.1.4
A-0050-Z	5050D	2020-02-19	12:15:00	192.168.1.5
A-0060-Z	6060D	2016-07-30	09:30:00	192.168.1.6
A-0070-Z	7070D	2015-10-14	11:45:00	192.168.1.7
A-0080-Z	8080D	2018-08-20	15:10:00	192.168.1.8
A-0090-Z	9090D	2017-01-05	13:30:00	192.168.1.9
A-0011-Z	1011D	2019-03-28	10:45:00	192.168.1.10
\.


--
-- Data for Name: digital; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.digital (isbn, url, formato, "tamaño") FROM stdin;
A-0010-Z	WWW.buenas_Artes/don-quijote-mancha	PDF	5
A-0020-Z	WWW.mando_Magno/los-12-dias-sodoma 	MOBI	3
A-0030-Z	WWW.Siempre_como/50 noches-en-un-dia 	AZW	10
A-0040-Z	WWW.norma.com/Economia-1 	PDF	9
A-0050-Z	WWW.Sorpresamen/Geografia-basica-1 	MOBI	6
A-0060-Z	WWW.cartaMagna/Introduccion-ingenieria-2	PDF	5
A-0070-Z	WWW.XlibrosX/nimales-sorprendentes	PDF	5
A-0080-Z	WWW.los_mejores_libros/Petro-al-poder 	PDF	5
A-0090-Z	WWW.riot/Principios-medicos	DOC	10
A-0011-Z	WWW.ColombiaM/Politicos-nivel-1	PDF	8
\.


--
-- Data for Name: editorial; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.editorial (codigo, pagina_web, nombre, pais_origen) FROM stdin;
C10	WWW.buenas_Artes.com	Juan de la Cuesta	España
C11	WWW.mando_Magno.com	Magno dc	España
C12	WWW.Siempre_como.com	siempre confiable	Peru
C13	WWW.norma.com	norma family	Mexico
C14	WWW.Sorpresamen.com	soprendete mente	Mexico
C15	WWW.cartaMagna.com	Carta de diso magno	España
C16	WWW.XlibrosX.com	Ice books	Canada
C17	WWW.los_mejores_libros.com	mi primera vez	Argentina
C18	WWW.riot.com	riotbooks help	EE.UU
C19	WWW.ColombiaM.com	columbian	EE.UU
\.


--
-- Data for Name: ejemplar_fisico; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.ejemplar_fisico (isbn, numero) FROM stdin;
A-0010-Z	1
A-0020-Z	2
A-0030-Z	3
A-0040-Z	4
A-0050-Z	5
A-0060-Z	6
A-0070-Z	7
A-0080-Z	8
A-0090-Z	9
A-0011-Z	10
\.


--
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.empleado (id_empleado, cargo, nombre, contrasena) FROM stdin;
E02	Acomodador	Jose Julian	\N
E03	Subdirector	Juliana Fernanda	\N
E04	Administrador	Juan Manuel	\N
E05	Asistente	Jhon Lopez	\N
E06	Administrador	Daiela Murillo	\N
E07	Auciliar Informatico	Bad buny	\N
E08	Acomodador	Camilo Andres	\N
E09	Director	Valentina Espina	\N
E11	Director	Ximena Trujillo	\N
E01	Director	Juan Manuel	1234
\.


--
-- Data for Name: estudiante; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.estudiante (usuario_id, carrera, universidad) FROM stdin;
1010D	ing.sistemas	Univalle
2020D	ing.sistemas	Univalle
3030D	ing.civil	Javeriana
4040D	Quimica	Santiago
5050D	Sociales	Santiago
6060D	Lenguas	libre
7070D	Medicina	Javeriana
8080D	ing.geomatico	Univalle
9090D	ing.electico	Santiago
1011D	ing.civil	Autonoma
\.


--
-- Data for Name: interes; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.interes (usuario_id, codigo_area) FROM stdin;
1012D	10012
1013D	20001
1014D	40085
1015D	40085
1016D	47851
\.


--
-- Data for Name: libro; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.libro (isbn, titulo, ano_publicacion, idioma, codigo_area, numero_pag, codigo_autor, codigo) FROM stdin;
A-0010-Z	Don Quijote de la Mancha	1605	Español	20001	150	2122	C10
A-0020-Z	Los 120 días de Sodoma	1904	Español	47851	150	2556	C11
A-0030-Z	50 noches en un dia	1850	Español	10012	150	2788	C12
A-0040-Z	Economia 1	1605	Español	20001	150	2478	C13
A-0050-Z	Geografia basica 1	1605	Español	20001	150	2998	C14
A-0060-Z	Introduccion ingenieria 2	1605	Español	40085	150	2336	C15
A-0070-Z	Animales sorprendentes	1605	Ingles	10012	150	2112	C16
A-0080-Z	Petro al poder	1605	Español	20001	150	2233	C17
A-0090-Z	Principios medicos	1605	Ingles	47851	150	2741	C18
A-0011-Z	Politicos nivel 1	1605	Ingles	20001	150	2999	C19
\.


--
-- Data for Name: multa; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.multa (usuario_id, isbn, fecha, valor) FROM stdin;
1010D	A-0010-Z	2021-04-17	12500
2020D	A-0020-Z	2020-08-29	15800
3030D	A-0030-Z	2019-12-05	7700
4040D	A-0040-Z	2018-03-18	14900
5050D	A-0050-Z	2017-07-07	9300
6060D	A-0060-Z	2016-11-22	17800
7070D	A-0070-Z	2015-05-03	6400
8080D	A-0080-Z	2014-09-14	12000
9090D	A-0090-Z	2013-01-28	14200
1011D	A-0011-Z	2012-06-10	8300
\.


--
-- Data for Name: peticion; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.peticion (isbn, usuario_id, titulo, descripcion, fecha) FROM stdin;
A-0010-Z	1010D	Don Quijote de la Mancha	Es una novela clásica escrita por Miguel de Cervantes que narra las aventuras de un caballero llamado Don Quijote y su fiel escudero Sancho Panza en busca de justicia y amor, en un mundo que confunde la realidad y la fantasía.	2019-09-03
A-0020-Z	2020D	Los 120 días de Sodoma	Esta controvertida obra escrita por el marqués de Sade relata la historia de cuatro nobles que secuestran a un grupo de personas para llevar a cabo prácticas sexuales sadomasoquistas extremas durante 120 días, explorando los límites de la depravación humana.	2020-04-12
A-0030-Z	3030D	50 noches en un dia	Un libro de poesía de José Antonio Gabriel y Galán que busca explorar y transmitir emociones y vivencias a través de la palabra escrita, utilizando un lenguaje lírico y evocador para sumergir al lector en una experiencia poética única.	2018-11-27
A-0040-Z	4040D	Economia 1	Un libro introductorio que aborda los conceptos fundamentales de la economía, proporcionando una visión general de los principios y teorías económicas, desde la oferta y la demanda hasta los sistemas económicos y la macroeconomía, con el objetivo de brindar una base sólida para comprender el funcionamiento de la economía.	2017-06-08
A-0050-Z	5050D	Matematicas	Un libro que cubre los conceptos básicos de las matemáticas, desde los números y las operaciones básicas hasta la geometría, el álgebra y el cálculo, presentando ejemplos y problemas para desarrollar las habilidades matemáticas y fomentar el razonamiento lógico.	2020-02-19
A-0060-Z	6060D	Geografia basica 1	Un libro introductorio que explora los fundamentos de la geografía, abarcando temas como la localización geográfica, los tipos de mapas, los continentes, los climas y los recursos naturales, brindando una visión general de los elementos clave de la disciplina geográfica.	2016-07-30
A-0070-Z	7070D	Introduccion ingenieria 2	Este libro continúa explorando los conceptos básicos de la ingeniería, abordando temas más avanzados como la termodinámica, la mecánica de fluidos, la electricidad y la electrónica, proporcionando una introducción más profunda a los principios y aplicaciones de la ingeniería.	2015-10-14
A-0080-Z	8080D	Animales sorprendentes	Un libro que presenta una amplia variedad de animales fascinantes y poco comunes, desde criaturas marinas hasta especies terrestres exóticas, con detalles sobre sus características únicas, hábitats y comportamientos, ilustrado con imágenes impresionantes para despertar la curiosidad y el interés por la diversidad de la vida animal.	2018-08-22
A-0090-Z	9090D	Petro al poder	Un libro político que analiza el ascenso al poder de un líder político, en este caso, centrado en la figura de Petro (referencia al político colombiano Gustavo Petro), examinando su trayectoria, propuestas y la influencia en la política y la sociedad.	2017-01-05
A-0011-Z	1011D	Principios medicos	Un libro que aborda los principios fundamentales de la medicina, desde la anatomía y la fisiología humana hasta las enfermedades y los tratamientos médicos, proporcionando una base de conocimientos esencial para comprender el funcionamiento del cuerpo humano y los principios de la atención médica.	2019-03-28
\.


--
-- Data for Name: prestamo; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.prestamo (numero, usuario_id, id_empleado, fecha_realizacion, fecha_devolucion, isbn) FROM stdin;
1	1010D	E01	2022-03-05	2022-04-18	A-0010-Z
2	2020D	E02	2020-09-12	2020-10-23	A-0020-Z
3	3030D	E03	2019-06-28	2019-07-17	A-0030-Z
4	4040D	E04	2018-12-18	2019-01-22	A-0040-Z
5	5050D	E05	2017-02-14	2017-03-28	A-0050-Z
6	6060D	E06	2016-11-21	2016-12-04	A-0060-Z
7	7070D	E07	2015-07-03	2015-08-12	A-0070-Z
8	8080D	E08	2014-09-16	2014-10-25	A-0080-Z
9	9090D	E09	2008-01-13	2008-02-13	A-0090-Z
10	1011D	E11	2010-06-12	2020-07-12	A-0011-Z
\.


--
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.profesor (usuario_id, dependencia, titulo) FROM stdin;
1012D	Academico	licenciado en Psicologia
1013D	Academico	licenciado en Psicologia
1014D	Logistica	licenciado en Psicologia
1015D	Logistica	licenciado en Psicologia
1016D	Academico	licenciado en Psicologia
\.


--
-- Data for Name: subarea; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.subarea (codigo_area, nombre, descripcion) FROM stdin;
10012	Quimica	Estudio de los elementos
10012	Biologia	Estudio de los seres vivios
10012	Fisica	Estudio de eventos naturales
10012	Matematicas	Estudio de los numeros
20001	Geografia	Analicis de espacios
10012	Historia	Acontecimientos del ser humano
10012	Economia	analisis de datos
47851	Psicologia	comportamiento del ser humano
10012	Medicina	Prevencion y proteccion del ser humano
10012	Biomedicina	fuerzas que actúan sobre los organismos
\.


--
-- Data for Name: ubicacion; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.ubicacion (isbn, nombre_sala, numero_pasillo, estante, numero_cajon) FROM stdin;
A-0010-Z	Mundo social	5	4	8
A-0020-Z	Mundo salud y vida	2	3	5
A-0030-Z	Mundo Naturlaza	12	8	6
A-0040-Z	Mundo social	2	4	6
A-0050-Z	Mundo social	11	7	5
A-0060-Z	Mundo Pensamientos y ingenieria	15	8	1
A-0070-Z	Mundo Naturlaza	8	7	9
A-0080-Z	Mundo social	7	1	2
A-0090-Z	Mundo salud y vida	9	9	9
A-0011-Z	Mundo social	14	3	4
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.usuario (usuario_id, nombre, telefono, email, direccion, contrasena) FROM stdin;
2020D	Daniel	3345556540	DanielG@gmail.com	Cra 99 #4B-19	\N
3030D	Eduardo	3178372930	Edu@gmail.com	calle berenjena 23	\N
4040D	Sara	3325550987	sarita@gmail.com	av deperros 30	\N
5050D	Marcela	122555333	Marcelauwu@gmail.com	calle desigual 34-6	\N
6060D	Samanta	5552620211	Sardina69@gmail.com	Cra96 #25B-89	\N
7070D	Ivan	122555227	Ivanshow96@gmail.com	Calle 94 #4C-19	\N
8080D	Rosalia	272555332	RosaMeL@gmail.com	avenida #2 calle 1	\N
9090D	Mario	3178372930	MarioBros123@gmail.com	avenia 2D #21c	\N
1011D	Juliana	3578372930	JulianaOnichan@gmail.com	Cr 2c #12c-12	\N
1012D	Mariana	3578372920	Mar@gmail.com	Calle 20 #5C-19	\N
1013D	Gabriela	3778372930	Gabigabi6@gmail.com	avenida sur 20 	\N
1014D	Juan	3178372930	juanCarlo@gmail.com	Calle 2 cr 22-3	\N
1015D	Natalia	122585227	Natalan@gmail.com	Cr 72 #89-23	\N
1016D	Alicia	122145227	AlicanteA@gmail.com	avenida 4a #32-14	\N
1010D	Hanner	3203002866	sinishanner@gmail.com	Cr98 #3a	123
\.


--
-- Name: area_conocimiento area_conocimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.area_conocimiento
    ADD CONSTRAINT area_conocimiento_pkey PRIMARY KEY (codigo_area);


--
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (codigo_autor);


--
-- Name: descarga descarga_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.descarga
    ADD CONSTRAINT descarga_pk PRIMARY KEY (isbn, usuario_id, fecha);


--
-- Name: digital digital_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.digital
    ADD CONSTRAINT digital_pk PRIMARY KEY (isbn, url);


--
-- Name: editorial editorial_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.editorial
    ADD CONSTRAINT editorial_pkey PRIMARY KEY (codigo);


--
-- Name: ejemplar_fisico ejemplar_fisico_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ejemplar_fisico
    ADD CONSTRAINT ejemplar_fisico_pkey PRIMARY KEY (numero);


--
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado);


--
-- Name: estudiante estudiante_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pk PRIMARY KEY (usuario_id);


--
-- Name: interes interes_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.interes
    ADD CONSTRAINT interes_pk PRIMARY KEY (usuario_id, codigo_area);


--
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (isbn);


--
-- Name: multa multa_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.multa
    ADD CONSTRAINT multa_pk PRIMARY KEY (usuario_id, isbn);


--
-- Name: peticion peticion_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.peticion
    ADD CONSTRAINT peticion_pk PRIMARY KEY (isbn, usuario_id);


--
-- Name: prestamo prestamo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.prestamo
    ADD CONSTRAINT prestamo_pkey PRIMARY KEY (numero);


--
-- Name: profesor profesor_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pk PRIMARY KEY (usuario_id);


--
-- Name: subarea subarea_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.subarea
    ADD CONSTRAINT subarea_pk PRIMARY KEY (codigo_area, nombre);


--
-- Name: ubicacion ubicacion_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ubicacion
    ADD CONSTRAINT ubicacion_pk PRIMARY KEY (isbn, nombre_sala, numero_pasillo, estante, numero_cajon);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id);


--
-- Name: subarea area_conocimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.subarea
    ADD CONSTRAINT area_conocimiento_fk FOREIGN KEY (codigo_area) REFERENCES public.area_conocimiento(codigo_area);


--
-- Name: libro area_conocimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT area_conocimiento_fk FOREIGN KEY (codigo_area) REFERENCES public.area_conocimiento(codigo_area);


--
-- Name: interes area_conocimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.interes
    ADD CONSTRAINT area_conocimiento_fk FOREIGN KEY (codigo_area) REFERENCES public.area_conocimiento(codigo_area);


--
-- Name: libro autor_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT autor_fk FOREIGN KEY (codigo_autor) REFERENCES public.autor(codigo_autor);


--
-- Name: libro editorial_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT editorial_fk FOREIGN KEY (codigo) REFERENCES public.editorial(codigo);


--
-- Name: prestamo empleado_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.prestamo
    ADD CONSTRAINT empleado_fk FOREIGN KEY (id_empleado) REFERENCES public.empleado(id_empleado);


--
-- Name: ejemplar_fisico libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ejemplar_fisico
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: ubicacion libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ubicacion
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: prestamo libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.prestamo
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: multa libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.multa
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: descarga libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.descarga
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: peticion libro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.peticion
    ADD CONSTRAINT libro_fk FOREIGN KEY (isbn) REFERENCES public.libro(isbn);


--
-- Name: profesor usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: estudiante usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: interes usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.interes
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: prestamo usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.prestamo
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: multa usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.multa
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: descarga usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.descarga
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- Name: peticion usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.peticion
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);


--
-- PostgreSQL database dump complete
--

