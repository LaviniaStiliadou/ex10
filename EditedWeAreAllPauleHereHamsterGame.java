package de.unistuttgart.iste.sqa.pse.sheet10.presence.scopes;

import java.util.List;
import java.util.function.Consumer;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A hamster game where every hamster is paule.
 */
public class WeAreAllPauleHereHamsterGame extends SimpleHamsterGame {

	private final Hamster annie;

	/**
	 * Create a new hamster game.
	 */
	public WeAreAllPauleHereHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		
		this.game.startGame();
		
		this.annie = new Hamster(game.getTerritory(), Location.from(3,1), Direction.EAST, 0);
	}


	@Override
	protected void run() {	
		Consumer<Hamster> consumer = (Hamster hamster) -> {hamster.move(); this.annie.move();};
		List<Hamster> paules = List.of(new Hamster(game.getTerritory(), Location.from(5, 1), Direction.EAST, 0));

		annie.move();
		for (Hamster hamster : paules) {
			hamster.move();
		}
		annie.move();
		
		final Hamster firstHamster = paules.get(0);
		firstHamster.move();
		
		this.annie.move();
		super.paule.move();
		
		doMovement();
		doMovement(firstHamster);

		consumer.accept(firstHamster);
	}
	
	/**
	 * Moves {@code paule} two steps ahead.
	 * 
	 * For each step, the tile in front of {@code paule} must be empty.
	 */
	private void doMovement() {
		annie.move();
		this.annie.move();
	}

	/**
	 * Move the hamster one step ahead.
	 * 
	 * For each step, the tile in front of {@code paule} must be empty.
	 * 
	 * @param hamster hamster to be moved. 
	 */
	private void doMovement(final Hamster hamster) {
		hamster.move();
		this.annie.move();
	}
}
