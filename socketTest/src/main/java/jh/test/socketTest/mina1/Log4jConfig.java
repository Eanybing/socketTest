package jh.test.socketTest.mina1;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.google.common.io.Resources;

/**
 * Log4j 日志启动类
 * @author qiuhd
 * @since  2014-1-17
 * @version V1.0.0
 */
public class Log4jConfig {

	public static void load(String filePath) throws Exception {
		InputStream is = Resources.getResource(filePath).openStream();
		Properties properties = new Properties();
		properties.load(is);
		PropertyConfigurator.configure(properties);
	}
}

