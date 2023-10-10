set serveroutput on

accept g prompt "Enter the string: "

declare
    g varchar2(20);
    r varchar2(20);
    i number;

begin
    g := '&g';
    for i in Reverse 1..length(g) loop
        r := r||substr(g,i,1);
    end loop;

    dbms_output.put_line(chr(10)||'Reverse string is '||r);

    if r = g then
        dbms_output.put_line(chr(10)||'String is palindrome.');
    else 
        dbms_output.put_line(chr(10)||'String is not palindrome.');
    
    end if;
end;
/

