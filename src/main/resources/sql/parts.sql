-- Table: public.parts

-- DROP TABLE public.parts;

CREATE TABLE public.parts
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    category_id bigint NOT NULL,
    CONSTRAINT parts_pkey PRIMARY KEY (id),
    CONSTRAINT part_category_fk FOREIGN KEY (category_id)
        REFERENCES public.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.parts
    OWNER to postgres;