package algo;

public class Mat {

	private double[][] data;
	private int rows;
	private int cols;

	public Mat(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.data = new double[rows][cols];
	}

	public void init(double val) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] = val;
	}

	public void randomize() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				data[i][j] = Math.random();
	}
	
	@Override
	public String toString() {
		var text = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			System.out.printf("[");
			for (int j = 0; j < cols; j++) {
				System.out.printf("%f", data[i][j]);
				if (j < cols - 1) System.out.printf(" ");
			}
			System.out.printf("]\n");
		} 
		return text.toString();
	}
}
