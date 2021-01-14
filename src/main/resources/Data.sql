

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
    createdTime timestamp without time zone,
    lastUpdatedTime timestamp without time zone,
    userType text 
)


    