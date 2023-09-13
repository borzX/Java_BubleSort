import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import java.util.Date;


class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;


    public void sortLog(String mas) throws IOException {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            
            fileWriter.write(mas+"\n");
            fileWriter.flush();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        // try {
        //     FileHandler fh = new FileHandler("log.txt", true);
        //     logger.addHandler(fh);
        
        //     SimpleFormatter sFormat = new SimpleFormatter();
        //     SimpleDateFormat sDateFormat = new SimpleDateFormat();
        //     fh.setFormatter(sFormat);
        //     String str = mas.toString();
        //     logger.info(str);

        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
    }
    
    public void sort(int[] mas) throws IOException {

      for (int i = 0; i < mas.length - 1; i++) {
        for(int j = 0; j < mas.length - i - 1; j++) {
          if(mas[j + 1] < mas[j]) {
            int temp = mas[j];
            mas[j] = mas[j + 1];
            mas[j + 1] = temp;
            int[] str = mas;    
            System.out.println(mas);
            // sortLog(str);
          }
        }
        return;
      }
    }
  }
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) throws IOException { 
      int[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new int[]{9, 4, 8, 3, 1};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
      }     
      
      BubbleSort ans = new BubbleSort();      
      ans.sort(arr);

      try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}