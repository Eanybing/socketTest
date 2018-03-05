package jh.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by 17020751 on 2018/1/2.
 */
public class JedisDo {

    @Test
    public void test(){
        Jedis jedis = new Jedis("10.200.64.79",6379);
        jedis.set("11","11");
        System.out.println(jedis.get("11"));
    }
}
