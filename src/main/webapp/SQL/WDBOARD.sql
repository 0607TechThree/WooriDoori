CREATE TABLE WDBOARD (
	wdbpk	int		NOT NULL,
	wdbwriter	int		NOT NULL,
	wdbtitle	varchar(120)		NOT NULL,
	wdbcontent	varchar(1000)		NOT NULL,
	wdblike	int	DEFAULT 0	NULL,
	wdbopen	int	DEFAULT 0	NULL
);