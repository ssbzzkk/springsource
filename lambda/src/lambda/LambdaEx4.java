package lambda;

public class LambdaEx4 {

	public static void main(String[] args) {
		
		Lambda4 lambda = (x,y)-> x>y?x:y;
		System.out.println(lambda.max(150, 100));

		Lambda5 lambda1 = (x,y)-> x<y?x:y;
		System.out.println(lambda1.min(150, 100));
		

	}

}
