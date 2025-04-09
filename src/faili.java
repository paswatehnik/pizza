import java.io.File;
import java.util.ArrayList;

public class faili {
	ArrayList<String> pabOrder;
	ArrayList<String> nepabOrder;
	File orderFile;
	
	public faili(String failaNS) {
	this.pabOrder = new ArrayList<>();
	this.nepabOrder = new ArrayList<>();
	this.orderFile = new File(failaNS);
	
	}
}
