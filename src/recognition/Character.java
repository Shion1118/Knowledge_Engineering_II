package recognition;

public class Character {

	int id;
	double[][] data;			//180文字196次元のデータ
	double[] mean;			//データの平均196個
	Eigenpair eigenpair;	//固有値・ベクトル(196次元)が196個

	public Character(int num) {
		id = num + 1;

		File dataFile = new File("data", id);
		File meanFile = new File("mean", id);
		
		data = dataFile.getMatrix(200, 196);
		mean = meanFile.getVector(196);
		eigenpair = new Eigenpair(id);
	}

	public int getId() {
		return id;
	}

    public double[][] getData() {
        return data;
    }

    public double[] getData(int row) {
        return data[row];
    }

	public double[] getMean() {
	    return mean;
    }

}
