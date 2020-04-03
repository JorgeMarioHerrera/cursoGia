/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mario
 * Created: 3/04/2020
 */
create table Usuario (

id bigint,
username varchar(50) not null,
password varchar(50),
name varchar(100),
email varchar(100) not null,
constraint Usuario_pk primary key (id)
);