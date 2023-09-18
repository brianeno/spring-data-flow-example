create TABLE IF NOT EXISTS CHARGING_SESSION
(
   id int,
   first_name varchar(50),
   last_name varchar(50),
   minutes int,
   watt_usage int,
   bill_amount decimal(10,2)
);