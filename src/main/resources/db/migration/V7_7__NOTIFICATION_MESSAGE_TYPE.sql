-- Table: public.notification_message_type

-- DROP TABLE public.notification_message_type;
create sequence notification_message_type_id_seq;

alter sequence notification_message_type_id_seq owner to postgres;
CREATE TABLE public.notification_message_type
(
    id integer NOT NULL DEFAULT nextval('notification_message_type_id_seq'::regclass),
    is_active boolean,
    message_title bytea,
    type character varying(255) COLLATE pg_catalog."default",
    customer_id bigint,
    CONSTRAINT notification_message_type_pkey PRIMARY KEY (id),
    CONSTRAINT fk9skstybgh249my44oribopk8x FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.notification_message_type
    OWNER to postgres;