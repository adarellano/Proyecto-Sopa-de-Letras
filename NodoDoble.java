/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfs;

/**
 *
 * @author Ada Arellano
 */
public class NodoDoble<T> {
    private NodoDoble<T> pNext;
    private NodoDoble<T> pPrev;
    private NodoDoble<T> pOriginal;
    private T data;
    private boolean visitado;
    private String position;
    private ListaDoble ListaAdya;

    

    public  NodoDoble(T data){
        this.pNext = null;
        this.pPrev = null;
        this.pOriginal = null;
        this.data = data;
        this.visitado = false;
        this.ListaAdya = new ListaDoble();
        
        
    }
    /**
     * La función imprime el dato del nodo actual  seguido de la lista de 
     * sus nodos adyacentes.
     * Si la lista de adyacencia está vacía, se imprime un mensaje que indica 
     * "No hay adyacentes".
     *  En caso contrario, se itera a través de la lista de adyacencia, imprimiendo el 
     * dato de cada nodo vecino seguido de una coma y un espacio.
     */
    
    public void printAdjacencyList() {
        System.out.println(data);
        if (ListaAdya.EsVacia()) {
            System.out.println("No hay adyacentes");
        } else {
            for (int i = 0; i < ListaAdya.getSize(); i++) {
            String neighbor = ListaAdya.BuscarIndice(i).getData().toString();
            System.out.print(neighbor + ", ");
}
        System.out.println();
        }
    }
    
    /**
     * 
     * La función crea un nuevo nodo doble (nuevoNodo) con el valor del parámetro 
     * data y lo agrega a la lista vacia del nodo que se esta seleccionando, 
     * si esta vacio lo agrega de primero, si no, lo agrega de ultimo
     *
     * @param data El dato que se almacena en el nodo adyacente (puede ser un String)
     */
    public void AgregaAdya(String data) {
        NodoDoble<T> nuevoNodo = new NodoDoble(data);
        int columnaactual, filaactual;
        if (ListaAdya.EsVacia()) 
        {
            filaactual = 1;
            columnaactual = Character.getNumericValue(this.getPosition().charAt(1));
            
            nuevoNodo.setPosition(String.valueOf(filaactual)+String.valueOf(columnaactual));
            
            ListaAdya.setpFirst(nuevoNodo);
            ListaAdya.setpLast(nuevoNodo);
        } else {
            NodoDoble<T> actualUltimo = ListaAdya.getpLast();
            filaactual = Character.getNumericValue(actualUltimo.getPosition().charAt(0))+1;
            columnaactual = Character.getNumericValue(actualUltimo.getPosition().charAt(1));
            nuevoNodo.setPosition(String.valueOf(filaactual)+String.valueOf(columnaactual));
            actualUltimo.setpNext(nuevoNodo);
            nuevoNodo.setpPrev(actualUltimo);
            ListaAdya.setpLast(nuevoNodo);
        }
            
    }
    
    

    public NodoDoble<T> getpNext() {
        return pNext;
    }

    public void setpNext(NodoDoble<T> pNext) {
        this.pNext = pNext;
    }

    public NodoDoble<T> getpPrev() {
        return pPrev;
    }
    
    public void setpPrev(NodoDoble<T> pPrev) {
        this.pPrev = pPrev;
    }
    
    public NodoDoble<T> getpOriginal() {
        return pOriginal;
    }

    public void setpOriginal(NodoDoble<T> pOriginal) {
        this.pOriginal = pOriginal;
    }

    public void setpLast(NodoDoble<T> pPrev) {
        this.pPrev = pPrev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ListaDoble getListaAdy() {
        return ListaAdya;
    }

    public void setListaAdy(T data) {
        this.ListaAdya = ListaAdya;
        this.data = data;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
 
    
   
}
 
    
    
    
   
