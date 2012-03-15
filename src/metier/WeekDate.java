package metier;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeekDate {
	
	private Calendar monday;
	private Calendar saturday;
	private String m;
	private String s;

	
	public WeekDate()
	{
		this.monday = Calendar.getInstance();
		this.saturday = Calendar.getInstance();
		
		this.monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		this.saturday.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		SimpleDateFormat dateM = new SimpleDateFormat("dd/MM/yyyy");
		
		this.m = dateM.format(this.monday.getTime());
		this.s = dateM.format(this.saturday.getTime());
		
	}
	
	public String getMonday()
	{
		return this.m;
	}
	
	public String getSaturday()
	{
		return this.s;
	}
	
	public void setNextWeek()
	{
		this.monday.add(Calendar.DAY_OF_WEEK, 7);
		this.saturday.add(Calendar.DAY_OF_WEEK, 7);
		update();
	}
	
	public void setPreviousWeek()
	{
		this.monday.add(Calendar.DAY_OF_WEEK, -7);
		this.saturday.add(Calendar.DAY_OF_WEEK, -7);
		update();
	}
	
	public void update()
	{
		SimpleDateFormat dateM = new SimpleDateFormat("dd/MM/yyyy");
		
		this.m = dateM.format(this.monday.getTime());
		this.s = dateM.format(this.saturday.getTime());
	}
	
	
	
}
