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