package chess.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Sets {
    public static <T> Set<T> union(Set<T>... sets) {
        return Arrays.stream(sets).flatMap(Collection::stream).collect(Collectors.toSet());
    }
}
