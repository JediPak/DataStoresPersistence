DROP TABLE CANDY;

CREATE TABLE if not exists CANDY (
    id bigint not null,
    name nvarchar(255),
    price decimal(12,4),
    primary key (id)
);
