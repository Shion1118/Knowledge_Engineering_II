package recognition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
	
	FileReader fr;
	BufferedReader br;
	String name;
	
	public File(String mode, int num) {
		String number = new String(String.format("%02d", num + 1));
		switch (mode) {
			case "data":
				name = "lib/data/c" + number + ".txt";
				break;
			case "mean":
				name = "lib/mean/mean" + number + ".txt";
				break;
			case "sigma":
				name = "lib/sigma/sigma" + number + ".txt";
				break;
			case "eigenvalue":
				name = "lib/eigenpair/eigenValue" + number + ".txt";
				break;
			case "eigenvector":
				name = "lib/eigenpair/eigenVector" + number + ".txt";
				break;
			default:
				return;
		}
		
		try {
			fr  = new FileReader(name);
			br = new BufferedReader(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double[] getVector(int row) {
		double[] tmp = new double[row];
		int i = 0;
		
		try {
		    for (String line; (line = br.readLine()) != null; i++) {
		        tmp[i] = Double.parseDouble(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public double[][] getMatrix(int row, int col) {
		double[][] tmp = new double[row][col];
		int i = 0;
		
		try {
		    for (String line; (line = br.readLine()) != null; i++) {
		        tmp[i % row][i % col] = Double.parseDouble(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}

}
