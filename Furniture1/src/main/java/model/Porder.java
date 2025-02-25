package model;

public class Porder {
	private Integer id;
	private String name;
	private Integer desk;
	private Integer gamingChair;
	private Integer wardrobe;
	private String username;
	public Porder(String name, Integer desk, Integer gamingChair, Integer wardrobe, String username) {
		super();
		this.name = name;
		this.desk = desk;
		this.gamingChair = gamingChair;
		this.wardrobe = wardrobe;
		this.username = username;
	}
	
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDesk() {
		return desk;
	}
	public void setDesk(Integer desk) {
		this.desk = desk;
	}
	public Integer getGamingChair() {
		return gamingChair;
	}
	public void setGamingChair(Integer gamingChair) {
		this.gamingChair = gamingChair;
	}
	public Integer getWardrobe() {
		return wardrobe;
	}
	public void setWardrobe(Integer wardrobe) {
		this.wardrobe = wardrobe;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}	
	