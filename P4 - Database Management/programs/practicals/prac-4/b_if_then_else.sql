-- Write a PL/SQL program to check number entered by user is less than 50.
set serveroutput on 
accept num number prompt "Enter the number: "

DECLARE
    NUM NUMBER := &num;
BEGIN
    IF (NUM < 50) THEN
        DBMS_OUtPUT.PUT_LINE(chr(10)||NUM||' is less than 50.');
    END IF;
    DBMS_OUtPUT.PUT_LINE(NUM||' is entered.');
END;
/