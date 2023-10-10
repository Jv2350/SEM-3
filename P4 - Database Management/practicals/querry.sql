set serveroutput on 
DECLARE
    -- name emp.ename%type;
BEGIN
    update emp set ename='Yash' where ename = 'Jayesh';
end;
/