SET SERVEROUTPUT ON 

accept num prompt "Enter the number: ";

DECLARE
    num number;

BEGIN
    num := &num;
    IF(num<=50) THEN
        DBMS_OUTPUT.PUT_LINE(num||' is less than 50 ');
    ELSE
        DBMS_OUTPUT.PUT_LINE(chr(10)||num||' is not less than 50');
    END IF;  

END;
/    