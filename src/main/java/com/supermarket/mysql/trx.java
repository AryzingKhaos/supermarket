package com.supermarket.mysql;

public class trx {
	private Integer id;
	private Integer contentId  ;
	private Integer personId ;
	private Integer buyPrice;
	private Long buyTime ;
	
//	public trx(int personId,int contentId,int buyPrice,long buyTime){
//		this.contentId=contentId;
//		this.personId=personId;
//		this.buyPrice=buyPrice;
//		this.buyTime=buyTime;
//	}
	
	@Override
	public String toString() {
        return "content ["
        		+ "id=" + id
        		+ ", contentId=" + contentId 
        		+ ", personId=" + personId 
        		+ ", price=" + buyPrice 
        		+ ", time=" + buyTime 
        		+ "]";
    }
	
	
		
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContentId() {
		return this.contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public long getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}

	
}
