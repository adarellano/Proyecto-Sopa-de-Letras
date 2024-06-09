/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dfs;


/**
 *
 * @author Ada Arellano
 */
public class DFS {
    
    /**
    * Busca la primera letra (LetraActual) dentro de la estructura de 
    * lista enlazada dada por (ListaBuscar).
    *
    * @param ListaBuscar La lista enlazada que representa la estructura 
    * del gráfico en la que se busca. Se asume que esta lista es la principal 
    * (de nivel superior) que contiene otras listas enlazadas como listas de adyacencia.
    * 
    * @param LetraActual El carácter (NodoDoble) que se busca.
    * @return El primer NodoDoble encontrado en el gráfico que coincide 
    * con el carácter especificado, o null si no se encuentra ninguna coincidencia.
    *
    * @throws NullPointerException si ListaBuscar o LetraActual es nulo.
    *
    */
    
    public static NodoDoble BuscarPrimeraLetra(ListaDoble ListaBuscar, NodoDoble LetraActual)
    {
        int intPosFila=0, intPosCol=0;
        boolean bContinuar=true;
        NodoDoble NodoRetorno = new NodoDoble(ListaBuscar.BuscarIndice(intPosCol));
        
        //recorro la fila 0, que es la lista principal.
        while(bContinuar)
        {
            if(intPosFila==0)
            {
                if(ListaBuscar.BuscarIndice(intPosCol).getData().toString().equals(LetraActual.getData().toString()))
                {
                    NodoRetorno = ListaBuscar.BuscarIndice(intPosCol);
                    break;
                }
            }
            else
            {
                if(ListaBuscar.BuscarIndice(intPosCol).getListaAdy().BuscarIndice(intPosFila-1).getData().toString().equals(LetraActual.getData().toString()))
                {
                    NodoRetorno = ListaBuscar.BuscarIndice(intPosCol).getListaAdy().BuscarIndice(intPosFila-1);
                    break;
                }
            }
            if(intPosCol<3)
                intPosCol++;
            else
            {
                intPosCol=0;
                intPosFila++;
                if (intPosFila>3)
                {
                    bContinuar = false; //while
                }
            }
        }
        if(!bContinuar)
        {
            //intPosCol=-1;
            //intPosFila=-1;
            NodoRetorno = null;
        }    
        
        //Posicion PosicionLetra = new Posicion(intPosFila, intPosCol);
        return NodoRetorno;
    }
    
    /**
    * Busca los nodos adyacentes al nodo dado (NodoActual) dentro de la lista 
    * doble que representa un grafo (Lista).
    * @param Lista La lista doble que representa el grafo.
    * @param NodoActual El nodo del cual se quieren encontrar los nodos adyacentes.
    * @return La función devuelve una nueva lista doble (ListaAdy) que contiene los nodos adyacentes al nodo actual.
    */
    
    public static ListaDoble BuscarNodosAdyacentes(ListaDoble Lista, NodoDoble NodoActual)
    {
        int fila;
        int col;
        fila = (int)(NodoActual.getPosition().charAt(0))-48;
        col = (int)(NodoActual.getPosition().charAt(1))-48;
        
        ListaDoble ListaAdy = new ListaDoble();
        if (fila==0) 
        {//a
            if (col==0 || col==3)
            {
                if (col==0)
                { //a
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext()); //s
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext().getListaAdy().getpFirst()); //m
                    ListaAdy.AgregarNodoFinal(NodoActual.getListaAdy().getpFirst()); //e
                    //ListaAdy.Imprimir();
                }
                else
                { //l
                    ListaAdy.AgregarNodoFinal(NodoActual.getListaAdy().getpFirst()); //i
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev().getListaAdy().getpFirst()); //p
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev()); //o
                    //ListaAdy.Imprimir();
                }
            }
            else //col = 1 || col = 2
            {
                if (col==1){ //s
                    
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext()); //o
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila)); //p
                    ListaAdy.AgregarNodoFinal(NodoActual.getListaAdy().BuscarIndice(fila)); //m
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev().getListaAdy().BuscarIndice(fila)); //e
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev()); //a
                    //ListaAdy.Imprimir();
                }
                else
                { //o
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext());//l
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila));//i
                    ListaAdy.AgregarNodoFinal(NodoActual.getListaAdy().BuscarIndice(fila));//p
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev().getListaAdy().BuscarIndice(fila));//m
                    ListaAdy.AgregarNodoFinal(NodoActual.getpPrev());//s
                    //ListaAdy.Imprimir();
                    
                }
            }
        }
        
        if(fila==1)
        {
            if(col==1 ||col==2)
            {
                if(col==1){//m
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col));//s
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1));
                     ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1));//a
                    //ListaAdy.Imprimir();
                }
                else{
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col));//s
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1));//a
                    //ListaAdy.Imprimir();
                    
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col)); //a
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1)); //s
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //m
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila)); //e
                    ListaAdy.AgregarNodoFinal(NodoActual.getpNext()); //s
                    //ListaAdy.Imprimir();
                }
                else
                { //i
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col)); //l
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila)); //n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila)); //o       
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //p
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1)); //o           
                    //ListaAdy.Imprimir();
                } 
            }
        }

        if(fila==2)
        {
            if(col==1 ||col==2)
            {
                if(col==1)
                {//e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2));//e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2));//m
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2)); //p
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //o
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila)); //a
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila)); //n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila)); //u
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //s
                    //ListaAdy.Imprimir();
                }
                else
                {//o
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2));//m
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2));//p
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2)); //i
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila)); //r
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila)); //a
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila)); //n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //e
                    //ListaAdy.Imprimir();
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {//s del lado
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2)); //e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2)); //m
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila)); //n       
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila)); //u
                    //ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2)); //p
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2)); //i
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila)); //r
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila)); //a      
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //o
                    //ListaAdy.Imprimir();
                }
            }
        }
        if (fila==3)
        {
            if (col==0 || col==3)
            {
                if (col==0){ //u
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2)); //s
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2)); //e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //n
                    //ListaAdy.Imprimir();
                }
                else{//r
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2)); //o
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2)); //n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //a
                    //ListaAdy.Imprimir();
                }
            }
            else { //col 1 || col=2
                if (col==1){//n
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2));//s
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2));
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); 
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1));
                    //ListaAdy.Imprimir();
                }
                else{//a
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2));//e
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2)); //o
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2)); //n            
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1)); //r
                    ListaAdy.AgregarNodoFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1)); //n
                    //ListaAdy.Imprimir();
                }            
            }   
        }
        return ListaAdy;
    }
 
    /**
 *  Busca el siguiente nodo en la lista adyacente proporcionada (ListaAdyacentes) 
 * coincida con el carácter dado (LetraActual).
 *
 * @param LetraActual representa el nodo que se busca
 * @param ListaAdyacentes La lista de adyacencia contenida en el nodo
 * @return el siguiente nodo de la lista que sea igual a la letra que se busca, o null si no consigue nada o la lista esta vacia
 */
    
    
    public static NodoDoble BuscarProximoNodo(NodoDoble LetraActual, ListaDoble ListaAdyacentes)
    {
        if (ListaAdyacentes.getpFirst() == null)
            return null;
        else
        {
            if(ListaAdyacentes.BuscarIndice(0).getData().toString().equals(LetraActual.getData().toString()))
                return ListaAdyacentes.BuscarIndice(0);
            else
            {
                ListaAdyacentes.setpFirst(ListaAdyacentes.BuscarIndice(0).getpNext());
                return BuscarProximoNodo(LetraActual, ListaAdyacentes);
            }
        }
    }
    
    /**
    * Esta función marca un nodo como visitado o no en la lista (ListaBuscar) 
    * según la posición dada (Posicion) y el valor de bVisitado.
    *
    * @param ListaBuscar La lista que tiene el nodo a marcar
    * @param Posicion El String que representa la poscion del nodo(fila y columna).
    * @param bVisitado El valor booleano que indica si hay que marcar el nodo
    * @return La lista cambiada (ListaBuscar) con el nodo con la posicion marcada como visitado o no, que lo da el valor de bVisitado.
    */
    public static ListaDoble MarcarVisitado(ListaDoble ListaBuscar, String Posicion, boolean bVisitado)
    {
        int fila;
        int col;
        fila = (int)(Posicion.charAt(0))-48;
        col = (int)(Posicion.charAt(1))-48;
        if (fila == 0)
        {
            ListaBuscar.BuscarIndice(col).setVisitado(bVisitado);
        }
        else
        {
            ListaBuscar.BuscarIndice(col).getListaAdy().BuscarIndice(fila-1).setVisitado(bVisitado);
        }
        return ListaBuscar;
    }
    
    /**
     * 
     * realiza una búsqueda recursiva en un grafo representado por una lista 
     * doble (Lista) para encontrar una cadena de caracteres (LetraActual) 
     * siguiendo las conexiones entre nodos.
     * 
     * @param Lista La lista doble que representa el grafo.
     * @param NodoActualSopa  El nodo actual en la sopa de letras (representada por la lista).
     * @param LetraActual El nodo que se busca en la cadena (el siguiente carácter a encontrar).
     * @return 
     */
    
    public static boolean DevolverABuscar(ListaDoble Lista, NodoDoble NodoActualSopa, NodoDoble LetraActual)
    {
        //LetraActual = A->[M]->O->R
        //ListaAdyacente = Los de la M, la primera vez. s->m->e
        //NodoActualSopa = [A] de la sopa
        ListaDoble ListaAdyacentes = new ListaDoble();
        boolean bEncontro;
        
        if (LetraActual==null)
            return true;
        else
        {
            ListaAdyacentes = BuscarNodosAdyacentes(Lista, NodoActualSopa);
            bEncontro = false;
            while (!bEncontro)
            {
                if(ListaAdyacentes.BuscarIndice(0).getData().toString().equals(LetraActual.getData().toString()))
                {
                    if (!ListaAdyacentes.BuscarIndice(0).getpOriginal().isVisitado())
                    {
                        LetraActual.setVisitado(true);
                        LetraActual = LetraActual.getpNext();
                        Lista = MarcarVisitado(Lista, NodoActualSopa.getPosition(), true);
                        NodoActualSopa = ListaAdyacentes.BuscarIndice(0).getpOriginal();
                        bEncontro = DevolverABuscar(Lista, NodoActualSopa, LetraActual);
                        if (!bEncontro)
                        {
                            LetraActual = LetraActual.getpPrev();
                            LetraActual.setVisitado(false);
                            Lista = MarcarVisitado(Lista, NodoActualSopa.getPosition(), false);
                            //NodoActualSopa = ListaAdyacentes.BuscarIndice(0).getpOriginal();
                            ListaAdyacentes.setpFirst(ListaAdyacentes.BuscarIndice(0).getpNext());
                            ListaAdyacentes.setSize(ListaAdyacentes.getSize()-1);
                        }
                    }
                    else
                    {
                        ListaAdyacentes.setpFirst(ListaAdyacentes.BuscarIndice(0).getpNext());
                        ListaAdyacentes.setSize(ListaAdyacentes.getSize()-1);
                    }
                }
                else
                {
                    ListaAdyacentes.setpFirst(ListaAdyacentes.BuscarIndice(0).getpNext());
                    ListaAdyacentes.setSize(ListaAdyacentes.getSize()-1);
                }
                if (!bEncontro && (ListaAdyacentes.getpFirst() == null))
                {
                    return false;
                }
            }
            return true;
        }
    }
           
    /**
     * 
     * Esta función busca una palabra dada (Palabra) en un grafo 
     * representado por una lista doble (ListaBuscar).
     * 
     * 
     * @param ListaBuscar La lista doble que representa el grafo
     * @param Palabra  La palabra que se busca.
     * @return  true Si la palabra se encuentra. False Si la palabra no se 
     * encuentra en el grafo o si la longitud de la palabra es menor a 3.
     * 
     */            
   
    public static boolean BuscarPalabra(ListaDoble ListaBuscar, String Palabra)
    {
       if(Palabra.length()>=3){
        //Transformamos la palabra en una lista de las letras que vamos a buscar
        boolean bPalabraEncontrada = false;
        boolean bContinuarBusqueda = false;
        boolean bExisteSiguiente = false;
        //int filaActual = 0;
        //int columnaActual = 0;
        int indiceletraActual = 0;
        int totalLetras = Palabra.length();
        ListaDoble ListaAdyacentes = new ListaDoble();
        ListaDoble ListaPalabra = new ListaDoble();
        NodoDoble ProximoNodo;
        
        for(int i=0; i< Palabra.length(); i++){
            ListaPalabra.AgregarFinal(Palabra.charAt(i));
        } //ejemplo: A -> M -> O -> R /P->I->N
        ListaPalabra.Imprimir();
        
        //Posicion pPosicionInicial = BuscarPrimeraLetra(ListaBuscar, ListaPalabra.BuscarIndice(0));
        NodoDoble NodoListaActual = BuscarPrimeraLetra(ListaBuscar, ListaPalabra.BuscarIndice(0));
        
        //filaActual = pPosicionInicial.getPosFila();
        //columnaActual = pPosicionInicial.getPosColumna();
        if (NodoListaActual!=null)
        {
            ListaPalabra.BuscarIndice(indiceletraActual).setVisitado(true); //Letra visitada
            ListaBuscar = MarcarVisitado(ListaBuscar, NodoListaActual.getPosition(), true);
        
            //filaActual = (int) NodoListaActual.getPosition().charAt(0)-48;
            //columnaActual = (int) NodoListaActual.getPosition().charAt(1)-48;
            bContinuarBusqueda = true;
            indiceletraActual++;
            //Como las palabras son de al menos 3 letras, existe al menos dos letras más en la lista a buscar
            NodoDoble LetraActual = ListaPalabra.BuscarIndice(indiceletraActual);

            //Buscamos el resto de la palabra
            bPalabraEncontrada = DevolverABuscar(ListaBuscar, NodoListaActual, LetraActual);
        }
        return bPalabraEncontrada;    
       }else{System.out.println("La palabra tener 3 letras minimo");
       }
        return false;
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    NodoDoble cabeza = null;
    NodoDoble cola = null; // Nueva variable para la cola de la lista
    
    
 
        ///para probar
        ListaDoble Lista = new ListaDoble();
        Lista.AgregarFinal("a");
        Lista.AgregarFinal("s");
        Lista.AgregarFinal("o");
        Lista.AgregarFinal("l");
            
               
        Lista.BuscarIndice(0).AgregaAdya("e");
        Lista.BuscarIndice(0).AgregaAdya("s");
        Lista.BuscarIndice(0).AgregaAdya("u");
        
        Lista.BuscarIndice(1).AgregaAdya("m");
        Lista.BuscarIndice(1).AgregaAdya("e");
        Lista.BuscarIndice(1).AgregaAdya("n");
        
        Lista.BuscarIndice(2).AgregaAdya("p");
        Lista.BuscarIndice(2).AgregaAdya("o");
        Lista.BuscarIndice(2).AgregaAdya("a");
        
        Lista.BuscarIndice(3).AgregaAdya("i");
        Lista.BuscarIndice(3).AgregaAdya("n");
        Lista.BuscarIndice(3).AgregaAdya("r");
        
        
        Lista.BuscarIndice(0).printAdjacencyList();
        
       
        String palabra1 = "amor";
        String palabra2 = "sol";
        String palabra3 = "pin";
        String palabra4= "una";
        String palabra5 = "ese";
        String palabra6 = "am";
        
        boolean bExistePalabra = BuscarPalabra(Lista, palabra6);
        if (!bExistePalabra)
            System.out.println("La palabra no esta en la sopa de letras.");
        else
            System.out.println("La palabra esta en la sopa de letras.");
        
       
        }
}

    
    


