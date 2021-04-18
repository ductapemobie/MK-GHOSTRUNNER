public class Run{
	
	private String route;
	private double distance;
	private double timeInHours;
	private int hours;
	private int minutes;
	private int seconds;
	private double mph;
	private double calBurnt;
	private double fatBurnt;
	
	
	public Run(String r,double d,int h, int m, int s){
		setRoute(r);
		setDistance(d);
		setHours(h);
		setMinutes(m);
		setSeconds(s);
		setTimeInHours(hours,minutes,seconds);
		setMph(timeInHours,distance);
		setCalBurnt(distance);
		setFatBurnt(calBurnt);
		
		
	}
	
	
	public void setRoute(String r){
		route=r;
	}
	public String getRoute(){
		return route;
	}
	public void setDistance(double d){
		distance=d;
	}
	public double getDistance(){
		return distance;
	}
	public void setTimeInHours(int h,int m,int s){
		timeInHours=(double)h+(double)(m/60)+(double)(s/3600);
	}
	public double getTimeInHours(){
		return timeInHours;
	}
	public void setHours(int h){
		hours=h;
	}
	public int getHours(){
		return hours;
	}
	public void setMinutes(int m){
		minutes=m;
	}
	public int getMinutes(){
		return minutes;
	}
	public void setSeconds(int s){
		seconds=s;
	}
	public int getSeconds(){
		return seconds;
	}
	public void setMph(double tiH,double dist){
		mph=dist/tiH;
	}
	public double getmph(){
		return mph;
	}
	
	public void setCalBurnt(double dist){
		 calBurnt =111*dist;
		
	}
	public double getCalBurnt(){
		return calBurnt;
	}
	public void setFatBurnt(double cb){
		fatBurnt=cb *.7;
		
	}
	public double getFatBurnt(){
		return fatBurnt;
	}
	
	public String toString(){
		String ret=" Route:"+ route +"\nDistance:"+distance+"\nTime:"+hours+" "+minutes+" "+seconds+"\nMPH"+mph+"\ncalories Burnt:"+calBurnt+"\nFat Burnt:"+fatBurnt+"\n";
		return ret;
	}
	
	
	
}