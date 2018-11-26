CREATE TABLE IF NOT EXISTS Company(
  id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  version INTEGER NOT NULL,
  name VARCHAR(30) NOT NULL,
  full_name VARCHAR(50),
  inn INT(12) NOT NULL,
  kpp INT(9) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(20),
  is_active BOOLEAN NOT NULL
  );

CREATE TABLE IF NOT EXISTS Office(
  id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  version INTEGER NOT NULL,
  com_id INTEGER NOT NULL,
  name VARCHAR(30) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(20),
  is_active BOOLEAN NOT NULL
  );

CREATE TABLE IF NOT EXISTS User(
  id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
  version INTEGER NOT NULL,
  office_id INTEGER NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NOT NULL,
  middle_name VARCHAR(50),
  position VARCHAR(50) NOT NULL,
  doc_code INTEGER ,
  doc_number INTEGER,
  doc_date DATE,
  citizenship_code INTEGER,
  is_identified BOOLEAN NOT NULL
  );

CREATE TABLE IF NOT EXISTS DOCS(
  id INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
  );

CREATE TABLE IF NOT EXISTS CITIZENSHIP(
  id INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
  );

CREATE INDEX IX_OFFICE_COM_ID ON OFFICE(COM_ID);
ALTER TABLE OFFICE ADD FOREIGN KEY (COM_ID) REFERENCES COMPANY(ID);

CREATE INDEX IX_USER_OFFICE_ID ON USER(OFFICE_ID);
ALTER TABLE USER ADD FOREIGN KEY (OFFICE_ID) REFERENCES OFFICE(ID);

CREATE INDEX IX_USER_DOC_CODE ON USER(DOC_CODE);
ALTER TABLE USER ADD FOREIGN KEY (DOC_CODE) REFERENCES DOCS(ID);

CREATE INDEX IX_USER_CITIZENSHIP_CODE ON USER(CITIZENSHIP_CODE);
ALTER TABLE USER ADD FOREIGN KEY (CITIZENSHIP_CODE) REFERENCES CITIZENSHIP(ID);