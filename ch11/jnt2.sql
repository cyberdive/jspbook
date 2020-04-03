CREATE SEQUENCE keyid_seq;

CREATE TABLE keywords (
    keywordid      integer 
                   default 
                   nextval('keyid_seq') 
                   primary key,
     keyword       char(10),
     description   text,
);

CREATE TABLE articlekeywords (
     articleid    int,
     keywordid    int
);

