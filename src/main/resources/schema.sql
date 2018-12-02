CREATE TABLE IF NOT EXISTS Organization(
                                         id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT NOT NULL ,
                                         version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
                                         name VARCHAR(30) UNIQUE NOT NULL COMMENT 'Наименование организации',
                                         full_name VARCHAR(50) UNIQUE NOT NULL COMMENT 'Полное наименование организации',
                                         inn VARCHAR(12) UNIQUE NOT NULL COMMENT 'ИНН',
                                         kpp VARCHAR(9) UNIQUE NOT NULL COMMENT 'КПП',
                                         address VARCHAR(255) NOT NULL COMMENT 'Адресс',
                                         phone VARCHAR(20) COMMENT 'Телефон',
                                         is_active BOOLEAN COMMENT 'Состояние организации'
);

CREATE TABLE IF NOT EXISTS Office(
                                   id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Уникальный идентификатор',
                                   version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
                                   org_id INTEGER NOT NULL COMMENT 'Идентификатор организации',
                                   name VARCHAR(30) UNIQUE NOT NULL COMMENT 'Наименование офиса',
                                   address VARCHAR(255) NOT NULL COMMENT 'Адресс',
                                   phone VARCHAR(20) COMMENT 'Телефон',
                                   is_active BOOLEAN COMMENT 'Состояние офиса'
);

CREATE TABLE IF NOT EXISTS User(
                                 id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Уникальный идентификатор',
                                 version INTEGER NOT NULL COMMENT 'Сдужебное поле Hibernate',
                                 office_id INTEGER NOT NULL COMMENT 'Идентификатор оффиса',
                                 first_name VARCHAR(50) NOT NULL COMMENT 'Имя',
                                 last_name VARCHAR(50) NOT NULL COMMENT 'Фамилия',
                                 middle_name VARCHAR(50) COMMENT 'Отчество',
                                 position VARCHAR(50) NOT NULL COMMENT 'Должность',
                                 document_id INTEGER NOT NULL COMMENT 'Идентификатор документа',
                                 citizenship_id INTEGER COMMENT 'Идентификатор гражданства',
                                 is_identified BOOLEAN COMMENT 'Статус сотрудника'
);

CREATE TABLE IF NOT EXISTS Doc_type(
                                     id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Уникальный идентификатор',
                                     code VARCHAR(2) NOT NULL COMMENT 'Код документа',
                                     name VARCHAR(255) NOT NULL COMMENT 'Наименование документа'
);

CREATE TABLE IF NOT EXISTS Document(
                                     id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Уникальный идентификатор',
                                     type INTEGER NOT NULL COMMENT 'Идентификатор документа',
                                     number VARCHAR(20) NOT NULL COMMENT 'Номер документа',
                                     doc_date DATE COMMENT 'Дата документа'
);

CREATE TABLE IF NOT EXISTS Country(
                                    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Идентификатор',
                                    code VARCHAR(3) NOT NULL COMMENT 'Код страны',
                                    name VARCHAR(255) NOT NULL COMMENT 'Название страны'
);

CREATE INDEX IX_OFFICE_ORG_ID ON OFFICE(ORG_ID);
ALTER TABLE OFFICE ADD FOREIGN KEY (ORG_ID) REFERENCES ORGANIZATION(ID);

CREATE INDEX IX_USER_OFFICE_ID ON USER(OFFICE_ID);
ALTER TABLE USER ADD FOREIGN KEY (OFFICE_ID) REFERENCES OFFICE(ID);

CREATE INDEX IX_USER_COUNTRY_ID ON USER(CITIZENSHIP_ID);
ALTER TABLE USER ADD FOREIGN KEY (CITIZENSHIP_ID) REFERENCES Country(ID);

CREATE INDEX IX_DOCUMENT_DOC_TYPE ON DOCUMENT(TYPE);
ALTER TABLE DOCUMENT ADD FOREIGN KEY (TYPE) REFERENCES DOC_TYPE(ID);

CREATE INDEX IX_USER_DOCUMENT_ID ON USER(DOCUMENT_ID);
ALTER TABLE USER ADD FOREIGN KEY (DOCUMENT_ID) REFERENCES DOCUMENT(ID);

