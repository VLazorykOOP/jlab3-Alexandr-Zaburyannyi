import java.util.Arrays;
import java.util.Objects;

interface Container1 {
    void sort();
    double norma();

    String toString();
    boolean equals(Object o);
    int hashCode();
}

class Bubble1 implements Container1 {
    private int[] elements1;

    public Bubble1(int[] elements1) {
        this.elements1 = elements1;
    }

    @Override
    public void sort() {
        boolean swapped1;
        int n1 = elements1.length;
        do {
            swapped1 = false;
            for (int i = 0; i < n1 - 1; i++) {
                if (elements1[i] > elements1[i + 1]) {
                    int temp1 = elements1[i];
                    elements1[i] = elements1[i + 1];
                    elements1[i + 1] = temp1;
                    swapped1 = true;
                }
            }
        } while (swapped1);
    }

    @Override
    public double norma() {
        int sum1 = 0;
        for (int el1 : elements1) {
            sum1 += el1;
        }
        return Math.sqrt(sum1);
    }

    @Override
    public String toString() {
        return Arrays.toString(elements1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bubble1 bubble1 = (Bubble1) o;
        return Arrays.equals(elements1, bubble1.elements1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(elements1));
    }
}

class Choice1 implements Container1 {
    private int[] elements1;

    public Choice1(int[] elements1) {
        this.elements1 = elements1;
    }

    @Override
    public void sort() {
        int n1 = elements1.length;
        for (int i = 0; i < n1 - 1; i++) {
            int maxIdx1 = i;
            for (int j = i + 1; j < n1; j++) {
                if (elements1[j] > elements1[maxIdx1]) {
                    maxIdx1 = j;
                }
            }
            int temp1 = elements1[maxIdx1];
            elements1[maxIdx1] = elements1[i];
            elements1[i] = temp1;
        }
    }

    @Override
    public double norma() {
        int sum1 = 0;
        for (int el1 : elements1) {
            sum1 += el1;
        }
        return (double) sum1 / elements1.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice1 choice1 = (Choice1) o;
        return Arrays.equals(elements1, choice1.elements1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(elements1));
    }
}

public class Task3 {
    public static void main(String[] args) {
        Container1[] containers1 = new Container1[2];

        containers1[0] = new Bubble1(new int[]{5, 1, 4, 2, 8});
        containers1[1] = new Choice1(new int[]{10, 3, 7, 2, 6});

        for (Container1 container1 : containers1) {
            System.out.println("Початкові елементи: " + container1.toString());
            container1.sort();
            System.out.println("Відсортовані елементи: " + container1.toString());
            System.out.println("Норма: " + container1.norma());
            System.out.println();
        }

        System.out.println("Контейнери рівні? " + containers1[0].equals(containers1[1]));
    }
}
