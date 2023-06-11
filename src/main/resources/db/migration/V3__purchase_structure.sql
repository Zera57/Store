create table purchase
(
    id              uuid    default gen_random_uuid()   not null,
    account_id      uuid                                not null,
    product_id      uuid                                not null,
    amount          bigint                              not null,
    purchase_date   timestamp with time zone            not null,
    PRIMARY KEY(id, product_id),
    FOREIGN KEY(account_id) REFERENCES account(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);
