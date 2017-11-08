package commonuser;

public class Fee {
	private double money;
	private int feeType;
	
	
	public Fee(int a ,double b)
	{
		this.money =  b;
		this.feeType = a;
		
	}
	public double calculateFee()
	{
		
		double fee=0;
		if(feeType ==1)
		
		//跨行取款
		fee = ( money* 0.01);							   
		
		//跨行存款
		if(feeType==2)
			  
			 fee = (money *0.005);;					
		
		//跨行转账
		if(feeType == 3)
		{
			if(money < 2000)
			fee = 2;
			if(money >= 2000&& money < 5000)
				fee = 5;
			if(money >= 5000 && money < 10000)
				fee = 10;
			if(money >= 10000 && money <= 50000)
				fee = 15;
		}
		else
			System.out.println("错误");
		if(fee<=2)
			fee=2;
		return fee;
	}

}
