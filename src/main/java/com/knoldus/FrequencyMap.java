package com.knoldus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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


        String fileName = "/home/knoldus/Documents/assignment-java-stream/src/main/resources/file";

        //read file into stream, try-with-resources

        Stream<String> streamOfLines = Files.lines(Paths.get(fileName));
        return streamOfLines;


    }
}


public class FrequencyMap {
    public static void main(String[] args) throws IOException {
        FileReader readOpration=new FileReader();
        FrequencyMapFinder modifyOpeartion=new FrequencyMapFinder();
        Stream<String> streamOflines=readOpration.lineFinder();
        List<String> totalWords = streamOflines.map(ele->ele.toString()).map(line->line.split(" ")).map(words->words.toString()).collect(Collectors.toList());
        System.out.println(totalWords);
    //    System.out.println(modifyOpeartion.frequencyFinder(totalWords));




    }
}
