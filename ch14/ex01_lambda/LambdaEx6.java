package ch14.ex01_lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

class LambdaEx6 {
    static void makeRandomList(IntSupplier s, int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.getAsInt();
        }
    }
    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr){
        System.out.print("[");
        for(int i : arr){
            if(p.test(i)){
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static int[] doSomething(IntUnaryOperator op, int[] arr){
        int[] newArr = new int[arr.length];

        for(int i = 0; i < newArr.length; i++){
            newArr[i] = op.applyAsInt(arr[i]);
        }
        return newArr;
    }
}
