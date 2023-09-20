-- Create the employees table
CREATE TABLE employees (
   employee_id NUMBER PRIMARY KEY,
   first_name VARCHAR2(50),
   last_name VARCHAR2(50),
   salary NUMBER
);

-- Insert sample data into the employees table
INSERT INTO employees (employee_id, first_name, last_name, salary)
VALUES (1, 'John', 'Doe', 18000);

INSERT INTO employees (employee_id, first_name, last_name, salary)
VALUES (2, 'Jane', 'Smith', 22000);

-- Commit the insertions
COMMIT;

-- PL/SQL program to update salary of employee by 2000 if salary is less than or equal to 20000
DECLARE
   v_employee_id NUMBER;
   v_current_salary NUMBER;
   v_new_salary NUMBER;
BEGIN
   -- Specify the employee ID for which you want to update the salary
   v_employee_id := 1; -- Replace with the actual employee ID

   -- Retrieve the current salary of the employee
   SELECT salary INTO v_current_salary
   FROM employees
   WHERE employee_id = v_employee_id;

   -- Check if the current salary is less than or equal to 20000
   IF v_current_salary <= 20000 THEN
      -- Calculate the new salary
      v_new_salary := v_current_salary + 2000;

      -- Update the employee's salary
      UPDATE employees
      SET salary = v_new_salary
      WHERE employee_id = v_employee_id;

      -- Commit the transaction
      COMMIT;

      DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Salary does not need to be updated.');
   END IF;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
