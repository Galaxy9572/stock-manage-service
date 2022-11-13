package com.jy.stock.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liaojunyao
 */
public class StreamUtils {

    public static <IN, OUT> List<OUT> mapCollect(List<IN> list, Function<? super IN, ? extends OUT> mapper){
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream().map(mapper).collect(Collectors.toList());
    }

}
