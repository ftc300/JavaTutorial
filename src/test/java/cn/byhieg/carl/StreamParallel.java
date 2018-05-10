package cn.byhieg.carl;

import cn.byhieg.collectiontutorial.listtutorial.ArrayListDemo;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamParallel extends TestCase {

    public void testSteam() throws Exception {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        IntStream.range(0,max).forEach(i->{
            values.add(UUID.randomUUID().toString());
        });
        testSteam(values);
        testParallel(values);
    }

    private void testSteam(List<String> values) {
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("steam sort took: %d ms", millis));
    }

    public void testParallel(List<String> values ){
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }


}
