

CREATE TABLE APPUser
(
     ID SERIAL PRIMARY KEY ,
    userName text  NOT NULL UNIQUE,
    password TEXT NOT NULL,
    mobile bigint NOT NULL UNIQUE,
    email text NOT NULL UNIQUE,
    createdBy text ,
    lastUpdatedBy text ,
    currentStatus text ,
    createdTime time without time zone NOT NULL,
    lastUpdatedTime time without time zone NOT NULL,
    userType text 
)


    