/*���{���p��ŦX�P�w�����ɬ۲������C���N�P�����p�ơA�B�]�t�P�w���ƦC����(�C����@�i�P) �p:�ᨣ�p��
*�U�� 06:05 2018/8/22 �̫��s*/

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
		System.out.print("�аݧA���X�ˤ��ɬۦP��(�H�ᨣ�ӻ���7�� : ���v¯�B����B......) ? ");
		groups = input.nextInt();
		existAmount = new int[groups];
		System.out.print("�̧ǿ�J�C�˭ӼơA�H�ťչj�} : ");
		for(int i = 0; i < groups; i++) existAmount[i] = input.nextInt();
		System.out.print("���X�� ? ");
		heaps = input.nextInt();
		heapRequire = new int[heaps];
		heapRecord = new int[heaps][groups];
		System.out.print("�̧ǿ�J�C��ӼơA�H�ťչj�} : ");
		for(int i = 0; i < heaps; i++) heapRequire[i] = input.nextInt();

		System.out.print("\n========�H�U�O�z����ƸԱ�========\n");
		System.out.print("�C�˪F��Ӽ� : " + Arrays.toString(existAmount) + " ��" + groups +"��\n");
		System.out.print("��" + heaps + "�� : " + Arrays.toString(heapRequire) + "\n\n");

		gogogo(		existAmount, 	0, 	heapRequire,		 0,		sum,	heapRecord);//�A�[�@��
		System.out.print("\n�`�p " + total);
	}

	public static void gogogo(	int[] castle, 	int towel, 	int[] heroesCombatPower, 	int heroOrder,	int collect, int[][] trophy){
		if(heroOrder == heroesCombatPower.length){
////System.out.print("\n�ӹL���L�O�˷R�����H������!~~~~~~~~~~~~~~~~~~~~~");
			ansN++;
			System.out.print(ansN + ". ");
			//�ϥΪ̤����͵��P�_
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