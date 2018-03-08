/**
 * 
 */
package cn.chaohi.recommend.common;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.DataModelBuilder;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

/**
 * @author Administrator
 *
 */
public class DataModelHelp {
	 /**
     * 从文件中构造数据模型，构建三列的数据模型，userId，itemId，rating
     */
    public static DataModel buildDataModel(String file) throws TasteException, IOException {
        return new FileDataModel(new File(file));
    }

    /**
     * 从文件中构造数据模型[去掉前缀版本] userId,itemId 只有两列的，沒有评分
     */
    public static DataModel buildDataModelNoPref(String file) throws TasteException, IOException {
        return new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel.toDataMap(new FileDataModel(new File(file))));
    }

    /**
     * 返回一个两列数据模型建造器
     */
    public static DataModelBuilder buildDataModelNoPrefBuilder() {
        return trainingData -> new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel.toDataMap(trainingData));
    }
}
