



CREATE TABLE public.person (
    id bigint NOT NULL,
    address character varying(100) NOT NULL,
    fist_name character varying(80) NOT NULL,
    gender character varying(6) NOT NULL,
    last_name character varying(80) NOT NULL
);



CREATE SEQUENCE public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE public.person_id_seq OWNED BY public.person.id;




ALTER TABLE ONLY public.person ALTER COLUMN id SET DEFAULT nextval('public.person_id_seq'::regclass);




SELECT pg_catalog.setval('public.person_id_seq', 14, true);



ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


