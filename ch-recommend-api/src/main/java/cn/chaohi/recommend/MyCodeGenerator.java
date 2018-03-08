package cn.chaohi.recommend;

import com.chaohi.tools.generator.plugins.mybatis.ChaohiGenerator;

/**
 * @author Administrator
 *
 */
public class MyCodeGenerator  extends ChaohiGenerator{

	public static void main(String[] args) throws NumberFormatException, Exception {
		genCode("config.properties");
	}
}
