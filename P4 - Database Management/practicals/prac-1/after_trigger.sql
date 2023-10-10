set serveroutput on 

create or replace trigger before_trigger
before
insert or delete or update of sal, dept 
on emp

FOR EACH ROW
begin 
    case 
        when inserting then 
            dbms_output.put_line('Inserting the value.');
        when deleting then 
            dbms_output.put_line('Deleting the value.');
        when updating ('dept')then 
            dbms_output.put_line('Updating the dept value.');
        when updating ('sal')then 
            dbms_output.put_line('updating the sal value.');
    end case;
end;
/