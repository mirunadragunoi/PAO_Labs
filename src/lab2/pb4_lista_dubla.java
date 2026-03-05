package lab2;

public class pb4_lista_dubla {
    // nodul listei
    static class node {
        int value;
        node prev, next;

        node(int value) {
            this.value = value;
        }
    }

    private node head;   // capul listei
    private node tail;   // capatul, coada listei
    private int size;

    // metoda statica pt a returna capul listei
    public static node CapLista(pb4_lista_dubla list){
        return list.head;
    }

    // addLast - primeste un int si adauga un nod la finalul listei
    // returneaza o referinta catre nodul nou creat
    public node addLast(int value) {
        node newnode = new node(value);

        if (head == null) {
            head = tail = newnode;
        }
        else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        size ++;
        return newnode;
    }

    // addFirst - primeste un int si adauga un nod la inceputul listei
    // referinta catre noul nod creat
    public node addFirst(int value) {
        node newnode = new node(value);

        if (head == null) {
            head = tail = newnode;
        }
        else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        size ++;
        return newnode;
    }

    // addAtIndex - adauga la un indez in lista un nou nod cu val primita
    // ca parametru
    public void addAtIndex(int index, int value) {
        if (index <= 0) { addFirst(value); return; }
        if (index >= size) { addLast(value); return; }

        node newnode = new node(value);
        node current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.next;

        newnode.next = current.next;
        newnode.prev = current;
        if (current.next != null) current.next.prev = newnode;
        current.next = newnode;
        size++;
    }

    // metoda fara parametrii size pt dimensiunea listei
    public int size() {
        return size;
    }

    // metoda find care vf daca o valoare numerica exista in lista
    public boolean find(int value) {
        node curent = head;
        while (curent != null) {
            if (curent.value == value) return true;
            curent = curent.next;
        }
        return false;
    }

    // metoda remove care pt un parametru dat elimina toate nodurile
    // din lista cu aceeasi valoare
    public void remove(int value) {
        node curent = head;
        while (curent != null) {
            if (curent.value == value) {
                if (curent.prev != null) curent.prev.next = curent.next;
                else head = curent.next;
                if (curent.next != null) curent.next.prev = curent.prev;
                else tail = curent.prev;
                size--;
            }
            curent = curent.next;
        }
    }

    // metoda sort care va sorta elementele listei cresc si va returna noul cap
    public node sort() {
        if (head == null) return null;
        boolean move;
        do {
            move = false;
            node curent = head;
            while (curent.next != null) {
                if (curent.value > curent.next.value) {
                    int temp = curent.value;
                    curent.value = curent.next.value;
                    curent.next.value = temp;
                    move = true;
                }
                curent = curent.next;
            }
        } while (move);
        return head;
    }

    // metoda pt print lista
    public void print() {
        node curent = head;
        while (curent != null) {
            System.out.print(curent.value + " ");
            curent = curent.next;
        }
        System.out.println();
    }

    /*
    // constructorul de copiere
    public pb4_lista_dubla(pb4_lista_dubla original) {
        node curent = original.head;
        while(curent != null) {
            this.addLast(curent.value);
            curent = curent.next;
        }
    }*/

    // main ul pentru testare
    public static void main(String[] args) {
        pb4_lista_dubla lista = new pb4_lista_dubla();
        lista.addLast(3);
        lista.addLast(1);
        lista.addLast(4);
        lista.addFirst(0);
        lista.addAtIndex(2, 99);
        lista.print();

        System.out.println("size lista: " + lista.size());
        System.out.println("find 99: " + lista.find(99));

        lista.remove(99);
        lista.print();

        lista.sort();
        lista.print();

        /*
        pb4_lista_dubla copie = new pb4_lista_dubla(lista);
        node capcopie = copie.head;

        copie.print();
        */
    }
}
