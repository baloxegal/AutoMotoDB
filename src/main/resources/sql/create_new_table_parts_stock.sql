-- Table: public.parts_stock

-- DROP TABLE public.parts_stock;

CREATE TABLE public.parts_stock
(
    part_id bigint NOT NULL,
    quantity bigint NOT NULL,
    CONSTRAINT parts_id_stock FOREIGN KEY (part_id)
        REFERENCES public.parts (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.parts_stock
    OWNER to postgres;