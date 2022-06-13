
drop database HappyProgramming
create database HappyProgramming
use HappyProgramming

create table Roles (
ID int identity primary key,
Name nvarchar(50)
)

create table Account (
ID int identity primary key,
AccountName varchar(50),
Password varchar(50),
RoleID int foreign key references Roles(ID)
)

create table Mentee (
ID int foreign key references Account(ID) primary key,
Email nvarchar(250) unique,
FullName nvarchar(250) ,
Address nvarchar(250) ,
Phone nvarchar(250) ,
DateOfBirth Date ,
Sex nvarchar(250) ,
Avatar nvarchar(250),
)

create table Mentor(
ID int foreign key references Account(ID) primary key,
Email nvarchar(250) unique,
FullName nvarchar(250) ,
Address nvarchar(250) ,
Phone nvarchar(250) ,
DateOfBirth Date ,
Sex nvarchar(250) ,
Profession nvarchar(250),
ProfessionIntro nvarchar(250),
ServiceDesc nvarchar(250),
AchievementDesc nvarchar(250),
Framework nvarchar(250),
Avatar nvarchar(250),
)

create table Request (
ID int identity primary key,
Title nvarchar(250),
Status nvarchar(250),
Content nvarchar(250),
MenteeID int foreign key references Mentee(ID),
DeadlineDate date,
DeadlineHour int,
)

create table Invite(
ID int identity primary key,
ReqID int foreign key references Request(ID),
MentorID int foreign key references Mentor(ID),
Status nvarchar(250),
)

create table Rating(
ID int identity primary key,
Rate int,
Comment nvarchar(250),
MenteeID int foreign key references Mentee(ID),
MentorID int foreign key references Mentor(ID),
)

create table Skill(
ID int identity primary key,
Name nvarchar(250),
Status nvarchar(250),
)

create table MentorSkill(
SkillID int foreign key references Skill(ID),
MentorID int foreign key references Mentor(ID),
primary key(SkillID, MentorID)
)

create table RequestSkill(
SkillID int foreign key references Skill(ID),
RequestID int foreign key references Request(ID),
primary key(SkillID, RequestID)
)


insert into Roles values ('Mentee');
insert into Roles values ('Mentor');
insert into Roles values ('Admin');

insert into Account values ('mentee1', 'mentee', 1);
insert into Account values ('mentee2', 'mentee', 1);
insert into Account values ('mentor1', 'mentor', 2);
insert into Account values ('mentor2', 'mentor', 2);
insert into Account values ('admin1', 'admin', 3);

insert into Mentee values  (1, 'mentee@email1', 'Le Nam Phu', '01 Le Van Viet', '0123456789','11-03-2002', 'M', 'images/avatar3.jpg')
insert into Mentee values  (2, 'mentee@email2', 'Le Tri Quyen', '02 Le Van Viet', '0987654321','11-04-2002', 'M', 'images/avatar4.jpg')

insert into Mentor values (3, 'mentee@email2', 'Le Dang Truong', '03 Le Van Viet', '0887654321','11-05-2002', 'M', 'Software Engineer', 'I write stuff', 'Will teach how to code','PhD','Java', 'images/avatar1.jpg');
insert into Mentor values (4, 'mentee@email3', 'Le Phuc Thien', '04 Le Van Viet', '0787654321','11-06-2002', 'M', 'Tester', 'I test stuff', 'Will teach how to test','Master','JUnit', 'images/avatar2.jpg');

insert into Request values ('Teach me java', 'Open', 'I wanna learn java', 1, '11-09-2022', 9);
insert into Request values ('Teach me mockito', 'Open', 'I wanna learn mockito', 2, '11-10-2022', 10);

insert into Invite values (2,3,'Processing');
insert into Invite values (1,3,'Processing');

insert into Rating values (5,'very good', 1, 3);
insert into Rating values (1,'very bad', 1, 3);

insert into SKill values ('Java', 'active');
insert into SKill values ('JUnit', 'active');
insert into SKill values ('Mockito', 'inactive');

insert into MentorSKill values (1,3);
insert into MentorSKill values (2,3);
insert into MentorSKill values (1,4);

insert into RequestSKill values (1,1);
insert into RequestSKill values (2,1);
insert into RequestSKill values (2,2);