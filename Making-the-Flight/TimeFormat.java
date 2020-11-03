
public class TimeFormat {

	public int hour;
	public int minutes;
	
	public TimeFormat(int hour, int minute) {
		this.hour = hour;
		this.minutes = minute;
	}
	
	public static void setTime(TimeFormat tf, int minutes) {
		int hours = minutes / 60;
		int newMin = minutes - (hours * 60);
		tf.hour += hours;
		tf.minutes += newMin;
		if (tf.minutes >= 60) {
			tf.hour++;
			tf.minutes = tf.minutes - 60;
		}
	}
	
	public static boolean compareTimes(TimeFormat tf1, TimeFormat tf2) {
		if (tf1.hour == tf2.hour) {
			if (tf1.minutes >= tf2.minutes) {
				return false;
			}
			else {
				return true;
			}
		}
		else if (tf1.hour > tf2.hour) {
			return false;
		}
		else {
			return true;
		}
	}
}
