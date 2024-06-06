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
    private T data;
    private boolean visitado;
    private ListaDoble ListaAdya;
    private String position;
    

    public  NodoDoble(T data){
        this.pNext = null;
        this.pPrev = null;
        this.data = data;
        this.visitado = false;
        this.ListaAdya = new ListaDoble();
        
        
    }
    
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
    
    public void AgregaAdya(String data) {
        NodoDoble<T> nuevoNodo = new NodoDoble(data);
        if (ListaAdya.EsVacia()) {
        nuevoNodo.setPosition("00"); // Set initial position as "00"
        ListaAdya.setpFirst(nuevoNodo);
        ListaAdya.setpLast(nuevoNodo);
    } else {
        NodoDoble<T> actualUltimo = ListaAdya.getpLast();
        int currentColumn = Character.getNumericValue(actualUltimo.getPosition().charAt(0)) + 1;
        int currentRow = Character.getNumericValue(actualUltimo.getPosition().charAt(1));

        nuevoNodo.setPosition(String.valueOf(currentColumn) + String.valueOf(currentRow));
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
    
    public void setpPrev(NodoDoble<T> pNext) {
        this.pPrev = pPrev;
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
        this.visitado = false;
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