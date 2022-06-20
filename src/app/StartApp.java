package app;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import core.ManagerDB;
import entity.Test;
import repository.TestRepository;
import services.TestServices;

public class StartApp {
	
	private TestServices service;
	
	public StartApp() {
		service = new TestServices(new TestRepository());
	}

	public static void main(String[] args) {
		
		StartApp app = new StartApp();
		
		app.guardar();
		
		app.listar();
		
		app.buscarPorId();
		
		app.actualizar();
		
		app.listar();
		
		app.eliminar();
		
		app.listar();
		
	}
	
	private void eliminar() {
		Test test = new Test("Test 1");
		test.setId(1L);
		service.delete(test);
		System.out.println("----------------------------------Eliminar-----------------------------");
		System.out.println();
		System.out.println();
		
	}

	private void guardar() {
		Test test = new Test("Test 1");
		test = service.save(test);
		
		System.out.println("----------------------------------Save-----------------------------");
		System.out.println(test);
		System.out.println();
		System.out.println();
	}
	
	private void listar(){
		Iterator<Test> testList =service.findAll();
		
		System.out.println("----------------------------------Lista-----------------------------");
		while(testList.hasNext()) {
			System.out.println(testList.next());
		}
		System.out.println();
		System.out.println();
	}

	private void buscarPorId() {
		Test testFind = service.findById(1L);
		System.out.println("----------------------------------Buscar por id-----------------------------");
		System.out.println(testFind);
		System.out.println();
		System.out.println();
	}
	
	private void actualizar() {
		Test testUpOld = new Test("Test update");
		Test testUp = service.update(1L, testUpOld);
		System.out.println("----------------------------------Update-----------------------------");
		System.out.println(testUp);
		System.out.println();
		System.out.println();
	}
	
}
