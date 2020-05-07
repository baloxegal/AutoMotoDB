-- Table: public.categories

-- DROP TABLE public.categories;

CREATE TABLE public.categories
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    parent_id bigint,
    CONSTRAINT categories_pkey PRIMARY KEY (id),
    CONSTRAINT unique_name UNIQUE (name),
    CONSTRAINT parent_category_fk FOREIGN KEY (parent_id)
        REFERENCES public.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.categories
    OWNER to postgres;