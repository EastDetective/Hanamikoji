import java.util.Scanner;
import java.util.Arrays;

public class Combination{
	static int ansN = 0;
	public static void main(String[] args){
		int groups;
		int numbers;
		int sum = 0;
		String combination = "";
		int[] existAmount;

		Scanner input = new Scanner(System.in);
		System.out.print("How many groups you have ? ");
		groups = input.nextInt();
		existAmount = new int[groups];
		System.out.print("依序輸入每堆個數，以空白隔開 : ");
		for(int i = 0; i < groups; i++) existAmount[i] = input.nextInt();
		//System.arraycopy(existAmount, 0, var, 0, existAmount.length);
		System.out.print("堆的個數 ? ");
		numbers = input.nextInt();
		gogogo(existAmount, 0, existAmount.length, combination, sum, numbers);
	}
	public static void gogogo(int[] castle, int towel, int returnLimit, String ans, int collect, int target){
		int need = target - collect;
		if(towel == returnLimit){
			if(need == 0){
			   	ansN++;
				System.out.println(ansN + ". " + ans);
			}
			//else System.out.println("bibu");
		}
		else for(int i = castle[towel]; i > -1; i--) if(i <= need)
			gogogo(castle, towel+1, returnLimit, ans + i + " ", collect + i, target);
	}
}