CREATE SEQUENCE adid_seq;

CREATE TABLE ads (
        adid                    integer 
                                default 
                                nextval('adid_seq') 
                                primary key,
        impressions             int,
        impressionssofar        int,
        adbody                  text
);


CREATE TABLE adkeywords (
        adid                    int,
        keywordid               int,
	score			int
);

