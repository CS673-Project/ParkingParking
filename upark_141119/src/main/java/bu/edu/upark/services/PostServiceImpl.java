package bu.edu.upark.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import bu.edu.upark.entities.ParkingInfo;
import bu.edu.upark.repositories.ParkingInfoDAO;


@Service
@ComponentScan("bu.edu.upark.repositories")
public class PostServiceImpl implements PostService{
	
	 	@Autowired
	    private ParkingInfoDAO pid;
	 	
		@Override
		public boolean doPost(HttpServletRequest req, ParkingInfo parkInfo) {
			
			pid.addParkInfo(parkInfo);
			System.out.println("Post Success");
			
			List<ParkingInfo> list;
			
			list = pid.findAll();
			
			ParkingInfo testP = list.get(0);
			
			
			
			return true;
		}

}
