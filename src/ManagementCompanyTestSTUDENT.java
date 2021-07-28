

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany propManCom;

	@Before
	public void setUp() throws Exception {
		//student create a management company
		propManCom = new ManagementCompany("J&F Services","4365",9);
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("Avis","Hyattsville",2000,"John Doe",1,1,3,3);
		p2 = new Property ("Budget","Bowie",3702,"Jane Doe",1,4,2,2);
		p3 = new Property ("Capgemini","Rockville",5040,"John Smith",4,1,1,1);
		propManCom.addProperty(p1);
		propManCom.addProperty(p2);
		propManCom.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null
		p1=p2=p3=null;
		propManCom = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property ("Excella","Tysons Corner",1200,"Johnathan James");
		assertEquals(propManCom.addProperty(p4),3,0.1);
		//student should add property with 8 args
		p5 = new Property ("Bozzuto","Washington DC",5000,"Jim John",3,3,2,2);
		assertEquals(propManCom.addProperty(p5),-4,0.1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property ("Capital One","Vienna",3000,"Janet Mary",4,2,1,1);
		assertEquals(propManCom.addProperty(p6),4,0.1);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(propManCom.maxRentProp(),5040.0,0.1);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(propManCom.totalRent(),10742.0,0.1);
	}

 }
