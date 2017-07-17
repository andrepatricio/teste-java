package teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import reader.Command;
import reader.PropertyNotFoundException;
import reader.Reader;


public class CommandTest {

	static Command command;
	
	@BeforeClass
	public static void before() throws IOException{
		command = Reader.readCSV("./cidades.csv");
	}
	
	@Test
	public void testCount() {
		assertEquals(5565, command.count());
	}
	
	@Test
	public void testCountDistinct() throws PropertyNotFoundException {
		assertEquals(27, command.count("uf"));
	}
	
	@Test(expected = PropertyNotFoundException.class)
	public void testCountDistinctPropertyNotFound() throws PropertyNotFoundException{
		command.count("property");
	}
	
	@Test
	public void testFilter() throws PropertyNotFoundException{
		String result = "ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion\n";
		result +="1100015,RO,Alta Floresta D'Oeste,,-61.9998238963,-11.9355403048,Alta Floresta D'Oeste,,Cacoal,Leste Rondoniense\n";
		
		assertEquals(null, result, command.filter("no_accents", "Alta Floresta D'Oeste"));
	}
	
	@Test(expected = PropertyNotFoundException.class)
	public void testFilterPropertyNotFound() throws PropertyNotFoundException{	
		command.filter("no_acce", "Alta Floresta D'Oeste");
	}

}
