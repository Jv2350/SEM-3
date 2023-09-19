DECLARE
    A NUMBER;
    B NUMBER;
    C NUMBER;
    PROCEDURE FINDMIN(
        X IN NUMBER,
        Y IN NUMBER,
        Z OUT NUMBER
    ) IS
    BEGIN
        IF X < Y THEN
            Z := X;
        ELSE
            Z:=Y;
        END IF;
    END;
BEGIN
    A:=&A;
    B:=&B;
    FINDMIN(D, B, C);
    DBMS_OUTPUT.PUT_LINE('Minimum of (' ||A|| ',' ||B|| '):' ||C);
END;
/