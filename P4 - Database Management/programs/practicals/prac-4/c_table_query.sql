set serveroutput on
declare
    sal number;
begin
    for i in (select emp.salary from emp) loop 
        if emp.salary <= 20000 then 
            update emp set salary=salary+2000;
        end if;
    end loop;
end;

/