import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoopPerformanceTesting {

    public static void printRunTimeOfLoops(final List<Integer> list) {

        Integer evenSum = 0;
        long startTime;
        long endTime;


        startTime = System.currentTimeMillis();
        for (int i =0;i<list.size();i++) {
            if (list.get(i) % 2 == 0) {
                evenSum += list.get(i);
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("For loop execution Time " + (endTime - startTime));


        evenSum = 0;
        startTime = System.currentTimeMillis();
        for (Integer i : list) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("For each loop execution Time is " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        evenSum = list.parallelStream().filter(num -> num % 2 == 0)
                .reduce(0, (sum, num) -> sum + num);
        endTime = System.currentTimeMillis();
        System.out.println("stream execution Time is " + (endTime - startTime));
    }

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i =1; i<100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        System.out.println("Loop execution time on Array list data structure.");
        printRunTimeOfLoops(arrayList);

        System.out.println("Loop execution time on Linked list data structure.");
        printRunTimeOfLoops(linkedList);
    }
}
