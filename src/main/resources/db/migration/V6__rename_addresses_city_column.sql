alter table addresses
    drop column column_name;

alter table addresses
    add city varchar(255) not null;