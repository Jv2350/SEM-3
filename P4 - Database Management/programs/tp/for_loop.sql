DECLARE
    A   NUMBER;
    NUM NUMBER;
BEGIN
    NUM := &NUM;
    FOR A IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(NUM
            ||' * '
            ||A
            ||' = '
            ||NUM*A);
    END LOOP;
END;
/