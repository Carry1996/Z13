package com.timor.dao;
import com.timor.vo.IndicatorSystemTree;
import java.util.List;
public interface IndicatorSystemTreeDao {
	/**
	 * 
	 * @param tree_name
	 * 		树的名字
	 * @return Tree	
	 * 		整棵树的列表
	 * @throws Exception 
	 * 		有异常交给调用方处理
	 * */
	public List<IndicatorSystemTree> getTree(String tree_name)throws Exception;
	/**
	 * @param nodeid
	 * 		节点的编号
	 * @return Node
	 * 		节点的全部信息
	 * @throws Exception
	 * 		有异常交给调用方处理
	 * */
	public IndicatorSystemTree getNode(int nodeid)throws Exception;
	/**
	 * 
	 * @param ist
	 * 		节点的信息
	 * @return
	 * 		向数据库设定信息是否成功
	 * @throws Exception
	 * 		有异常交给调用方处理
	 */
	public boolean setNode(IndicatorSystemTree ist)throws Exception;
	/**
	 * 
	 * @param istl
	 * 		整棵树的信息（但内部节点计算未完全）
	 * @return
	 * 		计算成功的信息
	 * @throws Exception
	 * 		有异常交给调用方处理
	 */
	public boolean calculateTree(List<IndicatorSystemTree> istl)throws Exception;
	
}
