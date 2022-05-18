package toy.toy_05_now;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Now {
	private LocalDateTime now; 
	private String format;
	
	public Now(String format)
	{
		now = null;
		this.format = format;
	}
	
	public Now() 
	{
		this(null);
	}
		
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public String getNow()
	{
		return LocalDateTime.now()
								.format(DateTimeFormatter.ofPattern(format));
	}
}
