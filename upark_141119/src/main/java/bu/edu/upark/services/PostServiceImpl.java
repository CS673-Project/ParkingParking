package bu.edu.upark.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import bu.edu.upark.entities.ParkingInfo;
import bu.edu.upark.repositories.ParkingInfoDAO;



@ComponentScan("bu.edu.upark.repositories")
public class PostServiceImpl implements PostService{
	
	 	@Autowired
	    private ParkingInfoDAO pid;
	 	
		@Override
		public boolean doPost(HttpServletRequest req, ParkingInfo parkInfo) {
			
			pid.addParkInfo(parkInfo);
			System.out.println("Post Success");
			
			return true;
		}

}
