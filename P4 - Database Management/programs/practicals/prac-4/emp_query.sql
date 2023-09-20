SET SERVEROUTPUT ON

declare
    id emp.eid%type:=1;
    sal emp.salary%type;
begin
    select salary into sal from emp where eid = id;

    if (sal <= 20000) then
        update emp set salary=salary+2000 where eid = id;
        dbms_output.put_line('Salary is updated');
    end if;
end;
/