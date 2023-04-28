create table addresses
(
    id             bigint auto_increment
        primary key,
    country        varchar(255) null,
    house          varchar(255) null,
    number_of_flat bigint       null,
    street         varchar(255) null,
    town           varchar(255) null
);

create table emails
(
    id    bigint auto_increment
        primary key,
    email varchar(255) null
);

create table customers
(
    id              bigint auto_increment
        primary key,
    name            varchar(255) null,
    name_by_father  varchar(255) null,
    passport_number varchar(255) null,
    surname         varchar(255) null,
    email_id        bigint       null,
    constraint FKelldgaccwtyb4kxu6wwf923uh
        foreign key (email_id) references emails (id)
);

create table CustomerEntity_numbersPhone
(
    CustomerEntity_id bigint       not null,
    numbersPhone      varchar(255) null,
    constraint FKqjhxvr3a6q5r9pdmioau0ut7o
        foreign key (CustomerEntity_id) references customers (id)
);

create table orders
(
    id          bigint auto_increment
        primary key,
    address_id  bigint null,
    customer_id bigint null,
    constraint FKhlglkvf5i60dv6dn397ethgpt
        foreign key (address_id) references addresses (id),
    constraint FKpxtb8awmi0dk6smoh2vp1litg
        foreign key (customer_id) references customers (id)
);

create table types_of_Material
(
    id   bigint auto_increment
        primary key,
    cost decimal(38, 2) null,
    name varchar(255)   null,
    unit varchar(10)    null
);

create table materials
(
    id                 bigint auto_increment
        primary key,
    amount             bigint null,
    `kind_material id` bigint null,
    order_id           bigint null,
    constraint FK3jxkj22jxur7uy0nsol1qxoyf
        foreign key (order_id) references orders (id),
    constraint FK8udxr9aqna6uhstlvsh6ml970
        foreign key (`kind_material id`) references types_of_Material (id)
);

create table types_of_work
(
    id   bigint auto_increment
        primary key,
    cost decimal(38, 2) null,
    name varchar(255)   null,
    unit varchar(255)   null,
    constraint UK_tc5i76ovb394p13qgffmvs2y4
        unique (name)
);

create table users
(
    id              bigint auto_increment
        primary key,
    surname         varchar(255) null,
    name            varchar(255) null,
    name_via_father varchar(255) null,
    email_id        bigint       null,
    constraint FKo9gqn8qlh6w3nt857lhxwn6uw
        foreign key (email_id) references emails (id)
);

create table manager_order
(
    order_id   bigint not null,
    manager_id bigint not null,
    constraint FK1mg5sygli0uucxsve2rwummbb
        foreign key (manager_id) references users (id),
    constraint FK34gfi1sy8akgo8h7kh14jvgcn
        foreign key (order_id) references orders (id)
);

create table works
(
    id           bigint auto_increment
        primary key,
    amount       bigint null,
    kind_work_id bigint null,
    order_id     bigint null,
    constraint FKgee8mhj6e516wwx4qdssp3tw
        foreign key (kind_work_id) references types_of_work (id),
    constraint FKgskejfslbxt19kk5dwvw7466d
        foreign key (order_id) references orders (id)
);