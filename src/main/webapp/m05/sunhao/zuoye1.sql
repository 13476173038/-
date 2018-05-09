declare
    v_a number(4);
begin
   v_a:='&����������';
   if(mod(v_a,2)!=0) then
          for v_k  in 1..v_a/2 loop
               for  v_j   in 1..v_a/2-v_k  loop
               dbms_output.put(' ');             
               end loop; 
               for v_t  in 1..2*v_t-1  loop
               dbms_output.put('*');         
               end loop;  
               dbms_output.put_line(' ');
          end loop; 
                    for v_k  in 1..v_a/2 loop
               for  v_j   in v_a/2-v_k..1  loop
               dbms_output.put(' ');             
               end loop; 
               for v_t  in 2*v_t-1..1  loop   //下半截有问题
               dbms_output.put('*');         
               end loop;  
               dbms_output.put_line(' ');
          end loop; 
   else 
          dbms_output.put_line('����������');
   end if;       
end;





