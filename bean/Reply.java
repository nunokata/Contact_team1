package bean;

public class Reply {
	private String subject;
	private String answerText;
	private int flag;
	
	public Reply() {
		this.subject = null;
		this.answerText = null;
		this.flag = 0;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getAnswerText() {
		return answerText;
	}
	
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
