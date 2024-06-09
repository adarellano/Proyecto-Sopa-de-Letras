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

    public boolean EsVacia() {
        return this.pFirst == null;
    }

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
    
    public void Imprimir(){
        NodoDoble pAux = pFirst;
        while(pAux != null){
            System.out.println(pAux.getData() + " - " + pAux.getPosition());
            pAux = pAux.getpNext();
        }
    }
    
    public void ImprimirNodos(){
        NodoDoble pAux = pFirst;
        while(pAux != null){
            System.out.println(pAux.getpOriginal().getData() + " - " + pAux.getpOriginal().getPosition());
            pAux = pAux.getpNext();
        }
    }
    
     public void ImprimirListaAdyacencia() {
        NodoDoble pAux = pFirst;
        while (pAux != null) {
            pAux.printAdjacencyList();
            pAux = pAux.getpNext();
        }
     }
    
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
    
    public T BuscarDataIndice(int index){
        NodoDoble<T> pAux =this.BuscarIndice(index);
        if (pAux != null){
            return pAux.getData();
        }else{
        return null;
        }
    }
    
    public void Asignaciondeindice(){
        NodoDoble pAux = pFirst;
        while(pAux != null){
            for(int i=1;i<5;i++){
                for(int j=1;j<5;j++){
                    String filaColumna = String.valueOf(i)+String.valueOf(j);
                    
                    pAux.setPosition(filaColumna);
                }
            }
                
            pAux = pAux.getpNext();
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
