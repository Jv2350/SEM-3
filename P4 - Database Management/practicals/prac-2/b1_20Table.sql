set serveroutput on;
accept num number prompt "Enter the number: ";

DECLARE
    num number;

BEGIN
    num := &num;
    DBMS_OUTPUT.PUT_LINE(chr(10));
    for i in 1 .. 10  loop
        DBMS_OUTPUT.PUT_LINE(num||' * '||i||' = '||num*i);
    end loop;
end;
/