package modal;

import java.io.Serializable;

public class menu implements Serializable{
	private static final long serialVersionUID=12345;
	//菜名编号
	private int menuenumber;
	//菜名
	private String dishes;
	//价格
	private double price;
	//菜系名
	private String cuiname;
	//规格
	private double num;
	public menu(int menuenumber, String dishes, double price, String cuiname) {
		super();
		this.menuenumber = menuenumber;
		this.dishes = dishes;
		this.price = price;
		this.cuiname = cuiname;
	}
	public menu(int menuenumber, String dishes, double price, double num) {
		super();
		this.menuenumber = menuenumber;
		this.dishes = dishes;
		this.price = price;
		this.num = num;
	}
	public menu(int menuenumber, String dishes, double price, String cuiname, double num) {
		super();
		this.menuenumber = menuenumber;
		this.dishes = dishes;
		this.price = price;
		this.cuiname = cuiname;
		this.num = num;
	}
	
	public menu(String dishes) {
		super();
		this.dishes = dishes;
	}
	public menu() {
		super();
	}
	public int getMenuenumber() {
		return menuenumber;
	}
	public void setMenuenumber(int menuenumber) {
		this.menuenumber = menuenumber;
	}
	public String getDishes() {
		return dishes;
	}
	public void setDishes(String dishes) {
		this.dishes = dishes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCuiname() {
		return cuiname;
	}
	public void setCuiname(String cuiname) {
		this.cuiname = cuiname;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
	
	
}
