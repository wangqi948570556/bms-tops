create or replace procedure s_wq(name in varchar2)
is 
cursor c is select distinct id,packet_id,item_id from bms_ctrl_packet_item;
    v_id number(19,0);
    v_packetId number(19,0);
    v_itemId number(19,0);
begin  
    open c;
    loop
      fetch c into v_id,v_packetId,v_itemId;
      if c %notfound then
        dbms_output.put_line(name);
        commit;
      else
        dbms_output.put_line(name);
        commit;
      end if;
    end loop;
    close c;
end s_wq;

call s_wq('wangqi');