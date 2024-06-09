/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfs;


/**
 *
 * @author Ada Arellano
 */
public class ListaDoble<T> {

    private NodoDoble pFirst;
    private NodoDoble pLast;
    private int size;
    private int maxsize;
    

    public ListaDoble() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        this.maxsize = 16;
        

    }

    /**
     * 
     * @return True si esta vacia (pFirst es null), False si no.
     */
    public boolean EsVacia() {
        return this.pFirst == null;
    }

    /**
     * 
     * Se establece la posición del nuevo nodo como "00" (primera posición).
     * Se obtiene el valor del caracter en la posición 0 de la cadena de posición
     * del nodo actual (nodo.getPosition().charAt(0)) y se convierte a entero.
     * 
     * Se obtiene el valor del caracter en la posición 1 de la cadena de posición del nodo 
     * actual (nodo.getPosition().charAt(1)) y se convierte a entero.
     * 
     * Se incrementa la columna (valor entero en la posición 1) en 1.
     * 
     * Se crea una nueva cadena de posición (Position) concatenando la fila (valor 
     * entero en la posición 0) y la nueva columna.
     * 
     * @param data  El dato que se almacena en el nodo (puede ser de cualquier tipo genérico T)
     * en este caso String
     */
     public void AgregarInicio(T data) {
        NodoDoble nodo = new NodoDoble(data);
        if (EsVacia()) {
            nodo.setPosition("00");
            pFirst = nodo;
            pLast = nodo;
        } else {
            nodo.setpNext(pFirst);
            int i=(int)nodo.getPosition().charAt(0)-48;
            int j=(int)nodo.getPosition().charAt(1)-48;
            j++;
            String Position = String.valueOf(i)+String.valueOf(j);
            nodo.getpNext().setPosition(Position);
            pFirst = nodo;
        }
        size++;
    }

     /**
      * 
      * La función crea un nuevo nodo doble (nodo) con el valor del parámetro data
      * agregandolo al final de la lista
      * 
      * @param data El dato que se almacena en el nodo (puede ser de cualquier tipo genérico T).
      */
    public void AgregarFinal(T data) {
        NodoDoble<T> nodo = new NodoDoble(data);
        if (EsVacia()) {
            nodo.setPosition("00");
            pLast = nodo;
            pFirst = nodo;
        } else {
            NodoDoble Aux = pLast;
            int i=Aux.getPosition().charAt(0)-48;
            int j=Aux.getPosition().charAt(1)-48;
            j++;
            pLast.setpNext(nodo);
            nodo.setpLast(pLast);
            String Position = String.valueOf(i)+String.valueOf(j);
            nodo.setPosition(Position);
            pLast = nodo;
            
        }
        size++;
    }
    
    /**
     * 
     * Esta función agrega un nuevo nodo al final de la lista doble, copiando 
     * el dato del nodo original proporcionado.
     * 
     * @param nodoOriginal  El nodo original del cual se copiará el dato.
     */
    public void AgregarNodoFinal(NodoDoble nodoOriginal) {
        NodoDoble<T> nodo = new NodoDoble(nodoOriginal.getData().toString());
        nodo.setpOriginal(nodoOriginal);
        if (EsVacia()) {
            nodo.setPosition("00");
            pLast = nodo;
            pFirst = nodo;
            
        } else {
            NodoDoble Aux = pLast;
            int i=Aux.getPosition().charAt(0)-48;
            int j=Aux.getPosition().charAt(1)-48;
            j++;
            pLast.setpNext(nodo);
            nodo.setpLast(pLast);
            String Position = String.valueOf(i)+String.valueOf(j);
            nodo.setPosition(Position);
            pLast = nodo;
            
        }
        size++;
    }
    
    /**
     * Imprime la informacion del nodo de una lista, con su posicion
     */
    public void Imprimir(){
        NodoDoble pAux = pFirst;
        while(pAux != null){
            System.out.println(pAux.getData() + " - " + pAux.getPosition());
            pAux = pAux.getpNext();
        }
    }
    
    /**
     *  Imprime el nodo de una lista con su posicion original en el grafo
     */
    public void ImprimirNodos(){
        NodoDoble pAux = pFirst;
        while(pAux != null){
            System.out.println(pAux.getpOriginal().getData() + " - " + pAux.getpOriginal().getPosition());
            pAux = pAux.getpNext();
        }
    }
    
    /**
     *  imprime la lista de adyacencia del nodo deseado
     */
     public void ImprimirListaAdyacencia() {
        NodoDoble pAux = pFirst;
        while (pAux != null) {
            pAux.printAdjacencyList();
            pAux = pAux.getpNext();
        }
     }
    
     /**
      * 
      * Esta función busca un nodo en un índice específico dentro de la lista doble 
      * segun su posicion en la misma
      * 
      * @param index  El índice del nodo que se desea buscar (comienza en 0).
      * @return El nodo encontrado en el índice especificado, o null si no se encuentra.
      */
    public NodoDoble BuscarIndice(int index){
        NodoDoble pAux= pFirst;
        int count = 0;
        while(pAux != null && count != index){
            pAux = pAux.getpNext();
            count++;
        }
        
        if(pAux != null){
            return pAux;
        } else{
            return null;
        }
    }
    
    /**
     * 
     *  Esta función busca un nodo en un índice específico dentro de la lista doble 
     *  segun su data.    
     * 
     * @param index El índice del nodo del cual se desea obtener el dato (comienza en 0).
     * @return El dato almacenado en el nodo del índice especificado, o null si 
     * no se encuentra el nodo.
     */
    public T BuscarDataIndice(int index){
        NodoDoble<T> pAux =this.BuscarIndice(index);
        if (pAux != null){
            return pAux.getData();
        }else{
        return null;
        }
    }
    

    
    
    public NodoDoble<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoDoble<T> pFirst) {
        this.pFirst = pFirst;
    }

    public NodoDoble<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoDoble<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }
    
    

}

