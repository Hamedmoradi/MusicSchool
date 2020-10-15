package com.music.school.enums;

public enum ActionType {
	INSERT("INSERT"),
	UPDATE("UPDATE"),
	DELETE("DELETE");
	private String type;

ActionType(String type) {
	this.type = type;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

}
