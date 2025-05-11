import wordcounter.*;

public class Main {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        counter.setText("Lorem ipsum lorem ipsum lorem ipsum one two two three three three");
        counter.calculate();
        System.out.println(counter);
    }
}