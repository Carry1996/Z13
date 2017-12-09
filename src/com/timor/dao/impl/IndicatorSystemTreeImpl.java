package com.timor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.timor.dao.IndicatorSystemTreeDao;
import com.timor.vo.IndicatorSystemTree;

public class IndicatorSystemTreeImpl implements IndicatorSystemTreeDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public IndicatorSystemTreeImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<IndicatorSystemTree> getTree(String tree_name) throws Exception {
		// TODO Auto-generated method stub
		List<IndicatorSystemTree> ist = null;
		ResultSet rs = null;
		String sql = "select ";
		return null;
	}

	@Override
	public IndicatorSystemTree getNode(int nodeid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setNode(IndicatorSystemTree ist) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean calculateTree(List<IndicatorSystemTree> istl) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
