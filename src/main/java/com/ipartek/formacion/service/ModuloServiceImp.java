package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.ModuloException;

public class ModuloServiceImp implements ModuloService{
	private List<Modulo> modulos;
	private static int i=0;
	
	private void init(){
		Modulo modulo=new Modulo();
		//modulo.setCodigo(i);
		modulo.setNombre("Programación Java");
		createModulo(modulo);
	}
	
	public ModuloServiceImp(){
		this.modulos=new ArrayList<Modulo>();
		init();
	}

	@Override
	public Modulo createModulo(Modulo modulo) {	//equivalente al insert SQL
		modulo.setCodigo(i);
		modulos.add(modulo);
		i++;
		return modulo;
	}

	@Override
	public Modulo getById(int codigo) {
		Modulo modulo=null;	//o directamente Modulo modulo=modulos.get(getIndex(codigo));
		modulo=new Modulo();
		try {
			modulo=modulos.get(getIndex(codigo));
		} catch (ModuloException e) {
			// modulo=new Modulo(); para evitar nulls
			e.printStackTrace();
		}
		return modulo;
	}

	@Override
	public void delete(int codigo) {
		try {
			this.modulos.remove(getIndex(codigo));
		} catch (ModuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Modulo> getAll() {
		return this.modulos;
	}

	@Override
	public Modulo update(Modulo modulo) {
		try {
			this.modulos.add(getIndex(modulo.getCodigo()),modulo);
		} catch (ModuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modulo;
	}
	
	private int getIndex(int codigo) throws ModuloException{
		int index=-1;
		int i=0;
		boolean found=false;
		while(i<modulos.size()&&found==false){
			Modulo aux=modulos.get(i);
			if(aux.getCodigo()==codigo){
				found=true;
				index=i;
			}
			if(index==-1){
				throw new ModuloException(ModuloException.CODIGO_ERROR_FECHA_NACIMIENTO,ModuloException.MSG_ERROR_FECHA_NACIMIENTO);
			}
			i++;
		}
		return index;
	}

}
