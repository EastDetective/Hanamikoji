/*此程式計算符合牌庫有不盡相異物的遊戲摸牌的情況數，且包含牌庫的排列情形(每局抽一張牌) 如:花見小路
*下午 06:05 2018/8/22 最後更新*/

import java.util.Scanner;
import java.util.Arrays;

public class Combination2{
	static int ansN = 0;
	static int total = 0;
	public static void main(String[] args){
		int groups;
		int[] existAmount;
		int heaps;
		int[] heapRequire;
		int[][] heapRecord;
		int sum = 0;
		String combination = "";


		Scanner input = new Scanner(System.in);
		System.out.print("請問你有幾樣不盡相同物(以花見來說有7樣 : 櫻花髮簪、茶具、......) ? ");
		groups = input.nextInt();
		existAmount = new int[groups];
		System.out.print("依序輸入每樣個數，以空白隔開 : ");
		for(int i = 0; i < groups; i++) existAmount[i] = input.nextInt();
		System.out.print("分幾堆 ? ");
		heaps = input.nextInt();
		heapRequire = new int[heaps];
		heapRecord = new int[heaps][groups];
		System.out.print("依序輸入每堆個數，以空白隔開 : ");
		for(int i = 0; i < heaps; i++) heapRequire[i] = input.nextInt();

		System.out.print("\n========以下是您的資料詳情========\n");
		System.out.print("每樣東西個數 : " + Arrays.toString(existAmount) + " 有" + groups +"樣\n");
		System.out.print("分" + heaps + "堆 : " + Arrays.toString(heapRequire) + "\n\n");

		gogogo(		existAmount, 	0, 	heapRequire,		 0,		sum,	heapRecord);//再加一行
		System.out.print("\n總計 " + total);
	}

	public static void gogogo(	int[] castle, 	int towel, 	int[] heroesCombatPower, 	int heroOrder,	int collect, int[][] trophy){
		if(heroOrder == heroesCombatPower.length){
////System.out.print("\n來過走過是親愛的路人成全我!~~~~~~~~~~~~~~~~~~~~~");
			ansN++;
			System.out.print(ansN + ". ");
			//使用者介面友善判斷
			if(castle.length * heroesCombatPower.length <= 20) for(int j = 0; j < trophy.length; j++) System.out.print(" " + Arrays.toString(trophy[j]));
			else for(int j = 0; j < trophy.length; j++) System.out.print("\n" + Arrays.toString(trophy[j]));
			int ways = repeatedPermutation(castle);
			total += ways;
			System.out.print("   *" + ways + "\n");
		}
		else if(towel == castle.length){
			if(heroesCombatPower[heroOrder] - collect == 0){
				int[] newCastle = new int[castle.length];
				for(int i = 0; i < castle.length; i++) newCastle[i] = castle[i] - trophy[heroOrder][i];
				towel = 0;
				collect = 0;
				gogogo(newCastle, towel, heroesCombatPower, heroOrder + 1, collect, trophy);
			}
			//else System.out.println("bibu");
		}
		else for(int i = castle[towel]; i > -1; i--) if(i <= heroesCombatPower[heroOrder] - collect){
			trophy[heroOrder][towel] = i;
			gogogo(castle, towel+1, heroesCombatPower, heroOrder, collect + i, trophy);
		}
	}

	public static int repeatedPermutation(int[] array){
		int stackN = 0;
		for(int i = 0; i < array.length; i++) stackN += array[i];
		stackN = factorial(stackN);
		for(int i = 0; i < array.length; i++) stackN /= factorial(array[i]);
		return stackN;
	}
	public static int factorial(int n){
		if(n == 0) return 1;
		else return n * factorial(n-1);
	}
}