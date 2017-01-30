package main;

import java.util.*;

public class LTVData {
	/*
	 * LTVData class contains variables related to LTV Calculation for a specific customer
	 * m_visitCountByWeek is an array containing the visitCount by week
	 * m_expenseByWeek is an array containing the accumulated customer expense by week
	 */
	private int[] m_visitCountByWeek;
	private double[] m_expenseByWeek;
	private static final int numOfWeeks = 52;		// currently this program can only analyze the data within one year
	private static final int averageLifespan = 10;

	LTVData(){
		m_visitCountByWeek = new int[numOfWeeks];
		m_expenseByWeek = new double[numOfWeeks];
	}

	public int getM_visitCountByWeek(int index) {
		return m_visitCountByWeek[index];
	}

	public void setM_visitCountByWeek(int index, int count) {
		this.m_visitCountByWeek[index] = count;
	}

	public double getM_expenseByWeek(int index) {
		return m_expenseByWeek[index];
	}

	public void setM_expenseByWeek(int index, double expense) {
		this.m_expenseByWeek[index] = expense;
	}

	public static int getNumofweeks() {
		return numOfWeeks;
	}

	public static int getAveragelifespan() {
		return averageLifespan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(m_expenseByWeek);
		result = prime * result + Arrays.hashCode(m_visitCountByWeek);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LTVData other = (LTVData) obj;
		if (!Arrays.equals(m_expenseByWeek, other.m_expenseByWeek))
			return false;
		if (!Arrays.equals(m_visitCountByWeek, other.m_visitCountByWeek))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LTVData [m_visitCountByWeek=" + Arrays.toString(m_visitCountByWeek) + ", m_expenseByWeek="
				+ Arrays.toString(m_expenseByWeek) + "]";
	}
	
	
}
