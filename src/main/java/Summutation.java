import java.util.List;

public class Summutation {
    public static Long sum(List<Long> list_of_cities_pop){
        long sum = 0;
        for (Long pop : list_of_cities_pop) {
            sum += pop;
        }
        return sum;
    }
}
