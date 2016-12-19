package recognition;

public class Eigenpair {
	
	double[] eigenValue;
	double[][] eigenVector;
	
	public Eigenpair(int num) {
		File valueFile = new File("eigenvalue", num);
		File vectorFile = new File("eigenvector", num);
		
		eigenValue = valueFile.getVector(196);
		eigenVector = vectorFile.getMatrix(196, 196);
	}
	
	public double[] getEigenValue() {
		return this.eigenValue;
	}
	
	public double[][] getEigenVector() {
		return this.eigenVector;
	}

}
