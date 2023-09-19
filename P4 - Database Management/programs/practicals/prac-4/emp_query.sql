SET SERVEROUTPUT ON

declare
    id emp.eid%type=1;
    sal emp.salary%type;
begin
for i in 1..3 loop
    select salary into sal from emp where eid = 1;

    if (sal <= 2000) then
        update emp set salary=salary+200 where eid = i;
        dbms_output.put_line('Salary is updated');
    end if;
end loop;
end;
/