create database Javataller;
use Javataller;

create table users_tbl (
	user_id int primary key auto_increment,
    user_firtsname varchar(40) not null,
    user_lastname varchar(40) not null,
    user_email varchar(60) not null,
    user_password varbinary(40)
);

insert into users_tbl (user_firtsname, user_lastname, user_email, user_password) values ( upper("juan esteban"), upper("Murcia Ramirez"), lower("juanmurcia45@gmail.com"), aes_encrypt("JuanContraseña45","$2a$12$Ix1zoQVCDfLx7lZJBP069.kZj41LVjafbR1OECGx/mUt9byf3VgWm"));

select*,
cast(aes_decrypt(user_password, '$2a$12$Ix1zoQVCDfLx7lZJBP069.kZj41LVjafbR1OECGx/mUt9byf3VgWm')as char(50))end_data from users_tbl where user_id=1;

select*from users_tbl;