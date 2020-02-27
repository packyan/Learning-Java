package com.SupplierConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumerDemo {
    public static void main(String[] args) {
        String s = useSupplier(new Supplier<String>() {
            @Override
            public String get() {
                return "43";
            }
        });
        System.out.println(s);

        String ss = useSupplier( ()-> "lambda supplier" );
        //默认复写了接口里的get操作，与上面的匿名内部类一致
        System.out.println(ss);

        useConsumer("consumer inner class", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("inner class method");
            }
        });

        useConsumer("consumer lambda",s1 -> System.out.println(
                new StringBuilder(s1).reverse().toString()
        ));
        useConsumer("consumer lambda 2", System.out::println);

        useConsumerTwice("consumer accept twice",System.out::println,
                s1 -> System.out.println(new StringBuilder(s1).reverse().toString()));

        List<String> stuInfo = new ArrayList<>();
        stuInfo.add("zhang, 14");
        stuInfo.add("hux,56");
        stuInfo.add("lu,43");
        stuInfo.add("xu2,32");

        for(var stu :stuInfo){
            useConsumerPrintStuInfo(stu,
                    (s1 -> {String[] strs = s1.split(",");
                        System.out.print("name: " + strs[0]);}),
                    (s1 -> {String[] strs = s1.split(",");
                        System.out.println(" , age: " + strs[1]);}));


        }

    }
    public static void useConsumerPrintStuInfo(String s, Consumer<String> con1, Consumer<String> con2){
        con1.andThen(con2).accept(s);
    }
    public static void useConsumerTwice(String s, Consumer<String> con1, Consumer<String> con2){
        con1.accept(s);
        con2.accept(s);

        con1.andThen(con2).accept(s);

    }
    public static  void useConsumer(String s , Consumer<String> consumer){
        consumer.accept(s);
    }
    public static String useSupplier(Supplier<String> supplier){
        return supplier.get();
    }
}
