public class Instance{
	int a0;
	int a1;
	int a2;
	int instanceClass;

	public Instance(int a1, int a2 ,int instanceClass){
		this.a0=1;
		this.a1=a1;
		this.a2=a2;
		this.instanceClass=instanceClass;
	}

	public int getActualClass(){
		return this.instanceClass;
	}
	public String toString()
	{
		return "[" + a0 +","+a1+","+a2+","+instanceClass+"]";
	}
	public int getA0(){
		return a0;
	}
	public int getA1(){
		return a1;
	}
	public int getA2(){
		return a2;
	}
	
}