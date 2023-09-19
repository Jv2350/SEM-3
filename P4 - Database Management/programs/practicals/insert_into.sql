accept id prompt "Enter the first value: "
DECLARE
    id emp.eid%type;
BEGIN
    insert into emp values(&id)
end;
/