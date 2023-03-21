package quickSort;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("quickSortAlgorithm 구");

		// 사용자가 원하는 갯수의 정수값을 입력받음
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] array = new String[n];

		for (int i = 0; i < n; i++) {
			array[i] = input.next();
		}

		// 퀵정렬을 수행함
		QuickSort(array, 0, array.length - 1);

		// 퀵 정렬 결과를 반복문으로 출력
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		input.close();
	}

	// array의 원소들을 오름차순으로 정렬하는 메소드
	private static void QuickSort(String[] array, int left, int right) {
		int pivot = partition(array, left, right); // 원소를 분할한다
		if (left < pivot - 1) {
			QuickSort(array, left, pivot - 1); // 왼쪽 부분배열을 정렬한다
		}
		if (right < pivot - 1) {
			QuickSort(array, pivot + 1, right); // 오른쪽 부분배열을 정렬한다
		}

	}

// partition을 구현하기
// pivot을 중심으로 왼쪽에 작은 값 오른쪽에 큰 값을 정리할 수 있는 알고리즘을 구현한다
	private static int partition(String[] array, int left, int right) { // 작은 값을 왼쪽에 큰 값을 오른쪽에 배치한다
		String pivot = array[right]; // 기준 원소 pivot을 선언한다
		int i = left - 1; // i구역의 1구역의 끝지점
		for (int j = left; j < right; j++) {
			if (array[j].length() < pivot.length()) { // 문자열을 정리하기 때문에 .length로 문자열의 길이를 센다.
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, right);
		return i + 1; // 기준원소의 위치를 리턴한다
	}

// array[i]와 array[j]를 교환하는 메소드죽 pivot값과 비교된 마지막 값을 바꿔준다.
	private static void swap(String[] array, int left, int right) {
		String temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}