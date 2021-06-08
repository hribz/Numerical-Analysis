import sys

from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = sympify(str_expr)
f = lambdify(x, expr, 'numpy')
derivation = diff(expr, x)
df = lambdify(x, derivation, 'numpy')

print(round(f(float(sys.argv[2])), 9))
print(round(df(float(sys.argv[2])), 9))




