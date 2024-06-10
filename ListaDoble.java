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
      /**
 * Recorre una ListaDoble y comprueba si algún nodo contiene un dato específico. Si lo encuentra, imprime la lista adyacente al nodo.
 * 
 * @param lista la ListaDoble que se recorrerá
 * @param data el dato a buscar en los nodos de la lista
 */
    }public void recorrer(ListaDoble lista,T data){
        lista.setposicionnodo(lista);
        NodoDoble pAux= pFirst;
        while(pAux != null){
          if(pAux.getData().equals(data))
                pAux.getListaAdy().Imprimir();
                       
                    
                    
        pAux = pAux.getpNext();
    
            }
         /**
 * Establece la posición de cada nodo en una ListaDoble recorriendo la lista.
 * 
 * @param T la ListaDoble cuyos nodos se establecerán con su posición
 */
    } public void setposicionnodo(ListaDoble T) {
        NodoDoble pAux = pFirst;
    int contador = 0;
        
    while(pAux != null){
        pAux.setPosition(contador);
      System.out.println(pAux.getPosition()); // Imprime la posición antes de mover el puntero
        pAux = pAux.getpNext();
        contador ++;
    }
    /**
 * Realiza operaciones sobre una ListaDoble, como búsqueda de índices, agregar elementos y establecer posiciones.
 * 
 * @param T la ListaDoble en la que se realizarán las operaciones
 */
}   public void setADY(ListaDoble T) {
        T.setposicionnodo(T);
// nodo 0      
    T.BuscarIndice(0).AgregaAdy(String.valueOf(T.BuscarIndice(1).getData())); 
     T.BuscarIndice(0).getListaAdy().BuscarIndice(0).setPosition(1);
     
    T.BuscarIndice(0).AgregaAdy(String.valueOf(T.BuscarIndice(4).getData()));
    T.BuscarIndice(0).getListaAdy().BuscarIndice(1).setPosition(4);
    
    T.BuscarIndice(0).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
    T.BuscarIndice(0).getListaAdy().BuscarIndice(2).setPosition(5);
    
    
//    nodo 1 
    
    T.BuscarIndice(1).AgregaAdy(String.valueOf(T.BuscarIndice(0).getData()));
    T.BuscarIndice(1).getListaAdy().BuscarIndice(0).setPosition(0);
    
    T.BuscarIndice(1).AgregaAdy(String.valueOf(T.BuscarIndice(2).getData()));
    T.BuscarIndice(1).getListaAdy().BuscarIndice(1).setPosition(2);
    
    T.BuscarIndice(1).AgregaAdy(String.valueOf(T.BuscarIndice(4).getData()));
    T.BuscarIndice(1).getListaAdy().BuscarIndice(2).setPosition(4);
    
    T.BuscarIndice(1).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
    T.BuscarIndice(1).getListaAdy().BuscarIndice(3).setPosition(5);
    
    T.BuscarIndice(1).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
    T.BuscarIndice(1).getListaAdy().BuscarIndice(4).setPosition(6);
    
    
    
//  nodo 2  
     T.BuscarIndice(2).AgregaAdy(String.valueOf(T.BuscarIndice(1).getData()));
     T.BuscarIndice(2).getListaAdy().BuscarIndice(0).setPosition(1);
    
     T.BuscarIndice(2).AgregaAdy(String.valueOf(T.BuscarIndice(3).getData()));
     T.BuscarIndice(2).getListaAdy().BuscarIndice(1).setPosition(3); 
      
     T.BuscarIndice(2).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
     T.BuscarIndice(2).getListaAdy().BuscarIndice(2).setPosition(5);
     
     T.BuscarIndice(2).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
     T.BuscarIndice(2).getListaAdy().BuscarIndice(3).setPosition(6);
     
     T.BuscarIndice(2).AgregaAdy(String.valueOf(T.BuscarIndice(7).getData()));
     T.BuscarIndice(2).getListaAdy().BuscarIndice(4).setPosition(7);
     
     
//   nodo 3   
     
      T.BuscarIndice(3).AgregaAdy(String.valueOf(T.BuscarIndice(2).getData()));
      T.BuscarIndice(3).getListaAdy().BuscarIndice(0).setPosition(2);
      
      T.BuscarIndice(3).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
      T.BuscarIndice(3).getListaAdy().BuscarIndice(1).setPosition(6);
      
      T.BuscarIndice(3).AgregaAdy(String.valueOf(T.BuscarIndice(7).getData()));
      T.BuscarIndice(3).getListaAdy().BuscarIndice(2).setPosition(7);
      
//  nodo 4 
      
      
      T.BuscarIndice(4).AgregaAdy(String.valueOf(T.BuscarIndice(0).getData()));
      T.BuscarIndice(4).getListaAdy().BuscarIndice(0).setPosition(0);
      
      T.BuscarIndice(4).AgregaAdy(String.valueOf(T.BuscarIndice(1).getData()));
      T.BuscarIndice(4).getListaAdy().BuscarIndice(1).setPosition(1);
      
      T.BuscarIndice(4).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
      T.BuscarIndice(4).getListaAdy().BuscarIndice(2).setPosition(5);
      
      T.BuscarIndice(4).AgregaAdy(String.valueOf(T.BuscarIndice(8).getData()));
      T.BuscarIndice(4).getListaAdy().BuscarIndice(3).setPosition(8);
     
      
      T.BuscarIndice(4).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
      T.BuscarIndice(4).getListaAdy().BuscarIndice(4).setPosition(9);
      
      
////      nodo 5

        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(0).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(0).setPosition(0);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(1).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(1).setPosition(1);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(2).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(2).setPosition(2);
      
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(4).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(3).setPosition(4);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(4).setPosition(6);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(8).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(5).setPosition(8);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(6).setPosition(9);
        
        T.BuscarIndice(5).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
        T.BuscarIndice(5).getListaAdy().BuscarIndice(7).setPosition(10);
        
        
//        nodo 6 

        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(1).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(0).setPosition(1);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(2).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(1).setPosition(2);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(3).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(2).setPosition(3);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(3).setPosition(5);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(7).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(4).setPosition(7);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(5).setPosition(9);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(6).setPosition(10);
        
        T.BuscarIndice(6).AgregaAdy(String.valueOf(T.BuscarIndice(11).getData()));
        T.BuscarIndice(6).getListaAdy().BuscarIndice(7).setPosition(11);
        
//        nodo 7 

        T.BuscarIndice(7).AgregaAdy(String.valueOf(T.BuscarIndice(2).getData()));
        T.BuscarIndice(7).getListaAdy().BuscarIndice(0).setPosition(2);
        
        T.BuscarIndice(7).AgregaAdy(String.valueOf(T.BuscarIndice(3).getData()));
        T.BuscarIndice(7).getListaAdy().BuscarIndice(1).setPosition(3);
        
        T.BuscarIndice(7).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
        T.BuscarIndice(7).getListaAdy().BuscarIndice(2).setPosition(6);
        
        T.BuscarIndice(7).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
        T.BuscarIndice(7).getListaAdy().BuscarIndice(3).setPosition(10);
        
        T.BuscarIndice(7).AgregaAdy(String.valueOf(T.BuscarIndice(11).getData()));
        T.BuscarIndice(7).getListaAdy().BuscarIndice(4).setPosition(11);
        
        
//        nodo 8 
        
         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(4).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(0).setPosition(4);
         
         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(1).setPosition(5);

         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(2).setPosition(9);
         
         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(3).setPosition(9);
         
         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(12).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(4).setPosition(12);

         T.BuscarIndice(8).AgregaAdy(String.valueOf(T.BuscarIndice(13).getData()));
         T.BuscarIndice(8).getListaAdy().BuscarIndice(5).setPosition(13);
         
//         nodo 9
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(4).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(0).setPosition(4);
          
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(1).setPosition(5);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(2).setPosition(6);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(8).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(3).setPosition(8);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(4).setPosition(10);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(12).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(5).setPosition(12);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(13).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(6).setPosition(13);
         
         T.BuscarIndice(9).AgregaAdy(String.valueOf(T.BuscarIndice(14).getData()));
         T.BuscarIndice(9).getListaAdy().BuscarIndice(7).setPosition(14);
         
         
//         nodo 10
        T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(5).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(0).setPosition(5);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(1).setPosition(6);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(7).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(2).setPosition(7);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(3).setPosition(9);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(11).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(4).setPosition(11);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(13).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(5).setPosition(13);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(14).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(6).setPosition(14);
         
          T.BuscarIndice(10).AgregaAdy(String.valueOf(T.BuscarIndice(15).getData()));
         T.BuscarIndice(10).getListaAdy().BuscarIndice(7).setPosition(15);
         
         
//         NODO 11 
        T.BuscarIndice(11).AgregaAdy(String.valueOf(T.BuscarIndice(6).getData()));
         T.BuscarIndice(11).getListaAdy().BuscarIndice(0).setPosition(6);
         
         T.BuscarIndice(11).AgregaAdy(String.valueOf(T.BuscarIndice(7).getData()));
         T.BuscarIndice(11).getListaAdy().BuscarIndice(1).setPosition(7);
         
          T.BuscarIndice(11).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
         T.BuscarIndice(11).getListaAdy().BuscarIndice(2).setPosition(10);
         
          T.BuscarIndice(11).AgregaAdy(String.valueOf(T.BuscarIndice(14).getData()));
         T.BuscarIndice(11).getListaAdy().BuscarIndice(3).setPosition(14);
         
          T.BuscarIndice(11).AgregaAdy(String.valueOf(T.BuscarIndice(15).getData()));
         T.BuscarIndice(11).getListaAdy().BuscarIndice(4).setPosition(15);
         
//         NODO 12
         T.BuscarIndice(12).AgregaAdy(String.valueOf(T.BuscarIndice(8).getData()));
         T.BuscarIndice(12).getListaAdy().BuscarIndice(0).setPosition(8);
         
         T.BuscarIndice(12).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(12).getListaAdy().BuscarIndice(1).setPosition(9);
         
         T.BuscarIndice(12).AgregaAdy(String.valueOf(T.BuscarIndice(13).getData()));
         T.BuscarIndice(12).getListaAdy().BuscarIndice(2).setPosition(13);
         
//         NODO 13 

         T.BuscarIndice(13).AgregaAdy(String.valueOf(T.BuscarIndice(8).getData()));
         T.BuscarIndice(13).getListaAdy().BuscarIndice(0).setPosition(8);
         
         T.BuscarIndice(13).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(13).getListaAdy().BuscarIndice(1).setPosition(9);
         
         T.BuscarIndice(13).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
         T.BuscarIndice(13).getListaAdy().BuscarIndice(2).setPosition(10);
         
         T.BuscarIndice(13).AgregaAdy(String.valueOf(T.BuscarIndice(12).getData()));
         T.BuscarIndice(13).getListaAdy().BuscarIndice(3).setPosition(12);
         
         T.BuscarIndice(13).AgregaAdy(String.valueOf(T.BuscarIndice(14).getData()));
         T.BuscarIndice(13).getListaAdy().BuscarIndice(4).setPosition(14);
         
         
//         NODO 14
         T.BuscarIndice(14).AgregaAdy(String.valueOf(T.BuscarIndice(9).getData()));
         T.BuscarIndice(14).getListaAdy().BuscarIndice(0).setPosition(9);
         
         T.BuscarIndice(14).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
         T.BuscarIndice(14).getListaAdy().BuscarIndice(1).setPosition(10);
         
         T.BuscarIndice(14).AgregaAdy(String.valueOf(T.BuscarIndice(11).getData()));
         T.BuscarIndice(14).getListaAdy().BuscarIndice(2).setPosition(11);
         
         T.BuscarIndice(14).AgregaAdy(String.valueOf(T.BuscarIndice(13).getData()));
         T.BuscarIndice(14).getListaAdy().BuscarIndice(3).setPosition(13);
         
         T.BuscarIndice(14).AgregaAdy(String.valueOf(T.BuscarIndice(15).getData()));
         T.BuscarIndice(14).getListaAdy().BuscarIndice(4).setPosition(15);
         
//         nodo 15
            T.BuscarIndice(15).AgregaAdy(String.valueOf(T.BuscarIndice(10).getData()));
         T.BuscarIndice(15).getListaAdy().BuscarIndice(0).setPosition(10);
         
         T.BuscarIndice(15).AgregaAdy(String.valueOf(T.BuscarIndice(11).getData()));
         T.BuscarIndice(15).getListaAdy().BuscarIndice(1).setPosition(11);
         
         T.BuscarIndice(15).AgregaAdy(String.valueOf(T.BuscarIndice(14).getData()));
         T.BuscarIndice(15).getListaAdy().BuscarIndice(2).setPosition(14);
     
  /**
 * Implementa el algoritmo BFS para recorrer una ListaDoble y buscar una palabra específica de 4 letras. Si la palabra se encuentra, se imprime un mensaje confirmando el hallazgo.
 * 
 * @param lista la ListaDoble que se recorrerá
 * @param data la palabra a buscar en la lista
 */
    }public void BFS4(ListaDoble lista,  String data) {
        lista.setADY(lista);
        int largo = data.length();
        String L1 = String.valueOf(data.charAt(largo-largo)); //a
        String L2 = String.valueOf(data.charAt(largo-3));//m
        String L3 = String.valueOf(data.charAt(largo-2));//o
        String L4 = String.valueOf(data.charAt(largo-1));//r
        
        NodoDoble pAux = pFirst;
        
        
        while(pAux != null) {
            if (pAux.getData().equals(L1)) {
               ListaDoble list = pAux.getListaAdy();
               pAux.getListaAdy().Imprimir();
                int p0 = list.posicionnodo(list,L2);
                if (list.contiene(list, L2)== true){
//                    System.out.println("LA LISTA DE ADYACENCIA DE A TIENE A M ")
                        ListaDoble list1= lista.BuscarIndice(p0).getListaAdy();
                            if(list1.contiene(list,L1)&& list1.contiene(list, L3)){
//                                System.out.println("buen camino ");
                                int p1 = list1.posicionnodo(list1,L3);
                                System.out.println(p1);
                                ListaDoble list2 = lista.BuscarIndice(p1).getListaAdy();
                                list2.Imprimir();
                                if(list2.contiene(list2, L2)&& list2.contiene(list2, L4)){
                                    
                                    int p2 = list2.posicionnodo(list2, L4);
                                    System.out.println(p2);
                                    ListaDoble list3 = lista.BuscarIndice(p2).getListaAdy();
                                    if(list3.contiene(list, L3)){
                                        System.out.println("PALABRA  ENCONTRADA");
                                    }
                                    else {
                                        System.out.println("la letra no esta  ");
                                    }
                                    
                                    
                                    
                                    
                                }
                                    
                                
                                
                                
                                
                            }
                                                  
                        
                        
            }
                
                    
                        
                       
            }
            pAux = pAux.getpNext();
        }
        /**
 * Comprueba si una ListaDoble contiene un dato específico.
 * 
 * @param lista la ListaDoble que se examinará
 * @param data el dato a buscar en la lista
 * @return true si el dato se encuentra en la lista, false en caso contrario
 */
    }public boolean contiene(ListaDoble lista,T data){
        NodoDoble pAux = pFirst;

        while(pAux != null) {
            if(pAux.getData().equals(data)) {
                return true;
            }
            pAux = pAux.getpNext();
        }

        return false;
        
        /**
 * Devuelve la posición del primer nodo en una ListaDoble que contiene un dato específico. Si no se encuentra el dato en la lista, se devolverá el valor predeterminado 1.
 * 
 * @param lista la ListaDoble que se examinará
 * @param data el dato a buscar en la lista
 * @return la posición del nodo que contiene el dato buscado, o 1 si no se encuentra el dato
 */
    }public int posicionnodo(ListaDoble lista,T data){
        
        NodoDoble pAux= pFirst;
        while(pAux != null){
          if(pAux.getData().equals(data))
                return pAux.getPosition();
                       
                    
                   
        pAux = pAux.getpNext();
    
            }
        return 1;
        
        /**
 * Implementa el algoritmo BFS para recorrer una ListaDoble y buscar una palabra específica de 3 letras. Si la palabra se encuentra, se imprime un mensaje confirmando el hallazgo.
 * 
 * @param lista la ListaDoble que se recorrerá
 * @param data la palabra a buscar en la lista
 */
    }public void BFS3(ListaDoble lista,  String data) {
        lista.setADY(lista);
        int largo = data.length();
        String L1 = String.valueOf(data.charAt(largo-largo)); //a
        String L2 = String.valueOf(data.charAt(largo-2));//m
        String L3 = String.valueOf(data.charAt(largo-1));//o
       
        
        NodoDoble pAux = pFirst;
        
        
        while(pAux != null) {
            if (pAux.getData().equals(L1)) {
               ListaDoble list = pAux.getListaAdy();
                int p0 = list.posicionnodo(list,L2);
                if (list.contiene(list, L2)== true){
                        ListaDoble list1= lista.BuscarIndice(p0).getListaAdy();
                            if(list1.contiene(list,L1)&& list1.contiene(list, L3)){
                                int p1 = list1.posicionnodo(list1,L3);
                                System.out.println(p1);
                                ListaDoble list2 = lista.BuscarIndice(p1).getListaAdy();                              
                                if(list2.contiene(list2, L2)){
                                    System.out.println("PALABRA  ENCONTRADA");
                                    }
                                    else {
                                        System.out.println("la letra no esta  ");
                                    }
                                    
                                    
                                    
                                    
                                }
                                    
                                
                                
                                
                                
                            }
                                           
                       
         
            pAux = pAux.getpNext();
        }
            
        }
    }
         
    
}
    
    

}

