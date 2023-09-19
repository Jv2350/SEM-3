DECLARE
    A NUMBER := 21;
    B NUMBER := 10;
BEGIN
    IF (A=B) THEN
        DBMS_OUTPUT.PUT_LINE('A is equal than b');
    ELSIF (A>B) THEN
        DBMS_OUTPUT.PUT_LINE('A is greater than b');
    ELSE
        DBMS_OUTPUT.PUT_LINE('A is less than b');
    END IF;
END;
/