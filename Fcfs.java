import java.util.*;
class Fcfs
{
	
	public static void main(String args[])
	{
		int num;
		int i;
		int  j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many processes are there");
		
		num=sc.nextInt();
		process[] obj= new process[num];
		process temp = new process();
		for(i=0;i<num;i++)
		{
			System.out.println("Enter details of " +(i+1)+" process");
			obj[i]=new process();
			obj[i].input();
		}
		//System.out.println(num);
		//System.out.println("---------------");
		//System.out.println(obj[0].entry);
		for(i=0;i<num;i++)
		{
			for(j=0;j<num-1;j++)
			{
				if(obj[j].entry>obj[j+1].entry)
				{
					temp=obj[j];
					obj[j]=obj[j+1];
					obj[j+1]=temp;
					
				}
			}
			
		}
		/// processes sorted in order of their entry time;
		//for(i=0;i<num;i++)
		//{
			//System.out.println(obj[i].n);
		//}
		System.out.println("--------------");
		obj[0].exit=obj[0].entry+obj[0].burst;
		
		for(i=1;i<num;i++)
		{
			if(obj[i-1].exit > obj[i].entry)
			{
				obj[i].exit=obj[i-1].exit+obj[i].burst;
			}
			else
			{
				obj[i].exit=obj[i].entry+obj[i].burst;
			}
			
		}
		System.out.println("ID   " + "ENTRY  " + "BURST    " + "EXIT  ");
		for(i=0;i<num;i++)
		{
			
			System.out.println(obj[i].n+"\t"+obj[i].entry+"\t"+obj[i].burst+"\t"+obj[i].exit);
		}
		
	}

}

 class process
{
	Scanner sc = new Scanner(System.in);
	int n; // process id 
	int entry; // entry time of process
	int burst; // burst time of process
	int exit; // exit time of process that will be calculated and stored

	public void input()
	{
				System.out.println("Enter the process id");
		n=sc.nextInt();
		System.out.println("Enter the entry time of the process");
		entry=sc.nextInt();
		System.out.println("Enter burst time of the process");
		burst=sc.nextInt();
		
	}
	
}
