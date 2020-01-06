package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.List;

import com.youedata.nncloud.modular.nanning.model.IndustryInfo;

public class IndustryInfoVo {
	private String name;
	private List<IndustryInfo> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<IndustryInfo> getList() {
		return list;
	}
	public void setList(List<IndustryInfo> list) {
		this.list = list;
	}
	
}
