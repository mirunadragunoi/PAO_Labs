package lab3;

public class InMemoryUser extends User{
    // 2 campuri cu 2 vectori strings
    // 2 liste cu combinatii de username si parole valide
    private static final String[] validUsernames = {"ana", "ion", "alex", "maria"};
    private static final String[] validPasswords = {"pass123", "pass456", "pass789", "pass000"};

    // constructor
    public InMemoryUser(String username, String password) {
        super();   // apeleaza constructorul din User (deci inclusiv si generatedId)
        this.username = username;
        this.password = password;
    }

    // 2. login -->> verifica existenta variabilelor de instanta username si password in vectorii mentionati anterior
    @Override
    public void login() {
        for (int i = 0; i < validUsernames.length; i++){
            if (validUsernames[i].equals(this.username) && validPasswords[i].equals(this.password)){
                this.isAuthenticated = true;
                System.out.println("Login reusit pentru: " + username);
                return;
            }
        }
        this.isAuthenticated = false;
        System.out.println("Username sau parola incorecte!!");
    }

    // counter static pentru id urile unice
    private static int counter = 0;

    // 3. generateId se va implementa astfel incat id-ul generat sa fie unic pentru fiecare instanta a clasei
    @Override
    public void generateId() {
        this.id = ++counter;
    }

    // 4. suprascrie metoda toString() a clasei InMemoryUser astfel incat sa afiseze campul id
    @Override
    public String toString() {
        return "InMemoryUser{id=" + id + "}";
    }
}
