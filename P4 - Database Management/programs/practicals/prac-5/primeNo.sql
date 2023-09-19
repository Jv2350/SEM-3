set serveroutput on 

accept num prompt "Enter the number: "


declare 
    num number;
    prime number;

begin
    num := &num;
    prime := 1;
    for i in 2..num-1 loop 
        if mod(num,i) = 0 then
            prime := 0;
        end if;
    end loop;

    if prime = 1 then
        dbms_output.put_line(chr(10)||num||' is prime number.');
    else 
        dbms_output.put_line(chr(10)||num||' is not prime number.');
    end if;
end;
/