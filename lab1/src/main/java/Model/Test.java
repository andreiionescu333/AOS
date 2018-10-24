package Model;

import Repository.PersonRepository;

public class Test {
	public static void main(String[] args) {
		PersonRepository pRep = new PersonRepository();
		System.out.println(pRep.emailAvailable("asdasdasdasda@gmail.com"));
	}
}
