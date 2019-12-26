package hypermarket.goods.bean;

import java.util.Arrays;

import hypermarket.utils.Page;

public class Goods extends Page{
	private long id;
	private long user_id;
	private long type_id;
	private String g_name="";
	private double price;
	private String inco;
	private String content;
	private int num;
	private long create_time;
	private int status;
	
	
	private String real_name;
	private String type_name;
	
	private long[] typeIds;
	
	public long[] getTypeIds() {
		return typeIds;
	}
	public void setTypeIds(long[] typeIds) {
		this.typeIds = typeIds;
	}
	public String getInco() {
		return inco;
	}
	public void setInco(String inco) {
		this.inco = inco;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getType_id() {
		return type_id;
	}
	public void setType_id(long type_id) {
		this.type_id = type_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"");
		builder.append(id);
		builder.append("\", \"user_id\":\"");
		builder.append(user_id);
		builder.append("\", \"type_id\":\"");
		builder.append(type_id);
		builder.append("\", \"g_name\":\"");
		builder.append(g_name);
		builder.append("\", \"price\":\"");
		builder.append(price);
		builder.append("\", \"inco\":\"");
		builder.append(inco);
		builder.append("\", \"content\":\"");
		builder.append(content);
		builder.append("\", \"num\":\"");
		builder.append(num);
		builder.append("\", \"create_time\":\"");
		builder.append(create_time);
		builder.append("\", \"status\":\"");
		builder.append(status);
		builder.append("\", \"real_name\":\"");
		builder.append(real_name);
		builder.append("\", \"type_name\":\"");
		builder.append(type_name);
		builder.append("\", \"typeIds\":\"");
		builder.append(Arrays.toString(typeIds));
		builder.append("\"}");
		return builder.toString();
	}
	
	
	
}
