package main;

public class MatUtils {
	public static void verifyDim(Mat m, Mat n) {
		if (m.rows() != n.rows() || m.cols() != n.cols())
			Error.fatal("Operation can not be performed.");
	}
	
	public static Mat add(Mat m, Mat n) {
		verifyDim(m, n);
		Mat r = new Mat(m.rows(), m.cols());
		for (int i = 0; i < m.rows(); i++)
			for (int j = 0; j < m.cols(); j++)
				r.data[i][j] = m.data[i][j] + n.data[i][j];
		return r;
	}
	
	public static Mat sub(Mat m, Mat n) {
		verifyDim(m, n);
		Mat r = new Mat(m.rows(), m.cols());
		for (int i = 0; i < m.rows(); i++)
			for (int j = 0; j < m.cols(); j++)
				r.data[i][j] = m.data[i][j] - n.data[i][j];
		return r;
	}
	
	public static Mat prod(Mat m, Mat n) {
		verifyDim(m, n);
		Mat r = new Mat(m.rows(), m.cols());
		for (int i = 0; i < m.rows(); i++)
			for (int j = 0; j < m.cols(); j++)
				r.data[i][j] = m.data[i][j] * n.data[i][j];
		return r;
	}
	
	public static Mat mul(Mat m, Mat n) {
		verifyDim(m, n);
		Mat r = new Mat(m.rows(), m.cols());
		for (int i = 0; i < m.rows(); i++)
			for (int j = 0; j < m.cols(); j++)
				r.data[i][j] = m.data[i][j] * n.data[i][j];
		return r;
	}
	
	public static Mat dot(Mat m, Mat n) {
		verifyDim(m, n);
		Mat r = new Mat(m.rows(), m.cols());
		for (int i = 0; i < m.rows(); i++)
			for (int j = 0; j < m.cols(); j++)
				r.data[i][j] = m.data[i][j] * n.data[i][j];
		return r;
	}
}
