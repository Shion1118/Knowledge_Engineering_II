package recognition;

public class Character {
	
	double[][] data;			//180文字196次元のデータ
	double[] mean;			//データの平均196個
	Eigenpair eigenpair;	//固有値・ベクトル(196次元)が196個

	public Character(int num) {
		File dataFile = new File("data", num);
		File meanFile = new File("mean", num);
		
		data = dataFile.getMatrix(180, 196);
		mean = meanFile.getVector(196);
		eigenpair = new Eigenpair(num);
	}

}
