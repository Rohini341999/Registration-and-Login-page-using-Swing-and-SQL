create database registration;
use registration;

create table account(firstname varchar(255) not null,
lastname varchar(255) not null,
username varchar(255) not null,
password varchar(255),
emailid varchar(255) not null,
mobileno varchar(255) not null);
