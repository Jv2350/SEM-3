set serveroutput on;
accept num number prompt "Enter the number: ";

DECLARE
    num number;
    i number;
BEGIN
    num := &num;
    i := 1;
    DBMS_OUTPUT.PUT_LINE(chr(10));
    loop
        DBMS_OUTPUT.PUT_LINE(num||' * '||i||' = '||num*i);
        i:=i+1;
        exit when i > 10;
    end loop;
end;
/