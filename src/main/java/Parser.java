import java.util.ArrayList;
import java.util.List;

public class Parser {
   
    public static List<Long> parsePopulation(List<String> input) {
        return parser(input);
    }
    public static List<Long> parser(List<String> lines) {
        List<Long> populations = new ArrayList<>();

        for (String line : lines) {
            String[] fields = line.split(",");
            if (fields.length > 4) {
                String populationString = fields[4].trim();
                if (!populationString.isEmpty()) {
                    try {
                        long population = Long.parseLong(populationString);
                        populations.add(population);
                    } catch (NumberFormatException e) {
                        System.out.println("Print Error"+populations);
                    }
                }
            }
        }

        return populations;
    }

    public static long sum(List<Long> List_OF_Cities){
        int sum = 0;
        for (Long cities : List_OF_Cities) {
            sum += cities;
        }
        return sum;
    }
}
