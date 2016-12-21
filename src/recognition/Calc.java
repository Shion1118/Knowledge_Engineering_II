package recognition;

import java.util.*;

public class Calc {

	static int PARAM = 5;

	/**
	 *  マハラノビス距離
	 *  @param chars 辞書データを含む文字
	 *               46文字
	 *  @param data 検証データ
	 *  @param d 個数
	 */
	public static int Mahalanobis(List<Character> chars, double[] data, int d){
		List<Double> distance = new ArrayList<>();

		double result;

		for (Character c: chars) {
			result = 0;
			for (int i = 0; i < d; ++i) {
				double[] difference = subVector(data, c.getMean());
				double product = multiVector(difference, c.eigenpair.getEigenVector(i));
				result += Math.pow(product, 2) / (c.eigenpair.getEigenValue(i) + PARAM);
			}
			distance.add(result);
		}

		Object obj = Collections.min(distance);

		return distance.indexOf(obj);
	}

	/**
	 *  ベクトルの引き算
	 *  @param minuend 引かれる列ベクトル
	 *  @param subtrahend 引く列ベクトル
	 */
	public static double[] subVector(double[] minuend, double[] subtrahend) {
		double[] result = new double[minuend.length];
		for (int i = 0; i < minuend.length; ++i) {
			result[i] = minuend[i] - subtrahend[i];
		}
		return result;
	}

	/**
	 *  ベクトルの引き算
	 *  行x列の計算をする。
	 *  @param multiplicand 掛けられる行ベクトル
	 *  @param multiplier 掛ける列ベクトル
	 */
	public static double multiVector(double[] multiplicand, double[] multiplier) {
		double product = 0;

		for (int i = 0; i < multiplicand.length; ++i) {
			product += multiplicand[i] * multiplier[i];
		}
		return product;
	}
	
}
