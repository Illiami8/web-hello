package com.cherepovski.logic;

import java.math.BigDecimal;
import java.util.List;

public class Statistic {
    public BigDecimal averege(List<Integer> integers) {
        double averegeDouble = integers.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
        return BigDecimal.valueOf(averegeDouble);
    }
}
