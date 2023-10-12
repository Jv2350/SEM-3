DECLARE
    DONE BOOLEAN;
BEGIN
    FOR I IN 1..50 LOOP
        IF DONE THEN
            GOTO END_LOOP;
        END IF;
        <<END_LOOP>>
        NULL;
    END LOOP;
END;
/