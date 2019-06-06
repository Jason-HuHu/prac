package com.huxl.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * lambda
 *
 * @author huxl
 * @since 2019/6/6 15:22
 */
public class LambdaBase {

    public static void main(String[] args) {

        testForEach();

        testStreamDuplicates();
    }

    private static void testForEach(){
        String[] arr = of("1","12","3");

        //转换成集合
        List<String> list = Arrays.asList(arr);

        //传统遍历方式
        System.out.println("传统遍历方式：");
        for (String s : list) {
            System.out.println(s);
        }

        //采用lambda表达式操作
        System.out.println("lambda表达式操作：");
        list.forEach((l) -> System.out.println(l));
        System.out.println("采用双冒号操作：");
        list.forEach(System.out::println);

    }

    private static void testStreamDuplicates() {
        System.out.println("Stream去重");
        List<String> list = asList("1","1","2","3","4","4");
        //Stream去重
        list = list.stream().distinct().collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    private static String[] of(String ... arg){
        return arg;
    }

    private static  <T> List asList(T... a){
        return new ArrayList<>(a);
    }

    private static class ArrayList<E> extends AbstractList<E>
            implements RandomAccess, java.io.Serializable
    {
        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;

        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }

        @Override
        public int size() {
            return a.length;
        }

        @Override
        public Object[] toArray() {
            return a.clone();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                return Arrays.copyOf(this.a, size,
                        (Class<? extends T[]>) a.getClass());
            System.arraycopy(this.a, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }

        @Override
        public E get(int index) {
            return a[index];
        }

        @Override
        public E set(int index, E element) {
            E oldValue = a[index];
            a[index] = element;
            return oldValue;
        }

        @Override
        public int indexOf(Object o) {
            E[] a = this.a;
            if (o == null) {
                for (int i = 0; i < a.length; i++)
                    if (a[i] == null)
                        return i;
            } else {
                for (int i = 0; i < a.length; i++)
                    if (o.equals(a[i]))
                        return i;
            }
            return -1;
        }

        @Override
        public boolean contains(Object o) {
            return indexOf(o) != -1;
        }

        @Override
        public Spliterator<E> spliterator() {
            return Spliterators.spliterator(a, Spliterator.ORDERED);
        }

        @Override
        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            for (E e : a) {
                action.accept(e);
            }
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            E[] a = this.a;
            for (int i = 0; i < a.length; i++) {
                a[i] = operator.apply(a[i]);
            }
        }

        @Override
        public void sort(Comparator<? super E> c) {
            Arrays.sort(a, c);
        }
    }
}
