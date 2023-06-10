create table product
(
    id          uuid    default gen_random_uuid()   not null primary key,
    name        varchar(255)        not null,
    description varchar(255),
    cost        bigint              not null,
    count       bigint  default 0   not null
);
