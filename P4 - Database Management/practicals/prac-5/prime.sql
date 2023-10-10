set serveroutput on

declare 
    counter number;
    k number;

begin
    for i in 1..50 loop
        counter := 0;
        k := floor(i/2);

        for j in 2..k loop  
            if(mod(i,j)=0) then
                counter := 1;
            end if;
        end loop;

        if(counter = 0) then    
            dbms_output.put_line(i||' is prime number.');
        end if;
    end loop;

end;
/
