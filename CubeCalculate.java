/*** 这是一个计算判断连续正整数立方和是否是另一个正整数立方的小程序
* @author hgb0607
* @version 1.0
***/

import java.util.Scanner;

public class CubeCalculate {
	/**该程序设置两个工作模式
	 * 模式一：通过手动输入第1项和最后1项来计算判断连续正整数立方和是否是另一个正整数立方
	 * 模式二：自动穷举计算判断最大相加项不超过1000的连续正整数立方和是否是另一个正整数立方
	 * @param 输入数字选择两种不同的计算模式
	 **/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*选择模式**/
		System.out.println("选择需要运行的模式：\n1.手动输入\n2.自动计算不大于1000内的连续正整数");
		int mode = in.nextInt();
		
		if (mode==1) {
			
		System.out.println("输入连续正整数的第一个数字：");		/*获得第一项的数值**/
		int a = in.nextInt();
		while (a<1) {
			System.out.println("输入连续正整数的第一个数字(请输入正整数)：");
			a = in.nextInt();
		}

		System.out.println("输入连续正整数的最后一个数字：");		/*获得最后一项的数值**/
		int b = in.nextInt();
		while (b<=a) {
			System.out.println("输入连续正整数的最后一个数字(必须大于之前的数值"+a+")：");
			b = in.nextInt();		
		}

		double sum = sum(a,b);							/*调用函数计算并判断**/
		int flag = CubeOrNot(sum);
		Output(a,b,flag,mode);								/*输出结果**/
		}
		
		/*模式二：自动计算**/
		else if (mode==2) {
			for (int x = 1; x <= 1000; x++) {				/*穷举相加项数，2项起至100项**/
				
				for (int y = 1; y <= 1000-x; y++) {		/*连续正整数第一项从1开始穷举**/
					
					double sum = sum(y,y+x);				/*调用函数计算并判断**/
					int flag = CubeOrNot(sum);
					Output(y,y+x,flag,mode);					/*输出结果**/
					
				}

			}

		}
		
		/*错误情况**/
		else {
			System.out.println("输入有误！！！");
		}
		
	}
		

	
	
	/**计算连续正整数的三次方和
	 * @param num1 连续正整数中的最小项
	 * @param num2 连续正整数中的最大项
	 * @return 输出立方和
	 **/
	private static double sum(double num1,double num2){
		double SumTemp = 0;
		int k = (int) (num2-num1);
		for (int i = 0; i <= k; i++) {
			SumTemp = SumTemp+num1*num1*num1;
			num1++;
		}
		return SumTemp;
	}
	
	/**判断结果是否为另外一个数的立方,是则获得立方根
	 * @param num 立方和
	 * @return 输出立方根或非正整数根状态值
	 **/
	private static int CubeOrNot(double num) {
		double cbrt = Math.cbrt(num);
		if ( cbrt%1 == 0 ) {
			return (int) cbrt;
		}
		return 0;
	}
	
	/**显示结果
	 * @param min 连续正整数中的最小项
	 * @param max 连续正整数中的最大项
	 * @param cbrt 立方根状态
	 * @param mode 选择模式
	 * @return 输出显示结果到屏幕
	 **/
	public static void Output(double min,double max ,int cbrt,int mode) {		
		if (cbrt==0) {
			if(mode==1)
			System.out.println("从"+ min + "到" + max + "的连续正整数的立方和不是任何正整数的立方");
			else {}
		} else {
			System.out.println("从"+ min + "到" + max + "的连续正整数的立方和为" + cbrt + "的立方");
		}
	}

	
}
