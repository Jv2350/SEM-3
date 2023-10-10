create or REPLACE function factorial(num integer)
return integer IS

begin 
    if num = 1 then 
        return num;
    else
        return (num*(factorial(num-1)));
    end if;
end;
/