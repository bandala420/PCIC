// Daniel Bandala @ oct-2021
package ejercicio12;

public class SquareMatrix {
	public int[][] matrix;
	public SquareMatrix(int n) {
		matrix = new int[n][n];
		int element = 0;
		for (int i=0; i<n ;i++) {
			for (int j=0; j<n ; j++) {
				matrix[i][j] = element;
				element++;
			}
		}
	}
	public void showMatrix() {
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}
