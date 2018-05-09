declare type t_array is array(9) of integer;
arr t_array := t_array(11,5,8,1,6,9,14,7,2);

tmp integer;
j integer;

begin
    if arr.count = 1 then
        dbms_output.put_line(arr(1));
    else
        for i in 2 .. arr.count loop
            tmp := arr(i);
            j := i - 1;
            while ((j > 0) and (arr(j) > tmp)) loop
                arr(j + 1) := arr(j);
                j := j - 1;
            end loop;
            arr(j + 1) := tmp;
        end loop;

        for i in 1.. arr.count loop
            dbms_output.put_line(arr(i));
        end loop;
    end if;
end;
