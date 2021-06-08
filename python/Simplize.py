import sys

from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = expand(str_expr)

print(expr)



