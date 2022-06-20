package services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import core.CrudRepository;
import core.CrudRepositoryJPA;
import core.ManagerDB;
import entity.Test;
import repository.TestRepository;

public class TestServices {

	private CrudRepository repository;

	public TestServices(CrudRepository repository) {
		this.repository = repository;
		this.repository.setEm(ManagerDB.getEntityManager());
	}

	public Iterator<Test> findAll() {
		return (Iterator<Test>) repository.findAll().iterator();
	}

	public Test save(Test test) {
		return (Test) repository.create(test);
	}

	public Test findById(Long id) {
		return (Test) repository.find(id);
	}

	public Test update(Long id, Test test) {
		test.setId(id);
		return (Test) repository.update(test);
	}

	public void delete(Test test) {
		repository.delete(test);
	}

}
