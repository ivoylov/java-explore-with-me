DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS explore_with_me_users;

CREATE TABLE IF NOT EXISTS explore_with_me_users (
    id bigint not null generated always as identity primary key,
    name varchar(255) not null,
    email varchar not null unique
);

CREATE TABLE IF NOT EXISTS events (
    id bigint not null generated always as identity primary key,
    title varchar(255) not null,
    annotation varchar(255) not null,
    description varchar(255) not null,
    event_date timestamp without time zone,
    participant_limit int not null,
    paid bool not null,
    lat float not null,
    lon float not null
);