package cn.rain.character1.calculator;

/**
 * 定义一个加、减、乘、除的计算器接口
 */
public interface ArithmeticCalculator {

	/** 加法 */
	int add(int i, int j);
	/** 减法 */
	int sub(int i, int j);
	/** 乘法 */
	int mul(int i, int j);
	/** 除法 */
	int div(int i, int j);
}
