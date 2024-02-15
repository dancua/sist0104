package day0104;

public class DataType_09 {

	public static void main(String[] args) {
		// args 이용한 연산

		// 변수선언
		int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);

		// 계산
		int tot = java + jsp + spring;
		int count = 3;

		double avg1 = tot / 3;
		double avg2 = (double) tot / count;

		System.out.println(avg1);
		System.out.println(avg2);

		// printf 를 이용해서 총점은 99.7
		// 총점은 99

		System.out.printf("java=%d, jsp = %d, spring=%d\n", java, jsp, spring);

		System.out.println("총점 =" + tot);
		System.out.println("평균 = %.2f\n");
	}

}
