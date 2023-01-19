import java.util.ArrayList;
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

        List<Integer> integerList = Stream
                .generate(() -> random.nextInt(MAX_NUMBER + 1))
                .limit(LIST_LENGTH).collect(Collectors.toList());

        integerList.forEach(System.out::println);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {

    }
}