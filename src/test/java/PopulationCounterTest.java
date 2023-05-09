/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
 
 
 public class PopulationCounterTest {
     @Test
     public void testSomeLibraryMethod() throws Exception {
 
         // Setup
         String expected = "World population is: 1,347,982,728\n";
 
         // https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         PrintStream old = System.out;
         System.setOut(ps);
 
         // Exercise
         PopulationCounter.main(new String[] {"./data/worldcitiespop.csv"});
 
         // Assert
         System.out.flush();
         String output = baos.toString();
         assertEquals(expected, output );
 
         // Teardown
         System.setOut(old);
     }
  
     @Test
     public void Reader() throws IOException {
        List<String> expected = new ArrayList<>();
        expected.add("ad,andorra la vella,Andorra la Vella,07,20430,42.5,1.5166667");

        Path filePath = Paths.get("./data/worldcitiespop.csv");
        mockStatic(Files.class);
        when(Files.readAllLines(eq(filePath), eq(StandardCharsets.ISO_8859_1))).thenReturn(expected);

        List<String> actual = Reader.read("./data/worldcitiespop.csv");

        verifyStatic(Files.class);
        Files.readAllLines(eq(filePath), eq(StandardCharsets.ISO_8859_1));

        assertEquals(expected, actual);
    }
 
    private void verifyStatic(Class<Files> class1) {
    }

    @Test
    public void Parser() {
        List<String> input = new ArrayList<>();
        input.add("Country,City,AccentCity,Region,Population,Latitude,Longitude");
        input.add("ad,andorra la vella,Andorra la Vella,,20430,42.5,1.5166667");
        input.add("ad,canillo,Canillo,02, 0,42.5666667,1.6");
        List<Long> expected = new ArrayList<>(List.of(20430L, 0L));
        List<Long> actual = Parser.parser(input);
        assertEquals(expected, actual);
    }   
  
    @Test
    public void TestPopulation() {
        List<Long> input = Arrays.asList(2L, 4L, 6L, 8L);
        long expected = 20L;
        long actual = Parser.sum(input);
        assertEquals(expected, actual);
    }
     
 }