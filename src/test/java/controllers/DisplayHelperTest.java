package controllers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import Controllers.DisplayHelper;

public class DisplayHelperTest {

	@Test
	@BeforeAll
	public void start() {
		System.out.println("Test started for display helper");
	}
	
	
	@Test
	public void validCheck1() {
		DisplayHelper.ls(System.getProperty("user.dir"));
		Assertions.assertTrue(true,"Valid path passed");
	}
	
	@Test
	public void validCheck2() {
		DisplayHelper.ls(System.getProperty("user.dir"+"\\TestFolder"));
		Assertions.assertTrue(true,"Valid path passed");
	}
	
	@Test
	public void validCheck3() {
		try {
			DisplayHelper.cat(System.getProperty("user.dir")+"\\TempFolder\\Goku", "goku.txt");
			assertTrue(true);
		} catch (FileNotFoundException e) {
			Assertions.assertFalse(true,"no exceptions occured!!");
		} catch (IOException e) {
			
			Assertions.assertFalse(true,"no exceptions occured!!");
		}
	}
	
	@Test
	public void invalidCheck1() {
		DisplayHelper.ls(null);
		Assertions.assertTrue(false,"Invalid path passed");
		Assertions.assertFalse(true,"invalid data");
	}
	
	@Test
	public void invalidCheck2() {
		try {
			DisplayHelper.cat(System.getProperty("user.dir"), "goku.txt");
			Assertions.assertFalse(true,"invalid data");
		} catch (FileNotFoundException e) {
			assertTrue(false);
		} catch (IOException e) {
			assertTrue(false);
		}
		
		
	}
	
	
	
	@Test
	@AfterAll
	public void close() {
		System.out.println("closing test for display helper");
	}
}
