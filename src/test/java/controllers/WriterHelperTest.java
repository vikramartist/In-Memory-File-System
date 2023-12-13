package controllers;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import Controllers.WriterHelper;

public class WriterHelperTest {

	@Test
	@BeforeAll
	public void start() {
		System.out.println("Test started for the writer helper class");
	}
	
	@Test
	public void validCheck1() {
		try {
			WriterHelper.echo(System.getProperty("user.dir")+"\\TestFolder\\Goku","goku.txt" , "hi i am vikram pai v from begaluru, hello goku\n");
			Assertions.assertTrue(true);
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true,"No exception occured, valid");
		}
	}
	
	@Test
	public void invalidCheck() {
		try {
			WriterHelper.echo(null,null , "hi i am vikram pai v from begaluru, hello goku\n");
			Assertions.assertTrue(false);
			Assertions.assertFalse(true,"Invalid data passed");
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true,"exception occured, Invalid");
		}
	}
	
	@Test
	public void invalidFilePath() {
		try {
			WriterHelper.echo(System.getProperty("user.dir")+"\\Goku",null , "hi i am vikram pai v from begaluru, hello goku\n");
			Assertions.assertTrue(false);
			Assertions.assertFalse(true,"Invalid data passed");
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true,"exception occured, Invalid");
		}
	}
	
	@Test
	public void noTextPassed() {
		try {
			WriterHelper.echo(null,null,null);
			Assertions.assertTrue(false);
			Assertions.assertFalse(true,"Invalid data passed");
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(false,"exception occured, Invalid");
			Assertions.assertFalse(true);
		}
	}
	
	@Test
	@AfterAll
	public void close() {
		System.out.println("Closing test of writer helper class");
	}
}
