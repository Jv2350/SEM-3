DECLARE
    MARKS NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Enter your marks: ');
    MARKS := &MARKS;
    IF MARKS >= 75 THEN
        DBMS_OUTPUT.PUT_LINE('O grade');
    ELSIF MARKS >= 60 THEN
        DBMS_OUTPUT.PUT_LINE('A grade');
    ELSIF MARKS >= 50 THEN
        DBMS_OUTPUT.PUT_LINE('B grade');
    ELSIF MARKS >= 35 THEN
        DBMS_OUTPUT.PUT_LINE('C grade');
    ELSE
        DBMS_OUTPUT.PUT_LINE('f grade');
    END IF;
END;
/