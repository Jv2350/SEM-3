CREATE PROCEDURE calculate_employee_bonus(
    p_employee_id IN NUMBER,
    p_bonus_amount OUT NUMBER
)
IS
    v_salary employees.salary%TYPE;
    v_bonus_percentage NUMBER;
    v_max_bonus NUMBER := 5000;
    v_bonus_exceeded_exception EXCEPTION;
    v_employee_not_found_exception EXCEPTION;
BEGIN
    -- Retrieve the sry of the employee
    SELECT salary INTO v_salary
    FROM employees
    WHERE employee_id = p_employee_id;

    -- Check if employee exists
    IF v_salary IS NULL THEN
        RAISE v_employee_not_found_exception;
    END IF;

    -- Calculate bonus percentage based on salary
    IF v_salary < 5000 THEN
        v_bonus_percentage := 0.1;
    ELSIF v_salary >= 5000 AND v_salary < 10000 THEN
        v_bonus_percentage := 0.08;
    ELSE
        v_bonus_percentage := 0.05;
    END IF;

    -- Calculate bonus amount
    p_bonus_amount := v_salary * v_bonus_percentage;

    -- Check if bonus exceeds the maximum limit
    IF p_bonus_amount > v_max_bonus THEN
        RAISE v_bonus_exceeded_exception;
    END IF;
    
    -- Display bonus amount
    DBMS_OUTPUT.PUT_LINE('Bonus Amount: ' || p_bonus_amount);
EXCEPTION
    WHEN v_employee_not_found_exception THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
    WHEN v_bonus_exceeded_exception THEN
        DBMS_OUTPUT.PUT_LINE('Bonus amount exceeds the maximum limit.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/