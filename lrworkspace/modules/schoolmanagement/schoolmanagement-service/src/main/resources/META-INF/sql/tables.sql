create table School (
	uuid_ VARCHAR(75) null,
	schoolId LONG not null primary key,
	groupId LONG,
	schoolName VARCHAR(75) null,
	schoolType VARCHAR(75) null,
	city VARCHAR(75) null,
	noOfStudents INTEGER,
	rating INTEGER,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);