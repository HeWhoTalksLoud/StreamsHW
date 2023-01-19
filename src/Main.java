import pair.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final int LIST_LENGTH = 10;
        final int MAX_NUMBER = 50;
        Random random = new Random();

        // Задание 1.
        List<Integer> integerList = Stream
                .generate(() -> random.nextInt(MAX_NUMBER + 1))
                .limit(LIST_LENGTH).collect(Collectors.toList());

        integerList.forEach(System.out::println);

        BiConsumer<Integer, Integer> showMinMaxInt = (min, max) -> {
            System.out.println("Min: " + min + ", max:" + max);
        };

        findMinMax(integerList.stream(), Comparator.naturalOrder(), showMinMaxInt);

        /* А теперь то же самое - с пользовательским классом!
        public class Pair {
            private Integer X;
            private Integer Y;
            ...
        }

        Пусть больше считается тот объект класса Pair, у которого больше
        сумма X+Y.

         */

        List<Pair> pairList = Stream
                                .generate(() -> {
                                    return new Pair(random.nextInt(MAX_NUMBER + 1),
                                            random.nextInt(MAX_NUMBER + 1));

                                })
                                .limit(LIST_LENGTH)
                                .collect(Collectors.toList());
        pairList.forEach(System.out::println);

        BiConsumer<Pair, Pair> showMinMaxPair = (min, max) -> {
            System.out.println("Min: " + min + ", max:" + max);
        };

        Comparator<Pair> pairComparator = Comparator.comparingInt(p -> (p.getX() + p.getY()));

        findMinMax(pairList.stream(), pairComparator, showMinMaxPair);

        // Задача 2.
        List<Integer> integerList2 = Stream
                .generate(() -> random.nextInt(MAX_NUMBER + 1))
                .limit(LIST_LENGTH).collect(Collectors.toList());

        showNumberOfEvens(integerList2);
    }

    // Задача 1.
    public static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        // Преобразую стрим в список, чтобы из него обратно добывать стрим
        // и не пытаться работать с уже закрытым стримом при получении минимума.
        // Не очень изящно, но лучше пока ничего не придумал.
        List<? extends T> list = stream.collect(Collectors.toList());

        T max = list.stream().max(order).orElse(null);
        T min = list.stream().min(order).orElse(null);
        minMaxConsumer.accept(min, max);
    }

    // Задача 2.
    public static void showNumberOfEvens(List<Integer> list) {
        long count  = list
                .stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println("Список:");
        list.forEach(System.out::println);
        System.out.println("Кол-во четных чисел: " + count);
    }
}