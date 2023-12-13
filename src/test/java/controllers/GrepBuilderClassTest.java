package controllers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import Controllers.GrepBuilderClass;

public class GrepBuilderClassTest {

	@Test
	@BeforeAll
	public void start() {
		System.out.println("Test started for grep");
	}
	
	@Test
	public void validCheck1() {
		GrepBuilderClass.mergeAllText("we are true");
		assertTrue(true,"accepted");
	}
	
	@Test
	public void invalidCheck1() {
		GrepBuilderClass.mergeAllText("");
		assertTrue(false,"unaccepted");
	}
	
	@Test
	public void invalidCheck2() {
		List<String> files = new ArrayList<String>();
		files.add("goku.txt");
		try {
			GrepBuilderClass.validatePatterns(System.getProperty("user.dir")+"\\TestFolder", "-i", "unix",files);
			assertFalse(true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void invalidCheck3() {
		List<String> files = new ArrayList<String>();
		files.add("goku.txt");
		try {
			GrepBuilderClass.validatePatterns(System.getProperty("user.dir")+"\\TestFolder", "a", "",files);
			assertTrue(false);
		} catch (FileNotFoundException e) {
			assertFalse(true,e.getLocalizedMessage());
		} catch (IOException e) {
			assertFalse(true,e.getLocalizedMessage());
		}
		
	}
	
	@Test
	@AfterAll
	public void close() {
		System.out.println("Test ended for grep");
	}
}
