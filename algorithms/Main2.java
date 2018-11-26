

public class Main2{
    

public static void main(String [] args) throws Exception{
      
	Integer [] num={5,3,1,4,2};
	int temp;
	for(int i=0;i<num.length;i++) {
		

		
		for(int j=0;j<num.length-i-1;j++) {
			if(num[j]>num[j+1]) {
				temp=num[j+1];
				num[j+1]=num[j];
				num[j]=temp;
			}
			System.out.print(i+1+": ");
			for(Integer n:num) {
				System.out.print(n+"\t");
			}
			System.out.println("\n");
		}
		
	}

	
	
	
    }

}