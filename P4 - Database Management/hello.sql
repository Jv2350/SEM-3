set serveroutput on 

declare
 string varchar2(20);
begin
   string := 'Jayesh Verma';
   dbms_output.Put_line('YOur name is '||string);
end;
/