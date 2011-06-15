/*
 * Copyright (C) 2010 Saarland University
 * 
 * This file is part of the GA library.
 * 
 * GA is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Lesser Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * GA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser Public License along with
 * GA. If not, see <http://www.gnu.org/licenses/>.
 */

package de.unisb.cs.st.evosuite.ga.stoppingconditions;

import de.unisb.cs.st.evosuite.Properties;
import de.unisb.cs.st.evosuite.ga.GeneticAlgorithm;

/**
 * Stop search after a predefined amount of time
 * 
 * @author Gordon Fraser
 * 
 */
public class MaxTimeStoppingCondition extends StoppingCondition {

	/** Maximum number of seconds */
	protected int max_seconds = Properties.GENERATIONS;

	protected long start_time;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.unisb.cs.st.evosuite.ga.StoppingCondition#getCurrentValue()
	 */
	@Override
	public int getCurrentValue() {
		long current_time = System.currentTimeMillis();
		return (int) ((current_time - start_time) / 1000);
	}

	@Override
	public int getLimit() {
		return max_seconds;
	}

	/**
	 * We are finished when the time is up
	 */
	@Override
	public boolean isFinished() {
		long current_time = System.currentTimeMillis();
		return (current_time - start_time) / 1000 > max_seconds;
	}

	/**
	 * Reset
	 */
	@Override
	public void reset() {
		start_time = System.currentTimeMillis();
	}

	@Override
	public void searchStarted(GeneticAlgorithm algorithm) {
		start_time = System.currentTimeMillis();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.unisb.cs.st.evosuite.ga.StoppingCondition#setLimit(int)
	 */
	@Override
	public void setLimit(int limit) {
		max_seconds = limit;
	}

}
