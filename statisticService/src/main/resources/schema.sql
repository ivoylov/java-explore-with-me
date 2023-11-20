DROP TABLE IF EXISTS hits;

CREATE TABLE IF NOT EXISTS hits (
    id bigint not null generated always as identity primary key,
    app VARCHAR(255) not null,
    uri VARCHAR(255) not null,
    ip VARCHAR(255) not null,
    timestamp TIMESTAMP WITHOUT TIME ZONE not null
);