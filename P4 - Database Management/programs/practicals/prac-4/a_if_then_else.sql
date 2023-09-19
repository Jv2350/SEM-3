-- Write a PL/SQL program to check whether number is less than 50

set serveroutput on 

DECLARE
    NUM NUMBER := 9;
BEGIN
    IF (NUM < 50) THEN
        DBMS_OUtPUT.PUT_LINE(chr(10)||NUM||' is less than 50.');
    END IF;
    DBMS_OUtPUT.PUT_LINE(NUM||' is entered.');
END;
/