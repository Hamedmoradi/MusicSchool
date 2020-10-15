-- Table: public.authority

-- DROP TABLE public.authority;

CREATE TABLE  IF NOT EXISTS public.authority
(
    id integer NOT NULL,
    authority_type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT authority_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.authority
    OWNER to postgres;
