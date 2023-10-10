set serveroutput on

accept range prompt "Enter the range of the number: "

declare 
    num1 number;
    num2 number;
    num3 number;
    num number;
    range number := &range;
begin
    num1 := 0; 
    num2 := 1; 
    num3 := 0; 
    num := 1;
    while(num<=range) loop
        dbms_output.put_line(num3); 
        num1 := num2;
        num2 := num3;
        num3 := num1 + num2;
        num := num +1;
    end loop;

end;
/