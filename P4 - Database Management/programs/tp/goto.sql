BEGIN
    GOTO F;
    DBMS_OUTPUT.PUT_LINE('This line will be skipped');
    <<F>>
    DBMS_OUTPUT.PUT_LINE('Skipped one line');
END;
/