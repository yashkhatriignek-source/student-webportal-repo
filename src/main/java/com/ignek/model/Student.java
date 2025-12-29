package com.ignek.model;

public class Student {
 
	private int id;
	private String name;
	private int rollNo;
	private String phoneNO;
	private String email;
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getRollNo() {
			return rollNo;
		}
		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}
		public String getPhoneNO() {
			return phoneNO;
		}
		public void setPhoneNO(String phoneNO) {
			this.phoneNO = phoneNO;
		}
}
