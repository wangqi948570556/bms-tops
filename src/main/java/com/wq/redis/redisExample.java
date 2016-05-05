package com.wq.redis;

import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RSet;

public class redisExample {

	public static void main(String[] args) {
		Config config = new Config();  
        config.setConnectionPoolSize(10);  
        config.addAddress("127.0.0.1:6379");  
        Redisson redisson = Redisson.create(config);  
        System.out.println("reids连接成功...");
        
     // 2.测试concurrentMap,put方法的时候就会同步到redis中  
        ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");  
        map.put("wuguowei", "男");  
        map.put("zhangsan", "nan");  
        map.put("lisi", "女");
        System.out.println(map.get("lisi"));
        ConcurrentMap resultMap = redisson.getMap("FirstMap");  
        System.out.println("resultMap==" + resultMap.keySet()); 
        
        
        RSet<Object> a = redisson.getSet("wangqi");
        a.add(11);
        RSet result = redisson.getSet("wangqi");
        System.out.println("result=="+result.iterator());
        
        
	}
}
