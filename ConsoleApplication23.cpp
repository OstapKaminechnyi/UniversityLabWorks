#include "stdafx.h"
#include <iostream>
#include <cstdlib>
#include <vector>
#include <cstdio>
#include <math.h>
#include <conio.h>

using namespace std;
const short N = 5;

class Matrix
{
	int matrix[N][N];
private:
	int i, j;
	vector<int> GeometricAverage;
public:
	void ReadFromConsole();
	void PrintToConsole();
	void MakeGeometricMean();
	void SelectionSort(int column);
};

void Matrix::ReadFromConsole() 
{
	cout << "Write matrix:" << endl;

	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) {
			cin >> matrix[i][j];
		}
	}

	cout << "\n\nPrevious matrix:" << endl;

	for (i = 0; i < N; i++, cout << endl) 
	{
		for (j = 0; j < N; j++)
		{
			printf("%5d ", matrix[i][j]);
		}
	}
}

void Matrix::SelectionSort(int column)
{
		for (i = 0; i < N; i++)
	{
		int Biggest = matrix[i][column]; int Position = i;

		for (j = i; j < N; j++)
		{
			if (matrix[j][column] < Biggest) 
			{
				Biggest = matrix[j] [column];
				Position = j;
			}
		}
		swap(matrix[i][column], matrix[Position][column]);
	}
}

void Matrix::MakeGeometricMean()
{
	double Sum = 0;
	double GeometricMean;
	int j, i;
	double Counter = 0;
	for (i = 0; i < N - 1; i++)
	{
		Counter = 0;
		int Product = 1;
		for (j = 0; j < N; j++)
		{
			if (i < j)
			{
				Product *= matrix[i][j];
				Counter++;
			}
		}
		GeometricMean = pow(fabs(Product), 1.0 / Counter);
		cout << "\nGeometric mean: " << GeometricMean << endl;
		Sum += GeometricMean;
	
	}
	cout << "Sum:" << Sum << endl;
}

void Matrix::PrintToConsole()
{
	cout << endl << "Sorted matrix:" << endl;

	for (i = 0; i < 5; i++, cout << endl)
	{
		for (j = 0; j < 5; j++) 
		{
			printf("%5d ", matrix[i][j]);
		}
	}
}


int main()
{
	Matrix A;

	A.ReadFromConsole();
	for (int column = 0; column < N; column++)
	{
		A.SelectionSort(column);
	}
	A.PrintToConsole();
	A.MakeGeometricMean();
	
	_getche();
	return 0;
}