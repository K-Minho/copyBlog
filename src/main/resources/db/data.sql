insert into user_tb(username, password, email, created_at) values('ssar', '1234', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at) values('cos', '1234', 'cos@nate.com', now());
insert into user_tb(username, password, email, created_at) values('love', '1234', 'love@nate.com', now());

insert into board_tb(title, content, userId, created_at) values('제목 1번', '내용 1번', 1, now());
insert into board_tb(title, content, userId, created_at) values('제목 2번', '내용 2번', 1, now());
insert into board_tb(title, content, userId, created_at) values('제목 3번', '내용 3번', 2, now());
insert into board_tb(title, content, userId, created_at) values('제목 4번', '내용 4번', 2, now());
insert into board_tb(title, content, userId, created_at) values('제목 5번', '내용 5번', 3, now());
insert into board_tb(title, content, userId, created_at) values('제목 6번', '내용 6번', 3, now());

commit;