-- Table: public.scheduler

-- DROP TABLE public.scheduler;
create sequence scheduler_id_seq;
alter sequence scheduler_id_seq owner to postgres;

CREATE TABLE public.scheduler
(
    id integer NOT NULL DEFAULT nextval('scheduler_id_seq'::regclass),
    busy boolean,
    due_date timestamp without time zone,
    request_date timestamp without time zone,
    service_code integer,
    service_name character varying(255) COLLATE pg_catalog."default",
    status integer,
    notification_id integer,
    CONSTRAINT scheduler_pkey PRIMARY KEY (id),
    CONSTRAINT fk6tvwch0pcwhliqfy5lg80p9cp FOREIGN KEY (notification_id)
        REFERENCES public.notification (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.scheduler
    OWNER to postgres;