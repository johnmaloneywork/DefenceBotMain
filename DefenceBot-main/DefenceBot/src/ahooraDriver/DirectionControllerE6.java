package ahooraDriver;

import java.util.ArrayList;
import java.util.List;


public class DirectionControllerE6 {
	private ParametersContainerE6 myPara;
	boolean jump = false;
	double jumpTime = 0.0;
	List<Double> speeds = new ArrayList<Double>();
	List<Double> times = new ArrayList<Double>();
	private double estimatedTurn = 0.0;
	double pSteer = 0.0;
	public DirectionControllerE6 (ParametersContainerE6 myPara){
		this.setMyPara(myPara);
		
	}
	
	public DirectionControllerE6 (){
		
		
	}
	
	public float calcSteer(MySensorModel sensors, StuckTypes stuck, boolean isOut){
	    float steer = calculateSteer(sensors, stuck, isOut);
	    if(isOut)
	    	if(steer > 0.8 || steer < -0.8)
	    		steer = (float) (Math.signum(steer)*0.8);

        if (steer < -1)
            steer = -1;
        if (steer > 1)
            steer = 1;
        
        pSteer = steer;
        
        return steer;
	}
	
	private float calculateSteer(MySensorModel sensors, StuckTypes stuck, boolean isOut){

		float steer = 0;
		if(stuck != StuckTypes.NoStuck){
//			System.out.println(isOut + ", left? " + DriverControllerHelperE6.isOnTheLeftHandSide(sensors) + ", towardsin? " + DriverControllerHelperE6.isTowardsInsideTheTrack(sensors) + ", cor? " + 
//					DriverControllerHelperE6.isInTheCorrectDirection(sensors));
			if(isOut){
				if(DriverControllerHelperE6.isOnTheLeftHandSide(sensors)){//left hand side of the track
					if(DriverControllerHelperE6.isTowardsInsideTheTrack(sensors)){//is towards the track, try to enter the track slowly (with a smooth direction)
						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
							steer = (float) 0.0;//g=1
						}else{
							steer = (float) 0.2;//g=1
						}
						
					}else{
						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
							steer = (float) 0.2;//g=-1
						}else{
							steer = (float) 0.2;//g=-1
						}
						
					}
					
				}else{//right hand side of the track
					if(DriverControllerHelperE6.isTowardsInsideTheTrack(sensors)){//is towards the track, try to enter the track slowly (with a smooth direction)
						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
							steer = (float) 0.0;//g=1
						}else{
							steer = (float) -0.2;//g=1
						}
						
					}else{
						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
							steer = (float) -0.2;//g=-1
						}else{
							steer = (float) -0.2;//g=-1
						}
						
					}
				}
			}else{
				if(sensors.getGear() == -1){
					steer = -(float) Math.signum(sensors.getAngleToTrackAxis());
				}else{
					steer = (float) Math.signum(sensors.getAngleToTrackAxis());
				}
				
//				if(DriverControllerHelperE6.isOnTheLeftHandSide(sensors)){//left hand side of the track
//					if(DriverControllerHelperE6.isTowardsInsideTheTrack(sensors)){//is towards the track, try to enter the track slowly (with a smooth direction)
//						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
//							steer = (float) 0.2;//g=1
//						}else{
//							steer = (float) 0.2;//g=1
//						}
//						
//					}else{
//						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
//							steer = (float) 0.2;//g=-1
//						}else{
//							steer = (float) 0.2;//g=-1
//						}
//						
//					}
//					
//				}else{//right hand side of the track
//					if(DriverControllerHelperE6.isTowardsInsideTheTrack(sensors)){//is towards the track, try to enter the track slowly (with a smooth direction)
//						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
//							steer = (float) -0.2;//g=1
//						}else{
//							steer = (float) -0.2;//g=1
//						}
//						
//					}else{
//						if(DriverControllerHelperE6.isInTheCorrectDirection(sensors)){
//							steer = (float) -0.2;//g=-1
//						}else{
//							steer = (float) -0.2;//g=-1
//						}
//						
//					}
//				}
			}
			steer *= 5.0; 
//			turnDirections.clear();

		}else{
			if(!isOut){
				int maxDistanceSensorIndx = DriverControllerHelperE6.extermumIndexAngle(sensors.getTrackEdgeSensors(), extermumTypes.maximization);
				float distInfront = (float) DriverControllerHelperE6.maximumDistanceInfront(sensors.getTrackEdgeSensors());
				
				double maxCorrectionSensors = getMyPara().getParameterByName("Maxsensors");
				double minCorrectionSensors = getMyPara().getParameterByName("Minsensors");
				double soarDirection = 0.00;//turnDirection/(minInMiddle-maxIn);//[-1, 1] left or right of the track
				
				double maxSoar = getMyPara().getParameterByName("MaximumSoar");//the minimum distance that it is still in soar (10 sensors for correction until that)
				double minSoar = getMyPara().getParameterByName("MinimumSoar");//the maximum distance that it is in soar (3 sensor for correction from that on)
	
				double numberOfCorrectionSensors = DriverControllerHelperE6.logSig(minCorrectionSensors, maxCorrectionSensors, minSoar, maxSoar, 0.99, distInfront);
				
				int correctionSensors = (int) numberOfCorrectionSensors;
				double minv = getMyPara().getParameterByName("minv");
				double midv1 = getMyPara().getParameterByName("midv1");
				double midv2 = getMyPara().getParameterByName("midv2");
				double maxv = getMyPara().getParameterByName("maxv");
				
				double s = DriverControllerHelperE6.trapasoide(minv, midv1, midv2, maxv, distInfront);

				if(getEstimatedTurn() < 0.0)//we are going to turn left
					s = -s;
				soarDirection = s;
				double[] opponentInfo = OpponentController.opponentSteerReviser(sensors, s, pSteer, correctionSensors);
				
				
				soarDirection = (float) opponentInfo[0];
				
				correctionSensors =  (int) Math.round(opponentInfo[1]);
				double steerToTurn = -weightedMean2(DriverControllerHelperE6.angles, sensors.getTrackEdgeSensors(), 
						maxDistanceSensorIndx, correctionSensors, soarDirection, sensors); 
				steer = (float) (steerToTurn);
				
			}else{
				steer = -(float) ((float) ((-sensors.getAngleToTrackAxis()*2.0)+Math.signum(sensors.getTrackPosition())*13.0*Math.PI/180));
			}
		}
		
		if(sensors.getZ() > 0.65){
			jumpTime = sensors.getCurrentLapTime();
			jump = true;
		}
		if(jump && jumpTime + 0.5 > sensors.getCurrentLapTime()){
			steer = steer/5.0f;
		}else
			jump = false;
//		System.out.println(sensors.getZ() + " " + jump + " " + steer);
//		speeds.add(sensors.getSpeed());
//		times.add(sensors.getCurrentLapTime());
//		if(speeds.size() > 2){
//			times.remove(0);
//			speeds.remove(0);
//		}
//		if(speeds.size() > 1 && Math.abs(steer) < 0.05)
//			System.out.println("Steer: " + steer + " speed: " + speeds.get(0) + " speed c: " + speeds.get(1) + " dif: " + (speeds.get(0) - speeds.get(1))/(times.get(0)-times.get(1)));
//		steer = (float) 0.0;
//		System.out.println(steer);
		
		return steer;
	}

	public double weightedMean(float[] angles, double[] distances, int baseAngle, 
			int count, double soarDirection, MySensorModel sensors){
		soarDirection = Math.pow(2.0, 2.0*soarDirection);//[-1, 1] left or right of the track
		double res=0;
		double sumDist = 0;
//		System.out.println("*********weight************");
//		System.out.println();
//System.out.println(angles[baseAngle] + " " + soarDirection);
		for(int i=baseAngle - count; i <= baseAngle + count; ++i){
			int indx = Math.min(i, angles.length - 1);
			indx = Math.max(indx, 0);
			
			if(Math.abs(angles[indx]) < 2 && angles[indx] != 0)
				continue;
			
			double dis = distances[indx];
			if(i<baseAngle){
				dis /= soarDirection;
			}
			if(i>baseAngle){
				dis *= soarDirection;
			}
			if(Math.abs((sensors.getAngleToTrackAxis() + angles[indx]*Math.PI/180.0)) > Math.PI/2 ){
//				System.out.println(angles[indx] + " " + sensors.getAngleToTrackAxis()*180.0/Math.PI);
				continue;
			}
			res += ((angles[indx])*(dis));
			sumDist += distances[indx];
//			System.out.println(angles[indx] + " " + dis + " res " + res + " dist sum " + sumDist);
			
		}
		
//		System.out.println(res+" "+sumDist + " " + res/sumDist); 
//		System.out.println(res/sumDist + " " + DriverControllerHelperE6.degreeToRadian(res/sumDist));
//		System.out.println("***end of weighted****");
		return DriverControllerHelperE6.degreeToRadian(res/sumDist);
	}

	public double weightedMean2(float[] angles, double[] distances, int baseAngle, 
			int count, double soarDirection, MySensorModel sensors){
		soarDirection = Math.pow(2.0, 2.0*soarDirection);//[-1, 1] left or right of the track
		double resx=0;
		double resy=0.0;
//		double sumDist = 0;
//		double sumDist2 = 0.0;
//		System.out.println("****Force*****");
//System.out.println(angles[baseAngle] + " " + soarDirection);
		for(int i=baseAngle - count; i <= baseAngle + count; ++i){
			int indx = Math.min(i, angles.length - 1);
			indx = Math.max(indx, 0);
			
			if(Math.abs(angles[indx]) < 2 && angles[indx] != 0)
				continue;
			
			double dis = distances[indx];
			if(i<baseAngle){
				dis /= soarDirection;
			}
			if(i>=baseAngle){
				dis *= soarDirection;
			}
			if(i == baseAngle){
				dis *= 2.0;
			}
			if(Math.abs((sensors.getAngleToTrackAxis() + angles[indx]*Math.PI/180.0)) > Math.PI/2 ){
//				System.out.println(angles[indx] + " " + sensors.getAngleToTrackAxis()*180.0/Math.PI);
				continue;
			}
			resx += (DriverControllerHelperE6.cosAng[indx]*(dis));
			resy += (DriverControllerHelperE6.sinAng[indx]*(dis));
//			sumDist += dis;
//			sumDist2 += distances[indx];
//			System.out.format("ang: %.2f, dis: %.2f\n", angles[indx], dis);
//			sumDist += distances[indx];
		}
//		System.out.println("**************"); 
		double res = Math.atan2(resy, resx);//*sumDist/sumDist2;

//		System.out.println(res+" "+sumDist + " " + res/sumDist); 
//		System.out.println("Force: " + res+ " degree: " + res*180/Math.PI);
//		System.out.println("****end force***");
		return res;
	}

	
	public double getEstimatedTurn() {
		return estimatedTurn;
	}

	public void setEstimatedTurn(double estimatedTurn) {
		this.estimatedTurn = estimatedTurn;
	}

	public ParametersContainerE6 getMyPara() {
		return myPara;
	}

	public void setMyPara(ParametersContainerE6 myPara) {
		this.myPara = myPara;
	}
}
