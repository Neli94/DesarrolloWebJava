package com.ipartek.formacion.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Alumno;

import junit.framework.Assert;

public class AlumnoServiceImpTest {
	private List<Alumno>alumnos=null;
	private AlumnoService aService=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Alumno alum=null;
		alum=new Alumno();
		alum.setCodigo(1);
		alum.setNombre("Neli");
		alum.setApellidos("Gonzalez Martinez");
		alum.setNota(8.0);
		
		aService=new AlumnoServiceImp();
	}

	@After
	public void tearDown() throws Exception {
		alumnos=null;
		aService=null;
	}

	@Test
	public void testAlumnoServiceImp() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateAlumno() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		Assert.assertEquals("", aService.getAll());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
