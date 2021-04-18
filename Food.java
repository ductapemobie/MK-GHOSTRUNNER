public class Food{
	
	private String name;
	private int servings;
	private int calories;
	private int fat;
	private int protein;
	
	//complete constructor
	public Food(String n,int s,int c,int f,int p){
		setName(n);
		setServings(s);
		setCalories(c);
		setFat(f);
		setProtein(p);
	}
	//constructor with just names. 
	public Food(String n){
		setName(n);
		setServings(0);
		setCalories(0);
		setFat(0);
		setProtein(0);
	}
	
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	public void setServings(int s){
		servings=s;
	}
	public int getServings(){
		return servings;
	}
	public void setCalories(int c){
		calories=c*servings;
	}
	public int getCalories(){
		return calories;
	}
	public void setFat(int f){
		fat=f*servings;
	}
	public int getFat(){
		return fat;
	}
	public void setProtein(int p){
		protein=p*servings;
	}
	public int getProtein(){
		return protein;
	}
	
	public String toString(){
		
		String output="name:"+ name +"\nServings:"+servings+"\nTotal Calories:"+calories+"\nTotal Fat:"+fat+"\nTotal Protein:"+protein+"\n"; 
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
}