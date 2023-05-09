import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        List<Long> populations = Parser.parser(Reader.read(filePath));
        long totalPopulation = Parser.sum(populations);
        String formattedPopulation = NumberFormat.getInstance(Locale.getDefault()).format(totalPopulation);
        System.out.printf("World population is: %s\n", formattedPopulation);
    }
}