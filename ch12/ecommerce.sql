CREATE SEQUENCE itemid_seq;
CREATE SEQUENCE catid_seq;
CREATE SEQUENCE orderid_seq;

CREATE TABLE ads (

CREATE TABLE descriptions (
        itemid      integer 
                    default 
                    nextval('itemid_seq') 
                    primary key,
        name        text,
        shortdesc   text,
        fulldesc    text
);

CREATE TABLE catalog (
        catid       integer 
                    default 
                    nextval('catid_seq') 
                    primary key,
        itemid      int,
        variation   text,
        price       float,
        inventory   int
);

CREATE TABLE orders (
        orderid     integer 
                    default 
                    nextval('orderid_seq') 
                    primary key,
        userid      int,
        catid       int,
        status      int
);

CREATE TABLE usershipinfo (
        userid          int,
        billaddress     text,
        shipaddress     text,
        creditcardnum   char(30),
        expmonth        int,
        expyear         int
);
