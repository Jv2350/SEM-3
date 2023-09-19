DECLARE
    num1 number; --Global Variable
    num2 number; --Global Variable

BEGIN
    num1 := 10;
    num2 := 20;

    DECLARE
	mult number; --Local Variable
    
    BEGIN
	mult := num1 * num2; --global variables are used
	dbms_output.put_line(num1||' * '||num2||' = '||mult);
    
    END;
END;
/