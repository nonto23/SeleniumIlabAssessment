package com.ilab.assessment;

public class Locators {
	
	private String username ="txtUsername";
	private String password  = "txtPassword";
	private String loginBtn = "Submit";
	private String tapAdmin = "menu_admin_viewAdminModule";
	private String addBtn = "btnAdd";
	private String deleteBtn = "btnDelete";
	private String searchBtn = "searchBtn";
	private String resetBtn = "resetBtn";
	private String header = "33";
	private String dropdownRole = "systemUser[userType]";
	
	//elements of the adding a user
	private String emploName = "systemUser[employeeName][empName]";
	private String emploUsername = "systemUser[userName]";
	private String emploPassword = "systemUser[password]";
	private String emploConfPassword = "systemUser[confirmPassword]";
	private String emploBtnsave = "//*[@id=\"btnSave\"]";
	
	
	
	public String getEmploBtnsave() {
		return emploBtnsave;
	}
	public void setEmploBtnsave(String emploBtnsave) {
		this.emploBtnsave = emploBtnsave;
	}
	public String getEmploConfPassword() {
		return emploConfPassword;
	}
	public void setEmploConfPassword(String emploConfPassword) {
		this.emploConfPassword = emploConfPassword;
	}
	public String getEmploPassword() {
		return emploPassword;
	}
	public void setEmploPassword(String emploPassword) {
		this.emploPassword = emploPassword;
	}
	public String getEmploUsername() {
		return emploUsername;
	}
	public void setEmploUsername(String emploUsername) {
		this.emploUsername = emploUsername;
	}
	public String getEmploName() {
		return emploName;
	}
	public void setEmploName(String emploName) {
		this.emploName = emploName;
	}
	public String getDropdownRole() {
		return dropdownRole;
	}
	public void setDropdownRole(String dropdownRole) {
		this.dropdownRole = dropdownRole;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getResetBtn() {
		return resetBtn;
	}
	public void setResetBtn(String resetBtn) {
		this.resetBtn = resetBtn;
	}
	public String getSearchBtn() {
		return searchBtn;
	}
	public void setSearchBtn(String searchBtn) {
		this.searchBtn = searchBtn;
	}
	public String getDeleteBtn() {
		return deleteBtn;
	}
	public void setDeleteBtn(String deleteBtn) {
		this.deleteBtn = deleteBtn;
	}
	public String getAddBtn() {
		return addBtn;
	}
	public void setAddBtn(String addBtn) {
		this.addBtn = addBtn;
	}
	public String getTapAdmin() {
		return tapAdmin;
	}
	public void setTapAdmin(String tapAdmin) {
		this.tapAdmin = tapAdmin;
	}
	public String getLoginBtn() {
		return loginBtn;
	}
	public void setLoginBtn(String loginBtn) {
		this.loginBtn = loginBtn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
