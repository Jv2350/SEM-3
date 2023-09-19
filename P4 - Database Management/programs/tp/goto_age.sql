DECLARE
    AGE NUMBER := 17;
BEGIN
    IF AGE < 18 THEN
        GOTO UNDERAGE;
    ELSE
        DBMS_OUTPUT.PUT_LINE('You are eligible.');
    END IF;
    UNDERAGE:
        DBMS_OUTPUT.PUT_LINE('You are underage.');
END;
/