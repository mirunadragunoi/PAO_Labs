package lab11.part2;

import java.util.List;

public interface ProductDao {
    /* insereaza in baza de date un produs al carei date vin prin parametrul 'product' si returneaza un obiect product cu id-ul setat de catre baza de date precum si celelalte
     */
    Product create(Product product);

    /*
    intoarce inapoi din baza de date toate produsele sub forma unei liste
     daca nu exista nici un produs se va returna o lista goala
     */
    List<Product> findAll();


    /*
    intoarce din baza de date un produs cu id-ul dat
    daca nu exista  nici un produs cu id-ul respectiv se va arunca o exceptie custom
     */
    Product findById(int id);



    /*
     * returneaza toate produsele din baza care au aceasta categorie
     * daca nu exista nici un produs se va returna o lista goala
     */
    List<Product> findByCategory(String category);


    /*
     pentru produsul cu id-ul dat updateaza pretul si stocul
    Va returna true in caz ca update-ul a reusit, altfel false
     */
    boolean updatePriceAndStock(int id, double price, int stock);


    /*
    sterge din baza produsul cu id-ul dat ca parametru
  Va returna true in caz ca delete-ul a reusit, altfel false
     */
    boolean deleteById(int id);

}
