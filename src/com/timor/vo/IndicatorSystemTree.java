package com.timor.vo;

public class IndicatorSystemTree {
	String node_name;
	int node_id;
	int layer;
	int parent_id;
	double weight;
	double data;
	String tree_name;
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	public String getTree_name() {
		return tree_name;
	}
	public void setTree_name(String tree_name) {
		this.tree_name = tree_name;
	}
	
}
