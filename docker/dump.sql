--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

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

ALTER TABLE ONLY public.seguradoratelefone DROP CONSTRAINT fk_id_seguradora_seguradoratelefone;
ALTER TABLE ONLY public.locacao DROP CONSTRAINT fk_id_seguradora_locacao;
ALTER TABLE ONLY public.seguradora DROP CONSTRAINT fk_id_municipio_seguradora;
ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_id_municipio_cliente;
ALTER TABLE ONLY public.carro DROP CONSTRAINT fk_id_modelo_carro;
ALTER TABLE ONLY public.modelo DROP CONSTRAINT fk_id_fabricante_modelo;
ALTER TABLE ONLY public.carro DROP CONSTRAINT fk_id_fabricante_carro;
ALTER TABLE ONLY public.seguradora DROP CONSTRAINT fk_id_estado_seguradora;
ALTER TABLE ONLY public.municipio DROP CONSTRAINT fk_id_estado_municipio;
ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_id_estado_cliente;
ALTER TABLE ONLY public.locacao DROP CONSTRAINT fk_id_cliente_locacao;
ALTER TABLE ONLY public.clientetelefone DROP CONSTRAINT fk_id_cliente_clientetelefone;
ALTER TABLE ONLY public.locacao DROP CONSTRAINT fk_id_carro_locacao;
ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
ALTER TABLE ONLY public.users DROP CONSTRAINT users_login_key;
ALTER TABLE ONLY public.seguradora DROP CONSTRAINT un_cnpj;
ALTER TABLE ONLY public.seguradoratelefone DROP CONSTRAINT pk_id_seguradoratelefone;
ALTER TABLE ONLY public.seguradora DROP CONSTRAINT pk_id_seguradora;
ALTER TABLE ONLY public.municipio DROP CONSTRAINT pk_id_municipio;
ALTER TABLE ONLY public.modelo DROP CONSTRAINT pk_id_modelo;
ALTER TABLE ONLY public.locacao DROP CONSTRAINT pk_id_locacao;
ALTER TABLE ONLY public.fabricante DROP CONSTRAINT pk_id_fabricante;
ALTER TABLE ONLY public.estado DROP CONSTRAINT pk_id_estado;
ALTER TABLE ONLY public.clientetelefone DROP CONSTRAINT pk_id_clientetelefone;
ALTER TABLE ONLY public.cliente DROP CONSTRAINT pk_id_cliente;
ALTER TABLE ONLY public.carro DROP CONSTRAINT pk_id_carro;
ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_cpf_key;
ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_placa_key;
ALTER TABLE public.seguradoratelefone ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.seguradora ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.modelo ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.locacao ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.fabricante ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.contato ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.clientetelefone ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.carro ALTER COLUMN id DROP DEFAULT;
DROP TABLE public.users;
DROP SEQUENCE public.seguradoratelefone_id_seq;
DROP TABLE public.seguradoratelefone;
DROP SEQUENCE public.seguradora_id_seq;
DROP TABLE public.seguradora;
DROP SEQUENCE public.newtable_id_seq;
DROP TABLE public.municipio;
DROP SEQUENCE public.modelo_id_seq;
DROP TABLE public.modelo;
DROP SEQUENCE public.locacao_id_seq;
DROP TABLE public.locacao;
DROP SEQUENCE public.fabricante_id_seq;
DROP TABLE public.fabricante;
DROP TABLE public.estado;
DROP TABLE public.contato;
DROP SEQUENCE public.clientetelefone_id_seq;
DROP TABLE public.clientetelefone;
DROP SEQUENCE public.cliente_id_seq;
DROP TABLE public.cliente;
DROP SEQUENCE public.carro_id_seq;
DROP TABLE public.carro;
SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: carro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carro (
    id integer NOT NULL,
    id_fabricante integer NOT NULL,
    id_modelo integer NOT NULL,
    placa character varying(7) NOT NULL,
    cor character varying(10) NOT NULL,
    disponivel boolean NOT NULL,
    ano integer NOT NULL,
    valorlocacao numeric(12,2) NOT NULL
);


ALTER TABLE public.carro OWNER TO postgres;

--
-- Name: carro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carro_id_seq OWNER TO postgres;

--
-- Name: carro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carro_id_seq OWNED BY public.carro.id;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    rg character varying(9) NOT NULL,
    cpf character varying(11) NOT NULL,
    nome character varying(100) NOT NULL,
    logradouro character varying(100) NOT NULL,
    id_municipio integer NOT NULL,
    id_estado integer NOT NULL,
    cnh character varying(11) NOT NULL,
    datavencimentocnh date,
    email character varying(50) NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- Name: clientetelefone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientetelefone (
    id integer NOT NULL,
    id_cliente integer NOT NULL,
    telefone character varying(20) NOT NULL
);


ALTER TABLE public.clientetelefone OWNER TO postgres;

--
-- Name: clientetelefone_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientetelefone_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientetelefone_id_seq OWNER TO postgres;

--
-- Name: clientetelefone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientetelefone_id_seq OWNED BY public.clientetelefone.id;


--
-- Name: contato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contato (
    id integer NOT NULL,
    email character varying NOT NULL
);


ALTER TABLE public.contato OWNER TO postgres;

--
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id integer NOT NULL,
    descricao character varying(100) NOT NULL,
    sigla character varying(2) NOT NULL
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- Name: fabricante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fabricante (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    imgurl text
);


ALTER TABLE public.fabricante OWNER TO postgres;

--
-- Name: fabricante_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fabricante_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fabricante_id_seq OWNER TO postgres;

--
-- Name: fabricante_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fabricante_id_seq OWNED BY public.fabricante.id;


--
-- Name: locacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.locacao (
    id integer NOT NULL,
    id_carro integer NOT NULL,
    id_seguradora integer NOT NULL,
    id_cliente integer NOT NULL,
    datalocacao date NOT NULL,
    datadevolucao date NOT NULL,
    datadevolvida date NOT NULL,
    valor numeric(12,2) NOT NULL,
    valordesconto numeric(12,2) NOT NULL,
    valortotal numeric(12,2) NOT NULL
);


ALTER TABLE public.locacao OWNER TO postgres;

--
-- Name: locacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.locacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locacao_id_seq OWNER TO postgres;

--
-- Name: locacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.locacao_id_seq OWNED BY public.locacao.id;


--
-- Name: modelo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modelo (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    id_fabricante integer NOT NULL
);


ALTER TABLE public.modelo OWNER TO postgres;

--
-- Name: modelo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modelo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modelo_id_seq OWNER TO postgres;

--
-- Name: modelo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modelo_id_seq OWNED BY public.modelo.id;


--
-- Name: municipio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.municipio (
    id integer NOT NULL,
    descricao character varying(100) NOT NULL,
    id_estado integer NOT NULL
);


ALTER TABLE public.municipio OWNER TO postgres;

--
-- Name: newtable_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.newtable_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.newtable_id_seq OWNER TO postgres;

--
-- Name: newtable_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.newtable_id_seq OWNED BY public.contato.id;


--
-- Name: seguradora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seguradora (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    cnpj character varying(14) NOT NULL,
    email character varying(100) NOT NULL,
    valor numeric(13,2) NOT NULL,
    id_municipio integer NOT NULL,
    id_estado integer NOT NULL
);


ALTER TABLE public.seguradora OWNER TO postgres;

--
-- Name: seguradora_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seguradora_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seguradora_id_seq OWNER TO postgres;

--
-- Name: seguradora_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.seguradora_id_seq OWNED BY public.seguradora.id;


--
-- Name: seguradoratelefone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seguradoratelefone (
    id integer NOT NULL,
    id_seguradora integer NOT NULL,
    telefone character varying(20) NOT NULL
);


ALTER TABLE public.seguradoratelefone OWNER TO postgres;

--
-- Name: seguradoratelefone_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seguradoratelefone_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seguradoratelefone_id_seq OWNER TO postgres;

--
-- Name: seguradoratelefone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.seguradoratelefone_id_seq OWNED BY public.seguradoratelefone.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id text NOT NULL,
    login text,
    password text,
    role text,
    name character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: carro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro ALTER COLUMN id SET DEFAULT nextval('public.carro_id_seq'::regclass);


--
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- Name: clientetelefone id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientetelefone ALTER COLUMN id SET DEFAULT nextval('public.clientetelefone_id_seq'::regclass);


--
-- Name: contato id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato ALTER COLUMN id SET DEFAULT nextval('public.newtable_id_seq'::regclass);


--
-- Name: fabricante id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fabricante ALTER COLUMN id SET DEFAULT nextval('public.fabricante_id_seq'::regclass);


--
-- Name: locacao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locacao ALTER COLUMN id SET DEFAULT nextval('public.locacao_id_seq'::regclass);


--
-- Name: modelo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelo ALTER COLUMN id SET DEFAULT nextval('public.modelo_id_seq'::regclass);


--
-- Name: seguradora id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradora ALTER COLUMN id SET DEFAULT nextval('public.seguradora_id_seq'::regclass);


--
-- Name: seguradoratelefone id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradoratelefone ALTER COLUMN id SET DEFAULT nextval('public.seguradoratelefone_id_seq'::regclass);


--
-- Data for Name: carro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carro (id, id_fabricante, id_modelo, placa, cor, disponivel, ano, valorlocacao) FROM stdin;
11	9	9	VWX6789	Orange	t	2021	115.00
12	10	10	YZA0123	Purple	t	2016	75.00
13	11	11	AAA1111	Preto	t	2022	100.00
15	13	13	CCC3333	Azul	t	2020	130.00
16	14	14	DDD4444	Vermelho	t	2019	140.00
17	15	15	EEE5555	Verde	t	2018	150.00
18	16	16	FFF6666	Amarelo	t	2017	160.00
19	17	17	GGG7777	Cinza	t	2016	170.00
21	19	19	III9999	Rosa	t	2014	190.00
23	1	1	FHTT123	ROSA	t	2024	1890.00
25	1	1	FASDF	R	t	2012	1902.00
27	1	1	FASD1	R	t	2012	1902.00
29	1	1	FASwq	R	t	2012	1902.00
31	1	1	FH123	R	t	2012	1902.00
33	1	1	ASDA	ROSA	t	2012	19298.00
34	1	1	ABCD	ROSA	t	2012	19298.00
36	1	1	FHGS12	VERDE	t	1999	199.00
37	1	1	AFDAS	LI	t	1992	121.00
44	1	1	GDFAS	TER	t	1992	123.00
43	1	1	ASDAD	123	t	123123	1212.00
45	1	1	HSGDAS	123	t	1821	123.00
47	1	1	SADAS	123	t	12312	112.00
39	1	1	FHGGS	FHGGS	t	123	123.00
42	1	1	FHGGSa	FHGGS	t	123	123.00
35	1	1	JAHS	VERDE	t	1992	120.00
14	12	12	BBB2222	Branco	f	2021	120.00
20	18	18	HHH8888	Marrom	f	2015	180.00
1	1	1	FOX9T11	PRETA	t	2022	1500.00
2	1	2	FOX9T35	PRETA	t	2022	1500.00
3	1	1	ABC1232	Blue	t	2020	100.00
4	2	2	XYZ5678	Red	t	2019	90.00
5	3	3	DEF9876	Silver	t	2021	110.00
6	4	4	GHI6543	Black	t	2018	85.00
7	5	5	JKL3210	White	t	2022	120.00
8	6	6	MNO4567	Gray	t	2017	80.00
9	7	7	PQR8901	Green	t	2019	95.00
10	8	8	STU2345	Yellow	t	2020	105.00
57	9	9	JESUS12	Orange	t	2021	115.00
59	9	9	JESUS13	Orange	t	2021	115.00
61	9	9	JESUS14	Orange	t	2021	115.00
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, rg, cpf, nome, logradouro, id_municipio, id_estado, cnh, datavencimentocnh, email) FROM stdin;
4	123456789	01234567890	John Doe	123 Main St	1	1	98765432101	2023-12-31	john.doe@example.com
5	987654321	09876543210	Jane Doe	456 Oak St	2	2	12345678901	2024-05-15	jane.doe@example.com
6	111223344	11223344556	Alice Smith	789 Pine St	3	3	55443322111	2023-08-20	alice.smith@example.com
7	555666777	55555555555	Bob Johnson	987 Elm St	4	4	44444444444	2022-10-01	bob.johnson@example.com
8	999888777	99999999999	Eva Davis	654 Maple St	5	5	88887777666	2023-11-15	eva.davis@example.com
9	444333222	44444444444	Chris Wilson	321 Oak St	6	6	33332222111	2024-02-28	chris.wilson@example.com
10	777888999	77777777777	Grace Miller	987 Pine St	7	7	99998888777	2022-07-10	grace.miller@example.com
11	888777666	88888888888	David Jones	456 Cedar St	8	8	77776666555	2023-04-05	david.jones@example.com
3	222333444	22222222222	Sophie Brown	789 Maple St	9	9	44443333222	2024-09-15	sophie.brown@example.com
16	111111111	11111111121	Cliente11	Rua 11	11	11	CNH11	2023-01-01	cliente11@example.com
17	222222222	22223222222	Cliente12	Rua 12	12	12	CNH12	2023-02-02	cliente12@example.com
18	333333333	23333333333	Cliente13	Rua 13	13	13	CNH13	2023-03-03	cliente13@example.com
19	444444444	42444444444	Cliente14	Rua 14	14	14	CNH14	2023-04-04	cliente14@example.com
20	555555555	55255555555	Cliente15	Rua 15	15	15	CNH15	2023-05-05	cliente15@example.com
21	666666666	66626666666	Cliente16	Rua 16	16	16	CNH16	2023-06-06	cliente16@example.com
15	777777777	77772777777	Cliente17	Rua 17	17	17	CNH17	2023-07-07	cliente17@example.com
14	888888888	88888288888	Cliente18	Rua 18	18	18	CNH18	2023-08-08	cliente18@example.com
13	999999999	99999929999	Cliente19	Rua 19	19	19	CNH19	2023-09-09	cliente19@example.com
12	000000000	00000002000	Cliente20	Rua 20	20	20	CNH20	2023-10-10	cliente20@example.com
2	333444555	33333333333	Michael White	654 Pine St	10	10	55554444333	2025-01-06	michael.white@example.com
27	999999999	99836638053	LUCAS VIGANO	RUA DA MINHA HUMILDE RESIDENCIA, 100	1	1	30132394323	2025-01-06	lucass.vigano@gmail.com
1	999999999	99836638059	LUCAS VIGANO	RUA DA MINHA HUMILDE RESIDENCIA, 100	1	1	30132394323	2025-01-06	lucass.vigano@gmail.com
\.


--
-- Data for Name: clientetelefone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientetelefone (id, id_cliente, telefone) FROM stdin;
2	2	9876543210
3	3	1112223333
4	4	5556667777
5	5	9998887777
6	6	4443332222
7	7	7778889999
8	8	8887776666
9	9	2223334444
10	10	3334445555
31	11	111-111-1111
32	12	222-222-2222
33	13	333-333-3333
34	14	444-444-4444
35	15	555-555-5555
36	16	666-666-6666
37	17	777-777-7777
38	18	888-888-8888
39	19	999-999-9999
40	20	000-000-0000
1	1	1234567890
41	1	1234567890
42	1	1234567890
43	1	1234567891
\.


--
-- Data for Name: contato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contato (id, email) FROM stdin;
1	rodolfo@gmail.com
2	rodolfo@gmail.com
3	rodolfo@gmail.com
4	rodolfo@gmail.com
\.


--
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado (id, descricao, sigla) FROM stdin;
2	Rio de Janeiro	RJ
3	Minas Gerais	MG
4	Rio Grande do Sul	RS
5	Bahia	BA
6	Santa Catarina	SC
7	Ceará	CE
8	Paraná	PR
9	Pernambuco	PE
10	Goiás	GO
11	Estado11	E1
12	Estado12	E2
13	Estado13	E3
14	Estado14	E4
15	Estado15	E5
16	Estado16	E6
17	Estado17	E7
18	Estado18	E8
19	Estado19	E9
20	Estado20	E1
1	Sao Paulo	SP
\.


--
-- Data for Name: fabricante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fabricante (id, nome, imgurl) FROM stdin;
2	CHEVROLET	\N
3	FIAT	\N
4	Toyota	\N
7	Chevrolet	\N
8	Volkswagen	\N
10	BMW	\N
12	Audi	\N
13	Hyundai	\N
9	Nissan	\N
16	Fabricante13	\N
20	Fabricante17	\N
22	Fabricante19	\N
23	Fabricante20	\N
36	ABCD TESTE	\N
21	Fabricante18 TESTE	\N
14	Fabricante11 Car	\N
15	Fabricante12 Car	\N
18	Fabricante15 Car	\N
37	TESTE CARD	\N
11	Mercedes-Benz car	\N
6	Honda Car	\N
39	abcd	\N
40	abcd	\N
17	Fabricante99	\N
38	abcd	\N
19	Fabricante160	\N
5	Ford Car 00	http
41	VW	\N
42	VW	\N
43	VW	\N
89	RODOLFO BRANDAO	\N
91	RODOLFO BRANDAO	\N
92	RODOLFO BRANDAO	\N
93	RODOLFO BRANDAO	\N
94	RODOLFO BRANDAO	\N
95	RODOLFO	\N
96	RODOLFO	\N
1	HONDA	\N
97	HONDA	\N
98	HONDA	\N
\.


--
-- Data for Name: locacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.locacao (id, id_carro, id_seguradora, id_cliente, datalocacao, datadevolucao, datadevolvida, valor, valordesconto, valortotal) FROM stdin;
2	1	1	1	2024-01-06	2024-01-16	2024-01-16	17000.00	0.00	17000.00
43	3	11	13	2023-02-02	2023-02-11	2023-02-12	120.00	12.00	108.00
44	6	15	1	2023-03-03	2023-03-12	2023-03-13	130.00	13.00	117.00
45	6	17	13	2023-04-04	2023-04-13	2023-04-14	140.00	14.00	126.00
46	7	8	12	2023-05-05	2023-05-14	2023-05-15	150.00	15.00	135.00
47	19	3	20	2023-06-06	2023-06-15	2023-06-16	160.00	16.00	144.00
48	5	9	3	2023-07-07	2023-07-16	2023-07-17	170.00	17.00	153.00
49	6	10	12	2023-08-08	2023-08-17	2023-08-18	180.00	18.00	162.00
50	19	8	11	2023-09-09	2023-09-18	2023-09-19	190.00	19.00	171.00
51	12	8	6	2023-10-10	2023-10-19	2023-10-20	200.00	20.00	180.00
52	8	11	1	2024-02-02	2024-02-11	2024-02-12	120.00	12.00	108.00
53	18	1	17	2024-03-03	2024-03-12	2024-03-13	130.00	13.00	117.00
54	19	18	16	2024-04-04	2024-04-13	2024-04-14	140.00	14.00	126.00
55	11	5	13	2024-05-05	2024-05-14	2024-05-15	150.00	15.00	135.00
56	19	2	19	2024-06-06	2024-06-15	2024-06-16	160.00	16.00	144.00
57	15	4	12	2024-07-07	2024-07-16	2024-07-17	170.00	17.00	153.00
58	10	16	14	2024-08-08	2024-08-17	2024-08-18	180.00	18.00	162.00
59	9	9	12	2024-09-09	2024-09-18	2024-09-19	190.00	19.00	171.00
60	1	11	10	2024-10-10	2024-10-19	2024-10-20	200.00	20.00	180.00
61	8	13	11	2024-11-11	2024-11-20	2024-11-21	220.00	22.00	198.00
62	7	12	10	2024-12-01	2024-12-10	2024-12-11	120.00	12.00	108.00
63	1	17	3	2025-01-01	2025-01-10	2025-01-11	130.00	13.00	117.00
64	13	9	13	2025-02-02	2025-02-11	2025-02-12	140.00	14.00	126.00
65	17	6	16	2025-03-03	2025-03-12	2025-03-13	150.00	15.00	135.00
66	16	13	18	2025-04-04	2025-04-13	2025-04-14	160.00	16.00	144.00
67	14	18	14	2025-05-05	2025-05-14	2025-05-15	170.00	17.00	153.00
68	14	13	7	2025-06-06	2025-06-15	2025-06-16	180.00	18.00	162.00
69	16	4	19	2025-07-07	2025-07-16	2025-07-17	190.00	19.00	171.00
70	9	3	18	2025-08-08	2025-08-17	2025-08-18	200.00	20.00	180.00
71	14	9	14	2025-09-09	2025-09-18	2025-09-19	210.00	21.00	189.00
72	7	18	19	2025-10-10	2025-10-19	2025-10-20	220.00	22.00	198.00
3	1	1	1	2024-01-26	2024-02-05	2024-02-06	120.00	10.00	110.00
4	2	2	2	2024-01-27	2024-02-08	2024-02-09	110.00	5.00	105.00
5	3	3	3	2024-01-28	2024-02-15	2024-02-16	130.00	15.00	115.00
6	4	4	4	2024-01-29	2024-02-25	2024-02-26	100.00	8.00	92.00
7	5	5	5	2024-01-30	2024-03-05	2024-03-06	140.00	12.00	128.00
8	6	6	6	2024-01-31	2024-03-12	2024-03-13	90.00	7.00	83.00
9	7	7	7	2024-02-01	2024-03-18	2024-03-19	95.00	3.00	92.00
10	8	8	8	2024-02-02	2024-03-25	2024-03-26	105.00	10.00	95.00
11	9	9	9	2024-02-03	2024-04-02	2024-04-03	115.00	6.00	109.00
73	2	17	13	2025-11-11	2025-11-20	2025-11-21	230.00	23.00	207.00
1	10	10	10	2024-02-04	2024-04-09	2024-04-10	75.00	8.00	67.00
74	8	5	1	2025-12-12	2025-12-21	2025-12-22	240.00	24.00	216.00
12	11	11	11	2023-01-01	2023-01-10	2023-01-11	100.00	10.00	90.00
13	12	12	12	2023-02-02	2023-02-11	2023-02-12	120.00	12.00	108.00
14	13	13	13	2023-03-03	2023-03-12	2023-03-13	130.00	13.00	117.00
15	14	14	14	2023-04-04	2023-04-13	2023-04-14	140.00	14.00	126.00
16	15	15	15	2023-05-05	2023-05-14	2023-05-15	150.00	15.00	135.00
17	16	16	16	2023-06-06	2023-06-15	2023-06-16	160.00	16.00	144.00
18	17	17	17	2023-07-07	2023-07-16	2023-07-17	170.00	17.00	153.00
19	18	18	18	2023-08-08	2023-08-17	2023-08-18	180.00	18.00	162.00
20	19	19	19	2023-09-09	2023-09-18	2023-09-19	190.00	19.00	171.00
21	20	20	20	2023-10-10	2023-10-19	2023-10-20	200.00	20.00	180.00
75	5	5	3	2026-01-01	2026-01-10	2026-01-11	250.00	25.00	225.00
76	18	4	14	2026-02-02	2026-02-11	2026-02-12	260.00	26.00	234.00
77	4	12	1	2026-03-03	2026-03-12	2026-03-13	270.00	27.00	243.00
78	1	4	1	2026-04-04	2026-04-13	2026-04-14	280.00	28.00	252.00
79	15	16	19	2026-05-05	2026-05-14	2026-05-15	290.00	29.00	261.00
80	12	16	5	2026-06-06	2026-06-15	2026-06-16	300.00	30.00	270.00
82	14	1	1	2024-03-23	2024-03-24	2024-03-24	0.00	0.00	320.00
84	20	1	1	2024-03-23	2024-03-24	2024-03-24	0.00	0.00	380.00
85	5	8	9	2023-01-01	2023-01-10	2023-01-11	100.00	10.00	90.00
42	5	8	9	2023-01-01	2023-01-10	2023-01-11	100.00	10.00	90.00
\.


--
-- Data for Name: modelo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modelo (id, nome, id_fabricante) FROM stdin;
8	Civic	3
9	Cruze	4
10	Golf	5
11	Altima	6
12	X3	7
13	C-Class	8
15	Elantra	10
25	Modelo200	20
14	A4A	9
2	ONIXX	2
1	CITYX	1
22	Modelo17X	17
16	Modelo11X	11
23	Modelo18SS	18
17	Modelo12	12
21	Modelo16F	16
20	Modelo15SS	15
19	Modelo14FS	14
18	Modelo13a	13
24	Modelo19SSS	19
4	CRUZE	2
5	UNOS	3
7	Focus	2
54	ABCDRODOLFO	2
55	ABCDRODOLFO	2
56	ABCDRODOLFONOVO	2
30	ABCDRODOLFs1	2
3	StringUNOS	1
35	Modelo 1	1
37	Modelo 1	1
42	2022	3
43	2022	3
44	2022	3
45	2022	3
46	2022	3
47	2022	3
48	2022	3
58	ABCDRODOLFsSSSS1	2
57	ABCDRODOLFOFF	2
6	Corolla	1
59	Corolla	1
60	Corolla	1
\.


--
-- Data for Name: municipio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.municipio (id, descricao, id_estado) FROM stdin;
2	Campinas	1
3	Belo Horizonte	3
4	Porto Alegre	4
5	Salvador	5
6	Florianópolis	6
7	Fortaleza	7
8	Curitiba	8
9	Recife	9
10	Goiânia	10
11	Municipio11	11
12	Municipio12	12
13	Municipio13	13
14	Municipio14	14
15	Municipio15	15
16	Municipio16	16
17	Municipio17	17
18	Municipio18	18
19	Municipio19	19
20	Municipio20	20
1	Limeira	1
\.


--
-- Data for Name: seguradora; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seguradora (id, nome, cnpj, email, valor, id_municipio, id_estado) FROM stdin;
2	PORTO SEGURO	45833130000143	contato@porto.com	600.00	1	1
3	ITAU SEGUROS	44039025000174	contato@iseguros.com	549.57	1	1
4	Seguradora A	12345678901234	seguradora_a@example.com	500.00	1	1
5	Seguradora B	56789012345678	seguradora_b@example.com	600.00	2	2
6	Seguradora C	90123456789012	seguradora_c@example.com	700.00	3	3
7	Seguradora D	34567890123456	seguradora_d@example.com	550.00	4	4
8	Seguradora E	78901234567890	seguradora_e@example.com	650.00	5	5
9	Seguradora F	12345098765432	seguradora_f@example.com	750.00	6	6
10	Seguradora G	67890123456789	seguradora_g@example.com	520.00	7	7
11	Seguradora H	23456789012345	seguradora_h@example.com	620.00	8	8
12	Seguradora I	89012345678901	seguradora_i@example.com	720.00	9	9
13	Seguradora J	45678901234567	seguradora_j@example.com	580.00	10	10
14	Seguradora11	CNPJ11	email11@example.com	1000.00	11	11
15	Seguradora12	CNPJ12	email12@example.com	1200.00	12	12
16	Seguradora13	CNPJ13	email13@example.com	1300.00	13	13
17	Seguradora14	CNPJ14	email14@example.com	1400.00	14	14
18	Seguradora15	CNPJ15	email15@example.com	1500.00	15	15
19	Seguradora16	CNPJ16	email16@example.com	1600.00	16	16
20	Seguradora17	CNPJ17	email17@example.com	1700.00	17	17
21	Seguradora18	CNPJ18	email18@example.com	1800.00	18	18
22	Seguradora19	CNPJ19	email19@example.com	1900.00	19	19
23	Seguradora20	CNPJ20	email20@example.com	2000.00	20	20
1	ALIANZ	77601101000142	contato@alianz.com	200.00	1	1
32	A1IANs	77101101000142	contato@alianz.co	200.00	1	1
34	A1IA1s	77101121000142	cont@alianz.co	200.00	1	1
\.


--
-- Data for Name: seguradoratelefone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seguradoratelefone (id, id_seguradora, telefone) FROM stdin;
2	2	987654321
3	3	111223344
4	4	555666777
5	5	999888777
6	6	444333222
7	7	777888999
8	8	888777666
9	9	222333444
10	10	333444555
11	11	111-111-1111
12	12	222-222-2222
13	13	333-333-3333
14	14	444-444-4444
15	15	555-555-5555
16	16	666-666-6666
17	17	777-777-7777
18	18	888-888-8888
19	19	999-999-9999
20	20	000-000-0000
1	1	123456789
21	1	123456789
22	1	123456789
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, role, name) FROM stdin;
7bcbccfa-96c1-45bb-af06-efacefd332a7	rodolfo	$2a$10$L0D5Hc7ppNTrjWarcYEnW.HgbKcQ7w9qzWSQ1.nIzGNpOU4hYMJYG	0	\N
2b9fb00c-23d0-4f52-b353-0ff442b13101	usernamee	$2a$10$NcO3Jn6MOoVnidpsGz/jr.EaiKLSY97P7wVD4phzr4UrGqqPf3cGC	1	\N
\.


--
-- Name: carro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carro_id_seq', 61, true);


--
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 27, true);


--
-- Name: clientetelefone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientetelefone_id_seq', 43, true);


--
-- Name: fabricante_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fabricante_id_seq', 98, true);


--
-- Name: locacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.locacao_id_seq', 85, true);


--
-- Name: modelo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modelo_id_seq', 60, true);


--
-- Name: newtable_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.newtable_id_seq', 4, true);


--
-- Name: seguradora_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seguradora_id_seq', 34, true);


--
-- Name: seguradoratelefone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seguradoratelefone_id_seq', 22, true);


--
-- Name: carro carro_placa_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_placa_key UNIQUE (placa);


--
-- Name: cliente cliente_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);


--
-- Name: carro pk_id_carro; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT pk_id_carro PRIMARY KEY (id);


--
-- Name: cliente pk_id_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_id_cliente PRIMARY KEY (id);


--
-- Name: clientetelefone pk_id_clientetelefone; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientetelefone
    ADD CONSTRAINT pk_id_clientetelefone PRIMARY KEY (id);


--
-- Name: estado pk_id_estado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT pk_id_estado PRIMARY KEY (id);


--
-- Name: fabricante pk_id_fabricante; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fabricante
    ADD CONSTRAINT pk_id_fabricante PRIMARY KEY (id);


--
-- Name: locacao pk_id_locacao; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locacao
    ADD CONSTRAINT pk_id_locacao PRIMARY KEY (id);


--
-- Name: modelo pk_id_modelo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelo
    ADD CONSTRAINT pk_id_modelo PRIMARY KEY (id);


--
-- Name: municipio pk_id_municipio; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT pk_id_municipio PRIMARY KEY (id);


--
-- Name: seguradora pk_id_seguradora; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradora
    ADD CONSTRAINT pk_id_seguradora PRIMARY KEY (id);


--
-- Name: seguradoratelefone pk_id_seguradoratelefone; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradoratelefone
    ADD CONSTRAINT pk_id_seguradoratelefone PRIMARY KEY (id);


--
-- Name: seguradora un_cnpj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradora
    ADD CONSTRAINT un_cnpj UNIQUE (cnpj);


--
-- Name: users users_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_login_key UNIQUE (login);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: locacao fk_id_carro_locacao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locacao
    ADD CONSTRAINT fk_id_carro_locacao FOREIGN KEY (id_carro) REFERENCES public.carro(id);


--
-- Name: clientetelefone fk_id_cliente_clientetelefone; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientetelefone
    ADD CONSTRAINT fk_id_cliente_clientetelefone FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);


--
-- Name: locacao fk_id_cliente_locacao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locacao
    ADD CONSTRAINT fk_id_cliente_locacao FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);


--
-- Name: cliente fk_id_estado_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_id_estado_cliente FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- Name: municipio fk_id_estado_municipio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.municipio
    ADD CONSTRAINT fk_id_estado_municipio FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- Name: seguradora fk_id_estado_seguradora; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradora
    ADD CONSTRAINT fk_id_estado_seguradora FOREIGN KEY (id_estado) REFERENCES public.estado(id);


--
-- Name: carro fk_id_fabricante_carro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT fk_id_fabricante_carro FOREIGN KEY (id_fabricante) REFERENCES public.fabricante(id);


--
-- Name: modelo fk_id_fabricante_modelo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modelo
    ADD CONSTRAINT fk_id_fabricante_modelo FOREIGN KEY (id_fabricante) REFERENCES public.fabricante(id);


--
-- Name: carro fk_id_modelo_carro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT fk_id_modelo_carro FOREIGN KEY (id_modelo) REFERENCES public.modelo(id);


--
-- Name: cliente fk_id_municipio_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_id_municipio_cliente FOREIGN KEY (id_municipio) REFERENCES public.municipio(id);


--
-- Name: seguradora fk_id_municipio_seguradora; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradora
    ADD CONSTRAINT fk_id_municipio_seguradora FOREIGN KEY (id_municipio) REFERENCES public.municipio(id);


--
-- Name: locacao fk_id_seguradora_locacao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.locacao
    ADD CONSTRAINT fk_id_seguradora_locacao FOREIGN KEY (id_seguradora) REFERENCES public.seguradora(id);


--
-- Name: seguradoratelefone fk_id_seguradora_seguradoratelefone; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seguradoratelefone
    ADD CONSTRAINT fk_id_seguradora_seguradoratelefone FOREIGN KEY (id_seguradora) REFERENCES public.seguradora(id);


--
-- PostgreSQL database dump complete
--

