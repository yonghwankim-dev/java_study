package ch14.ex01_lambda;

import org.assertj.core.api.Assertions;

class Outer {
    int val = 10; // Outer.this.val
    
    class Inner{
        int val = 20; // this.val
        
        int method1(int i){ // void method(final int i){
//            i = 10; // Error, 상수의 값을 변경할 수 없음

            MyFunction f1 = ()->{
                return i;
            };
            return f1.run();
        }

        int method2(){
            int val = 30; // final int val = 30;
            MyFunction f1 = ()->{
                return val;
            };
            return f1.run();
        }

        int method3(){
            MyFunction f1 = ()->{
                this.val++;
                return this.val;
            };
            return f1.run();
        }

        int method4(){
            MyFunction f1 = ()->{
                Outer.this.val++;
                return Outer.this.val;
            };
            return f1.run();
        }
    }
}
