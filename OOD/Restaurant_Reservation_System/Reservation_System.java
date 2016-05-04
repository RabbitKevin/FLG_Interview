Class ReservationSystem{
	HashTable <Long,Reservation> reservationTable = new HashTable<>();

	public void createReservation(long startTime,String firstName, String LastName,int partySize){
    	Random random = new Random();
    	long reservationID = random.getNextLong(10000);
    	Person reserver = new Person();
    	reserver.firstName = firstName;
    	reserver.lastName = lastName;
    	reservationTable.put(reservationID, new Reservation(reservationId,startTime,reserver,partySize);
	}
	public Reservation searchReservation(){}
	public void cancelReservation(){}
}
Class Reservation{
	long reservationID;
	long startTime;
	Person reserver;
	int partySize;
	public Reservation( long reservationID, long startTime, Person reserver, int partySize){
    	this.startTime = startTime;
    	this.reserver = reserver;
    	this.partySize = partySize;
	}
}

Class Person
{
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
}
