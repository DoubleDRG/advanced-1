package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

@Slf4j
public class FieldServiceTest
{
    private FieldService fieldService = new FieldService();

    @Test
    void field()
    {
        log.info("main start");

        Runnable userA = () ->
        {
            fieldService.logic("userA");
        };

        Runnable userB = () ->
        {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("tread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("tread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 X
        sleep(100); //동시성 문제 O
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}