set serveroutput on

accept A number prompt "Enter the number: "

DECLARE
    A NUMBER;
BEGIN
    A := &A;
    IF (A=10) THEN
        DBMS_OUTPUT.PUT_LINE(CHR(10)||'Value of a is 10');
    ELSIF (A=20) THEN
        DBMS_OUTPUT.PUT_LINE(CHR(10)||'Value of a is 20');
    ELSIF (A=30) THEN
        DBMS_OUTPUT.PUT_LINE(CHR(10)||'Value of a is 30');
    ELSE
        DBMS_OUTPUT.PUT_LINE(CHR(10)||'None of the values is matching');
    END IF;
    DBMS_OUTPUT.PUT_LINE('Exact value of a is '||A);
END;
/