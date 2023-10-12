declare 
a1 number;
s1 number;
    function add(a number, b number)  
        return number
        is 
        n number;
        BEGIN
            n := a+b;
            return n;
        end add;

    function sub(n number, m number) 
    return NUMBER
    IS
    a number;
    BEGIN
        a := n-m;
        return a;
    end sub;
    

BEGIN
a1 := add(10,20);
dbms_output.put_line(a1);
-- end;
s1 := sub(10,20);
dbms_output.put_line(s1);
end;
/