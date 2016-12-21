package recognition;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shion on 2016/12/21.
 */
public class MahalanobisThread implements Callable<Integer> {

    private List<Character> chars;
    private int id = 0;
    private int cnt = 0;

    public MahalanobisThread(List<Character> chars, int num) {
        this.chars = chars;
        this.id = num;
    }

    @Override
    public Integer call() throws Exception {

        for (int i = 180; i < 200; ++i) {
            int num = Calc.Mahalanobis(chars, chars.get(id).getData(i), 180);
            if (id == num) cnt++;
        }
        return cnt;
    }
}
