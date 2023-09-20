set serveroutput on

DECLARE
    ID  EMP.EID%TYPE;
    SAL EMP.SALARY%TYPE;
BEGIN
    FOR I IN (SELECT EID, SALARY FROM EMP) LOOP
        ID := I.EID;
        SAL := I.SALARY;
        IF SAL <= 20000 THEN
            UPDATE EMP SET SALARY=SALARY+2000 WHERE EID=ID;
            DBMS_OUTPUT.PUT_LINE('Salary updated for employee '||ID);
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Salaries are updated');
END;
/