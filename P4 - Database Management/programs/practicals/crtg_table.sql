accept t_name prompt "Enter your table name: "

accept f_col prompt "Enter 1st column name: "

accept f_col_data prompt "Enter 1st column datatype: "

DECLARE
    T_NAME     VARCHAR2(30);
    F_COL      VARCHAR2(30);
    F_COL_DATA VARCHAR2(30);
BEGIN
    EXECUTE IMMEDIATE '
    create table &t_name(&f_COL &f_col_data)
    ';
    DBMS_OUTPUT.PUT_LINE('Table &t_name is created');
END;
/