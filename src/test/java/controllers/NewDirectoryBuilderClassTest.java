package controllers;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import Controllers.NewDirectoryBuilderClass;

public class NewDirectoryBuilderClassTest {

	@Test
	@BeforeAll
	public void start() {
		System.out.println("Test started");
	}

	@Test
	@Before
	public void validCheckOfmkdir() {

		try {
			NewDirectoryBuilderClass.mkdir(System.getProperty("user.dir") + "\\TestFolder", "");
			Assertions.assertTrue(true);
			Assertions.assertFalse(false);
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true);
		}

		try {
			NewDirectoryBuilderClass.mkdir(System.getProperty("user.dir") + "\\TestFolder", "Goku Vegeta naruto");
			Assertions.assertFalse(false);

		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true);
		}

	}

	@Test
	public void invalidCheckOfmkdir1() {
		try {
			NewDirectoryBuilderClass.mkdir(null, null);
			Assertions.assertFalse(false);
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true);
		}

	}

	@Test
	public void invalidCheckOfmkdir2() {
		try {
			NewDirectoryBuilderClass.mkdir(null, "goku vegeta");
			Assertions.assertTrue(true);
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true);
		}

	}

	@Test
	public void invalidCheckOfmkdir3() {

		try {
			NewDirectoryBuilderClass.mkdir(System.getProperty("user.dir") + "\\vikram", "goku vegeta");
			Assertions.assertTrue(true);
		} catch (FileNotFoundException e) {
			Assertions.assertTrue(true);
		}

	}

	@Test
	@AfterAll
	public void close() {
		System.out.println("Closing test of New Builder Class");
	}
}
