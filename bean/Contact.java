package bean;

public class Contact {
	private int userNum;

	private String email;

	private String name;

	private int age;

	private String address;

	private String gender;
	//ContactItemの部分
	private String pulldown;

	private String howYou;

	private String freeText;

	private String contactDate;

	private int status;

	public Contact() {
		this.userNum = 0;
		this.email = null;
		this.name = null;
		this.age = 0;
		this.address = null;
		this.gender = null;
		this.pulldown = null;
		this.howYou = null;
		this.freeText = null;
		this.contactDate = null;
		this.status = 0;

	}

	// お問い合わせ番号を取得する
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	// お問い合わせ先のメールを取得する
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//お問い合わせ先の名称を取得する。
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//お問い合わせ先の住所を取得
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//お問い合わせ先の性別を取得
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//お問い合わせ先の要件項目を取得
	public String getPulldown() {
		return pulldown;
	}

	public void setPulldown(String pulldown) {
		this.pulldown = pulldown;
	}

	//お問い合わせ先の受講状態を取得
	public String getHowYou() {
		return howYou;
	}

	public void setHowYou(String howYou) {
		this.howYou = howYou;
	}

	//お問い合わせ先の要件内容を取得
	public String getFreeText() {
		return freeText;
	}

	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	//管理者画面の未読表示を取得
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}