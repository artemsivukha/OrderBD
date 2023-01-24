CREATE TABLE org
(
    id      BIGSERIAL,
    name   VARCHAR NOT NULL,
    address     VARCHAR NOT NULL,
    CONSTRAINT org_id_pk PRIMARY KEY (id)
);

ALTER TABLE ord
ADD COLUMN organization_id BIGINT;