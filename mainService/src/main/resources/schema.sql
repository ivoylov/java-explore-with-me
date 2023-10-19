DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS explore_with_me_users;

CREATE TABLE IF NOT EXISTS explore_with_me_users (
    user_id bigint not null generated always as identity primary key,
    user_name varchar(255) not null,
    user_email varchar not null unique
);

CREATE TABLE IF NOT EXISTS events (
    event_id bigint not null generated always as identity primary key,
    user_id bigint not null REFERENCES explore_with_me_users(user_id),
    event_date TIMESTAMP WITHOUT TIME ZONE not null,
    description VARCHAR(255) not null
);