call next value for hibernate_sequence; -- PK save시 값 변경
insert into TB_User (id,created_dt,email,name,updated_dt) values(1,now(),'martin@naver.com','martin',now());

call next value for hibernate_sequence;
insert into TB_User (id,created_dt,email,name,updated_dt) values(2,now(),'dennis@naver.com','dennnis',now());

call next value for hibernate_sequence;
insert into TB_User (id,created_dt,email,name,updated_dt) values(3,now(),'soap@naver.com','soap',now());

call next value for hibernate_sequence;
insert into TB_User (id,created_dt,email,name,updated_dt) values(4,now(),'amy@naver.com','amy',now());

call next value for hibernate_sequence;
insert into TB_User (id,created_dt,email,name,updated_dt) values(5,now(),'looter@naver.com','martin',now());
