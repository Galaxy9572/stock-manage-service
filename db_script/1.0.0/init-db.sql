create user stock_manage
    superuser
    createdb;

create table if not exists user_info
(
    id                 bigint                not null
        constraint user_info_pk
            primary key,
    user_name          varchar(256)          not null,
    encrypted_password varchar(256)          not null,
    salt               varchar(6)            not null,
    create_time        timestamp             not null,
    update_time        timestamp             not null,
    logic_delete       boolean default false not null
);

comment on column user_info.id is '主键';

comment on column user_info.user_name is '用户名';

comment on column user_info.encrypted_password is '密码';

comment on column user_info.salt is '盐值';

comment on column user_info.create_time is '创建时间';

comment on column user_info.update_time is '更新时间';

comment on column user_info.logic_delete is '逻辑删除';

alter table user_info
    owner to stock_manage;

create table if not exists goods_type
(
    id             bigint                  not null
        constraint goods_type_pk
            primary key,
    type_name      varchar(256)            not null,
    parent_type_id bigint,
    create_time    timestamp default now() not null,
    update_time    timestamp default now() not null,
    logic_delete   boolean   default false not null,
    create_user_id bigint                  not null,
    update_user_id bigint                  not null
);

comment on table goods_type is '商品类别';

comment on column goods_type.id is '主键';

comment on column goods_type.type_name is '商品类别名称';

comment on column goods_type.parent_type_id is '父类别ID';

comment on column goods_type.create_time is '创建时间';

comment on column goods_type.update_time is '更新时间';

comment on column goods_type.logic_delete is '逻辑删除';

comment on column goods_type.create_user_id is '创建用户ID';

comment on column goods_type.update_user_id is '更新用户ID';

alter table goods_type
    owner to stock_manage;

create table if not exists goods_info
(
    id             bigint                  not null,
    goods_name     varchar(256)            not null,
    goods_type_id  bigint                  not null,
    goods_unit_id  bigint                  not null,
    memo           text,
    create_user_id bigint                  not null,
    update_user_id bigint                  not null,
    create_time    timestamp default now() not null,
    update_time    timestamp default now() not null,
    logic_delete   boolean   default false not null
);

comment on table goods_info is '商品';

comment on column goods_info.goods_name is '品名';

comment on column goods_info.goods_type_id is '商品类别ID';

comment on column goods_info.goods_unit_id is '商品计量单位ID';

comment on column goods_info.memo is '备注';

comment on column goods_info.create_user_id is '创建人ID';

comment on column goods_info.update_user_id is '更新用户ID';

comment on column goods_info.create_time is '创建时间';

comment on column goods_info.update_time is '更新时间';

comment on column goods_info.logic_delete is '逻辑删除';

alter table goods_info
    owner to stock_manage;

create table if not exists goods_stock
(
    id                bigint                  not null
        constraint goods_stock_pk
            primary key,
    goods_id          bigint                  not null,
    purchase_price    numeric                 not null,
    retail_price      numeric                 not null,
    wholesale_price   numeric,
    init_stock_num    bigint    default 0     not null,
    min_stock_num     bigint    default 0     not null,
    max_stock_num     bigint    default 0     not null,
    current_stock_num bigint    default 0     not null,
    create_user_id    bigint                  not null,
    update_user_id    bigint                  not null,
    create_time       timestamp default now() not null,
    update_time       timestamp default now() not null,
    logic_delete      boolean   default false not null
);

comment on table goods_stock is '商品库存';

comment on column goods_stock.id is '商品库存ID';

comment on column goods_stock.goods_id is '商品ID';

comment on column goods_stock.purchase_price is '进货价';

comment on column goods_stock.retail_price is '零售价';

comment on column goods_stock.wholesale_price is '批发价';

comment on column goods_stock.init_stock_num is '初始库存数量';

comment on column goods_stock.min_stock_num is '最低库存数量';

comment on column goods_stock.max_stock_num is '最高库存数量';

comment on column goods_stock.current_stock_num is '当前库存数量';

comment on column goods_stock.create_user_id is '创建用户ID';

comment on column goods_stock.update_user_id is '更新用户ID';

comment on column goods_stock.create_time is '创建时间';

comment on column goods_stock.update_time is '更新时间';

comment on column goods_stock.logic_delete is '逻辑删除';

alter table goods_stock
    owner to stock_manage;

create table if not exists goods_unit
(
    id             bigint                  not null,
    unit_name      bigint                  not null,
    create_time    timestamp default now() not null,
    update_time    timestamp default now() not null,
    logic_delete   boolean   default false not null,
    create_user_id bigint                  not null,
    update_user_id bigint                  not null
);

comment on table goods_unit is '商品计量单位';

comment on column goods_unit.id is '主键';

comment on column goods_unit.unit_name is '计量单位';

comment on column goods_unit.create_time is '创建时间';

comment on column goods_unit.update_time is '更新时间';

comment on column goods_unit.logic_delete is '逻辑删除';

comment on column goods_unit.create_user_id is '创建人ID';

comment on column goods_unit.update_user_id is '更新人ID';

alter table goods_unit
    owner to stock_manage;

