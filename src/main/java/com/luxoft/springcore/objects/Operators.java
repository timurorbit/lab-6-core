package com.luxoft.springcore.objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service("operatorsBean")
public class Operators {
	
	private boolean ageComparisonTest;
	private boolean distanceComparisonTest;
	
	public boolean isAgeComparisonTest() {
		return ageComparisonTest;
	}

	@Value("true")
	public void setAgeComparisonTest(boolean ageComparisonTest) {
		this.ageComparisonTest = ageComparisonTest;
	}

	public boolean isDistanceComparisonTest() {
		return distanceComparisonTest;
	}

	@Value("true")
	public void setDistanceComparisonTest(boolean distanceComparisonTest) {
		this.distanceComparisonTest = distanceComparisonTest;
	}

}
