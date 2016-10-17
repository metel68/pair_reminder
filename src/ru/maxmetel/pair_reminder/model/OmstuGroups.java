package ru.maxmetel.pair_reminder.model;

import java.util.List;

public class OmstuGroups {
	List<Group> list;
	Boolean success;
	OmstuError error;
	
	public List<Group> getList() {
		return list;
	}
	public Boolean getSuccess() {
		return success;
	}
	public OmstuError getError() {
		return error;
	}
}
