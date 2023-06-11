create table account
(
    id              uuid default gen_random_uuid() not null primary key,
    user_name       varchar(255)    not null,
    password        varchar(255)    not null,
    account_role    varchar(255)    not null
);
