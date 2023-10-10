-- Write a PL/SQL program to check number entered by user is less than 50.
set serveroutput on

accept num number prompt "Enter the number: "

DECLARE
    NUM NUMBER := &NUM;
BEGIN
    IF (NUM < 50) THEN
        DBMS_OUTPUT.PUT_LINE(CHR(10) ||NUM ||' is less than 50.');
    END IF;
    DBMS_OUTPUT.PUT_LINE(NUM ||' is entered.');
END;
/