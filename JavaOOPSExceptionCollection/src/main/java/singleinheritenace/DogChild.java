package singleinheritenace;

public class DogChild extends AnimalParent
{
	public void speed()
	{
		System.out.println("Dog runs at 40kmph");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DogChild out=new DogChild();
		out.running();
		out.speed();
	}
}