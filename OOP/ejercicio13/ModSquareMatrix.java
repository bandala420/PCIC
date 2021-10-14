// Daniel Bandala @ oct-2021
package ejercicio13;
import ejercicio12.SquareMatrix;
public class ModSquareMatrix extends SquareMatrix{
	public ModSquareMatrix(int n) {
		super(n);
	}
	public void substituteElement(int[] position,int newElement) {
		final int iPos = position[0]-1;
		final int jPos = position[1]-1;
		if (matrix.length<iPos) {
			System.out.println("Matrix error: La fila seleccionada es mayor al tamaño de la matriz");
			return;
		}else if (matrix[iPos].length<jPos)
			System.out.println("Matrix error: La columna seleccionada es mayor al tamaño de la matriz");
		else
			matrix[position[0]][position[1]] = newElement;
	}
}
