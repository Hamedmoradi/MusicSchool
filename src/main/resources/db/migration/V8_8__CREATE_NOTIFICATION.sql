-- Table: public.notification

-- DROP TABLE public.notification;
create sequence notification_id_seq;

alter sequence notification_id_seq owner to postgres;
CREATE TABLE public.notification
(
    notification character varying(31) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('notification_id_seq'::regclass),
    context character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    message_type character varying(255) COLLATE pg_catalog."default",
    status integer,
    phone_number character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default",
    notification_message_type_id integer,
    CONSTRAINT notification_pkey PRIMARY KEY (id),
    CONSTRAINT fktii6wwux0pcoif4f9grlv0ln0 FOREIGN KEY (notification_message_type_id)
        REFERENCES public.notification_message_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.notification
    OWNER to postgres;