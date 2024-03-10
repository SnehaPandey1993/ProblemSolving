package DSA;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadData {
    @Test
    public void test1() throws IOException {
        String input="C:\\Users\\rahul\\OneDrive\\Desktop\\Sneha\\Notes\\input.txt";
        read(input);

    }

    static void read(String file) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(file));
        String s=br.readLine();
        Arrays.asList(s.split(" ")).stream().forEach(System.out::println);
    }
    static void readExcel(String file){
      try {
          FileInputStream fis=new FileInputStream(file);
         // XSSFWorkbook workbook=new XSSFWorkbook(fis);
      }catch (Exception e){

      }
    }
}
