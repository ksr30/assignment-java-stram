package com.knoldus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FrequencyMapFinder {

    Map<String, Long> frequencyFinder(Stream<String> totalWordsInFile) {

        Map<String, Long> frequencyCount = totalWordsInFile.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return frequencyCount;

    }
}

class FileReader {
    Stream<String> lineFinder() throws IOException {


        String fileName = "./src/main/resources/file";

        //read file into stream, try-with-resources

        Stream<String> streamOfLines = Files.lines(Paths.get(fileName));
        return streamOfLines;


    }
}


public class FrequencyMap {
    public static void main(String[] args) throws IOException {
        FileReader readOpration = new FileReader();
        FrequencyMapFinder modifyOpeartion = new FrequencyMapFinder();
        Stream<String> streamOflines = readOpration.lineFinder();

        Stream<String> totalWords = streamOflines.map(line -> line.split(" ")).flatMap(Arrays::stream);

        System.out.println(modifyOpeartion.frequencyFinder(totalWords));


    }
}
