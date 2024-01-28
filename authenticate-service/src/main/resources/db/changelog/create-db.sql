--liquibase formatted sql
--changeset V.Kozhevnikov:1 create table user_credential
CREATE TABLE IF NOT EXISTS user_credential (
    id bigint generated by default as identity,
    name varchar(64) NOT NULL,
    password varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    constraint pk_user_credential_id PRIMARY KEY (id),
    constraint uq_user_credential_name UNIQUE (name),
    constraint uq_user_credential_email UNIQUE (email)
);