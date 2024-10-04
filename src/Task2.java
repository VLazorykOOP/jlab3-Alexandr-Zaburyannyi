import java.util.Arrays;
import java.util.Objects;

abstract class Container {
    protected int[] elements;

    public Container(int[] elements) {
        this.elements = elements;
    }

    public abstract void sort();
    public abstract double norma();

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Arrays.equals(elements, container.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(elements));
    }
}

class Bubble extends Container {

    public Bubble(int[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        boolean swapped;
        int n = elements.length;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    int temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
    public double norma() {
        int sum = 0;
        for (int el : elements) {
            sum += el;
        }
        return Math.sqrt(sum);
    }
}

class Choice extends Container {

    public Choice(int[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (elements[j] > elements[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = elements[maxIdx];
            elements[maxIdx] = elements[i];
            elements[i] = temp;
        }
    }

    @Override
    public double norma() {
        int sum = 0;
        for (int el : elements) {
            sum += el;
        }
        return (double) sum / elements.length;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Container[] containers = new Container[2];

        containers[0] = new Bubble(new int[]{5, 1, 4, 2, 8});
        containers[1] = new Choice(new int[]{10, 3, 7, 2, 6});

        for (Container container : containers) {
            System.out.println("Початкові елементи: " + container.toString());
            container.sort();
            System.out.println("Відсортовані елементи: " + container.toString());
            System.out.println("Норма: " + container.norma());
            System.out.println();
        }

        System.out.println("Контейнери рівні? " + containers[0].equals(containers[1]));
    }
}
