package ahooraDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParametersContainerE6 {
//	private boolean evolutionaryMode = false;
	
//	String param = "maxv: 107.9075418536763, maxAggV: 4.753901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//wheel2
//	String param = "maxv: 107.9075418536763, maxAggV: 6.153901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Brondehatch
//	String param = "maxv: 107.9075418536763, maxAggV: 5.683901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Etrack-3
//	String param = "maxv: 107.9075418536763, maxAggV: 4.983901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Eroad
//	String param = "maxv: 107.9075418536763, maxAggV: 5.513901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Street1
//	String param = "maxv: 107.9075418536763, maxAggV: 5.513901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Wheel1
//	String param = "maxv: 107.9075418536763, maxAggV: 6.913901789093406, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Alpine2
	String param = "maxv: 107.9075418536763, maxAggV: 7.0, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01956501913690144, maxAggTurn: 5.382771708803534, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//default-slowest
	
	
	
//	String param = "maxv: 107.9075418536763, maxAggV: 3.242568600336371, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01478384777891481, maxAggTurn: 3.169069285437615, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//Brondehatch
//	String param = "maxv: 107.9075418536763, maxAggV: 8.351090668086998, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.02459410715535047, maxAggTurn: 16.95975738979463, Maxsensors: 6.230728885167587, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Minsensors: 2.011735390446281";//etrack2
//	String param = "maxv: 107.9075418536763, maxAggV: 5.332868446716203, -absSlip: 1.0, MaximumSoar: 95.30302118020252, midv2: 114.1158700288616, midv1: 90.47991440926471, -absMinSpeed: 3.0, minv: 50.95124925780534, minAggV: 0.01971582329352539, maxAggTurn: 5.145771032002575, Minsensors: 2.011735390446281, MinimumSoar: -0.2300585760015009, -absRange: 3.0, Maxsensors: 6.230728885167587";//etrack3
	private Map<String, Double> parameters = new HashMap<String, Double>();
	private List<String> parametersNames = new ArrayList<String>();// = Arrays.asList("minAggC", "maxAggC", "minAggV", "maxAggV", "Minimum Soar", "Maximum Soar", "Min sensors", "Max sensors");

	//	outputs
	private double totalTime = 0.0;
	private double damage = 0.0;
//	private String trackName = ""; 
	
//	private String fileToSave = "";
//	private String fileToInit = "Para.txt";
	private int numberOfParameters = 0;
	private double penaltyCoef = 1.0;
	boolean pIsOut = false;
	
	private double friction = -1.08;
	double slipSampler = 0.0;
	double slipSamplerNumber = 0.0;
	double pRPM = 0.0;
	double lastTimeOut = 0.0;
	int lastLapOut = 1;
	double lastdamage = 0.0;
	private double trackWidth = 15.0;
	
//	private FileWriter out;
	
	public ParametersContainerE6(){
		
//		File f = new File(fileToSave);
		
//		f = new File(f.getAbsolutePath());
		
//		this.fileToSave = f.getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath() + "\\" + fileToSave;
		
		
//		this.fileToInit = fileToInit;
		
//		this.trackName = trackName;
		readInitialization();		
	}
	
	public void readInitialization(){
		String [] parameters = param.split(", ");
		for(String s : parameters){
			String [] currentLine = s.split(": ");
			numberOfParameters++;

			parametersNames.add(currentLine[0]);
			System.out.println(currentLine[0] + " " + currentLine[1]);
			getParameters().put(currentLine[0], Double.parseDouble(currentLine[1]));
		}
	}
	
	public void ParametersContainerInitializer(List<Double> parametersValues){
//		this.fileToSave = fileToSave;
//		this.fileToInit = fileToInit;
//		setEvolutionaryMode(isEvolutionaryMode);
//		parameters.clear();
		int i = 0;
		for(String s : parametersNames){
			if(i >= parametersValues.size())
				break;
			
			getParameters().put(s, parametersValues.get(i));
//			System.out.println(s + " " + parametersValues.get(i));
			++i;
		}		
	}
	
	public void writeToResultsFile(){
//		String s = printOutResults();
		
//		s += "\n";
	}

	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public Map<String, Double> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Double> parameters) {
		this.parameters = parameters;
	}
		
	public double getParameterByName(String name){
		Double res = parameters.get(name);
		if(res == null){
			String s = "-" + name;
//			System.out.println(s);
			res = parameters.get(s);
		}
//		System.out.println(name);
		return res;		
	}

	public int getNumberOfParameters() {
		return numberOfParameters;
	}

	public void setNumberOfParameters(int numberOfParameters) {
		this.numberOfParameters = numberOfParameters;
	}

	public String getParametersNames(int i) {
		String s = parametersNames.get(i);
		if(s.charAt(0) == '-')
			return s.substring(1);
		
		return s;
	}
	
	public boolean isEvolvable(int i){
		String s = parametersNames.get(i);
		if(s.charAt(0) == '-')
			return false;
		
		return true;
	}

	public void updatePenalty(boolean isOut, double damage, int lap, int pos){
//		System.out.println(getPenaltyCoef() + " " + lastdamage + " " + damage);
		if(pIsOut != isOut){
			if(isOut){
				lastLapOut = lap;
				setPenaltyCoef(getPenaltyCoef() / 1.03);
				setPenaltyCoef(Math.max(getPenaltyCoef(), 0.6));
//				System.out.println(getPenaltyCoef());
//				System.out.println(getParameterByName("maxAggTurn")*getPenaltyCoef());
			}
		}
		
		if(lastLapOut < lap){
			if(lastdamage >= damage){				
				if(pos != 1){
					setPenaltyCoef(getPenaltyCoef() * 1.03);
					setPenaltyCoef(Math.min(getPenaltyCoef(), 1.4));
				}
			}
			lastLapOut = lap;
			lastdamage = damage;
//			System.out.println(getPenaltyCoef() + " " + lastTimeOut);
		}
//		setPenaltyCoef(1.0);
//		System.out.println(lastTimeOut + " " + time);
		pIsOut = isOut;
		
	}

	public double getPenaltyCoef() {
		return penaltyCoef;
	}

	public void setPenaltyCoef(double penaltyCoef) {
		this.penaltyCoef = penaltyCoef;
	}
	
	public void frictionUpdater(int gear, MySensorModel sensors, double steer){
		double RPM = sensors.getRPM();
		if(RPM > 7000.0 && RPM < 8000.0){
//			System.out.println(RPM + " " + gear + " " + slipSampler);
			if(gear == 3 || gear == 2){// || gear == 4){
				if(RPM > pRPM && Math.abs(steer) < 0.06){
			    	double slip = 0.0;
//			    	System.out.println(pRPM);
			    	slip=(sensors.getWheelSpinVelocity()[3] * DriverControllerHelperE6.wheelRadius[3] + sensors.getWheelSpinVelocity()[2] * DriverControllerHelperE6.wheelRadius[2])/2.0;
			    	slip = (sensors.getSpeed()/3.6)-slip;
//			    	System.out.println(slip);
					slipSampler += slip;
					slipSamplerNumber++;
				}else{
					slipSampler = 0.0;
					slipSamplerNumber = 0.0;	
				}
				
			}
		}else{
//			System.out.println(slipSampler + " " + slipSamplerNumber + " " + RPM + " " + gear);

			slipSampler = 0.0;
			slipSamplerNumber = 0.0;					
		}
		if(slipSampler != 0.0 && slipSamplerNumber > 15){
//			if(gear == 4)
//				slipSampler *= 1.178;
//			System.out.println(friction + " " + slipSampler/slipSamplerNumber);
//			double f = (friction + (slipSampler/slipSamplerNumber))/2.0;
			setFriction(slipSampler/slipSamplerNumber);
			
			slipSampler = 0.0;
			slipSamplerNumber = 0.0;
			if(gear == 2)
				getParameters().put("maxAggV", getFriction()*3.5);
			if(gear == 3)
				getParameters().put("maxAggV", getFriction()*4.5);			
			
			double widthCoef =  ((2.0-1.0)/(30.0-16.0)) * (getTrackWidth()-16.0) + 1.0;
			widthCoef = Math.max(widthCoef, 1.0);
			double maxAggV = getParameterByName("maxAggV");
//			System.out.println(maxAggV);
			maxAggV /= widthCoef;
			maxAggV = Math.max(maxAggV, 4.50);
			if(sensors.getDamage() > 7000 && widthCoef <= 1){
				maxAggV = Math.max(maxAggV, 7.0);
			}
			getParameters().put("maxAggV", maxAggV);	
//			System.out.println(maxAggV);
//			getParameters().put("maxAggV", 6.0);	
			
			
//			System.out.println(getFriction() + " " + gear + " " + trackWidth + " " + parameters.get("maxAggV"));
			
		}
		pRPM = RPM;
	}

	public void trackWidthUpdater(MySensorModel sensors, double steer, boolean isOut){
		if(Math.abs(steer) < 0.06 && !isOut){
			trackWidth = (sensors.getTrackEdgeSensors()[0] + sensors.getTrackEdgeSensors()[sensors.getTrackEdgeSensors().length - 1]);
			
		}
	}
	
	public double getFriction() {
		return Math.abs(friction);
	}

	public void setFriction(double friction) {
		this.friction = friction;
	}

	public double getTrackWidth() {
		return trackWidth;
	}

	public void setTrackWidth(double trackWidth) {
		this.trackWidth = trackWidth;
	}
	
//	public void setParametersNames(List<String> parametersNames) {
//		this.parametersNames = parametersNames;
//	}
}
