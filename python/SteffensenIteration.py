import sys

from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = sympify(str_expr)
f = lambdify(x, expr, 'numpy')

x0 = float(sys.argv[2])
Accuracy = float(sys.argv[3])
c = 0.0
times = 0

preX = x0
error = 10000
print('          x                f(x)')
while error > Accuracy:
    print('%d  %.6f  %.6f' % (times, preX, x0))
    y0 = f(preX)
    z0 = f(y0)
    x0 = preX - (y0 - preX)*(y0 - preX)/(z0 - 2*y0 +preX)
    preError = error
    error = abs((x0 - preX) / x0)
    if error > preError:
        print('error')
        break
    times = times + 1
    preX = x0
print(round(x0, 9))
print(times)
