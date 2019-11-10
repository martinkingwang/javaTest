package org.martin;

public class Test6 implements ITest{

	@Override
	public void run() {
        Solution6 solution = new Solution6();
		System.out.println(solution.convert("PAYPALISHIRING", 3));
		System.out.println(solution.convert2("A", 1));
	}
	

}