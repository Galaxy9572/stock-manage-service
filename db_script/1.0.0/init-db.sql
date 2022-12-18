create user stock_manage
    superuser
    createdb;

create table if not exists user_info
(
    id                 bigint                not null
        constraint user_info_pk
            primary key,
    user_name          varchar(256)          not null,
    avatar_url         text,
    memo               text,
    encrypted_password varchar(256)          not null,
    salt               varchar(6)            not null,
    create_time        timestamp             not null,
    update_time        timestamp             not null,
    logic_delete       bool    default false not null
);

comment on column user_info.id is '主键';

comment on column user_info.user_name is '用户名';

comment on column user_info.avatar_url is '头像地址';

comment on column user_info.memo is '备注';

comment on column user_info.encrypted_password is '密码';

comment on column user_info.salt is '盐值';

comment on column user_info.create_time is '创建时间';

comment on column user_info.update_time is '更新时间';

comment on column user_info.logic_delete is '逻辑删除';

alter table user_info
    owner to stock_manage;

create table user_role
(
    id                 bigint                not null
        constraint user_role_pk
            primary key,
    user_id            bigint                not null,
    role_code          varchar(256)          not null,
    create_time        timestamp             not null,
    update_time        timestamp             not null,
    logic_delete       bool    default false not null
);

comment on column user_role.id is '主键';

comment on column user_role.user_id is '用户ID';

comment on column user_role.role_code is '角色编码';

comment on column user_role.create_time is '创建时间';

comment on column user_role.update_time is '更新时间';

comment on column user_role.logic_delete is '逻辑删除';

alter table user_role
    owner to stock_manage;

create table if not exists goods_type
(
    id             bigint                     not null
        constraint goods_type_pk
            primary key,
    type_name      varchar(256)               not null,
    parent_type_id bigint,
    level          integer                    not null,
    path           text      default ''::text not null,
    create_time    timestamp default now()    not null,
    update_time    timestamp default now()    not null,
    logic_delete   bool      default false    not null,
    create_user_id bigint                     not null,
    update_user_id bigint                     not null
);

comment on table goods_type is '商品类别';

comment on column goods_type.id is '主键';

comment on column goods_type.type_name is '商品类别名称';

comment on column goods_type.parent_type_id is '父类别ID';

comment on column goods_type.level is '层级';

comment on column goods_type.path is '完整路径';

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
    purchase_price  numeric                 not null,
    retail_price    numeric                 not null,
    wholesale_price numeric,
    memo           text,
    create_user_id bigint                  not null,
    update_user_id bigint                  not null,
    create_time    timestamp default now() not null,
    update_time    timestamp default now() not null,
    logic_delete   bool      default false not null
);

comment on table goods_info is '商品';

comment on column goods_info.goods_name is '品名';

comment on column goods_info.goods_type_id is '商品类别ID';

comment on column goods_info.goods_unit_id is '商品计量单位ID';

comment on column goods_info.purchase_price is '进货价';

comment on column goods_info.retail_price is '零售价';

comment on column goods_info.wholesale_price is '批发价';

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
    id                  bigint                  not null
        constraint goods_stock_pk
            primary key,
    goods_id            bigint                  not null,
    init_stock_num      bigint    default 0     not null,
    min_stock_num       bigint    default 0     not null,
    max_stock_num       bigint    default 0     not null,
    current_stock_num   bigint    default 0     not null,
    allow_stock_warning boolean   default true  not null,
    create_user_id      bigint                  not null,
    update_user_id      bigint                  not null,
    create_time         timestamp default now() not null,
    update_time         timestamp default now() not null,
    logic_delete        bool      default false not null
);

comment on table goods_stock is '商品库存';

comment on column goods_stock.id is '商品库存ID';

comment on column goods_stock.goods_id is '商品ID';

comment on column goods_stock.init_stock_num is '初始库存数量';

comment on column goods_stock.min_stock_num is '最低库存数量';

comment on column goods_stock.max_stock_num is '最高库存数量';

comment on column goods_stock.current_stock_num is '当前库存数量';

comment on column goods_stock.allow_stock_warning is '是否允许库存告警';

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
    unit_name      varchar(256)            not null,
    allow_decimal  boolean   default false not null,
    create_time    timestamp default now() not null,
    update_time    timestamp default now() not null,
    logic_delete   bool      default false not null,
    create_user_id bigint                  not null,
    update_user_id bigint                  not null
);

comment on table goods_unit is '商品计量单位';

comment on column goods_unit.id is '主键';

comment on column goods_unit.unit_name is '计量单位';

comment on column goods_unit.allow_decimal is '是否允许小数';

comment on column goods_unit.create_time is '创建时间';

comment on column goods_unit.update_time is '更新时间';

comment on column goods_unit.logic_delete is '逻辑删除';

comment on column goods_unit.create_user_id is '创建人ID';

comment on column goods_unit.update_user_id is '更新人ID';

alter table goods_unit
    owner to stock_manage;

create table if not exists customer_info
(
    id                          bigint                  not null
        constraint customer_info_pk
            primary key,
    customer_name               varchar(256)            not null,
    contact_person              varchar(256)            not null,
    phone                       varchar(256),
    email                       text,
    fax                         varchar(256),
    qq                          varchar(256),
    wechat                      varchar(256),
    country                     varchar(256)            not null,
    state                       varchar(256)            not null,
    city                        varchar(256)            not null,
    district                    varchar(256)            not null,
    address                     text                    not null,
    post_code                   varchar(256),
    init_accounts_receivable    numeric   default 0.0   not null,
    current_accounts_receivable numeric   default 0.0   not null,
    memo                        text,
    bank_name                   varchar(256),
    bank_card_id                varchar(256),
    taxpayer_id                 varchar(256),
    create_time                 timestamp default now() not null,
    update_time                 timestamp default now() not null,
    create_user_id              bigint                  not null,
    update_user_id              bigint                  not null,
    logic_delete                boolean   default false not null
);

comment on table customer_info is '客户信息';

comment on column customer_info.id is '主键';

comment on column customer_info.customer_name is '客户名称';

comment on column customer_info.contact_person is '联系人';

comment on column customer_info.phone is '联系电话';

comment on column customer_info.email is '电子邮箱';

comment on column customer_info.fax is '传真';

comment on column customer_info.qq is 'QQ号';

comment on column customer_info.wechat is '微信号';

comment on column customer_info.country is '国家';

comment on column customer_info.state is '州、省';

comment on column customer_info.city is '市';

comment on column customer_info.district is '区';

comment on column customer_info.address is '地址';

comment on column customer_info.post_code is '邮政编码';

comment on column customer_info.init_accounts_receivable is '初始应收款';

comment on column customer_info.current_accounts_receivable is '当前应收款';

comment on column customer_info.memo is '备注';

comment on column customer_info.bank_name is '开户行';

comment on column customer_info.bank_card_id is '银行卡号';

comment on column customer_info.taxpayer_id is '纳税人识别号';

comment on column customer_info.create_time is '创建时间';

comment on column customer_info.update_time is '更新时间';

comment on column customer_info.create_user_id is '创建人ID';

comment on column customer_info.update_user_id is '更新人ID';

comment on column customer_info.logic_delete is '逻辑删除';

alter table customer_info
    owner to stock_manage;

create table if not exists supplier_info
(
    id                          bigint                  not null
        constraint supplier_info_pk
            primary key,
    supplier_name               varchar(256)            not null,
    contact_person              varchar(256)            not null,
    phone                       varchar(256),
    email                       text,
    fax                         varchar(256),
    qq                          varchar(256),
    wechat                      varchar(256),
    country                     varchar(256)            not null,
    state                       varchar(256)            not null,
    city                        varchar(256)            not null,
    district                    varchar(256)            not null,
    address                     text                    not null,
    post_code                   varchar(256),
    memo                        text,
    create_time                 timestamp default now() not null,
    update_time                 timestamp default now() not null,
    create_user_id              bigint                  not null,
    update_user_id              bigint                  not null,
    logic_delete                bool      default false not null
);

comment on table supplier_info is '供应商信息';

comment on column supplier_info.id is '主键';

comment on column supplier_info.supplier_name is '供应商名称';

comment on column supplier_info.contact_person is '联系人';

comment on column supplier_info.phone is '联系电话';

comment on column supplier_info.email is '电子邮箱';

comment on column supplier_info.fax is '传真';

comment on column supplier_info.qq is 'QQ号';

comment on column supplier_info.wechat is '微信号';

comment on column supplier_info.country is '国家';

comment on column supplier_info.state is '州、省';

comment on column supplier_info.city is '市';

comment on column supplier_info.district is '区';

comment on column supplier_info.address is '地址';

comment on column supplier_info.post_code is '邮政编码';

comment on column supplier_info.memo is '备注';

comment on column supplier_info.create_time is '创建时间';

comment on column supplier_info.update_time is '更新时间';

comment on column supplier_info.create_user_id is '创建人ID';

comment on column supplier_info.update_user_id is '更新人ID';

comment on column supplier_info.logic_delete is '逻辑删除';

alter table supplier_info
    owner to stock_manage;

create table if not exists region_info
(
    id            bigint       not null
        constraint region_info_pk
            primary key,
    country_code  varchar(256)  not null,
    country_desc  varchar(256)  not null,
    state_code    varchar(256),
    state_desc    varchar(256),
    city_code     varchar(256),
    city_desc     varchar(256),
    district_code varchar(256),
    district_desc varchar(256),
    level         varchar(256) not null
);

comment on table region_info is '区域信息';

comment on column region_info.id is '主键';

comment on column region_info.country_code is '国家编码';

comment on column region_info.country_desc is '国家描述';

comment on column region_info.state_code is '省/自治区/州编码';

comment on column region_info.state_desc is '省/自治区/州描述';

comment on column region_info.city_code is '城市编码';

comment on column region_info.city_desc is '城市描述';

comment on column region_info.district_code is '区县编码';

comment on column region_info.district_desc is '区县描述';

comment on column region_info.level is '区域等级';

alter table region_info
    owner to stock_manage;

create table if not exists public.order_record
(
    id              bigint primary key,
    order_id        varchar(256) not null,
    order_type      varchar(256) not null,
    total_price     numeric not null,
    payment_method  varchar(256) not null,
    memo            text,
    supplier_id     bigint,
    customer_id     bigint,
    create_user_id  bigint not null,
    update_user_id  bigint not null,
    create_time     timestamp not null default now(),
    update_time     timestamp not null default now(),
    logic_delete    bool default false
);

alter table public.order_record
    owner to stock_manage;

comment on column order_record.id is '主键';

comment on column order_record.order_id is '订单号';

comment on column order_record.order_type is '订单类型';

comment on column order_record.total_price is '订单总价';

comment on column order_record.payment_method is '支付方式';

comment on column order_record.supplier_id is '供应商ID';

comment on column order_record.customer_id is '客户ID';

comment on column order_record.memo is '备注';

comment on column order_record.create_user_id is '创建人ID';

comment on column order_record.update_user_id is '更新人ID';

comment on column order_record.create_time is '创建时间';

comment on column order_record.update_time is '更新时间';

comment on column order_record.logic_delete is '逻辑删除';


create table if not exists public.order_record_detail
(
    id              bigint primary key,
    order_id        varchar(256) not null,
    goods_id        bigint not null,
    unit_price      numeric not null,
    discount        numeric not null default 1.00,
    amount          numeric not null,
    total_price     numeric not null,
    supplier_id     bigint,
    customer_id     bigint,
    create_user_id  bigint not null,
    update_user_id  bigint not null,
    create_time     timestamp not null default now(),
    update_time     timestamp not null default now(),
    logic_delete    bool default false
);

alter table public.order_record_detail
    owner to stock_manage;

comment on column order_record_detail.id is '主键';

comment on column order_record_detail.order_id is '订单号';

comment on column order_record_detail.goods_id is '商品ID';

comment on column order_record_detail.unit_price is '单价';

comment on column order_record_detail.discount is '折扣';

comment on column order_record_detail.amount is '商品数量';

comment on column order_record_detail.total_price is '订单总价';

comment on column order_record_detail.supplier_id is '供应商ID';

comment on column order_record_detail.customer_id is '客户ID';

comment on column order_record_detail.create_user_id is '创建人ID';

comment on column order_record_detail.update_user_id is '更新人ID';

comment on column order_record_detail.create_time is '创建时间';

comment on column order_record_detail.update_time is '更新时间';

comment on column order_record_detail.logic_delete is '逻辑删除';

create table if not exists public.operation_log
(
    id                 bigint                  not null
        constraint operation_log_pk
            primary key,
    user_id            bigint                  not null,
    module             varchar(256)            not null,
    module_business_id bigint                  not null,
    operation_type     varchar(256)            not null,
    operation_desc             text,
    create_time        timestamp default now() not null
);

alter table public.operation_log
    owner to stock_manage;

comment on table public.operation_log is '操作记录表';

comment on column public.operation_log.id is '主键';

comment on column public.operation_log.user_id is '用户ID';

comment on column public.operation_log.module is '模块';

comment on column public.operation_log.module_business_id is '模块业务主键';

comment on column public.operation_log.operation_type is '操作类型';

comment on column public.operation_log.operation_desc is '描述';

comment on column public.operation_log.create_time is '创建时间';


