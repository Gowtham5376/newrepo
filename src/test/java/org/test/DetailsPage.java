package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage extends BaseClass {
	
	public void DetailPage() {
		PageFactory.initElements(driver, this);
		}
			@FindBy(id="location")
			private WebElement location;
			@FindBy(id="hotels")
			private WebElement hotels;
			@FindBy(id="room_type")
			private WebElement roomtype;
			@FindBy(id="room_nos")
			private WebElement noofrooms;
			@FindBy(id="datepick_in")
			private WebElement checkindate;
			@FindBy(id="datepick_out")
			private WebElement checkoutdate;
			@FindBy(id="adult_room")
			private WebElement adultperrm;
			@FindBy(id="child_room")
			private WebElement childroom;
			@FindBy(id="Submit")
			private WebElement search;
	        public WebElement getLocation() {
				return location;
			}
	       public WebElement getHotels() {
				return hotels;
			}
	       public WebElement getRoomtype() {
				return roomtype;
			}

			public WebElement getNoofrooms() {
				return noofrooms;
			}

			public WebElement getCheckindate() {
				return checkindate;
			}

			public WebElement getCheckoutdate() {
				return checkoutdate;
			}

			public WebElement getAdultperrm() {
				return adultperrm;
			}

			public WebElement getChildroom() {
				return childroom;
			}

			public WebElement getSearch() {
				return search;
			}
			
			
			
			
			
			
			
			

}
