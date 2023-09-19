set serveroutput on

accept num prompt "Enter the number: "

declare 
    num number := 6;
    p varchar2(200);
begin
    p := 'Using the goto statement';
    
    num := &num;
    if mod(num,2)=0 then 
        dbms_output.put_line(num||' is even number.');
        goto print_now;
    else 
        dbms_output.put_line(num||' is odd number.');
        GoTo print_now;


    end if;
    <<print_now>>
        dbms_output.put_line(to_char(num)||p);

end;
/