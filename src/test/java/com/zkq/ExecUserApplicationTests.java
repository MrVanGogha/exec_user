package com.zkq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class ExecUserApplicationTests {

    @Test
    void contextLoads() {
       String time1 = "2020-06-02 19:00:00";
       String time2 = "2020-06-04 20:30:00";

       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime start = LocalDateTime.parse(time1,dtf);
        LocalDateTime end = LocalDateTime.parse(time2,dtf);
        Duration between = Duration.between(start, end);
        System.out.println(between.toDays());
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());
        System.out.println(between.toMillis());
        System.out.println(between.toNanos());
        System.out.println(between.getSeconds());

    }

    @Test
    public void test01(){
        String str = "http://flyu.soflyit.com/api/profile/upload/2020/08/31/bc42e5a03901a9b396e8f1f0b7953c6b.jpg";
        int pos = str.lastIndexOf("/");
        System.out.println(str.substring(pos+1));
    }

}
