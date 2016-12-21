package recognition;

import java.util.ArrayList;
import java.util.List;

public class Main{

    static int HIRAGANA = 46;

	public static void main(String[] args) {

        List<Character> chars = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        int cnt;

        for (int i = 0; i < HIRAGANA; ++i) {
            chars.add(new Character(i));
        }

        for (int i = 0; i < HIRAGANA; ++i) {
            cnt = 0;
            for (int j = 180; j < 200; ++j) {
                int num = Calc.Mahalanobis(chars, chars.get(i).getData(j), 180);
                if (i == num) cnt++;
            }
            result.add((double) cnt / 20);
        }

        for (double d: result) System.out.println(d);
	}
}
