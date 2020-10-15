-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL,
    date_created timestamp without time zone,
    enabled boolean,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    fk_authority_id integer NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username)
    ,
    CONSTRAINT fkbr6xv9q70uyhfj7f08ikbfeh7 FOREIGN KEY (fk_authority_id)
        REFERENCES public.authority (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;