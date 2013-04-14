//程序作用为：让用户输入n个整型数，通过选择序号来选择“冒泡排序”
//“选择排序”、“插入排序”算法进行排序，并且计算每个排序需要的时间
//最后打印出结果 

//作者：吴建杰
//学号：20102100035


public class IntSort{
	
	public static void main(String agrs[]){
	//用choice来保存用户选择算法代表的序号
	int choice = Integer.parseInt(agrs[0]);
	
	//生成相对应大小的Int 型数组number
	IntSort intSort = new IntSort();            //生成类对象IntSort
	int [] number = new int[agrs.length-1];
	
	//这一步是把输进来的String型的数字转化为Int型的数字，存放在数组number中
	intSort.input(number,agrs);
	
	System.out.println("你输入的"+number.length+"个整数是:");
	intSort.print(number);

	//这个进行算法的选择处理，并且排序输出
	intSort.Switch(choice,number);
	
	}  
	
	//冒泡排序
	public void Bubble_Sort(int number[]){
		int temp;
		for(int i = 0;i < number.length;i++){
			for(int j = i + 1;j < number.length;j++){
				if(number[i] > number[j]){
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
	}
	
	//选择排序
	public void Select_Sort(int number[]){
		int temp;
		for(int i = 0;i < number.length-1;i++){
			int k = i;
			for(int j =i + 1;j < number.length;j++){
				if( number[k]> number[j]){
					k = j;
				}
			}			
			if( k != i ){
				temp = number[i];
				number[i] = number[k];
				number[k] = temp;
			}
	    }
	}
	
	//插入排序
	public void Insert_Sort(int number[]){
		int temp;
		int j;
		for(int i = 1; i < number.length;i++){
			temp = number[i];
			j = i - 1;
			while(( j >= 0)&&(number[j] > temp)){
				number[j+1] = number[j];
				j = j - 1;
			}
			number[j+1] = temp;
		}
	}
	
	//打印数组
	public void print(int number[]){
		for(int i = 0;i < number.length;i++){
			System.out.print(number[i]+" ");
		}
	}
	
	//处理输入的5个整数
	public void input(int number[],String agrs[]){
		for(int i = 0;i < number.length;i++){
			number[i] = Integer.parseInt(agrs[i+1]);
		}
	
	}
	
	//选择算法进行排序
	public void Switch(int choice ,int number[]){
		long startTime;
		long estimatedTime;
		switch(choice){
		case 1:
			System.out.println("\n你选择的排序算法是“冒泡排序”\n这些整数在冒泡中。。。。。。。。");
			startTime = System.nanoTime();                   //返回一个毫微秒数，开始的时间，下同
			Bubble_Sort(number);
			estimatedTime = System.nanoTime() - startTime;               //得出结束所需的时间，下同
			System.out.println("这"+number.length+"个整数冒泡后是:");
			print(number);
			System.out.println("\n冒泡用时为:"+estimatedTime/1000+"微秒");
			break;
		case 2:
			System.out.println("\n你选择的排序算法是“选择排序”\n这些整数在选择中。。。。。。。。");
			startTime = System.nanoTime();
			Select_Sort(number);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("这"+number.length+"个整数选择后是:");
			print(number);
			System.out.println("\n选择用时为:"+estimatedTime/1000+"微秒");
			break;
		case 3:
			System.out.println("\n你选择的排序算法是“插入排序”\n这些整数在插入中。。。。。。。。");
			startTime = System.nanoTime();
			Insert_Sort(number);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("这"+number.length+"个整数插入后是:");
			print(number);
			System.out.println("\n插入用时为:"+estimatedTime/1000+"微秒");
			break;
		}
	}
	
}