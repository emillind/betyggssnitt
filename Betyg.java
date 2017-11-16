import java.io.*;
import java.util.*;

class Betyg {

  public static void main(String[] args) {
    try {
      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
      String line;
      double weighted = 0;
      double sum = 0;
      while((line = b.readLine()) != null) {
        String[] split = line.split("[ \t]");
        // for (String s : split ) {
        //   System.out.println(s);
        // }
        String firstThree = split[0].substring(0,3);
        if (!isNumeric(firstThree.substring(0,1)) && !isNumeric(firstThree.substring(1,2)) && isNumeric(firstThree.substring(2,3))) {
          double converted = convertGrade(split[split.length-3]);
          double credits = Double.parseDouble(split[split.length-5].replace(",", "."));
          if (converted != -1) {
            weighted +=  credits * converted;
            sum += credits;
          }
        }
      }
      System.out.println(weighted/sum);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  private static boolean isNumeric(String str)  {
    try {
      double d = Double.parseDouble(str);
    } catch(NumberFormatException e) {
      return false;
    }
    return true;
  }

  private static double convertGrade(String grade) {
    switch (grade) {
      case "F":
        return 0.0;
      case "E":
        return 3.0;
      case "D":
        return 3.5;
      case "C":
        return 4.0;
      case "B":
        return 4.5;
      case "A":
        return 5.0;
      default:
        return -1.0;
    }
  }

}
