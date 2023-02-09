package other.thread.threadpool;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExample {
    @Test
    public void testcase1(){
        //given
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //when
        executor.execute(()->System.out.println("Hello World"));
        //then
    }
    
    @Test
    public void testcase2() throws ExecutionException, InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //when
        Future<String> future = executor.submit(() -> "Hello World");
        //then
        String actual = future.get();
        Assertions.assertThat(actual).isEqualTo("Hello World");
    }
    
    @Test
    public void testcase3(){
        //given
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //when
        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });
        //then
        Assertions.assertThat(executor.getPoolSize()).isEqualTo(2);
        Assertions.assertThat(executor.getQueue().size()).isEqualTo(1);
    }

    @Test
    public void testcase4(){
        //given
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //when
        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });
        //then
        Assertions.assertThat(executor.getPoolSize()).isEqualTo(3);
        Assertions.assertThat(executor.getQueue().size()).isEqualTo(0);
    }

    @Test
    public void testcase5(){
        //given
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //when
        executor.submit(()->{
            counter.set(1);
        });
        executor.submit(()->{
            counter.compareAndSet(1, 2);
        });
        //then
        Assertions.assertThat(counter.get()).isEqualTo(1);
    }

    @Test
    public void testcase6() throws ExecutionException, InterruptedException {
        //given
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        //when
        System.out.println("before");
        executor.schedule(() -> System.out.println("Hello World"), 500, TimeUnit.MILLISECONDS).get();
        System.out.println("after");
        //then
    }
    
    @Test
    public void testcase7() throws InterruptedException {
        //given
        CountDownLatch lock = new CountDownLatch(3);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        //when
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("hello world");
            lock.countDown();
        }, 5, 1, TimeUnit.SECONDS);

        lock.await(7, TimeUnit.SECONDS);
        future.cancel(true);
        //then
    }
}
