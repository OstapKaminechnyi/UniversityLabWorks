#include <stdio.h>
#include "stdafx.h"
#include <math.h>
#include <conio.h>

int main() {
	double a, b, h, d, x, sum;
	int k;
	double result;
	printf("a = ");
	scanf_s("%lf", &a);

	printf("b = ");
	scanf_s("%lf", &b);

	printf("h = ");
	scanf_s("%lf", &h);

	printf("d = ");
	scanf_s("%lf", &d);

	printf("result= ");
	for (x = a; x <= b; x += h)
	{

		k = 2;
		sum = 0;

		do
		{
			result = (pow(-1, k)*k) / (pow(k, 2) - 1) * sin(k*x);
			sum += result;
			k++;
		} while (fabs(result) > d);
		printf("x=%lf sum=%lf result=%lf\n", x, sum, result);
	}

	_getch();
	return 0;
}