#create database DB_ADOPTER;
#use DB_ADOPTER;


create table Document_Type(
	DocumentId INT NOT NULL AUTO_INCREMENT primary key,
	Description varchar(20)
);

create table Pet_Organization_Category(
	PetOrganizationCategoryId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Attempts INT,
    Type varchar(100)
);


create table Pet_Organization (
	OrganizationId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name varchar(100) NOT NULL,
    FoundationDate date,
    LogoLink text,
    CreationDate date,
    Phone varchar(20),
	Status bit,
    Members int,
	Email VARCHAR(40),
	DistritoID INT,
    WebsiteLink text,
    TwitterLink text,
    InstagramLink text,
    FacebookLink text,
	FOREIGN KEY(DistritoID) REFERENCES Distrito(DistritoID),
    PetOrganizationCategoryId int,
    FOREIGN KEY(PetOrganizationCategoryId) REFERENCES Pet_Organization_Category(PetOrganizationCategoryId),
    INDEX (FoundationDate,CreationDate,Status)
);

create table Pet_Organization_Detail(
	PetOrganizationDetailId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	OrganizationId int,
    FOREIGN KEY(OrganizationId) REFERENCES Pet_Organization(OrganizationId),
    AttemptsAvailable INT
);

create table Adopter_Severity(
	SeverityId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description varchar(50)
);


create table Adopter(
	AdopterId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FirstName varchar(100),
    LastName varchar(100),
    Gender varchar(20),
	Phone varchar(20),
	Birthdate date,
	CreationDate date,
    DocNumber varchar(20),
    DocumentId int,
	DistritoID int,
    Status bit,
	FOREIGN KEY(DistritoID) REFERENCES Distrito(DistritoID),
    FOREIGN KEY (DocumentId) REFERENCES Document_Type(DocumentId),
    INDEX( CreationDate, DocNumber, Status)
);

create table Adopter_Detail (
	AdopterDetailId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	AdopterId int,
    OrganizationId int,
	SeverityId int,
    IssueDate date,
    CommentaryCreationDate date,
    Comment varchar (500),
    Evidence varchar(500),
	FOREIGN KEY(AdopterId) REFERENCES Adopter(AdopterId),
	FOREIGN KEY (SeverityId) REFERENCES Adopter_Severity(SeverityId),
	FOREIGN KEY (OrganizationId) REFERENCES Pet_Organization(OrganizationId),
    INDEX (CommentaryCreationDate,IssueDate)
);

/* -----------------  */
create table User(
	UserId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Username varchar(15) unique not null,
	Password text,
	Enabled bit default 1,
    OrganizationId INT,
	FOREIGN KEY (OrganizationId) REFERENCES Pet_Organization(OrganizationId),
    INDEX(enabled)
);

create table Role(
	RoleId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Description varchar(40)
);

create table UserRole (
	UserRoleId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	Enabled bit default 1,
	UserId int,
	FOREIGN KEY(UserId) REFERENCES User(UserId),
	RoleId int,
	FOREIGN KEY(RoleId) REFERENCES Role(RoleId)
);
/*
create table SystemOption(
	SystemOptionId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	PadreID int,
	FOREIGN KEY(PadreID) REFERENCES SystemOption(SystemOptionId),
	Orden int,
	NombreCorto varchar(40), 
	NombreLargo varchar(40), 
	Uri varchar(20)
);

create table SystemOptionRole(
	SystemOptionRoleId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	Opcion varchar(40),
	UserRoleId int,
	FOREIGN KEY(UserRoleId) REFERENCES UserRole(UserRoleId),
	SystemOptionId int,
	FOREIGN KEY(SystemOptionId) REFERENCES SystemOption(SystemOptionId)
);*/