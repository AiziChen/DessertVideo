package quanye.dessertvideo.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanye.dessertvideo.dao.VideoDao;

public class Tools {
	private Tools() {
	}

	private static ApplicationContext ctx;
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 取得spring的context
	 * 
	 * @return
	 */
	public static ApplicationContext getBeanContext() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("bean.xml");
		}
		return ctx;
	}

	/**
	 * 解析指定的字符串日期
	 * 
	 * @param source
	 * @return
	 */
	public static Date parseDate(String source) {
		try {
			return format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String format(Date date) {
		return format.format(date);
	}

	public static VideoDao getVideoDao() {
		return Tools.getBeanContext().getBean("videoDao", VideoDao.class);
	}
}
