/*
 * The multithreaded section of the code:
 * 
 * Essentially, each element is computed 
 * parallely by the N*M Theads since the
 * addition operation can be parallelized
 * */

package matrix_multiply.threaded_progs;

public class RowMultiplyWorker extends Thread {
	private int row;
	private int col;
	private int inter; //The intermediate row/column length

	private int [][] A;
	private int [][] B;
	private int [][] C;

	public RowMultiplyWorker(int row, int col, int inter, int[][] A, int[][] B, int[][] C) {
		this.row = row;
		this.col = col;
		this.inter = inter;

		this.A = A;
		this.B = B;
		this.C = C;
	}

	public void run() {
		C[row][col] = 0;
		for (int i = 0 ; i < inter ; i++) {
			C[row][col] = C[row][col]+ (A[row][i] * B[i][col]); 
		}
	}
}
