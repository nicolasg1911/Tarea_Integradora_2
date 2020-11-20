package model;
public class User {

	
	private String name;
	private int age;
	private String password; 
	private int categorynum;

	private Category categoryType;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param age user age
	 * @param nickname user name
	 * @param password user password
	 */
	public User(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
		this.categorynum = categorynum;
		this.categoryType =Category.NEWBIE;
		
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return nickname
	 */
	public String getName() {
	return name;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return age
	 */
	public int getAge() {
	return age;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return password
	 */
	public String getPassword() {
	return password;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return categoryType
	 */
	public Category getCategoryType() {
	return categoryType;
	}
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return playlist duration
	 */
	public int getCategorynum() {
	return categorynum;
	}

	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param name: user name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param age: user name
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param password: user password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param categorynum: count user
	 */
	public void setCategorynum(int categorynum) {
		this.categorynum = categorynum;
	}	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param cayegoryType
	  user category
	 */
	public void setCategoryType(Category categoryType) {
		this.categoryType = categoryType;
	}	

	 /**
	 * convert Category(enum) to String  <br>
	 *<b> pre: For convert Category (enum) to string, is necessary the Category class(enum)</b>
	 * @param categoryType user category </b> 
	 */
	public Category convert(String categoryType){
        Category myUserType = Category.valueOf(categoryType);
        return myUserType;

    }

	/**
	 * displays User information on screen<br>
	 * <b> pre: we need all the User information: nickname, age and categoryType </b> 
	 * @return a message showing all the information of the User
	 */
	public String toString(){
	String message;
	message=
		"\n **********USER***********" +
		"\n Username: " + name +
		"\n Age: " + age +
		"\n Category: " + categoryType+
		"\n *************************";
		return message;
	}



}