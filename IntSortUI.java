//��������ã�ͨ��UI���û��Ľ��������û�����n��������
//ͨ������ť��Ȼ��ð��,ѡ�񡢲�����һ�������С���������
//���ߣ��⽨�� 20102100035

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

//�¼������
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntSortUI extends JFrame{
	//���캯��
	public IntSortUI(){
		super("�����㷨С���򡣡�����");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		final JTextField [] t = {
				new JTextField("����5��������",7),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField("���5��������",7),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField(null,4),
				new JTextField("����ѡ����㷨�ǣ�",10),
		};
		JButton b = new JButton("ȷ��");
		final JRadioButton [] r = { 
			new JRadioButton("ð��"),
			new JRadioButton("ѡ��"),
			new JRadioButton("����")
		};
		ButtonGroup rg = new ButtonGroup();
		r[0].setSelected(false);
		r[1].setSelected(false);
		r[2].setSelected(false);
		////////////////////////////////
		t[0].setEditable(false);
		t[6].setEditable(false);
		t[12].setEditable(false);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton)e.getSource();
				int [] number = new int[5];
				int temp;
				String str =null;
				
				for(int i = 0;i < 5;i++){
					str = t[i + 1].getText();
					number[i] = Integer.parseInt(str);
				}
				
				if(r[0].isSelected()){ 
					for(int i = 0;i < 5;i++){
						for(int j = i + 1;j < 5;j++){
							if(number[i] > number[j]){
								temp = number[i];
								number[i] = number[j];
								number[j] = temp;
							}
						}
					}
					
				}
				
				if(r[1].isSelected()){ 

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
				
				if(r[2].isSelected()){ 
	
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

				
				for(int i = 0;i < 5;i++){
					t[i+7].setText(""+number[i]);
				}
			}
		}
		);
		
		for(int i = 0;i < 13;i++){
				c.add(t[i]);
			}
		for(int i = 0;i < 3;i++){
				c.add(r[i]);
				rg.add(r[i]);
			}
		c.add(b);
	}
	//���������	
	public static void main(String agrs[]){
	    IntSortUI app = new IntSortUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(380,130);
		app.setVisible( true );
	}
}