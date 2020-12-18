package com.xz2dai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// JDK8m Strea Test
        List<Integer> list1 = List.of(1,2,3,4,5,6,7,3454,52,34,12,4212,2,124,2353,5235,2);
        list1 = list1.stream().distinct().collect(Collectors.toList()); //去除重复
        List<Integer> list2 = list1.stream().filter(num -> num!=0).collect(Collectors.toList());//过滤0
        list2.stream().limit(10).forEach(System.out::print);//迭代输出
        List<Integer> list3 = list2.stream().map(i -> i+1).collect(Collectors.toList()); //逐个加一
        list1.stream().sorted().forEach(System.out::print); //排序
//
//        String str1 = " ";
//        String str2 = null;
//        if(Optional.ofNullable(str2).isPresent()){  //判断值是否为空
//            //do something
//        }
//        String value = Optional.ofNullable(str1)
//                .map(str -> {System.out.print(str);return str;})
//                .orElse("null");


//        int[] a = {1,2,3,4};
//        int[] b = {2,3,4,5};

        List<Integer> a = List.of(1,2,3,4);
        List<Integer> b = List.of(3,4,5,6);
        List<Integer> c = a.stream().filter(i -> {
                for(int j:b){
                    return !i.equals(j);
                }
                return false;
        }).collect(Collectors.toList());
//        List<Integer> c = a.stream().filter(integer -> b.stream().anyMatch(i -> integer.equals(integer))).collect(Collectors.toList());
        c.forEach(System.out::print);
    }
}
