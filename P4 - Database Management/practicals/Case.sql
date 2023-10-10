set serveroutput on

accept grade prompt "Enter your grade: "

declare
    grade char;

begin    
    grade := &grade;
    case grade
        when 'A' then
           --dbms_output.new_line;
            dbms_output.put_line(chr(10)||'Exellent');
        when 'B' then
            dbms_output.put_line('Very good');
        when 'C' then
            dbms_output.put_line('Well done');
        when 'D' then
             dbms_output.put_line('You passed');
        when 'F' then
            dbms_output.put_line('better try again');
        else
            dbms_output.put_line('No such grade');
    end case;

end;
/