CREATE TABLE WDMEMBER (
	wdmpk	int		NOT NULL,
	wdmid	varchar(30)		NOT NULL,
	wdmpw	varchar(30)		NOT NULL,
	wdmnick	varchar(30)		NOT NULL,
	wdmemail	varchar(50)		NOT NULL,
	wdmgender	varchar(30)		NOT NULL,
	wdmmbti	varchar(30)		NOT NULL,
	nemail	varchar(50)		NULL,
	kemail	varchar(50)		NULL,
	wdmvip	int	DEFAULT 0	NOT NULL
);