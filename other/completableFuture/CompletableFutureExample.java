package other.completableFuture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {
    @Test
    public void testcase1() throws ExecutionException, InterruptedException {
        //given
        Future<String> future = calculateAsync();
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello");
    }

    public Future<String> calculateAsync(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(()->{
            try {
                Thread.sleep(5000);
                completableFuture.complete("Hello");
                return null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return completableFuture;
    }
    
    @Test
    public void testcase2() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.completedFuture("Hello");
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello");
    }

    @Test
    public void testcase3() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello");
    }

    @Test
    public void testcase4() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        //when
        future = future.thenApply(s -> s + " World");
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello World");
    }

    @Test
    public void testcase5() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        //when
        CompletableFuture<Void> future2 = future.thenAccept(s -> System.out.println("Computation returned: " + s));
        //then
        future2.get();
    }

    @Test
    public void testcase6() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        //when
        // "Hello" 계산 결과가 필요없이 이전 비동기 함수가 실행되고 난 이후 다른 함수를 호출하고 싶다면 thenRun 사용
        future.thenRun(()->System.out.println("Computation finished."));
        //then
        String actual = future.get();
        System.out.println(actual);
        Assertions.assertThat(actual).isEqualTo("Hello");
    }

    @Test
    public void testcase7() throws ExecutionException, InterruptedException {
        //given
        // thenCompose는 매개변수를 입력받고 또다른 CompletableFuture 객체를 반환함
        // thenApply는 매개변수를 입력받고 매개변수와 같은 타입의 값을 반환함
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello World");
    }
    
    @Test
    public void testcase8() throws ExecutionException, InterruptedException {
        //given
        // CompletableFuture 객체의 get 메서드 호출시
        // supplyAsync에 들어간 함수와 thenCombine 첫번째 매개변수에 들어간 CompletableFuture 객체를 실행시키고 난 이후
        // thenCombine 두번째 매개변수의 함수를 실행시키고 반환값을 반환함
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("Hello World");
    }

    @Test
    public void testcase9() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
        //when
        future.get();
        //then
    }

    @Test
    public void testcase10() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10).thenApply(i -> i + 1);
        //when
        Integer actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo(11);
    }

    @Test
    public void testcase11() throws ExecutionException, InterruptedException {
        //given
        Function<Integer, CompletableFuture<Integer>> computeAnother = (i)-> CompletableFuture.supplyAsync(()-> 10 + i);
        //when
        CompletableFuture<Integer> finalResult = CompletableFuture.supplyAsync(() -> 10).thenCompose(computeAnother);
        //then
        Integer actual = finalResult.get();
        Assertions.assertThat(actual).isEqualTo(20);
    }
    
    @Test
    public void testcase12() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        //when
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
        //then
        combinedFuture.get();
        Assertions.assertThat(future1.isDone()).isTrue();
        Assertions.assertThat(future2.isDone()).isTrue();
        Assertions.assertThat(future3.isDone()).isTrue();
    }

    @Test
    public void testcase13() {
        //given
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        //when
        String actual = Stream.of(future1, future2, future3)
                              .map(CompletableFuture::join)
                              .collect(Collectors.joining(" "));
        //then
        Assertions.assertThat(actual).isEqualTo("Hello Beautiful World");
    }

    @Test
    public void testcase14() throws ExecutionException, InterruptedException {
        //given
        String name = null;
        //when
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                                                if (name == null) {
                                                    throw new RuntimeException("Computation error!");
                                                }
                                                return "Hello, " + name;
                                            }).handle((s, t) -> s != null ? s : "Hello, Stranger!");// 예외가 발생할 경우 수행됨
        //then
        String actual = future.get();
        Assertions.assertThat(actual).isEqualTo("Hello, Stranger!");
    }

    @Test
    public void testcase15() {
        //given
        CompletableFuture<String> future = new CompletableFuture<>();
        //when
        future.completeExceptionally(new RuntimeException("Calculation failed!"));
        //then
        Assertions.assertThatThrownBy(future::get);
    }


    @Test
    public void testcase16() throws ExecutionException, InterruptedException {
        //given

        //when
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(true){
                throw new IllegalStateException("call exception");
            }
            return "Thread: " + Thread.currentThread().getName();
        }).exceptionally(Throwable::getMessage);
        //then
        String actual = future.get();
        Assertions.assertThat(actual).isEqualTo("java.lang.IllegalStateException: call exception");
    }

    @Test
    public void testcase17() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new IllegalStateException("call exception");
            }
            return "Thread: " + Thread.currentThread().getName();
        }).handle((result, e) -> e == null ? result : e.getMessage());
        //when
        String actual = future.get();
        //then
        Assertions.assertThat(actual).isEqualTo("java.lang.IllegalStateException: call exception");
    }

    @Test
    public void testcase18() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        //when
        future = future.thenApplyAsync(s -> s + " World");
        //then
        String actual = future.get();
        Assertions.assertThat(actual).isEqualTo("Hello World");
    }

    @Test
    public void testcase19() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("hello world");
        });
        //when
        System.out.println("call");
        future.get();
        //then

    }

    
    @Test
    public void runAsync() throws ExecutionException, InterruptedException {
        //given
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("Thread: " + Thread.currentThread().getName()));
        //when
        future.get();
        //then
        System.out.println("Thread: " + Thread.currentThread().getName());
    }


}
