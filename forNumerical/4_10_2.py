import math


def method(f, a, b, n):
    print("\nPartition: ", n)
    h = (b-a)/float(n)
    print("Step:", h)
    total = sum([f((a + (k*h))) for k in range(0, n)])
    result = h * total
    print("Result: ", result)
    return result


def f(x):
    return x*math.exp(3*x)

print("Right Rectangles")
print("f(x) = x*math.exp(3*x)")
print("Accuracy: 0.001")

integral = method(f, 1, 2, 90)

def check(x):
    f = (math.exp(3*x)/9)*(3*x -1)
    return f

print("\nSolution:", integral, "\nPartitions:", 90)

print("\nCheck result:", check(2)-check(1))