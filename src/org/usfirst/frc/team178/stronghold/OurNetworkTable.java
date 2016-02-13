package org.usfirst.frc.team178.stronghold;

import edu.wpi.first.wpilibj.networktables.*;

public class OurNetworkTable {
	//Creating class variables
	static NetworkTable thisTable;
	static String tableName;
	static int teamNumber = 178;
	
	public OurNetworkTable(String tableName) {
		// TODO Auto-generated constructor stub
		OurNetworkTable.tableName = tableName;
	}
	
	public static void setUpServer() {
		thisTable.setServerMode();
		thisTable.setTeam(teamNumber);
		thisTable.getTable(tableName);
	}
}
