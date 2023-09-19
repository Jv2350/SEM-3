--for accepting the lower and upper limits 

BEGIN
    FOR X IN &X .. &Y LOOP
        DBMS_OUTPUT.PUT_LINE(X);
    END LOOP;
END;
/