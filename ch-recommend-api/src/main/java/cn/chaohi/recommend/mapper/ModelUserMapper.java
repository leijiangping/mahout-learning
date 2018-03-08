package cn.chaohi.recommend.mapper;
import java.util.List;
import java.util.Map;
import cn.chaohi.recommend.entity.ModelUser;
/**
 * 数据层接口
 * @auhthor leijiangping
 * @date 2018年1月23日
 */
public interface ModelUserMapper {

	/**
	 * 根据ID获取信息实体.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ModelUser findById(String id) throws Exception;

	/**
	 * 根据条件查询信息.
	 * 
	 * @param param 查询条件
	 * @return
	 * @throws Exception
	 */
	List<ModelUser> findByParam(Map<String, Object> param) throws Exception;
	
  /**
	 * 根据实例查询信息.
	 * 
	 * @param modelUser  实例查询条件
	 * @return
	 * @throws Exception
	 */
	List<ModelUser> findByExample(ModelUser modelUser) throws Exception;

  /**
	 * 根据ids查询信息.
	 * 
	 * @param ids  实例查询条件
	 * @return
	 * @throws Exception
	 */
	List<ModelUser> findByIds(List<String> ids) throws Exception;
	/**
	 * 获取所有信息.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ModelUser> findAll() throws Exception;

	/**
	 * 保存信息.
	 * 
	 * @param modelUser
	 *            版本信息
	 * @return
	 * @throws Exception
	 */
	void save(ModelUser  modelUser) throws Exception;

	/**
	 * 批量删除.
	 * 
	 * @param ids 需要删除的ID列表.
	 * @throws Exception
	 */
	void deleteMany(String ids) throws Exception;
   /**
	 * 删除.
	 * 
	 * @param ids 需要删除的ID列表.
	 * @throws Exception
	 */
	void deleteOne(String id) throws Exception;

	/**
	 * 更新版本信息.
	 * 
	 * @param  modelUser 信息实体
	 * @throws Exception
	 */
	void update(ModelUser  modelUser) throws Exception;
}
