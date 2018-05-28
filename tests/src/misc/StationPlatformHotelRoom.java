package misc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StationPlatformHotelRoom {

	static List<Room> rooms = new ArrayList<>();
	static List<Guest> guests = new ArrayList<>();


	class Room{
		boolean isFree=true;
		Date checkinTime;
		Date checkoutTime;
		public Room(boolean isFree, Date checkinTime) {
			super();
			this.isFree = isFree;
			this.checkinTime = checkinTime;
		}
		public Date getCheckoutTime() {
			return checkoutTime;
		}
		public void setCheckoutTime(Date checkoutTime) {
			this.checkoutTime = checkoutTime;
		}
		public boolean isFree() {
			return isFree;
		}
		public void setFree(boolean isFree) {
			this.isFree = isFree;
		}
		public Date getCheckinTime() {
			return checkinTime;
		}
		public void setCheckinTime(Date checkinTime) {
			this.checkinTime = checkinTime;
		}
		
		
		
		
	}
	
	class Guest{
		Date checkinTime;
		Date checkoutTime;
		public Guest(Date t1, Date t2){
			checkinTime = t1;
			checkoutTime = t1;
		}
	}
	
	public static void main(String args[]){
		int totalOccupiedRooms=0;
		int totalRoomRequired=0;
		StationPlatformHotelRoom obj = new StationPlatformHotelRoom();
		Date currentDate = new Date(123450);

		guests.add(obj.new Guest(new Date(123452), new Date(123457)));
		guests.add(obj.new Guest(new Date(123454), new Date(123456)));
		guests.add(obj.new Guest(new Date(123451), new Date(123458)));
		guests.add(obj.new Guest(new Date(123458), new Date(123459)));
		
		for(Guest guest : guests){
			Room room = obj.getNewRoom(currentDate);
		}

		
	}

	
	private void updateRoomStatus(Date currentDate){
		for(Room room : rooms){
			if(room.getCheckoutTime().before(currentDate) || room.getCheckoutTime().equals(currentDate)){
				room.isFree = true;
			}
			
		}
		
	}
	private  Room getNewRoom(Date currentDate) {
		if(!rooms.isEmpty()){
			for(Room room : rooms){
				if(room.isFree()){
					return room;
					
				}
			}
		}
		Room room = new Room(false, currentDate );
		rooms.add(room);
		return room;

	}


}
