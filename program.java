import java.util.*;
import java.util.stream.*;
import java.io.*;

public class program{

  //Determines the chord notes
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

  //Reverses the notes to a chord 
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

    //Sisestame andmed listi
    Scanner str = new Scanner(new FileReader("chords.txt"));

      while (str.hasNext()) {
        chords.add(chord(str.nextLine()));//converts chords symbols to notes
      //  System.out.println(chords);
      }

      str.close();

      PrintWriter pw = new PrintWriter(new FileWriter("notes.txt"));

    //Andmetöötlus
      chords
        .stream()
        .sorted()
        .map(String::toLowerCase)//lowercase notes
        .filter(c -> c.startsWith("f"))//filters chords that start with the 'f' note
        .map(String::toUpperCase)//upparcase notes 
        .peek(c -> System.out.println("Chord " +unChord(c) +" notes are: " + c + "\n"))//prints the original chord with notes
        .collect(Collectors.toList())//collect to list
        .forEach(pw::println);//writes them to a file

      pw.close();


  }//ends main
}//ends class
