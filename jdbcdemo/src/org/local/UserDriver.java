package org.local;

public class UserDriver {

	public static void main(String[] args) throws Exception {
		String name = "KBC";
		int id = 345;
		String password = "987";
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		UserCRUD c = new UserCRUD();
		c.saveUser(user);
	}

}
