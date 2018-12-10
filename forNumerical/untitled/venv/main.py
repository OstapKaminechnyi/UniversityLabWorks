import math
from numpy import arange
import matplotlib.pyplot as plt

C1 = 0.3 * 10 ** (-6)
C2 = 0.5 * 10 ** (-6)
C3 = 0.1 * 10 ** (-6)




R1 = 150
R2 = 25
R3 = 90

T = 0
step = 0.00001
a = 0.002

Uc1 = 0
Uc2 = 0
Uc3 = 0

Uc1_new = 0
Uc2_new = 0
Uc3_new = 0


def dUc1(Uc1, Uc2, Uc3):
    tmp = (calc_i1(Uc1, Uc2, Uc3)) / C1
    return tmp


def dUc2(Uc1, Uc2, Uc3):
    tmp = calc_i3(Uc1, Uc2, Uc3) / C2
    return tmp


def dUc3(Uc1, Uc2, Uc3):
    tmp = (calc_i3(Uc1, Uc2, Uc3) - Uc3 / R4) / C3
    return tmp


def calc_i2(Uc1, Uc2, Uc3):
    return ((U1 - Uc2) * (R2 / R1) + Uc2 + Uc3) / (R3 + (R2 / R1) * (R3 + R1))


def calc_i1(Uc1, Uc2, Uc3):
    return (U1 - Uc1 - calc_i2(Uc1, Uc2, Uc3) * R3) / R1


def calc_i3(Uc1, Uc2, Uc3):
    return calc_i1(Uc1, Uc2, Uc3) + calc_i2(Uc1, Uc2, Uc3)


def trapezoid_method(t):
    global Uc1, Uc2, Uc3, Uc1_new, Uc2_new, Uc3_new, U2

    Uc1_new = Uc1 + step / 2 * (dUc1(Uc1_new, Uc2_new, Uc3_new) + dUc1(Uc1, Uc2, Uc3))
    Uc2_new = Uc2 + step / 2 * (dUc2(Uc1_new, Uc2_new, Uc3_new) + dUc2(Uc1, Uc2, Uc3))
    Uc3_new = Uc3 + step / 2 * (dUc3(Uc1_new, Uc2_new, Uc3_new) + dUc3(Uc1, Uc2, Uc3))

    Uc1 = Uc1_new
    Uc2 = Uc2_new
    Uc3 = Uc3_new
    U2 = Uc3

    # plt.plot(t, Uc1, 'ro')
    # plt.plot(t, Uc2, 'ro')
    # plt.plot(t, Uc3, 'ro')ro
    plt.plot(t, U2, 'ro')


if __name__ == '__main__':

    for i in range(5):
        start = T
        end = start + a
    for t in arange(start, end, step):
        U1 = 5000 * (t - 6 * a * i)
        # plt.plot(t, U1, 'ro')
        trapezoid_method(t)

    start = T + a
    end = start + a
    for t in arange(start, end, step):
        U1 = 10
        # plt.plot(t, U1, 'ro')
        trapezoid_method(t)

    start = T + 2 * a
    end = start + a
    for t in arange(start, end, step):
        U1 = 10 - (5000 * (t - 2 * a - 6 * a * i))
        # plt.plot(t, U1, 'ro')
        trapezoid_method(t)

    start = T + 3 * a
    end = start + 3 * a
    for t in arange(start, end, step):
        U1 = 0
        # plt.plot(t, U1, 'ro')
        trapezoid_method(t)

    T += 6 * a

    # plt.ylabel(r'$U1$')
    # plt.ylabel(r'$Uc1$')
    # plt.ylabel(r'$Uc2$')
    # plt.ylabel(r'$Uc3$')
    plt.ylabel(r'$U2$')
    plt.xlabel(r'$t$')

    plt.grid(True)
    plt.show()
