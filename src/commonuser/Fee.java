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
		
		//����ȡ��
		fee = ( money* 0.01);							   
		
		//���д��
		if(feeType==2)
			  
			 fee = (money *0.005);;					
		
		//����ת��
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
			System.out.println("����");
		if(fee<=2)
			fee=2;
		return fee;
	}

}
