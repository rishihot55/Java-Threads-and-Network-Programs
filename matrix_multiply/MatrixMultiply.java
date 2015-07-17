/*
* A Matrix Multiplication program
* programmed to use multiple threads
* 
* OS Project Code based off (the hopelessly incorrect): 
* https://github.com/Tacuma/Matrix-Multiplication-Using-Threads
*/

package matrix_multiply.threaded_progs;

public class MatrixMultiply {
	public static int M = 4;
	public static int K = 4;
	public static int N = 4;
	
	// Checkerboard matrices
	public static int [][]A = { 
		{1,0,1,0}, 
		{0,1,0,1},
		{1,0,1,0},
		{0,1,0,1}
	};

	public static int [][]B = {
		{1,0,1,0},
		{0,1,0,1},
		{1,0,1,0},
		{0,1,0,1}
	};
	// The matrices give a predictable result
	// 2 0 2 0
	// 0 2 0 2
	// 2 0 2 0
	// 0 2 0 2
	// This can be proved by induction
	
	public static int [][] C = new int [M][N];
	
	// Checking to see if variable allocation 
	// can be done for worker threads
	public static RowMultiplyWorker[][] Threads = new RowMultiplyWorker[M][N];
	public static void main(String [] args) {
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < N ; j++) {
				Threads[i][j] = new RowMultiplyWorker(i,j,K,A,B,C);
				Threads[i][j].start();
			}
		}

		System.out.println("Elements of Matrix C:");
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print("C" + i + j +" = " + C[i][j] + " "); 
			}
			System.out.println("");
		}
	}
}
