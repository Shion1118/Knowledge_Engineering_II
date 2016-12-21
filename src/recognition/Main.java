package recognition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main{

    static int HIRAGANA = 46;

	public static void main(String[] args) {

        List<Character> chars = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < HIRAGANA; ++i) {
            chars.add(new Character(i));
        }

        ExecutorService exec = Executors.newFixedThreadPool(46);
        List<Future<Integer>> futures = new ArrayList<>();
        Future<Integer> future;

        for (int i = 0; i < HIRAGANA; ++i) {
            MahalanobisThread thread = new MahalanobisThread(chars, i);
            future = exec.submit(thread);
            futures.add(future);
        }

        try {
            for (Future<Integer> f: futures) {
                result.add((double)f.get() / 20);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (double d: result) {
            System.out.println(d * 100);
        }

        return;
	}
}
