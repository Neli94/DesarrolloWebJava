package com.ipartek.formacion.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.pojo.exception.DniException;

import junit.framework.Assert;

public class UtilTest {
	private String dni=null;
	private List<String> dnis=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dni="78889321X";
		dnis=new ArrayList<String>();
		dnis.add("dni");
		
		for(int i=0;i<6;i++){
			dni=i+"8889321X";
			dnis.add(dni);
		}
	}

	@After
	public void tearDown() throws Exception {
		dni=null;
	}

	@Test
	public void testValidarDni() {
		for(String aux: dnis){
			try {
				Assert.assertEquals("",Util.validarDni(aux), false);
			} catch (CandidatoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*try {
			if(Util.validarDni(dni)){
				
			}else{
				fail("Error DNI");
			}
		} catch (DniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
