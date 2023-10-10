set serveroutput on

accept grade char prompt "Enter your grades: "

DECLARE
    GRADE CHAR;
BEGIN
    GRADE := '&grade';
    CASE GRADE
        WHEN 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Excellent');
        WHEN 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Very good');
        WHEN 'C' THEN
            DBMS_OUTPUT.PUT_LINE('Well done');
        WHEN 'D' THEN
            DBMS_OUTPUT.PUT_LINE('You passed');
        WHEN 'F' THEN
            DBMS_OUTPUT.PUT_LINE('Better try again');
        ELSE
            DBMS_OUTPUT.PUT_LINE('No such grade');
    END CASE;
END;
/