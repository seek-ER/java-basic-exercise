import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input word list");
        String first = scanner.nextLine();
        System.out.println("please input another word list");
        String second = scanner.nextLine();
        String firstWordList = first;
        String secondWordList = second;


        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码

        if (!(Pattern.matches("^[a-zA-Z,]+$",firstWordList)) ||
            !(Pattern.matches("^[a-zA-Z,]+$",secondWordList)) ||
            Pattern.matches(".*,,.*",firstWordList) ||
            Pattern.matches(".*,,.*",secondWordList)
        ){
            throw new RuntimeException("input not valid");
        }

        String[] firstList = firstWordList.split(",");
        String[] secondList = secondWordList.split(",");

        Stream<String> stream1 = Arrays.stream(firstList);

        //打算对collect中大小写不同但是重复的元素进行操作。
        /*Map<String, String> collect = stream1.filter(s1 -> Arrays.stream(secondList).anyMatch(s2 -> s2.equalsIgnoreCase(s1)))//判断secondList中是否有相同元素
                .distinct()
                .collect(Collectors.toMap(
                        String::new, String::toLowerCase
                ));
        Stream.of(collect).
                filter(stringStringMap -> stringStringMap.entrySet().forEach())*/


        List<String> collect = stream1.filter(s1 -> Arrays.stream(secondList).anyMatch(s2 -> s2.equalsIgnoreCase(s1)))//判断secondList中是否有相同元素
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        /*long startTime2 = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (String word : firstList) {
            for (String wordInSecond : secondList) {
                if (word.equalsIgnoreCase(wordInSecond)){
                    list.add(word);
                }
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2-startTime2);*/
        return collect;
    }
}
