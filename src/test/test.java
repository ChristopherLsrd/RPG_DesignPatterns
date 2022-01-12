package test;

import main.personnage.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @Test
	void testEtatMort(){
		Personnage personnage=new Guerrier(new CreateWarrior());
		Personnage personnage1=new Sorcier(new CreateMage());
		personnage.setAttaque(200);
		personnage.setProbaAttack(1);
		personnage.attack(personnage1);
		String etat=personnage1.getEtat().getClass().getSimpleName();
		assertEquals("EtatMort",etat);
	}

	@Test
	void testEtatAgonie(){
		Personnage personnage=new Guerrier(new CreateWarrior());
		Personnage personnage1=new Sorcier(new CreateMage());
		personnage.setAttaque(90);
		personnage.setProbaAttack(1);
		personnage.attack(personnage1);
		String etat=personnage1.getEtat().getClass().getSimpleName();
		assertEquals("EtatAgonie",etat);
	}

	@Test
	void testEtatAgonieversEtatVivant(){
		Personnage personnage=new Guerrier(new CreateWarrior());
		Personnage personnage1=new Sorcier(new CreateMage());
		personnage.setAttaque(90);
		personnage.setProbaAttack(1);
		personnage.attack(personnage1);
		String etat=personnage1.getEtat().getClass().getSimpleName();
		assertEquals("EtatAgonie",etat);
		personnage1.heal();
		etat=personnage1.getEtat().getClass().getSimpleName();
		assertEquals("EtatVivant",etat);
	}

	@Test
	void testFactory(){
		CreateWarrior cw=new CreateWarrior();
		String desc=cw.addChest().getDescription();
		assertEquals(desc,"Une armure solide");
	}

	@Test
	void testregenMana(){
		Personnage personnage=new Guerrier(new CreateWarrior());
		double mana=personnage.getMana()+20;
		personnage.regenMana();
		assertEquals(mana,personnage.getMana());
	}



}
