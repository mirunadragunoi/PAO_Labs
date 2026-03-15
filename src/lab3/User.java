package lab3;

public abstract class User {
    // campurile clasei ->> punctul a
    protected String username;
    protected String password;
    protected Boolean isAuthenticated;
    protected Integer id;

    // metodele abstracte -->> punctul b
    public abstract void generateId();
    public abstract void login();

    // isLoggedIn returneaza true/false daca userul s a logat
    public boolean isLoggedIn() {
        return isAuthenticated;
    }

    // equals suprascris ->> 2 instante sunt egale daca au acleasi id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof User)) return false;
        User other = (User) obj;
        return this.id.equals(other.id);
    }

    // constructor fara parametrii al clasei User ce initializeaza id apeland metoda generateId()
    public User() {
        this.isAuthenticated = false;
        generateId();    // initializeaza id-ul
    }
}
