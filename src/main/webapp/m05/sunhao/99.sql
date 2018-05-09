declare
begin
   for v_i in  1..9 loop
   for v_c in  1..9  loop
   dbms_output.put_line(v_i||'*'||v_c||'='||v_i*v_c);      
   end loop;
   dbms_output.put_line(chr(13)); 
   end loop;
end;



