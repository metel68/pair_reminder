package ru.maxmetel.pair_reminder.main.model;

import java.util.Iterator;
import java.util.List;

public class ListAnswer<T> implements Iterable<T>{
	List<T> list;
	Boolean success;
	OmstuError error;
	
	public ListAnswer(String error) {
		super();
		this.error = new OmstuError(error);
		this.success = false;
	}
	
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

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
}
