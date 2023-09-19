DECLARE
    A BOOLEAN := TRUE;
    B BOOLEAN := FALSE;
BEGIN
    IF (A AND B) THEN
        DBMS_OUTPUT.PUT_LINE('condition is true');
    END IF;

    IF (NOT A) THEN
        DBMS_OUTPUT.PUT_LINE('condition is true');
    ELSE
        DBMS_OUTPUT.PUT_LINE('a is true');
    END IF;
    
    IF (NOT B) THEN
        DBMS_OUTPUT.PUT_LINE('b is not true');
    ELSE
        DBMS_OUTPUT.PUT_LINE('b is true');
    END IF;
END;
/