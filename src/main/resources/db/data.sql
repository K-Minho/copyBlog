insert into user_tb(username, password, email, created_at) values('ssar', '1234', 'ssar@nate.com', now());

insert into board_tb(title, content, userId, created_at) values('제목1번', '내용1번', 1, now());

commit;