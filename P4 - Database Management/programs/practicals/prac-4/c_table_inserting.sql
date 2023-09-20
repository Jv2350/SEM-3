accept eid prompt "Enter employee id: "
accept ename prompt "Enter employee name: "
accept salary prompt "Enter employee salary: "

insert into emp values(&eid,'&ename',&salary);
-- commit;