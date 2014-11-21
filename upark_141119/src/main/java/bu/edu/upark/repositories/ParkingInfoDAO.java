package bu.edu.upark.repositories;

import bu.edu.upark.entities.ParkingInfo;
import bu.edu.upark.entities.UserAccount;

public interface ParkingInfoDAO {
	public void addParkInfo(ParkingInfo pi);
    public void updateParkInfo(ParkingInfo pi);
    public ParkingInfo findInfobyName(String username);
    public ParkingInfo getParkInfo(String id);
    public void deleteParkInfo(String id);
}
