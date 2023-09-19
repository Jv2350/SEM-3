set serveroutput on 

accept operation char prompt "Enter the operation(+, -, *, /): " 
-- prompt "The enetered number is :" &operatoin
accept n1 number prompt "Enter first number: " 
accept n2 number prompt "Enter second number: " 

DECLARE
    N1 NUMBER;
    N2 NUMBER;
    OPERATION VARCHAR(1);
BEGIN
    N1 := &N1;
    N2 := &N2;
    OPERATION := '&OPERATION';

    IF OPERATION = '+' THEN 
        DBMS_OUTPUT.PUT_LINE(chr(10)||'The addition of '||N1||' and '||N2||' is '||(N1+N2));
    ELSIF OPERATION = '-' THEN 
        DBMS_OUTPUT.PUT_LINE('The addition of '||N1||' and '||N2||' is '||(N1-N2));
    ELSIF OPERATION = '*' THEN 
        DBMS_OUTPUT.PUT_LINE('The addition of '||N1||' and '||N2||' is '||(N1*N2));
    elsif OPERATION = '/' THEN 
        DBMS_OUTPUT.PUT_LINE('The addition of '||N1||' and '||N2||' is '||(N1/N2));
    END if;
END;
/