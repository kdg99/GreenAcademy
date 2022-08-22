package sub02;
/*
 * 날짜 : 2022/08/22
 * 이름 : 김동근
 * 내용 : Java 다차원 배열 실습하기
 * 
 */
public class MultiArrayTest {
	public static void main(String[] args) {
		
		//1차원 배열
		System.out.println("1차원 배열\n");
		int[] scores = {80,60,78,62,92};
		int total = 0;
		
		for(int score : scores) {
			total += score;
		}
		System.out.println("score들의 합 : " + total);
		
		//2차원 배열
		System.out.println("\n2차원 배열\n");
		int[][] arr2d = {{1, 2, 3, 4},
						 {5, 6, 7, 8},
						 {9, 10, 11, 12}};
		//for each문
		
		for (int[] row : arr2d) {
			
			for (int col : row) {
				System.out.print(col + " ");
			}
			
			System.out.println();
		}
		
		
/* 중첩for문

		for(int i=0 ; i<arr2d.length ; i++) {
			for (int j=0 ; j<arr2d[i].length ; j++) {
				System.out.printf("arr2d[%d][%d] : %d\n", i, j, arr2d[i][j]);
			}
			System.out.println();
		}
		System.out.println("arr2d[0][0] : " + arr2d[0][0]);
		System.out.println("arr2d[0][1] : " + arr2d[0][1]);
		System.out.println("arr2d[0][2] : " + arr2d[0][2]);
		System.out.println("arr2d[0][3] : " + arr2d[0][3]);

		System.out.println("arr2d[1][0] : " + arr2d[1][0]);
		System.out.println("arr2d[1][1] : " + arr2d[1][1]);
		System.out.println("arr2d[1][2] : " + arr2d[1][2]);
		System.out.println("arr2d[1][3] : " + arr2d[1][3]);

		System.out.println("arr2d[2][0] : " + arr2d[2][0]);
		System.out.println("arr2d[2][1] : " + arr2d[2][1]);
		System.out.println("arr2d[2][2] : " + arr2d[2][2]);
		System.out.println("arr2d[2][3] : " + arr2d[2][3]);
*/		
		
		//3차원 배열
		System.out.println("\n3차원 배열\n");
		int[][][] arr3d = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
						   {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
						   {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}};
		
		
		//for each문
		
		for (int[][] index1 : arr3d) {
			for (int[] index2 : index1) {
				for (int index3 : index2) {
					System.out.printf("%d ", index3);
				}
				System.out.println();
			}
			System.out.println();
		}//for each-end
		
		
/* 중첩for문

		for(int i=0 ; i<arr3d.length ; i++) {
			for(int j=0 ; j<arr3d[i].length ; j++) {
				for(int k=0 ; k<arr3d[i][j].length ; k++) {
					System.out.printf("arr3d[%d][%d][%d] : %d\n", i,j,k,arr3d[i][j][k]);
				}
			}
			System.out.println();
		}
*/
		
	}//main-end
}
