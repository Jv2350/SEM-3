declare 
    p varchar(20);
    n integer;

BEGIN   
    n := 36;
    for i in 2..round(sqrt(n)) loop
        if n mod i = 0 then 
            p := ' is not prime number';
            goto print_now;
        end if;
    end loop;
    p := ' is prime number';
    <<print_now>>
    dbms_output.put_line(n||p);
end;
/