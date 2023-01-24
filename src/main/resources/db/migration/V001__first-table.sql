CREATE TABLE ord
(
    id            BIGSERIAL,
    title         VARCHAR NOT NULL,
    createDate    TIMESTAMP,
    declineDate   TIMESTAMP,
    CONSTRAINT ord_id_pk PRIMARY KEY (id)
);