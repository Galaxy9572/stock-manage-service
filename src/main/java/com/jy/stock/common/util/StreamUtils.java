package com.jy.stock.common.util;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liaojunyao
 */
public class StreamUtils {

    public static <IN, OUT> List<OUT> mapCollect(List<IN> list, Function<? super IN, ? extends OUT> mapper) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().map(mapper).collect(Collectors.toList());
    }

    public static <IN, OUT> Set<OUT> mapCollectToSet(List<IN> list, Function<? super IN, ? extends OUT> mapper) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().map(mapper).collect(Collectors.toSet());
    }

    public static <IN, OUT> List<OUT> distinctMapCollect(List<IN> list, Function<? super IN, ? extends OUT> mapper) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().map(mapper).distinct().collect(Collectors.toList());
    }

    public static <IN> IN findFirst(List<IN> list, Predicate<? super IN> predicate) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().filter(predicate).findFirst().orElse(null);
    }

    public static <IN> boolean allMatch(List<IN> list, Predicate<? super IN> predicate) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().allMatch(predicate);
    }

    public static <IN> List<IN> filterCollect(List<IN> list, Predicate<? super IN> predicate) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().filter(predicate).collect(Collectors.toList());
    }

    public static <IN, OUT> List<OUT> filterMapCollect(List<IN> list, Predicate<? super IN> predicate, Function<? super IN, ? extends OUT> mapper) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().filter(predicate).map(mapper).collect(Collectors.toList());
    }

    public static <IN, K, V> Map<K, V> toMap(List<IN> list, Function<? super IN, ? extends K> keyMapper,
                                             Function<? super IN, ? extends V> valueMapper) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().collect(Collectors.toMap(keyMapper, valueMapper));
    }

    public static <K, IN> Map<K, List<IN>> group(List<IN> list, Function<? super IN, ? extends K> classifier) {
        return Optional.ofNullable(list).orElse(new ArrayList<>()).stream().collect(Collectors.groupingBy(classifier));
    }

}
