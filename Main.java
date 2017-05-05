import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws FileNotFoundException{
		
		File file = new File("input.txt");
		String WHITESPACE = "\\s+";
		Scanner scanner = new Scanner(file);
		int predictedClass=0;
		ArrayList<Instance> instances= new ArrayList<Instance>();
		Weight weight = new Weight(0,0,0);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			String [] numbers=line.split(WHITESPACE);
			Instance myInstance = new Instance(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]),Integer.parseInt(numbers[2]));
			instances.add(myInstance);

		}
		for(int j=0; j<10000;j++){
		for (Instance i : instances) {
			System.out.println(i);
			
			int dotProduct = (i.getA0()*weight.w0)+(i.getA1()*weight.w1)+(i.getA2()*weight.w2);
			if(dotProduct==0){
				predictedClass=-1;
			}
			if(dotProduct>0){
				predictedClass=1;
			}
			if (dotProduct<0) {
				predictedClass=-1;				
			}
			int actual=i.getActualClass();
			if(actual>predictedClass){
				weight=new Weight(i.getA0()+weight.w0,i.getA1()+weight.w1,i.getA2()+weight.w2);
			}
			if(actual<predictedClass){
				weight=new Weight(weight.w0-i.getA0(),weight.w1-i.getA1(),weight.w2-i.getA2());
			}
			if(actual==predictedClass){
				System.out.println("Do nothing");
			}
			System.out.println("Actual class "+actual);
			System.out.println("Predicted Class "+predictedClass);

			System.out.println("Dot Poduct "+dotProduct);
			System.out.println(weight);
			}
		}
			System.out.println(weight);
		
	}

}