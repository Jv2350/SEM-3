set serveroutput on

accept num prompt 'Enter the number: '

declare 
    num number;
    rev number := 0;
    rem number;
    i number;

begin
    num := &num;

    while (num>0) loop
        rem := mod(num,10);
        rev := (rev*10)+rem;
        num := trunc(num/10);
    end loop;
    dbms_output.put_line('Reverse of the'||num||' is '||rev);
end;
/