package de.unistuttgart.iste.sqa.pse.sheet10.presence.scopes;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import java.util.List;
import java.util.function.Consumer;

/**
 * A hamster game where every hamster is paule.
 */
public class WeAreAllPauleHereHamsterGame extends SimpleHamsterGame {

	private final Hamster paule;

	/**
	 * Create a new hamster game.
	 */
	public WeAreAllPauleHereHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();

		this.game.startGame();

		this.paule = new Hamster(game.getTerritory(), Location.from(3, 1), Direction.EAST, 0);
	}

	@Override
	protected void run() {
		Consumer<Hamster> consumer = (Hamster paule) -> {
			paule.move();
			this.paule.move();
		};
		List<Hamster> paules = List.of(new Hamster(game.getTerritory(), Location.from(5, 1), Direction.EAST, 0));

		paule.move();
		for (Hamster paule : paules) {
			paule.move();
		}
		paule.move();

		final Hamster paule = paules.get(0);
		paule.move();

		this.paule.move();
		super.paule.move();

		doMovement();
		doMovement(paule);

		consumer.accept(paule);
	}

	/**
	 * Moves {@code paule} two steps ahead.
	 *
	 * For each step, the tile in front of {@code paule} must be empty.
	 */
	private void doMovement() {
		paule.move();
		this.paule.move();
	}

	/**
	 * Move the hamster one step ahead.
	 *
	 * For each step, the tile in front of {@code paule} must be empty.
	 *
	 * @param paule hamster to be moved.
	 */
	private void doMovement(final Hamster paule) {
		paule.move();
		this.paule.move();
	}
}
