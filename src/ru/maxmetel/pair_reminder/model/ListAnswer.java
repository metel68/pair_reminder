package ru.maxmetel.pair_reminder.model;

import java.util.List;

public class ListAnswer<T> {
	List<T> list;
	Boolean success;
	OmstuError error;
	
	public ListAnswer(List<T> list, Boolean success, OmstuError error) {
		super();
		this.list = list;
		this.success = success;
		this.error = error;
	}
	public List<T> getList() {
		return list;
	}
	public Boolean getSuccess() {
		return success;
	}
	public OmstuError getError() {
		return error;
	}
}
