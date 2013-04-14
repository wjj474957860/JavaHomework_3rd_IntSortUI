//��������Ϊ�����û�����n����������ͨ��ѡ�������ѡ��ð������
//��ѡ�����򡱡������������㷨�������򣬲��Ҽ���ÿ��������Ҫ��ʱ��
//����ӡ����� 

//���ߣ��⽨��
//ѧ�ţ�20102100035


public class IntSort{
	
	public static void main(String agrs[]){
	//��choice�������û�ѡ���㷨��������
	int choice = Integer.parseInt(agrs[0]);
	
	//�������Ӧ��С��Int ������number
	IntSort intSort = new IntSort();            //���������IntSort
	int [] number = new int[agrs.length-1];
	
	//��һ���ǰ��������String�͵�����ת��ΪInt�͵����֣����������number��
	intSort.input(number,agrs);
	
	System.out.println("�������"+number.length+"��������:");
	intSort.print(number);

	//��������㷨��ѡ���������������
	intSort.Switch(choice,number);
	
	}  
	
	//ð������
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
	
	//ѡ������
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
	
	//��������
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
	
	//��ӡ����
	public void print(int number[]){
		for(int i = 0;i < number.length;i++){
			System.out.print(number[i]+" ");
		}
	}
	
	//���������5������
	public void input(int number[],String agrs[]){
		for(int i = 0;i < number.length;i++){
			number[i] = Integer.parseInt(agrs[i+1]);
		}
	
	}
	
	//ѡ���㷨��������
	public void Switch(int choice ,int number[]){
		long startTime;
		long estimatedTime;
		switch(choice){
		case 1:
			System.out.println("\n��ѡ��������㷨�ǡ�ð������\n��Щ������ð���С���������������");
			startTime = System.nanoTime();                   //����һ����΢��������ʼ��ʱ�䣬��ͬ
			Bubble_Sort(number);
			estimatedTime = System.nanoTime() - startTime;               //�ó����������ʱ�䣬��ͬ
			System.out.println("��"+number.length+"������ð�ݺ���:");
			print(number);
			System.out.println("\nð����ʱΪ:"+estimatedTime/1000+"΢��");
			break;
		case 2:
			System.out.println("\n��ѡ��������㷨�ǡ�ѡ������\n��Щ������ѡ���С���������������");
			startTime = System.nanoTime();
			Select_Sort(number);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("��"+number.length+"������ѡ�����:");
			print(number);
			System.out.println("\nѡ����ʱΪ:"+estimatedTime/1000+"΢��");
			break;
		case 3:
			System.out.println("\n��ѡ��������㷨�ǡ���������\n��Щ�����ڲ����С���������������");
			startTime = System.nanoTime();
			Insert_Sort(number);
			estimatedTime = System.nanoTime() - startTime;
			System.out.println("��"+number.length+"�������������:");
			print(number);
			System.out.println("\n������ʱΪ:"+estimatedTime/1000+"΢��");
			break;
		}
	}
	
}