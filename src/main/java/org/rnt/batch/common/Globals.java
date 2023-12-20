package org.rnt.batch.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Globals {
	public static final String FROM_DB ="From DB";
	public static final String TO_DB ="To DB";
	public static final String FROM_GTW ="From GTW";
	public static final String TO_GTW ="To GTW";
	public static int lfStart = 0;
	public static int lineTotalCount = 0;
	
	public static String currentTime() {   
		Calendar calendar = Calendar.getInstance();
		Date currentTime = calendar.getTime();
        String time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime));
        return time;
	}
	
	public static long getCurrentTime() { // 현재의시간을 초로 계산하여 분초정보만 전달한다.
		long time1 = System.currentTimeMillis();
		long time2 = 0;
		time2 = time1 / 1000;
		return time2;
	}
}