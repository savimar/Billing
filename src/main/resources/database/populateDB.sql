insert into users (id, first_name,last_name )
values
(1,'Иван', 'Иванов'),
(2,'Нина', 'Петрова');

insert into bills (id, user_id, account, bill_status)
values
(3, 1, 2000, 'paid'),
(4,2,  10000, 'payment_reversed');


