DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";

CREATE TABLE "authors" (
    "id" BIGSERIAL NOT NULL,
    "name" text,
    "age" text,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
    REFERENCES authors(id)
);