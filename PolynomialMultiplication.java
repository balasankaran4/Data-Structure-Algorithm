import java.util.*;
class PolyNode {
int coefficient;

int power;
PolyNode next;

PolyNode(int c, int p) {
coefficient = c;
power = p;
next = null;
}
}

public class PolynomialMultiplication {

public PolyNode multiplyPolynomials(PolyNode poly1, PolyNode poly2) {
if (poly1 == null || poly2 == null) return null;


TreeMap<Integer, Integer>map = new TreeMap<>(Collections.reverseOrder());

for (PolyNode p1 = poly1; p1 != null; p1 = p1.next) {
for (PolyNode p2 = poly2; p2 != null; p2 = p2.next) {
int newPower = p1.power + p2.power;
int newCoeff = p1.coefficient * p2.coefficient;
map.put(newPower, map.getOrDefault(newPower, 0) + newCoeff);
}
}


PolyNode dummy = new PolyNode(0, 0);
PolyNode current = dummy;

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
int coeff = entry.getValue();

int pow = entry.getKey();
if (coeff != 0) {
current.next = new PolyNode(coeff, pow);
current = current.next;
}
}

return dummy.next;
}


public void printPolynomial(PolyNode head) {
while (head != null) {
System.out.print(head.coefficient + "x^" + head.power);
if (head.next != null)
System.out.print(" +");
head = head.next;
}
System.out.println();
}

public static void main(String[] args) {
PolynomialMultiplication pm = new PolynomialMultiplication();

PolyNode poly1 = new PolyNode(2, 1);
poly1.next = new PolyNode(3, 0);

PolyNode poly2 = new PolyNode(4, 1);
poly2.next = new PolyNode(1, 0);

System.out.print("Poly1:");

pm.printPolynomial(poly1);

System.out.print("Poly2:");
pm.printPolynomial(poly2);

PolyNode result = pm.multiplyPolynomials(poly1, poly2);

System.out.print("Result (Poly1 * Poly2):");
pm.printPolynomial(result);
}
}
