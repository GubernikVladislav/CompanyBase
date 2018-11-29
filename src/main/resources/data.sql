--Добавление данных в таблицу документов удостоверяющих личность
INSERT INTO Document VALUES(07, 'Военный билет');
INSERT INTO Document VALUES(08, 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO Document VALUES(10, 'Паспорт иностранного гражданина');
INSERT INTO Document VALUES(11, 'Свидетельство о рассмотрении ходатайства о признании лица
беженцем на территории Российской Федерации по существу ');
INSERT INTO Document VALUES(12, 'Вид на жительство в Российской Федерации  ');
INSERT INTO Document VALUES(13, 'Удостоверение беженца');
INSERT INTO Document VALUES(15, 'Разрешение на временное проживание в Российской Федерации ');
INSERT INTO Document VALUES(18, 'Свидетельство о предоставлении временного убежища на территории
Российской Федерации');
INSERT INTO Document VALUES(21, 'Паспорт гражданина Российской Федерации');
INSERT INTO Document VALUES(23, 'Свидетельство о рождении, выданное уполномоченным органом
иностранного государства ');
INSERT INTO Document VALUES(24, 'Удостоверение личности военнослужащего Российской Федерации ');
INSERT INTO Document VALUES(91, 'Иные документы');

--Добавление данных в таблицу гражданства
INSERT INTO CITIZENSHIP VALUES(643, 'Российская Федерация');
--Добавление данных в таблицу компаний
INSERT INTO ORGANIZATION(VERSION, NAME, FULL_NAME, INN, KPP, ADDRESS, PHONE, IS_ACTIVE) VALUES(0, 'Органихация', 'Тестовая Организация', '123456789112', '123456789', 'Москва, ул.Домодедовская, д12б ', '7495999999', true);

--Добавление данных в таблицу оффисов
INSERT INTO OFFICE(VERSION, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES(0, 1, 'Центральный', 'г.Химки', '7499888888', true);

--Добавление данных в тааблицу сотрудников
INSERT INTO USER(VERSION, OFFICE_ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, DOC_CODE, DOC_NUMBER, DOC_DATE, CITIZENSHIP_CODE, IS_IDENTIFIED) VALUES(0, 1, 'Иван', 'Иванов', 'Иванович', 'Директор', 21, '4916-699999', '1994-10-07', 643, true);