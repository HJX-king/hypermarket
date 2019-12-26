package hypermarket.user.bean;

public class Users {
	private long id;
	private String userName;
	private String password;
	
	
	private String real_name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"userName\":\"");
		builder.append(userName);
		builder.append("\", \"password\":\"");
		builder.append(password);
		builder.append("\", \"real_name\":\"");
		builder.append(real_name);
		builder.append("\"}");
		return builder.toString();
	}

}
