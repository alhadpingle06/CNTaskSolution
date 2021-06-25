package com.wired.get.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.wired.get.utils.Utils;

/**
 * @author Alhad.Pingle
 * This class is meant to enable the @Test methods execution as per the preferences set by the tester in "src\test\resources\
 * TestConfig\TestExecutor.xlsx" for the desired test suite
 * 
 *
 */
public class AnnotationTest implements IAnnotationTransformer {

	/* (non-Javadoc)
	 * @see org.testng.IAnnotationTransformer#transform(org.testng.annotations.ITestAnnotation, java.lang.Class, java.lang.reflect.Constructor, java.lang.reflect.Method)
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,Constructor testConstructor, Method testMethod) {

		ArrayList<String> testCaseNames = Utils.getExecutableTestCases();

		Iterator<String> iterator = testCaseNames.iterator();
		while (iterator.hasNext()) {

			if (iterator.next().contains(annotation.getTestName())){
				annotation.setEnabled(true);

			}

		}

	}

}