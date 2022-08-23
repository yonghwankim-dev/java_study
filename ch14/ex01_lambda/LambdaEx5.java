package ch14.ex01_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class LambdaEx5 {
    static <T> void makeRandomList(Supplier<T> s, List<T> list){
        for(int i = 0; i < 10; i++){
            list.add(s.get());
        }
    }
    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list){
        System.out.print("[");
        for(T i : list){
            if(p.test(i)){
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list){
        List<T> newList = new ArrayList<T>(list.size());

        for(T i : list){
            newList.add(f.apply(i));
        }
        return newList;
    }
}
