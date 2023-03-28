
#UC 1
        create database Address_Book_System;
        use address_book_system;

        #UC 2
        create table address_book_service (
        first_name varchar(20),
        last_name varchar(10),
        address varchar(20),
        city varchar (10),
        state varchar (15),
        zip int,
        phone_number int(10),
        email_id varchar(100));

        #UC 3
        insert into address_book_service (first_name, last_name, address, city, state, zip, phone_number, email_id) values ("Arindam","Saha","Mahesh Colony","Serampore","West Bengal",712202,798021155,"asaha15071998@gmail.com"),
        ("Sumit","Das","Mahesh Colony","Serampore","West Bengal",712202,790087767,"sumit@gmail.com"),
        ("Avijit","Bera","TalaTola Road","Kolkata","West Bengal",700004,764867542,"Avijitbera@gmail.com"),
        ("Neha","Roy","Hall Road","Mumbai","Maharashta",890012,876790881,"neha1559@gmail.com"),
        ("Chavi","Bose","Clock Tower","New Delhi","Haryana",244678,789965123,"chavi567@gmail.com");

        #UC 4
        update address_book_service set address = "Kali Tola",
        city = "Kolkata",
        state = "West Bengal",
        zip = "8977",
        phone_number = 898900,
        email_id = "Sourav@gmail.com"
        where
        first_name = "Avijit"
        and
        last_name = "Bera";

        #UC 5
        delete from address_book_service where
        first_name = "Avijit"
        and
        last_name = "Bera";

        #UC 6
        select * from address_book_service where city = "Serampore";

        #UC 7
        select count(city) from address_book_service;
        select count(state) from address_book_service;

        #UC 8
        insert into address_book_service (first_name, last_name, address, city, state, zip, phone_number, email_id) values ("Aniket","Roy","Neheru Nagar","Serampore","West Bengal",712203,898979,"aniket@gmail.com");
        insert into address_book_service (first_name, last_name, address, city, state, zip, phone_number, email_id) values ("Neela","Bose","Camp Colony","Serampore","West Bengal",712253,645242,"NEELA@gmail.com");
        select * from address_book_service where city = "Serampore" order by first_name;

        #UC 9
        alter table address_book_service add column Book_Name varchar(20) first;
        alter table address_book_service add column Book_Type varchar(20) after Book_Name;
        alter table address_book_service drop column Book_Name;
        update address_book_service set Book_type = "Family" where first_name="Arindam" or first_name = "Neha" or first_name = "Aniket";
        update address_book_service set Book_type = "Work" where first_name="Sumit" or first_name = "Chavi" or first_name = "Neela";

        #UC 10
        select count(Book_Type) from address_book_service where Book_Type = "Family";
        select count(Book_Type) from address_book_service where Book_Type = "Work";

        #UC 11
        insert into address_book_service (Book_Type, first_name, last_name, address, city, state, zip, phone_number, email_id) values ("Friends",'Avijit','Bera','Lake Road','Kolkata','West Bengal','8009','66545','Avijit@gmail.com');


        #UC 12
        #After Using Normalization

        create table personal_details (
        contact_id int not null primary key,
        first_name varchar(20),
        last_name varchar(10),
        phone_number int,
        email_id varchar(100)
        );

        insert into personal_details (contact_id, first_name, last_name, phone_number, email_id) values
        (1,'Arindam','Saha','9100','asaha15@gmail.com'),
        (2,'Isha','Roy','4500','isha@gmail.com'),
        (3,'Sumit','Das',67009,'sumit@gmail.com'),
        (4,'Avijit','Bera',98007,'avijit@gmail.com'),
        (5,'Neela','Bose',78003,'Neela@gmail.com');


        create table type_choose (
        contact_type_id int primary key,
        contact_type varchar(10)
        );

        insert into type_choose (contact_type_id , contact_type) values (1,'Family'),(2,'Friends'),(3,'Work');

        create table book_type (
        contact_id int,
        contact_type_id int,
        foreign key (contact_id) references personal_details (contact_id),
        foreign key (contact_type_id) references type_choose (contact_type_id)
        );

        insert into book_type (contact_id,contact_type_id) values (1,1),(2,1),(3,2),(4,2),(5,3);

        create table contact_address (
        contact_id int not null,
        address varchar(20),
        city varchar(15),
        state varchar(20),
        foreign key (contact_id) references personal_details (contact_id)
        );

        insert into contact_address (contact_id, address, city, state) values
        (1,'Mahesh Colony','Serampore','West Bengal'),
        (3,'Mahesh Colony','Serampore','West Bengal'),
        (4,'Mahesh Colony','Serampore','West Bengal'),
        (2,'Gouri Bari', 'Kolkata','West Bengal'),
        (5,'Bainchi','Bardhaman','West Bengal');

        #UC 13
        # reviewing UC 6, UC 7, UC 8, UC 10


        select * from contact_address where city = "Serampore";

        select count(city) from contact_address;
        select count(state) from contact_address;

        select * from personal_details inner join contact_address  on personal_details.contact_id = contact_address.contact_id;
