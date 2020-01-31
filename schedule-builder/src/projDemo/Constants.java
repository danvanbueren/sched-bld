package projDemo;

import java.awt.Color;
import java.time.format.DateTimeFormatter;

public class Constants {
	
	// BMC (Basic Mission Current) -  BAQ (Basic Aircerw Qual) - not mission qual
	public enum IndefiniteGrounded {
		GENERIC_RED, GENERIC_YELLOW, NON_CMR, BMC, BAQ, DNIF, SUPERVISED, UQ, TRAINING_PLAN_UQ;
	}

	public enum GeneralTags {
		NO_FLIGHT, NO_SIM;
	}

	public enum RAP {
		VOICETELL;
	}

	enum MeterState {
		GREEN, YELLOW, RED, UNK;
	}

	enum MeterType {
		ONE, THREE, QUAL, MSN;
	}

	public final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

	public final static Color red = new Color(183, 28, 28);
	public final static Color darkRed = new Color(127, 0, 0);
	public final static Color yellow = new Color(245, 127, 23);
	public final static Color darkYellow = new Color(188, 81, 0);
	public final static Color green = new Color(27, 94, 32);
	public final static Color darkGreen = new Color(0, 51, 0);
	public final static Color gray = new Color(33, 33, 33);
	public final static Color darkGray = new Color(0, 0, 0);
	public final static Color white = new Color(255, 255, 255, 127);
}