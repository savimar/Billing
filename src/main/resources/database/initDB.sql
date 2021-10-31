DROP table IF EXISTS users CASCADE;
DROP table IF EXISTS bills CASCADE;




create table users (  id serial primary key,
                      first_name varchar(200),
                      last_name varchar(200),
                      email varchar(50)
);

create table bills
(
                      id  serial primary key,
                      user_id  integer,
                      account  integer,
                      bill_status varchar(50),
                      constraint fk_bills_user
                          foreign key (user_id)
                              REFERENCES users (id)

);


