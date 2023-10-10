accept num prompt 'Enter the number: '


set serveroutput on 
DECLARE 

    num number;
    f integer;

begin 
    num := &num;
    f := factorial(num);
    dbms_output.put_line('The facotrial of '||num||' is '||f);

end;
/