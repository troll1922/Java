--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: shop; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'ru_RU.UTF-8' LC_CTYPE = 'ru_RU.UTF-8';


ALTER DATABASE shop OWNER TO postgres;

\connect shop

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: shop; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE shop IS 'БД магазина (урок JDBC)';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: buyings; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE buyings (
    id integer NOT NULL,
    date date NOT NULL,
    count integer NOT NULL,
    product_id integer,
    user_id integer
);


ALTER TABLE public.buyings OWNER TO postgres;

--
-- Name: buyings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE buyings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.buyings_id_seq OWNER TO postgres;

--
-- Name: buyings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE buyings_id_seq OWNED BY buyings.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE products (
    id integer NOT NULL,
    product_name text NOT NULL,
    price double precision NOT NULL,
    count integer NOT NULL,
    category text NOT NULL,
    description text NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE products_id_seq OWNED BY products.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    user_name text NOT NULL,
    money double precision NOT NULL,
    email text NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buyings ALTER COLUMN id SET DEFAULT nextval('buyings_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products ALTER COLUMN id SET DEFAULT nextval('products_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: buyings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY buyings (id, date, count, product_id, user_id) FROM stdin;
1	2015-03-16	5	36	4
2	2015-03-16	2	98	97
3	2015-03-16	2	55	63
4	2015-03-16	4	99	34
5	2015-03-16	6	82	99
6	2015-03-16	6	172	36
7	2015-03-16	6	126	9
8	2015-03-16	9	93	22
9	2015-03-16	9	36	94
10	2015-03-16	2	67	97
11	2015-03-16	8	199	1
12	2015-03-16	0	49	30
13	2015-03-16	5	45	60
14	2015-03-16	9	196	5
15	2015-03-16	0	21	12
16	2015-03-16	2	52	15
17	2015-03-16	4	190	75
18	2015-03-16	0	43	25
19	2015-03-16	3	182	9
20	2015-03-16	2	82	92
21	2015-03-16	9	24	8
22	2015-03-16	5	183	74
23	2015-03-16	5	159	42
24	2015-03-16	6	38	42
25	2015-03-16	2	114	60
26	2015-03-16	1	29	96
27	2015-03-16	0	87	17
28	2015-03-16	8	75	64
29	2015-03-16	6	99	51
30	2015-03-16	5	8	87
31	2015-03-16	9	195	46
32	2015-03-16	1	75	44
33	2015-03-16	2	74	18
34	2015-03-16	2	87	5
35	2015-03-16	0	161	90
36	2015-03-16	0	104	35
37	2015-03-16	1	144	25
38	2015-03-16	4	94	80
39	2015-03-16	2	169	27
40	2015-03-16	2	180	86
41	2015-03-16	1	76	44
42	2015-03-16	3	173	45
43	2015-03-16	8	137	94
44	2015-03-16	1	3	13
45	2015-03-16	2	186	25
46	2015-03-16	0	196	70
47	2015-03-16	4	120	92
48	2015-03-16	2	117	59
49	2015-03-16	9	84	8
50	2015-03-16	2	6	65
51	2015-03-16	8	118	85
52	2015-03-16	5	107	31
53	2015-03-16	4	18	7
54	2015-03-16	7	192	22
55	2015-03-16	7	9	88
56	2015-03-16	8	58	86
57	2015-03-16	7	59	88
58	2015-03-16	7	125	36
59	2015-03-16	8	187	47
60	2015-03-16	1	151	48
61	2015-03-16	2	144	41
62	2015-03-16	5	47	89
63	2015-03-16	9	179	32
64	2015-03-16	4	92	44
65	2015-03-16	3	132	67
66	2015-03-16	0	62	51
67	2015-03-16	9	18	30
68	2015-03-16	7	29	26
69	2015-03-16	3	27	2
70	2015-03-16	0	166	2
71	2015-03-16	4	60	7
72	2015-03-16	4	57	8
73	2015-03-16	6	56	27
74	2015-03-16	3	84	12
75	2015-03-16	8	192	84
76	2015-03-16	0	119	45
77	2015-03-16	5	167	68
78	2015-03-16	6	117	43
79	2015-03-16	7	160	47
80	2015-03-16	9	103	64
81	2015-03-16	8	80	83
82	2015-03-16	1	43	20
83	2015-03-16	4	13	54
84	2015-03-16	8	6	45
85	2015-03-16	5	174	32
86	2015-03-16	7	139	85
87	2015-03-16	7	62	15
88	2015-03-16	5	93	86
89	2015-03-16	9	177	31
90	2015-03-16	4	95	17
91	2015-03-16	7	170	9
92	2015-03-16	8	95	19
93	2015-03-16	7	196	93
94	2015-03-16	5	154	60
95	2015-03-16	3	109	69
96	2015-03-16	2	135	7
97	2015-03-16	4	139	85
98	2015-03-16	6	151	68
99	2015-03-16	0	94	70
100	2015-03-16	5	88	25
101	2015-03-16	8	71	63
102	2015-03-16	5	129	22
103	2015-03-16	8	191	3
104	2015-03-16	4	13	34
105	2015-03-16	1	102	12
106	2015-03-16	3	82	94
107	2015-03-16	1	32	96
108	2015-03-16	6	174	22
109	2015-03-16	9	92	7
110	2015-03-16	9	151	77
111	2015-03-16	2	149	2
112	2015-03-16	0	34	2
113	2015-03-16	9	170	19
114	2015-03-16	1	1	34
115	2015-03-16	7	97	11
116	2015-03-16	8	74	90
117	2015-03-16	5	196	34
118	2015-03-16	5	113	21
119	2015-03-16	9	178	42
120	2015-03-16	6	33	32
121	2015-03-16	1	124	38
122	2015-03-16	7	129	28
123	2015-03-16	6	41	30
124	2015-03-16	8	136	27
125	2015-03-16	7	93	54
126	2015-03-16	4	113	34
127	2015-03-16	9	192	3
128	2015-03-16	3	144	63
129	2015-03-16	0	80	99
130	2015-03-16	0	77	72
131	2015-03-16	3	96	85
132	2015-03-16	9	138	90
133	2015-03-16	2	125	10
134	2015-03-16	0	116	73
135	2015-03-16	9	133	4
136	2015-03-16	2	133	68
137	2015-03-16	2	114	76
138	2015-03-16	3	72	88
139	2015-03-16	6	95	19
140	2015-03-16	1	149	28
141	2015-03-16	9	70	99
142	2015-03-16	2	127	61
143	2015-03-16	2	139	52
144	2015-03-16	5	84	52
145	2015-03-16	4	18	90
146	2015-03-16	9	5	93
147	2015-03-16	9	92	12
148	2015-03-16	1	42	21
149	2015-03-16	2	2	55
150	2015-03-16	6	188	38
151	2015-03-16	2	65	21
152	2015-03-16	0	28	96
153	2015-03-16	7	150	5
154	2015-03-16	1	55	44
155	2015-03-16	6	97	20
156	2015-03-16	0	86	85
157	2015-03-16	8	108	91
158	2015-03-16	5	100	47
159	2015-03-16	3	87	34
160	2015-03-16	5	26	84
161	2015-03-16	8	159	91
162	2015-03-16	6	198	33
163	2015-03-16	7	162	21
164	2015-03-16	7	75	66
165	2015-03-16	5	78	70
166	2015-03-16	6	195	38
167	2015-03-16	0	142	82
168	2015-03-16	1	195	49
169	2015-03-16	7	11	35
170	2015-03-16	7	14	61
171	2015-03-16	3	145	1
172	2015-03-16	5	95	1
173	2015-03-16	6	90	77
174	2015-03-16	9	96	54
175	2015-03-16	1	59	61
176	2015-03-16	4	48	34
177	2015-03-16	7	181	31
178	2015-03-16	9	55	37
179	2015-03-16	4	87	31
180	2015-03-16	9	54	76
181	2015-03-16	4	117	89
182	2015-03-16	6	48	35
183	2015-03-16	6	168	24
184	2015-03-16	6	169	93
185	2015-03-16	4	59	88
186	2015-03-16	2	68	35
187	2015-03-16	1	163	68
188	2015-03-16	4	55	39
189	2015-03-16	8	131	47
190	2015-03-16	3	174	27
191	2015-03-16	6	79	68
192	2015-03-16	8	10	89
193	2015-03-16	5	1	39
194	2015-03-16	6	72	66
195	2015-03-16	3	110	18
196	2015-03-16	6	71	91
197	2015-03-16	4	120	69
198	2015-03-16	2	154	64
199	2015-03-16	1	94	4
200	2015-03-16	6	151	57
201	2015-03-16	7	123	44
202	2015-03-16	6	60	20
203	2015-03-16	6	5	86
204	2015-03-16	6	82	23
205	2015-03-16	7	189	96
206	2015-03-16	5	55	74
207	2015-03-16	6	13	40
208	2015-03-16	6	101	42
209	2015-03-16	8	23	77
210	2015-03-16	1	130	45
211	2015-03-16	3	71	71
212	2015-03-16	5	123	15
213	2015-03-16	2	60	2
214	2015-03-16	6	156	50
215	2015-03-16	7	103	92
216	2015-03-16	1	127	13
217	2015-03-16	2	48	68
218	2015-03-16	4	12	95
219	2015-03-16	5	102	38
220	2015-03-16	6	54	7
221	2015-03-16	2	26	13
222	2015-03-16	2	20	47
223	2015-03-16	6	98	48
224	2015-03-16	4	155	87
225	2015-03-16	2	18	78
226	2015-03-16	5	80	98
227	2015-03-16	7	85	3
228	2015-03-16	1	124	13
229	2015-03-16	4	191	76
230	2015-03-16	9	68	61
231	2015-03-16	2	140	71
232	2015-03-16	0	57	85
233	2015-03-16	8	194	87
234	2015-03-16	8	103	85
235	2015-03-16	6	21	76
236	2015-03-16	0	168	67
237	2015-03-16	5	189	30
238	2015-03-16	1	115	72
239	2015-03-16	4	77	68
240	2015-03-16	5	186	98
241	2015-03-16	1	117	43
242	2015-03-16	5	55	96
243	2015-03-16	0	44	90
244	2015-03-16	1	14	92
245	2015-03-16	4	160	4
246	2015-03-16	3	31	65
247	2015-03-16	6	144	1
248	2015-03-16	4	156	67
249	2015-03-16	5	124	17
250	2015-03-16	6	138	21
\.


--
-- Name: buyings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('buyings_id_seq', 250, true);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY products (id, product_name, price, count, category, description) FROM stdin;
4	productName_4	12	750	category_1	description productName_4
7	productName_7	91	600	category_1	description productName_7
15	productName_15	165	850	category_2	description productName_15
16	productName_16	8	750	category_1	description productName_16
17	productName_17	1	600	category_1	description productName_17
19	productName_19	51	600	category_1	description productName_19
22	productName_22	155	750	category_1	description productName_22
25	productName_25	177	850	category_2	description productName_25
30	productName_30	108	850	category_2	description productName_30
35	productName_35	148	850	category_2	description productName_35
37	productName_37	23	600	category_1	description productName_37
39	productName_39	136	950	category_3	description productName_39
40	productName_40	22	850	category_2	description productName_40
46	productName_46	175	750	category_1	description productName_46
50	productName_50	177	850	category_2	description productName_50
51	productName_51	79	950	category_3	description productName_51
53	productName_53	170	600	category_1	description productName_53
61	productName_61	123	600	category_1	description productName_61
63	productName_63	40	950	category_3	description productName_63
64	productName_64	154	750	category_1	description productName_64
66	productName_66	186	950	category_3	description productName_66
69	productName_69	139	950	category_3	description productName_69
73	productName_73	195	600	category_1	description productName_73
81	productName_81	101	950	category_3	description productName_81
20	productName_20	63	848	category_2	description productName_20
67	productName_67	129	598	category_1	description productName_67
49	productName_49	185	600	category_1	description productName_49
45	productName_45	65	845	category_2	description productName_45
77	productName_77	177	596	category_1	description productName_77
52	productName_52	68	748	category_1	description productName_52
32	productName_32	59	749	category_1	description productName_32
24	productName_24	13	941	category_3	description productName_24
38	productName_38	185	744	category_1	description productName_38
27	productName_27	49	947	category_3	description productName_27
33	productName_33	49	944	category_3	description productName_33
8	productName_8	143	745	category_1	description productName_8
78	productName_78	34	945	category_3	description productName_78
76	productName_76	138	749	category_1	description productName_76
3	productName_3	132	949	category_3	description productName_3
62	productName_62	172	743	category_1	description productName_62
29	productName_29	153	592	category_1	description productName_29
58	productName_58	23	742	category_1	description productName_58
59	productName_59	138	588	category_1	description productName_59
47	productName_47	31	595	category_1	description productName_47
48	productName_48	112	938	category_3	description productName_48
13	productName_13	183	586	category_1	description productName_13
5	productName_5	179	835	category_2	description productName_5
21	productName_21	88	944	category_3	description productName_21
56	productName_56	111	744	category_1	description productName_56
44	productName_44	186	750	category_1	description productName_44
43	productName_43	87	599	category_1	description productName_43
6	productName_6	34	940	category_3	description productName_6
23	productName_23	30	592	category_1	description productName_23
34	productName_34	74	750	category_1	description productName_34
72	productName_72	28	941	category_3	description productName_72
74	productName_74	101	740	category_1	description productName_74
41	productName_41	90	594	category_1	description productName_41
68	productName_68	55	739	category_1	description productName_68
60	productName_60	171	838	category_2	description productName_60
70	productName_70	166	841	category_2	description productName_70
80	productName_80	0	837	category_2	description productName_80
42	productName_42	76	949	category_3	description productName_42
2	productName_2	4	748	category_1	description productName_2
65	productName_65	100	848	category_2	description productName_65
28	productName_28	171	750	category_1	description productName_28
75	productName_75	119	834	category_2	description productName_75
11	productName_11	137	593	category_1	description productName_11
31	productName_31	51	597	category_1	description productName_31
57	productName_57	132	946	category_3	description productName_57
26	productName_26	68	743	category_1	description productName_26
12	productName_12	2	946	category_3	description productName_12
79	productName_79	180	594	category_1	description productName_79
10	productName_10	158	842	category_2	description productName_10
1	productName_1	22	594	category_1	description productName_1
71	productName_71	108	583	category_1	description productName_71
54	productName_54	165	935	category_3	description productName_54
18	productName_18	30	931	category_3	description productName_18
14	productName_14	83	742	category_1	description productName_14
83	productName_83	97	600	category_1	description productName_83
89	productName_89	112	600	category_1	description productName_89
91	productName_91	181	600	category_1	description productName_91
105	productName_105	6	850	category_2	description productName_105
106	productName_106	83	750	category_1	description productName_106
111	productName_111	80	950	category_3	description productName_111
112	productName_112	107	750	category_1	description productName_112
121	productName_121	24	600	category_1	description productName_121
122	productName_122	133	750	category_1	description productName_122
128	productName_128	35	750	category_1	description productName_128
134	productName_134	81	750	category_1	description productName_134
141	productName_141	150	950	category_3	description productName_141
143	productName_143	96	600	category_1	description productName_143
146	productName_146	195	750	category_1	description productName_146
147	productName_147	125	950	category_3	description productName_147
148	productName_148	167	750	category_1	description productName_148
152	productName_152	132	750	category_1	description productName_152
153	productName_153	105	950	category_3	description productName_153
157	productName_157	179	600	category_1	description productName_157
158	productName_158	86	750	category_1	description productName_158
159	productName_159	150	937	category_3	description productName_159
162	productName_162	120	943	category_3	description productName_162
126	productName_126	24	944	category_3	description productName_126
94	productName_94	195	745	category_1	description productName_94
150	productName_150	80	843	category_2	description productName_150
90	productName_90	78	844	category_2	description productName_90
161	productName_161	127	600	category_1	description productName_161
99	productName_99	157	940	category_3	description productName_99
104	productName_104	125	750	category_1	description productName_104
124	productName_124	35	743	category_1	description productName_124
88	productName_88	122	745	category_1	description productName_88
137	productName_137	192	592	category_1	description productName_137
154	productName_154	65	743	category_1	description productName_154
144	productName_144	31	938	category_3	description productName_144
119	productName_119	0	600	category_1	description productName_119
118	productName_118	179	742	category_1	description productName_118
107	productName_107	99	595	category_1	description productName_107
151	productName_151	159	578	category_1	description productName_151
87	productName_87	106	941	category_3	description productName_87
132	productName_132	164	947	category_3	description productName_132
92	productName_92	180	728	category_1	description productName_92
131	productName_131	45	592	category_1	description productName_131
127	productName_127	190	597	category_1	description productName_127
102	productName_102	173	944	category_3	description productName_102
113	productName_113	152	591	category_1	description productName_113
149	productName_149	138	597	category_1	description productName_149
109	productName_109	169	597	category_1	description productName_109
135	productName_135	13	848	category_2	description productName_135
84	productName_84	66	933	category_3	description productName_84
136	productName_136	22	742	category_1	description productName_136
155	productName_155	164	846	category_2	description productName_155
101	productName_101	163	594	category_1	description productName_101
86	productName_86	118	750	category_1	description productName_86
156	productName_156	68	940	category_3	description productName_156
140	productName_140	9	848	category_2	description productName_140
129	productName_129	112	938	category_3	description productName_129
93	productName_93	60	929	category_3	description productName_93
116	productName_116	188	750	category_1	description productName_116
139	productName_139	128	587	category_1	description productName_139
133	productName_133	195	589	category_1	description productName_133
97	productName_97	189	587	category_1	description productName_97
108	productName_108	198	942	category_3	description productName_108
100	productName_100	66	845	category_2	description productName_100
160	productName_160	132	839	category_2	description productName_160
142	productName_142	100	750	category_1	description productName_142
145	productName_145	94	847	category_2	description productName_145
95	productName_95	98	827	category_2	description productName_95
96	productName_96	4	938	category_3	description productName_96
110	productName_110	104	847	category_2	description productName_110
120	productName_120	74	842	category_2	description productName_120
82	productName_82	30	733	category_1	description productName_82
130	productName_130	45	849	category_2	description productName_130
123	productName_123	151	938	category_3	description productName_123
115	productName_115	60	849	category_2	description productName_115
85	productName_85	149	843	category_2	description productName_85
138	productName_138	92	935	category_3	description productName_138
103	productName_103	178	576	category_1	description productName_103
117	productName_117	159	937	category_3	description productName_117
164	productName_164	41	750	category_1	description productName_164
165	productName_165	103	850	category_2	description productName_165
171	productName_171	26	950	category_3	description productName_171
175	productName_175	143	850	category_2	description productName_175
176	productName_176	150	750	category_1	description productName_176
184	productName_184	122	750	category_1	description productName_184
185	productName_185	110	850	category_2	description productName_185
193	productName_193	0	600	category_1	description productName_193
197	productName_197	35	600	category_1	description productName_197
200	productName_200	187	850	category_2	description productName_200
172	productName_172	160	744	category_1	description productName_172
36	productName_36	142	936	category_3	description productName_36
199	productName_199	144	592	category_1	description productName_199
190	productName_190	48	846	category_2	description productName_190
182	productName_182	185	747	category_1	description productName_182
183	productName_183	2	945	category_3	description productName_183
180	productName_180	190	848	category_2	description productName_180
173	productName_173	156	597	category_1	description productName_173
198	productName_198	20	944	category_3	description productName_198
9	productName_9	191	943	category_3	description productName_9
187	productName_187	143	592	category_1	description productName_187
179	productName_179	192	591	category_1	description productName_179
166	productName_166	112	750	category_1	description productName_166
195	productName_195	87	834	category_2	description productName_195
167	productName_167	164	595	category_1	description productName_167
181	productName_181	4	593	category_1	description productName_181
177	productName_177	172	941	category_3	description productName_177
170	productName_170	108	834	category_2	description productName_170
196	productName_196	60	729	category_1	description productName_196
178	productName_178	11	741	category_1	description productName_178
192	productName_192	123	926	category_3	description productName_192
125	productName_125	128	841	category_2	description productName_125
114	productName_114	171	946	category_3	description productName_114
188	productName_188	10	744	category_1	description productName_188
169	productName_169	44	592	category_1	description productName_169
163	productName_163	44	599	category_1	description productName_163
174	productName_174	124	936	category_3	description productName_174
98	productName_98	103	742	category_1	description productName_98
191	productName_191	168	588	category_1	description productName_191
194	productName_194	44	742	category_1	description productName_194
168	productName_168	41	944	category_3	description productName_168
189	productName_189	33	938	category_3	description productName_189
186	productName_186	109	943	category_3	description productName_186
55	productName_55	16	824	category_2	description productName_55
\.


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('products_id_seq', 200, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, user_name, money, email) FROM stdin;
4	userName_4	170000	userName4@mail.ru
7	userName_7	180000	userName7@mail.ru
15	userName_15	150000	userName15@mail.ru
16	userName_16	170000	userName16@mail.ru
17	userName_17	170000	userName17@mail.ru
19	userName_19	180000	userName19@mail.ru
22	userName_22	170000	userName22@mail.ru
25	userName_25	150000	userName25@mail.ru
30	userName_30	150000	userName30@mail.ru
35	userName_35	150000	userName35@mail.ru
37	userName_37	180000	userName37@mail.ru
39	userName_39	180000	userName39@mail.ru
40	userName_40	150000	userName40@mail.ru
46	userName_46	170000	userName46@mail.ru
50	userName_50	150000	userName50@mail.ru
51	userName_51	180000	userName51@mail.ru
53	userName_53	170000	userName53@mail.ru
61	userName_61	150000	userName61@mail.ru
63	userName_63	180000	userName63@mail.ru
64	userName_64	170000	userName64@mail.ru
66	userName_66	180000	userName66@mail.ru
69	userName_69	180000	userName69@mail.ru
73	userName_73	180000	userName73@mail.ru
81	userName_81	180000	userName81@mail.ru
83	userName_83	170000	userName83@mail.ru
89	userName_89	170000	userName89@mail.ru
91	userName_91	150000	userName91@mail.ru
49	userName_49	150000	userName49@mail.ru
18	userName_18	177334	userName18@mail.ru
97	userName_97	148866	userName97@mail.ru
78	userName_78	177394	userName78@mail.ru
38	userName_38	178890	userName38@mail.ru
48	userName_48	149666	userName48@mail.ru
36	userName_36	168722	userName36@mail.ru
67	userName_67	179742	userName67@mail.ru
45	userName_45	149675	userName45@mail.ru
77	userName_77	148797	userName77@mail.ru
52	userName_52	149864	userName52@mail.ru
44	userName_44	179532	userName44@mail.ru
32	userName_32	179941	userName32@mail.ru
24	userName_24	169883	userName24@mail.ru
27	userName_27	169853	userName27@mail.ru
88	userName_88	149390	userName88@mail.ru
33	userName_33	179647	userName33@mail.ru
99	userName_99	179058	userName99@mail.ru
8	userName_8	169285	userName8@mail.ru
20	userName_20	169719	userName20@mail.ru
76	userName_76	169862	userName76@mail.ru
3	userName_3	179868	userName3@mail.ru
55	userName_55	179884	userName55@mail.ru
62	userName_62	148796	userName62@mail.ru
29	userName_29	168929	userName29@mail.ru
9	userName_9	168663	userName9@mail.ru
58	userName_58	169816	userName58@mail.ru
59	userName_59	148838	userName59@mail.ru
47	userName_47	169845	userName47@mail.ru
34	userName_34	170000	userName34@mail.ru
85	userName_85	178825	userName85@mail.ru
82	userName_82	169820	userName82@mail.ru
5	userName_5	148926	userName5@mail.ru
21	userName_21	169334	userName21@mail.ru
56	userName_56	169187	userName56@mail.ru
80	userName_80	149048	userName80@mail.ru
43	userName_43	149913	userName43@mail.ru
6	userName_6	149403	userName6@mail.ru
70	userName_70	177564	userName70@mail.ru
94	userName_94	169805	userName94@mail.ru
23	userName_23	179760	userName23@mail.ru
42	userName_42	179924	userName42@mail.ru
72	userName_72	179832	userName72@mail.ru
86	userName_86	150000	userName86@mail.ru
74	userName_74	149192	userName74@mail.ru
41	userName_41	149460	userName41@mail.ru
93	userName_93	179580	userName93@mail.ru
57	userName_57	178825	userName57@mail.ru
60	userName_60	179618	userName60@mail.ru
90	userName_90	179532	userName90@mail.ru
84	userName_84	149534	userName84@mail.ru
92	userName_92	178380	userName92@mail.ru
2	userName_2	179960	userName2@mail.ru
65	userName_65	179800	userName65@mail.ru
28	userName_28	149988	userName28@mail.ru
87	userName_87	149576	userName87@mail.ru
100	userName_100	169515	userName100@mail.ru
26	userName_26	148766	userName26@mail.ru
75	userName_75	179167	userName75@mail.ru
11	userName_11	149041	userName11@mail.ru
31	userName_31	179647	userName31@mail.ru
95	userName_95	169488	userName95@mail.ru
96	userName_96	179964	userName96@mail.ru
79	userName_79	148810	userName79@mail.ru
12	userName_12	169480	userName12@mail.ru
13	userName_13	148902	userName13@mail.ru
10	userName_10	168736	userName10@mail.ru
1	userName_1	179890	userName1@mail.ru
71	userName_71	149028	userName71@mail.ru
54	userName_54	179010	userName54@mail.ru
98	userName_98	149048	userName98@mail.ru
68	userName_68	149505	userName68@mail.ru
14	userName_14	178297	userName14@mail.ru
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 100, true);


--
-- Name: buyings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY buyings
    ADD CONSTRAINT buyings_pkey PRIMARY KEY (id);


--
-- Name: products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: buyings_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buyings
    ADD CONSTRAINT buyings_product_id_fkey FOREIGN KEY (product_id) REFERENCES products(id);


--
-- Name: buyings_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buyings
    ADD CONSTRAINT buyings_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

