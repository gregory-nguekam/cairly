create table public.users
(
    id         bigint generated always as identity
        primary key,
    first_name varchar(50)  not null,
    last_name  varchar(50)  not null,
    email      varchar(50)  not null,
    password   varchar(100) not null
);

alter table public.users
    owner to postgres;

create table public.quote
(
    id     bigint generated always as identity
        primary key,
    text   varchar(500) not null,
    author varchar(50)  not null
);

alter table public.quote
    owner to postgres;

create table public.quote_view
(
    id          bigint generated always as identity
        primary key,
    date_viewed date   not null,
    quote_id    bigint not null
        references public.quote,
    user_id     bigint not null
        references public.users
);

alter table public.quote_view
    owner to postgres;

