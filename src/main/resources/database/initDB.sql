DROP table IF EXISTS users;
DROP table IF EXISTS bills;




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

                      constraint fk_bills_user
                          foreign key (user_id)
                              REFERENCES users (id)

);


