package game;

import java.io.Serializable;

public class Card implements Serializable {

    private static final long serialVersionUID = 2L;
    private String name;
    private int id;
    private String desc;
    String imagePath = "";

    public Card() {
        this.name = "";
        this.id = 0;
        this.desc = "";
        this.imagePath = "";
    }

    public Card(String desc) {
        this.desc = desc;
    }

    public Card(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Card(String name, int id, String desc) {
        this.name = name;
        this.id = id;
        this.desc = desc;
    }

    public Card(String name, int id, String desc, String imgPath) {
        this.name = name;
        this.id = id;
        this.desc = desc;
        this.imagePath = imgPath;
    }

    /** 
	* Replace the current ID by the ID of the card passed in the parameter
	*  
    * @param aCard       
    * @return int 
    *
	*/
    public int setIdCard(Card aCard) {
        return this.id = aCard.id;
    }

    /** 
	* Replace the current name by the name passed in the parameter
	*  
    * @param name       
    *
	*/
    public void setCardName(String name) {
        this.name = name;
    }

    /** 
	* Get the current card's name 
	*  
    * @return String       
    *
	*/
    public String getNameCard() {
        return name;
    }

    /** 
	* Replace the current id by the id passed in the parameter
	*  
    * @param id       
    *
	*/
    public void setCardId(int id) {
        this.id = id;
    }

    /** 
	* Get the current card's ID 
	*  
    * @return int       
    *
	*/
    public int getIdCard() {
        return id;
    }

    /** 
	* Replace the current description by the description passed in the parameter
	*  
    * @param desc       
    *
	*/
    public void setCardDesc(String desc) {
        this.desc = desc;
     }

    /** 
	* Get the current card's description 
	*  
    * @return String       
    *
	*/
    public String getDescCard() {
        return desc;
    }

    /** 
	* Replace the current path to image by the path to image passed in the parameter
	*  
    * @param name       
    *
	*/
    public void setCardPathImg(String imgPath) {
        this.imagePath = imgPath;
    }

    /** 
	* Get the current card's image path 
	*  
    * @return String       
    *
	*/
    public String getImgCard() {
        return imagePath;
    }

    /** 
	*  
    * @return String       
    *
	*/
    @Override
    public String toString() {
        return "The " + this.name + " " + this.id + " has as description " + this.desc + " " + this.imagePath;
		
    }
}