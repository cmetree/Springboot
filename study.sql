create table study_record(

	key_id int  NOT NULL,
	study_day varchar(8),
	contents varchar(100),
	reg_day date,
	constraint pk_study_record primary key(key_id)


);

drop table study_record;

insert into study_record(key_id, study_day,contents,reg_day) values(1,'20230725','공부 내용',GETDATE());
insert into study_record(key_id, study_day,contents,reg_day) values(2,'20230726','lets start',GETDATE());
insert into study_record(key_id, study_day,contents,reg_day) values(3,'20230726','i can do it',GETDATE());
insert into study_record(key_id, study_day,contents,reg_day) values(4,'20230726','해봅십다',GETDATE());



SELECT convert(varchar(3),key_id,20) as key_id, study_day, contents, convert(varchar(10),reg_day,120) as reg_day
FROM study_record
Order by key_id




SELECT convert(char(10),key_id,20) as key_id, study_day, contents, convert(char(10),reg_day,120) as reg_day
FROM study_record

Order by key_id


UPDATE study_record
   SET contents = '드디어 감을 잡았다.'
     , study_day = '20230726'
	 ,reg_day = GETDATE()
 WHERE key_id = 3

 DELETE 
  FROM study_record
 WHERE key_id=2



--idendity(1,1)사용시,   DBCC CHECKIDENT( study_record , RESEED, 0 )  -- 자동정렬 초기화


SELECT convert(char(10),key_id,20) as KEY_ID, STUDY_DAY, CONTENTS, convert(char(10),reg_day,120) as REG_DAY FROM study_record where KEY_ID = 1 --mybatis 변수사용 Order by key_id