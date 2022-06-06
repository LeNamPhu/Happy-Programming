create database HappyProg1
use HappyProg1

create table Roles (
ID int primary key,
Name nvarchar(50)
)
create table Account (
ID int primary key,
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
create table RequestStatus(
ID int primary key,
Name nvarchar(250),
)

create table Request (
ID int primary key,
Title nvarchar(250),
Status int foreign key references RequestStatus(ID),
Content nvarchar(250),
MenteeID int foreign key references Mentee(ID),
DeadlineDate date,
DeadlineHour int,
)

create table InviteStatus(
ID int primary key,
Name nvarchar(250),
)

create table Invite(
ID int primary key,
ReqID int foreign key references Request(ID),
MentorID int foreign key references Mentor(ID),
StatusID int foreign key references InviteStatus(ID),
)
create table Rating(
ID int primary key,
Rate int,
Comment nvarchar(250),
MenteeID int foreign key references Mentee(ID),
MentorID int foreign key references Mentor(ID),

)

create table SkillStatus(
ID int primary key,
Name nvarchar(250),
)

create table SkillList(
ID int primary key,
Name nvarchar(250),
StatusID int foreign key references SkillStatus(ID),
)

create table MentorSKill(
SkillID int foreign key references SkillList(ID),
MentorID int foreign key references Mentor(ID),
primary key(SkillID, MentorID)
)
create table RequestSKill(
SkillID int foreign key references SkillList(ID),
RequestID int foreign key references Request(ID),
primary key(SkillID, RequestID)
)
