set serveroutput on

accept num1 number prompt "Enter the first number: "
accept num2 number prompt "Enter the second number: "

DECLARE
    NUM1 NUMBER;
    NUM2 NUMBER;
BEGIN

    num1 := &num1;
    num2 := &num2;
    DBMS_OUTPUT.PUT_LINE(CHR(10));
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUM1);
        NUM1 := NUM1+1;
        EXIT WHEN NUM1>NUM2;
    END LOOP;
END;
/