DROP TABLE IF EXISTS hits;

CREATE TABLE IF NOT EXISTS hits (
    hit_id bigint not null generated always as identity primary key,
    hit_app VARCHAR(255) not null,
    hit_uri VARCHAR(255) not null,
    hit_ip VARCHAR(255) not null,
    hit_timestamp TIMESTAMP WITHOUT TIME ZONE not null
);