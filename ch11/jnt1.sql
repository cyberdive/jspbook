CREATE SEQUENCE articleid_seq;
CREATE SEQUENCE authorid_seq;
CREATE SEQUENCE sectionid_seq;

CREATE TABLE articles (
    articleid    integer 
                 default 
                 nextval('articleid_seq') 
                 primary key,
     sectionid   int,
     authorid    int,
     pubtime     datetime,
     headline    text,
     summary     text,
     body        text
);

CREATE TABLE authors (
    authorid     integer 
                 default 
                 nextval('authorid_seq') 
                 primary key,
     firstname   char(10),
     lastname    char(10),
     email       char(30),
     password    char(15),
     bio         text
);

CREATE TABLE sections (
    sectionid      integer 
                   default 
                   nextval('sectionid_seq') 
                   primary key,
     name          text,
     description   text
);
