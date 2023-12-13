package controllers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import Controllers.DirectoryChangeHelper;

public class DirectoryChangeHelperTest {

	@Test
	@BeforeAll
	public void start() {
		System.out.println("Test started for change directory");
	}
	
	
	@Test
	public void validCheck1() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "D:/", "goku");
			assertTrue(true);
		} catch (FileNotFoundException e) {
			assertTrue(false,"no exceptions");
		}
	}
	
	@Test
	public void validCheck2() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "D:\\Colt steele web developer bootcamp\\", "goku");
			assertTrue(true);
		} catch (FileNotFoundException e) {
			assertTrue(false,"no exceptions");
		}
	}
	
	@Test
	public void validCheck3() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "../", "goku");
			assertTrue(true);
		} catch (FileNotFoundException e) {
			assertTrue(false,"no exceptions");
		}
	}
	
	@Test
	public void validCheck4() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "/", "goku");
			assertTrue(true);
		} catch (FileNotFoundException e) {
			assertTrue(false,"no exceptions");
		}
	}
	
	@Test
	public void invalidCheck1() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "", "goku");
			assertFalse(true);
		} catch (FileNotFoundException e) {
			assertFalse(true,"exception occured");
		}
	}
	
	@Test
	public void invalidCheck2() {
		try {
			DirectoryChangeHelper.cd(System.getProperty("user.dir"), "", "");
			assertFalse(true);
		} catch (FileNotFoundException e) {
			assertFalse(true,"exception occured");
		}
	}
	
	@Test
	public void invalidCheck3() {
		try {
			DirectoryChangeHelper.cd("", "", "goku");
			assertFalse(true);
		} catch (FileNotFoundException e) {
			assertFalse(true,"exception occured");
		}
	}
	
	
	@Test
	@AfterAll
	public void close() {
		System.out.println("closing test for change directory");
	}
}
