package model;

public class MySet<E> implements SimpleSet<E> {

    private Object[] set = new Object[0];


    public boolean add(E e) {
        addNewIndex();
        set[set.length - 1] = e;
        return true;
    }

    public void addNewIndex() {
        Object[] backing = new Object[set.length];
        for (int i = 0; i < set.length; i++) {
            backing[i] = set[i];
        }
        int sizeArray = set.length;
        set = new Object[sizeArray + 1];
        for (int i = 0; i < set.length - 1; i++) {
            set[i] = backing[i];
        }
    }

    public E remove(E e) throws ElementDoesNotExistException {
        if (contains(e)) {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == e) {

                    Object removedObject = set[i];

                    Object[] backing = new Object[set.length - 1];
                    for (int j = 0; j < i; j++) {
                        backing[j] = set[j];
                    }

                    for (int k = i + 1; i < backing.length; k++) {
                        backing[k] = set[k];
                    }

                    return ((E) removedObject);

                }
            }
        } else {
            throw new ElementDoesNotExistException("Element not in array");
        }
        return null;
    }

    public boolean contains(E e) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] == e) {
                return true;
            }
        }
        return false;
    }

    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        boolean containsThem = true;
        for (int i = 0; i < set.length; i++) {
            if (!(contains(e[i]))) {
                containsThem = false;
                throw new ElementDoesNotExistException("An element in the array"
                    + "was not found");
            }
        }

        if (containsThem) {
            for (int j = 0; j < set.length; j++) {
                remove(e[j]);
                j--;
            }
        }
        return e;
    }

    public void clear() {
        set = new Object[0];
    }


    public int size() {
        return set.length;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public E getRandomElement() throws ElementDoesNotExistException {
        if (isEmpty()) {
            throw new ElementDoesNotExistException("There are no elements.");
        } else {
            int randomNum = ((int) (set.length * Math.random() + 1));
            return ((E) set[randomNum]);
        }
    }

    public E[] toArray() {
        return ((E[]) set);
    }

    @Override
    public String toString() {
        String returned = "";
        for (int i = 0; i < set.length; i++) {
            returned = returned + set[i].toString();
        }
        return returned;
    }

}