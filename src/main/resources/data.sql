INSERT INTO DOC_TYPE(CODE,NAME) VALUES('08', 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO DOC_TYPE(CODE,NAME) VALUES('18', 'Свидетельство о предоставлении временного убежища на территории
Российской Федерации');
INSERT INTO DOC_TYPE(CODE,NAME) VALUES('21', 'Паспорт гражданина Российской Федерации');

INSERT INTO COUNTRY(CODE, NAME) VALUES('643', 'Российская Федерация');

INSERT INTO ORGANIZATION(VERSION, NAME, FULL_NAME, INN, KPP, ADDRESS, PHONE, IS_ACTIVE) VALUES(0, 'Органихация', 'Тестовая Организация', '123456789112', '123456789', 'Москва, ул.Домодедовская, д12б ', '7495999999', true);

INSERT INTO OFFICE(VERSION, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES(0, 1, 'Центральный', 'г.Химки', '7499888888', true);

INSERT INTO DOCUMENT(DOC_TYPE_ID,NUMBER, DOC_DATE) VALUES(3, '4619-554433', '1994-10-11');

INSERT INTO USER(VERSION, OFFICE_ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION, DOCUMENT_ID, CITIZENSHIP_ID, IS_IDENTIFIED) VALUES(0, 1, 'Иван', 'Иванов', 'Иванович', 'Директор', 1, 1, true);
