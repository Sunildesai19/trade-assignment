CREATE TABLE IF NOT EXISTS PORTAL_USER_AUDIT_DATA (
 ID VARCHAR(50),
 TRADE_ID VARCHAR(50),
 VERSION NUMBER,
 COUNTER_PARTY_ID VARCHAR(50),
 BOOK_ID VARCHAR(50),
 MATURITY_DATE VARCHAR(50),
 CREATED_DATE VARCHAR(50),
 EXPIRED VARCHAR(1),
 PRIMARY KEY (ID)
 );