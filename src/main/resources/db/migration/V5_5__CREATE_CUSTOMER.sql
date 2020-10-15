-- Table: public.customer

-- DROP TABLE public.customer;

-- auto-generated definition
create sequence customer_id_seq;

alter sequence customer_id_seq owner to postgres;

CREATE TABLE public.customer
(
    id bigint NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    created_by character varying(255) COLLATE pg_catalog."default",
    creation_date timestamp without time zone,
    last_modified_by character varying(255) COLLATE pg_catalog."default",
    last_modified_date timestamp without time zone,
    cell_phone character varying(255) COLLATE pg_catalog."default",
    created_date bigint NOT NULL,
    email_address character varying(255) COLLATE pg_catalog."default",
    family character varying(255) COLLATE pg_catalog."default",
    modified_date bigint,
    name character varying(255) COLLATE pg_catalog."default",
    national_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;

