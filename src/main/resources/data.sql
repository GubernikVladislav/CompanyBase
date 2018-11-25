--Добавление данных в таблицу company
INSERT INTO COMPANY(
        VERSION,
        NAME,
        FULL_NAME,
        INN,
        KPP,
        ADDRESS,
        PHONE,
        IS_ACTIVE)
VALUES(
       0,
       'Ирбис',
       'ООО Автоцентр Ирбис',
       '771582515',
       '775101001',
       '142701, МОСКОВСКАЯ ОБЛ, ЛЕНИНСКИЙ Р-Н, ВИДНОЕ Г, ОЛЬХОВАЯ УЛ, ДОМ 9, ПОМ.,КОМН. 11,7',
       '84959951212',
       true
);

INSERT INTO COMPANY(
        VERSION,
        NAME,
        FULL_NAME,
        INN,
        KPP,
        ADDRESS,
        PHONE,
        IS_ACTIVE)
VALUES(
       0,
       'ПАО Сбербанк',
       'Публичное акционерное общество «Сбербанк России»',
       '770708389',
       '773601001',
       'Москва, 117997, ул. Вавилова, д. 19',
       '74959877311',
       true
);
--Добавление тестовых данных в таблицу офисов
INSERT INTO OFFICE(
        VERSION,
        COM_ID,
        NAME,
        ADDRESS,
        IS_active)
VALUES(
       0,
       1,
       'Ирбис ЮГ',
       'г.Москва, МКАД 44-км Внешняя сторона',
       true
);

INSERT INTO OFFICE(
        VERSION,
        COM_ID,
        NAME,
        ADDRESS,
        PHONE,
        IS_ACTIVE)
VALUES(
        0,
        2,
        'Центральный',
        'г.Москва',
        '74957777777',
        true
);

--Добавление тестовых данных в таблицу пользователей
INSERT INTO USER(version,office_id, FIRST_NAME, SECOND_NAME,MIDDLE_NAME, POSITION, DOC_CODE, DOC_NAME, DOC_NUMBER, DOC_DATE, CITIZENSHIP_NAME, CITIZENSHIP_CODE, IS_IDENTIFIED)
VALUES(0, 2, 'ИВАН', 'ИВАНОВ', 'ИВАНОВИЧ', 'ДИРЕКТОР', 21, 'ПАСПОРТ',4561266, '2014-11-03', 'РФ', 134, TRUE);