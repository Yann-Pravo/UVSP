package metier;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeekDate {
	
	private Calendar monday;
	private Calendar tuesday;
	private Calendar wednesday;
	private Calendar thursday;
	private Calendar friday;
	private Calendar saturday;

	private String m;
	private String t;
	private String w;
	private String th;
	private String f;
	private String s;

	
	public WeekDate()
	{
		this.monday = Calendar.getInstance();
		this.tuesday = Calendar.getInstance();
		this.wednesday = Calendar.getInstance();
		this.thursday = Calendar.getInstance();
		this.friday = Calendar.getInstance();
		this.saturday = Calendar.getInstance();
		
		this.monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		this.tuesday.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		this.wednesday.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		this.thursday.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		this.friday.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		this.saturday.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		
		this.update();
		
		
	}
	
	public String getMonday()
	{
		return this.m;
	}
	
	public String getTuesday()
	{
		return this.t;
	}
	
	public String getWednesday()
	{
		return this.w;
	}
	
	public String getThursday()
	{
		return this.th;
	}
	
	public String getFriday()
	{
		return this.f;
	}
	
	public String getSaturday()
	{
		return this.s;
	}
	
	public void setNextWeek()
	{
		this.monday.add(Calendar.DAY_OF_WEEK, 7);
		this.tuesday.add(Calendar.DAY_OF_WEEK, 7);
		this.wednesday.add(Calendar.DAY_OF_WEEK, 7);
		this.thursday.add(Calendar.DAY_OF_WEEK, 7);
		this.friday.add(Calendar.DAY_OF_WEEK, 7);
		this.saturday.add(Calendar.DAY_OF_WEEK, 7);
		update();
	}
	
	public void setPreviousWeek()
	{
		this.monday.add(Calendar.DAY_OF_WEEK, -7);
		this.tuesday.add(Calendar.DAY_OF_WEEK, -7);
		this.wednesday.add(Calendar.DAY_OF_WEEK, -7);
		this.thursday.add(Calendar.DAY_OF_WEEK, -7);
		this.friday.add(Calendar.DAY_OF_WEEK, -7);
		this.saturday.add(Calendar.DAY_OF_WEEK, -7);
		update();
	}
	
	public void update()
	{
		SimpleDateFormat dateM = new SimpleDateFormat("dd/MM/yyyy");
		
		this.m = dateM.format(this.monday.getTime());
		this.t = dateM.format(this.tuesday.getTime());
		this.w = dateM.format(this.wednesday.getTime());
		this.th = dateM.format(this.thursday.getTime());
		this.f = dateM.format(this.friday.getTime());
		this.s = dateM.format(this.saturday.getTime());
	}
	
	
	
}
