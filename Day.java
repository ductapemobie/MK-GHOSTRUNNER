import java.util.*;
public class Day{
	
	
public static void main(String[] args){
	
	final int DailyCal=2000;
	int usedCal=0;
	final int DailyFat=78;
	int usedFat=0;
	final int DailyProtein=50;
	int usedProt=0;
	
	
	Scanner scan=new Scanner(System.in);
	LinkedList<Food> dailyfood= new LinkedList<Food>();
	LinkedList<Run> dailyruns= new LinkedList<Run>();
	System.out.println("Choose an activity: 1:Enter data       2:View food       3:View Runs      4:Quit");
	int activity=scan.nextInt();
	while(activity!=4){
		System.out.println("Daily Calories:"+usedCal+"/"+DailyCal);
		System.out.println("Daily Fat:"+usedFat+"/"+DailyFat);
		System.out.println("Daily Protein:"+usedProt+"/"+DailyProtein);
		System.out.println("Food:1        Run:2");
		
		if(activity==1){
		int choice=scan.nextInt();
		//entering new food.
			if(choice==1){
				System.out.print("enter food name: ");
				scan.nextLine();
				String n = scan.nextLine();
				System.out.print("enter # of servings eaten: ");
				int serv =scan.nextInt();
				System.out.print("enter calories per serving: ");
				int cal =scan.nextInt();
				System.out.print("enter fat per serving: ");
				int fat =scan.nextInt();
				System.out.print("enter protein per serving: ");
				int prot =scan.nextInt();
				Food meal= new Food(n,serv,cal,fat,prot);
				dailyfood.add(meal);
				usedCal+=meal.getCalories();
				usedFat+=meal.getFat();
				usedProt+=meal.getProtein();
			}
			else if(choice==2){
				System.out.print("enter route: ");
				scan.nextLine();
				String r =scan.nextLine();
				System.out.print("enter Total Distance: ");
				double dist =scan.nextDouble();
				System.out.print("enter Time in format H M S: ");
				int h =scan.nextInt();
				int m = scan.nextInt();
				int s= scan.nextInt();
				Run run = new Run(r,dist,h,m,s);
				dailyruns.add(run);
				usedCal-=run.getCalBurnt();
				usedFat-=run.getFatBurnt();
			}
		
			System.out.println("Choose an activity: Enter data:1       View food:2       View Runs:3      4:Quit");
			activity=scan.nextInt();
			continue;
		}
		if(activity==2){
			for(int i=0;i<dailyfood.size();i++){
				System.out.print(dailyfood.get(i));
			}
			System.out.println("Choose an activity: Enter data:1       View food:2       View Runs:3      4:Quit");
			activity=scan.nextInt();
			continue;
		}
		if(activity==3){
			for(int i=0;i<dailyruns.size();i++){
				System.out.print(dailyruns.get(i));
			}
			System.out.println("Choose an activity: Enter data:1       View food:2       View Runs:3      4:Quit");
			activity=scan.nextInt();
			continue;
		}
	
	}
	
	
	
}







}