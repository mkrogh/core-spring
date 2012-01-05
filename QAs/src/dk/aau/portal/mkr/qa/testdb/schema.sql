drop table answers if exists;
drop table questions if exists;

create table questions (id integer identity primary key, question varchar(255) not null);
create table answers (id integer identity primary key, question_id integer not null, answer varchar(255) not null);

alter table answers add constraint FK_QUESTION_ANSWERS foreign key (question_id) references questions(id) on delete cascade;


