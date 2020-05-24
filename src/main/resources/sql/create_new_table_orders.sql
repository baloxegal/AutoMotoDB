-- Table: public.orders

-- DROP TABLE public.orders;

CREATE TABLE public.orders
(
    id bigint NOT NULL,
    quantity bigint,
    part_id bigint NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT parts_id_orders FOREIGN KEY (part_id)
        REFERENCES public.parts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;