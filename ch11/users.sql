CREATE SEQUENCE userid_seq;

CREATE TABLE users (
        userid    integer 
                  default 
                  nextval('userid_seq') 
                  primary key,
        name      char(30),
        password  char(30),
        email     char(50),
        style     char(10),
        color     char(10),
	wantsquiz char(1)
);
        

CREATE TABLE usersections (
        userid    int,
        sectionid int
);

CREATE TABLE userauthors (
        userid   int,
        authorid int
);

