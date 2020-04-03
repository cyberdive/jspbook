DROP TABLE cd;
DROP TABLE track;

CREATE TABLE cd (albumid  int,artist   text, name  text);
CREATE TABLE track (albumid  int, name     text, length   int);

INSERT INTO cd VALUES(1,'Sunshine Blind','Liquid');
INSERT INTO cd VALUES(2,'Sunshine Blind','Love the Sky to Death');

INSERT INTO track VALUES(1,'Chimera',202);
INSERT INTO track VALUES(1,'Neon',267);
INSERT INTO track VALUES(1,'Release',295);

INSERT INTO track VALUES(2,'Is there',248);
INSERT INTO track VALUES(2,'Keyeslough,',227);
INSERT INTO track VALUES(2,'Crescent and the star',226);


DROP SEQUENCE articleid_seq;
DROP SEQUENCE authorid_seq;
DROP SEQUENCE sectionid_seq;

CREATE SEQUENCE articleid_seq;
CREATE SEQUENCE authorid_seq;
CREATE SEQUENCE sectionid_seq;

DROP TABLE articles;

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

DROP TABLE authors;

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

DROP TABLE sections;

CREATE TABLE sections (
    sectionid      integer 
                   default 
                   nextval('sectionid_seq') 
                   primary key,
     name          text,
     description   text
);

DROP SEQUENCE keyid_seq;

CREATE SEQUENCE keyid_seq;

DROP TABLE keywords;

CREATE TABLE keywords (
    keywordid      integer 
                   default 
                   nextval('keyid_seq') 
                   primary key,
     keyword       char(10),
     description   text
);

DROP TABLE articlekwyrods;

CREATE TABLE articlekeywords (
     articleid    int,
     keywordid    int
);

insert into sections values(0,
 'Home Page',
 'Your on-line home for up to the minute Java news');

insert into sections(name,description)
 values('Industry News','Business happenings');

insert into sections(name,description)
 values('Enterprise Java',
 'The latest on the Enterprise Edition APIs and implementations');

insert into sections(name,description)
 values('Standard Edition','What\'s new in the standard JDK');

insert into sections(name,description)
     values('Micro Edition &amp; devices',
            'Java in the palm of your hand');

insert into sections(name,description)
     values('Beans','New APIs and product announcements');

insert into sections(name,description)
     values('Editorials','Our staff mouths off');

INSERT INTO authors(firstname,lastname,email,password,bio)
VALUES('Sifl','','sifl@jnt.com','crescent','');

INSERT INTO authors(firstname,lastname,email,password,bio)
VALUES('Olly','','olly@jnt.com','fresh','');

INSERT INTO authors(firstname,lastname,email,password,bio)
VALUES('Chester','','chester@jnt.com','cereal','');

INSERT INTO authors(firstname,lastname,email,password,bio)
VALUES('Precious','Roy','roy@jnt.com','SUCKERS!','');



INSERT INTO keywords(keyword,description)
VALUES('Linux','The Linux Operating System');

INSERT INTO keywords(keyword,description)
VALUES('Mac','MacOS');

INSERT INTO keywords(keyword,description)
VALUES('Solaris','The Solaris Operating System');

INSERT INTO keywords(keyword,description)
VALUES('Legal','Legal issues');

INSERT INTO keywords(keyword,description)
VALUES('Compiler','Compiler Technology');

INSERT INTO keywords(keyword,description)
VALUES('IDE','Integrated development environements');


INSERT INTO articles(sectionid,authorid,headline,summary,body)
VALUES(1,1,'Findings of Fact issued in Microsoft case',
'Judge rules that Microsoft abused monopoly power',
'After months of legal rambling and deliberation, Judge Jackson today issued his findings of fact in the landmark Microsoft trial.  The findings state that Microsoft does consititue a monopoly, and that they futher have used this monopoly power to the harm of consumers and the industry as a whole.  These findings do not constitute a judgement, which is expected early next year...');

INSERT INTO articles(sectionid,authorid,headline,summary,body)
VALUES(2,3,'Jakarta 3.0 released',
'New version of JSP reference available',
'The newest version of Tomcat, the reference implementation for JSPs, was released by the Apache/Jakarta team earlier today.  Withing a half hour of the announcement, approximately 5000 eager developers had downloaded the new packages');


DROP SEQUENCE articleid_seq;

CREATE SEQUENCE articleid_seq;

DROP SEQUENCE userid_seq;

CREATE SEQUENCE userid_seq;

DROP TABLE users;

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
        

DROP TABLE usersections;

CREATE TABLE usersections (
        userid    int,
        sectionid int
);

DROP TABLE userauthors;

CREATE TABLE userauthors (
        userid   int,
        authorid int
);

DROP TABLE userinterests;

CREATE TABLE userinterests (
        userid    int,
        keywordid int,
        score     int
);

DROP TABLE adid_seq;

CREATE SEQUENCE adid_seq;

DROP TABLE ads;

CREATE TABLE ads (
        adid                    integer 
                                default 
                                nextval('adid_seq') 
                                primary key,
        impressions             int,
        impressionssofar        int,
        adbody                  text
);


DROP TABLE adkeywords;

CREATE TABLE adkeywords (
        adid                    int,
        keywordid               int,
	score			int
);

DROP SEQUENCE itemid_seq;
DROP SEQUENCE catid_seq;
DROP SEQUENCE orderid_seq;

CREATE SEQUENCE itemid_seq;
CREATE SEQUENCE catid_seq;
CREATE SEQUENCE orderid_seq;

DROP TABLE descriptions;

CREATE TABLE descriptions (
        itemid      integer 
                    default 
                    nextval('itemid_seq') 
                    primary key,
        name        text,
        shortdesc   text,
        fulldesc    text
);

INSERT INTO descriptions(name,shortdesc,fulldesc)
VALUES('T-shirt','A cotton T with the JNT logo','This handsome shirt proudly features the JNT logo, and it comes in a variety of colors, just like the site itself');

INSERT INTO descriptions(name,shortdesc,fulldesc)
VALUES('Mousepad','A rubber mousepad with an assortment of Java logos','Keep your mouse happy with the JNT mousepad, featuring a number of logos and sketches, in 16 vibrant colors');

DROP TABLE catalog;

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

INSERT INTO catalog(itemid,variation,price,inventory)
VALUES(1,'Large, Red',15.95,200);

INSERT INTO catalog(itemid,variation,price,inventory)
VALUES(1,'Large, Blue',15.95,200);

INSERT INTO catalog(itemid,variation,price,inventory)
VALUES(1,'Small, Red',15.95,200);

INSERT INTO catalog(itemid,variation,price,inventory)
VALUES(2,'Mousepad',12.95,100);


DROP TABLE orders;

CREATE TABLE orders (
        orderid     integer 
                    default 
                    nextval('orderid_seq') 
                    primary key,
        userid      int,
        catid       int,
        status      int
);

DROP TABLE usershipinfo;

CREATE TABLE usershipinfo (
        userid          int,
        billaddress     text,
        shipaddress     text,
        creditcardnum   char(30),
        expmonth        int,
        expyear         int
);
