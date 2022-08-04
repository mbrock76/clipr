drop table if exists clipr."users_coupons" cascade;
drop table if exists clipr."stores_coupons" cascade;
drop table if exists clipr."users_stores" cascade;
drop table if exists clipr."coupons" cascade;
drop table if exists clipr."stores" cascade;
drop table if exists clipr."users" cascade;

create table clipr."users" (
	"user_id" serial primary key,
	"user_type" text not null,
	"user_name" text not null unique,
	"pass_word" text not null,
	"email" text not null,
	"clipped" integer default 0,
	"redeemed" integer default 0,
	"created" integer default extract(epoch from now())
);

create table clipr."stores" (
	"store_id" serial primary key,
	"store_name" text not null unique,
	"address" text not null,
	"company" text not null,
	"email" text not null
);

create table clipr."coupons" (
	"coupon_id" serial primary key,
	"created_by" integer not null,
	"store_id" integer not null references clipr."stores"(store_id),
	"product_id" text not null,
	"product_name" text not null,
	"discount" numeric not null,
	"discount_type" text not null, -- % or $ characters so discount is always a decimal number
	"qty_redeemed" integer default 0,
	"created" integer default extract(epoch from now()),
	"expires" integer default null
);

create table clipr."users_coupons" (
	"user_coupon_id" serial primary key,
	"user_id" integer not null references clipr."users"(user_id),
	"coupon_id" integer not null references clipr."coupons"(coupon_id)
);

--create table clipr."stores_coupons" (
--	"store_id" integer not null references clipr."stores"(store_id),
--	"coupon_id" integer not null references clipr."coupons"(coupon_id)
--);

create table clipr."users_stores" (
	"user_store_id" serial primary key,
	"user_id" integer not null references clipr."users"(user_id),
	"store_id" integer not null references clipr."stores"(store_id)
);


insert into clipr."users" ("user_type", "user_name", "pass_word", "email") values
('admin', 'admin', 'admin$$', 'admin@admin.com'),
('store', 'store', 'store$$', 'store@store.com'),
('cust', 'cust', 'cust$$', 'cust@cust.com');

insert into clipr."stores" ("store_name", "address", "company", "email") values 
('CM-165', '123 cheap dr, Peoria, IL 61604', 'cheapmart', 'customerservice@cheapmart.com');

insert into clipr."users_stores" ("user_id", "store_id") values 
('2', '1');

insert into clipr."coupons" ("created_by", "store_id", "product_id", "product_name", "discount", "discount_type", "expires") values
('2', '1', 'pro-123', 'lettuce', '0.5', '%', '1661545360');

insert into clipr."users_coupons" ("user_id", "coupon_id") values
('3', '1');

