import java.util.*;
import java.util.stream.*;
import java.io.*;

public class program{

  private static String chord(String s) {
    if(s.equals("F#7")){
      return "F#, A, C#, E | ";
    }else if(s.equals("E7")){
      return "E, G#, B, D | ";
    }else if(s.equals("D7")){
      return "D, F#, A, C | ";
    }else if(s.equals("C#7")){
      return "C#, E, G#, B | ";
    }else if(s.equals("Fm7")){
      return "F, Ab, C, Eb | ";
    }else{
      return "Invalid";
    }
  }//ends chord function

  private static String unChord(String s) {
    if(s.equals("F#, A, C#, E | ")){
      return "F#7";
    }else if(s.equals("E, G#, B, D | ")){
      return "E7";
    }else if(s.equals("D, F#, A, C | ")){
      return "D7";
    }else if(s.equals("C#, E, G#, B | ")){
      return "C#7";
    }else if(s.equals("F, AB, C, EB | ")){
      return "Fm7";
    }else{
      return "Invalid";
    }
  }//ends chord function

  public static void main(String[] args) throws Exception{

    ArrayList<String> chords = new ArrayList<>();

    Scanner str = new Scanner(new FileReader("chords.txt"));

      while (str.hasNext()) {
        chords.add(chord(str.nextLine()));
      //  System.out.println(chords);
      }

      str.close();

      PrintWriter pw = new PrintWriter(new FileWriter("notes.txt"));

      chords
        .stream()
        .sorted()
        .map(String::toLowerCase)
        .filter(c -> c.startsWith("f"))
        .map(String::toUpperCase)
        .peek(c -> System.out.println("Chord " +unChord(c) +" notes are: " + c + "\n"))
        .collect(Collectors.toList())
        .forEach(pw::println);

      pw.close();


  }//ends main
}//ends class
