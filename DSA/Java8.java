package DSA;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {
    @Test
    public void Evenodd(){
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Set<Map.Entry<Boolean,List<Integer>>> list= listOfIntegers.stream().collect(Collectors.partitioningBy(s->s%2==0)).entrySet();
        for (Map.Entry<Boolean,List<Integer>> entry:list){
            boolean flag=entry.getKey();
            if(flag==true){
                System.out.print("Even ");
            }else {
                System.out.print("Odd ");
            }
            List<Integer> value=entry.getValue();
            for (int i:value){
                System.out.print(i+" ");
            }
        }
    }
    @Test
    public void Evenodd1(){
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        IntStream.rangeClosed(0,listOfIntegers.size()).filter(i->i%2==0).forEach(System.out::print);
        System.out.println(" ");
        IntStream.rangeClosed(0,listOfIntegers.size()).filter(i->i%2!=0).forEach(System.out::print);
    }
    @Test
    public void removeDup(){
        List<String> list=Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        Map<String,Long> ls=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(ls);
        Map.Entry<String,Long> col=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(i->i.getValue()>1).max(Map.Entry.comparingByKey()).get();
        System.out.println("MAX "+col.getValue()+" key "+col.getKey());
        //15) Given a list of strings, sort them according to increasing order of their length?
        List<String> st=list.stream().distinct().toList().stream().sorted().toList();
        String sjoin=st.stream().collect(Collectors.joining(",","[","]"));
        st.stream().forEach(i-> System.out.print(i+" "));
        System.out.println(sjoin);
    }
    @Test
    public void freqString(){
        String inputString = "Java Concept Of The Day";
       Map<String,Long> freq=Arrays.stream(inputString.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(freq);
        List<Character> freqchar=inputString.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(freqchar);
    }

    @Test
    public void revDouble(){
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
          decimalList.stream().sorted(Comparator.reverseOrder()).forEach(i->System.out.print(i+" "));
    }

    @Test
    public void maxInt(){
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("min::");
        listOfIntegers.stream().sorted().limit(3).forEach(i-> System.out.print(i+" "));
        int min=listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("max::");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(i->System.out.print(i+" "));
        System.out.println("::");
        listOfIntegers.stream().filter(i->i%5==0).sorted().forEach(i->System.out.print(i+" "));
    }

    @Test
    public void joinArray(){
        int[] a=new int[]{1,4,3,5};
        int[] b=new int[]{7,6,3,9};
        int[] c=IntStream.concat(Arrays.stream(a),Arrays.stream(b)).distinct().sorted().toArray();
        Integer secmax= Arrays.stream(c).sorted().skip(Math.max(0,c.length-2)).findFirst().orElseThrow();
        Integer secmin= Arrays.stream(c).sorted().skip(1).findFirst().orElseThrow();
        System.out.println(secmax+" "+secmin);
        System.out.println(Arrays.toString(c));
    }
    @Test
    public void anagram(){
        String s1="Racecar";
        String s2="carRace";
        s1= Stream.of(s1.split(" ")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2= Stream.of(s2.split(" ")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if(s1.equals(s2)){
            System.out.println("String are anagram");
        }else {
            System.out.println("String is not anagram");
        }
    }
    @Test
    public void sumOfDigit(){
        //13) Find sum of all digits of a number in Java 8?
        int i= 156789;
        //Integer sum=Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
       Integer sum=Arrays.asList(String.valueOf(i).split("")).stream().collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sum);
    }
    @Test
    public void sumAvg(){
        int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum=Arrays.stream(a).sum();
        System.out.println(sum);

        double avg=Arrays.stream(a).average().getAsDouble();
        System.out.println(avg);
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);
        int sumNatural=IntStream.rangeClosed(1,11).sum();
        System.out.println("natural "+sumNatural);
        int[] rev=IntStream.rangeClosed(1,a.length).map(i->a[a.length-i]).toArray();
        System.out.println(Arrays.toString(rev));
        IntStream.rangeClosed(1,10).map(i->i*2).forEach(System.out::print);
    }

    @Test
    public void average(){
        //19) How do you find sum of first 10 natural numbers?
        String str = "Java Concept Of The Day";
        String revStr=Arrays.stream(str.split(" ")).map(word->new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(revStr);
    }

}
