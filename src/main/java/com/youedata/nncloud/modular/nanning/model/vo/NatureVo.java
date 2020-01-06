package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatureVo {
	private Integer natureId;
	private String natureName;
	private Integer natureSecond;
	private Integer natureType;
	private List<NatureVo> list;
	public Integer getNatureId() {
		return natureId;
	}
	public void setNatureId(Integer natureId) {
		this.natureId = natureId;
	}
	public String getNatureName() {
		return natureName;
	}
	public void setNatureName(String natureName) {
		this.natureName = natureName;
	}
	public Integer getNatureSecond() {
		return natureSecond;
	}
	public void setNatureSecond(Integer natureSecond) {
		this.natureSecond = natureSecond;
	}
	public Integer getNatureType() {
		return natureType;
	}
	public void setNatureType(Integer natureType) {
		this.natureType = natureType;
	}
	public List<NatureVo> getList() {
		return list;
	}
	public void setList(List<NatureVo> list) {
		this.list = list;
	}
	
}
