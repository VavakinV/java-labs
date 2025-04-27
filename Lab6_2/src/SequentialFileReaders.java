import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SequentialFileReaders {
    private static final int THREAD_COUNT = 5;
    public static final String FILE_PATH = "./Lab6_2/words.txt";

    public static void main(String[] args) {
        FileController controller = new FileController(THREAD_COUNT);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            Thread thread = new Thread(() -> {
                try {
                    controller.readWords(threadId);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        controller.printResults();
    }
}
