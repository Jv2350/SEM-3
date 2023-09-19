DECLARE
    NUM NUMBER;
BEGIN
    NUM := 1;
    WHILE NUM<=10 LOOP
        DBMS_OUTPUT.PUT_LINE('Value of num: '||NUM);
        NUM:=NUM+1;
    END LOOP;
END;
/