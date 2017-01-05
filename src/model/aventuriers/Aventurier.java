package model.aventuriers;

import model.cartes.CarteTirage;
import java.util.*;
import model.ObjetIdentifie;
import model.cases.Tuile;

public abstract class Aventurier extends ObjetIdentifie {

	Tuile position;
	Collection<CarteTirage> cartesEnMain;
}