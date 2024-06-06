/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dfs;

import javax.swing.JOptionPane;

/**
 *
 * @author Ada
 */
public class DFS {
    
    public static Posicion BuscarPrimeraLetra_OLD(ListaDoble ListaBuscar, NodoDoble LetraActual)
    {
        int intPosFila=0, intPosCol=0;
        boolean bContinuar=true;
        
        //recorro la fila 0, que es la lista principal.
        while(bContinuar)
        {
            if(intPosFila==0)
            {
                if(ListaBuscar.BuscarIndice(intPosCol).getData() == LetraActual.getData())
                    break;
            }
            else
            {
                if(ListaBuscar.BuscarIndice(intPosCol).getListaAdy().BuscarIndice(intPosFila-1).getData() == LetraActual.getData())
                    break;
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
            intPosCol=-1;
            intPosFila=-1;
        }    
        
        Posicion PosicionLetra = new Posicion(intPosFila, intPosCol);
        return PosicionLetra;
    }
    
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
    
    public static ListaDoble BuscarNodosAdyacentes(ListaDoble Lista, NodoDoble NodoActual)
    {
        int fila = (int)(NodoActual.getPosition().charAt(0));
        int col = (int)(NodoActual.getPosition().charAt(1));
        
        ListaDoble ListaAdy = new ListaDoble();
        if (fila==0) 
        {//a
            if (col==0 || col==3)
            {
                if (col==0)
                {
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData()); //s
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().getpFirst().getData()); //m
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().getpFirst().getData()); //e
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().getpFirst().getData()); //i
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getListaAdy().getpFirst().getData()); //p
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getData()); //o
                    ListaAdy.Imprimir();
                }
            }
            else //col = 1 || col = 2
            {
                if (col==1){ //s
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                }
                else
                { //o
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());//l
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());//i
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());//p
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());//m
                    ListaAdy.Imprimir();
                    
                }
            }
        }
        if (fila==3)
        {
            if (col==0 || col==3)
            {
                if (col==0){ //u
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila-1).getData());    
                    ListaAdy.Imprimir();
                }
                else{//r
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
            else { //col 1 || col=2
                if (col==1){//n
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());            
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); 
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else{//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());            
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); 
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }            
            }   
        }

        if(fila==1)
        {
            if(col==1 ||col==2)
            {
                if(col==1){//m
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else{
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                    
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData()); //a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData()); //s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); //m
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData()); //e
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData()); //s
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                } 
            }
        }

        if(fila==2)
        {
            if(col==1 ||col==2)
            {
                if(col==1)
                {//e
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {//s del lado
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
        }
        return ListaAdy;
    }
    
    public static boolean BuscarPalabra(ListaDoble ListaBuscar, String Palabra)
    {
        //Transformamos la palabra en una lista de las letras que vamos a buscar
        boolean bPalabraEncontrada = false;
        boolean bContinuarBusqueda = false;
        int filaActual = 0;
        int columnaActual = 0;
        int letraActual = 0;
        int totalLetras = Palabra.length();
        
        ListaDoble ListaPalabra = new ListaDoble();
        for(int i=0; i< Palabra.length(); i++){
            ListaPalabra.AgregarFinal(Palabra.charAt(i));
        } //ejemplo: A -> M -> O -> R /P->I->N
        ListaPalabra.Imprimir();
        
        //Posicion pPosicionInicial = BuscarPrimeraLetra(ListaBuscar, ListaPalabra.BuscarIndice(0));
        NodoDoble NodoListaActual = BuscarPrimeraLetra(ListaBuscar, ListaPalabra.BuscarIndice(0));
        
        ListaPalabra.BuscarIndice(letraActual).setVisitado(true); //Letra ubicada
        //filaActual = pPosicionInicial.getPosFila();
        //columnaActual = pPosicionInicial.getPosColumna();
        if (NodoListaActual!=null)
        {
            filaActual = (int) NodoListaActual.getPosition().charAt(0);
            columnaActual = (int) NodoListaActual.getPosition().charAt(1);
            bContinuarBusqueda = true;
            letraActual++;
            
            NodoDoble LetraActual = ListaPalabra.BuscarIndice(letraActual);
            while(bContinuarBusqueda)
            {
                //Partiendo del Nodo(filaActual,columnaActual) comenzamos la búsqueda de la letra inicial
                //Llamada a la función que nos retorno los nodos adyacentes
                
                ListaDoble ListaAdyacentes = BuscarNodosAdyacentes(ListaBuscar, NodoListaActual);
                //verificar la condicion de parada
                if (letraActual==totalLetras)
                {
                    //validamos si todas las letras fueron encontradas.
                    bPalabraEncontrada = true;
                    for (int i=0; i<totalLetras; i++)
                    {
                         if(ListaPalabra.BuscarIndice(i).isVisitado())
                             bPalabraEncontrada = true;
                         else
                         {
                             bPalabraEncontrada = false;
                             break; //for
                         }
                    }
                    if (!bPalabraEncontrada)
                        break; //while
                }
            }
        }
        
        return bPalabraEncontrada;        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    NodoDoble cabeza = null;
    NodoDoble cola = null; // Nueva variable para la cola de la lista
    
    
 
//    
//// practica con joptionpane, pero debe ser una interfaz
//  
//    String input = JOptionPane.showInputDialog("inserta tu palabra: ");
//
//    //convierto mi input en nodos
//    //contadorposition le asgina cada nodo un numero del 0 al 15 
//    
//    ListaDoble Listainsertar =new ListaDoble();
//    int contadorposition = 0;
//    for (char i : input.toCharArray()) {
//    NodoDoble nuevoNodo = new NodoDoble(String.valueOf(i));
//    
//        if (cabeza == null) {
//            
//            cabeza = nuevoNodo;
//            cola = nuevoNodo; // Inicializar cola con el primer nodo
//            nuevoNodo.setPosition(contadorposition);
//            Listainsertar.AgregarFinal(nuevoNodo);
//            //System.out.println(nuevoNodo.getData());
//            //System.out.println(nuevoNodo.getPosition());
//            
//                
//        } else {
//            cola.setpNext(nuevoNodo); // Agregar al final de la lista
//            cola = nuevoNodo; // Actualizar la cola al nuevo nodo
//            contadorposition ++;
//            nuevoNodo.setPosition(contadorposition);
//            Listainsertar.AgregarFinal(nuevoNodo);
//            //System.out.println(nuevoNodo.getData());
//            //System.out.println(nuevoNodo.getPosition());
//        }
            
//    /**
//     *
//     * @param nuevoNodo
//     */
//    public static void algoritmodebusqueda(NodoDoble nuevoNodo) {
//        if (nuevoNodo.getPosition() == 0) {
//        // si la psoicion es 0 comienza
//        // Visita el nodo 
//        nuevoNodo.setVisitado(true);
//        //imprima la primera letra
//        System.out.print(nuevoNodo.getData() + " ");
//        }
//
//        //esta es una idea de forma horizontal
//        //tengo que usar las posiciones, para hacerlo vertical, horizonta o diagonal
//        // llama de nuevo la funcion para ir al siguiente vecino
//        if (nuevoNodo.getpNext()!= null && nuevoNodo.getpNext().isVisitado()) {
//            nuevoNodo.setVisitado(true);
//            algoritmo(nuevoNodo.getpNext());
//        }
//
//        if (nuevoNodo.getpPrev() != null && nuevoNodo.getpPrev().isVisitado()) {
//            nuevoNodo.getpPrev().setVisitado(true);
//            algoritmo(nuevoNodo.getpPrev());
//            
//        }
        ///para probar
        ListaDoble Lista = new ListaDoble();
        Lista.AgregarFinal("a");
        Lista.AgregarFinal("s");
        Lista.AgregarFinal("o");
        Lista.AgregarFinal("l");
//        Lista.AgregarFinal("e");
//        Lista.AgregarFinal("m");
//        Lista.AgregarFinal("p");
//        Lista.AgregarFinal("i");
//        Lista.AgregarFinal("s");
//        Lista.AgregarFinal("e");
//        Lista.AgregarFinal("o");
//        Lista.AgregarFinal("n");
//        Lista.AgregarFinal("u");
//        Lista.AgregarFinal("n");
//        Lista.AgregarFinal("a");
//        Lista.AgregarFinal("r");
        
//        Lista.Asignaciondeindice();
        
        
       
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
        String palabra6 = "qin";
        
        //boolean bExistePalabra = BuscarPalabra(Lista, palabra1);
        
                
        //Lista.BuscarIndice(0).printAdjacencyList();
        
        //Funcion de Inicializacion de los visitados.
        //Recorrrer la lista principal y colocar como setVisitado(false)
        //Luego desde cada item navegar por los adyacentes.
        //Antes de cada palabra hay que inicializar.
        
        //Funcion de Busqueda(Lista, palabra)
        ListaDoble ListaPalabra = new ListaDoble();
        ListaPalabra.AgregarFinal("q");
        ListaPalabra.AgregarFinal("i");
        ListaPalabra.AgregarFinal("n");
        ListaPalabra.AgregarFinal("r"); //A -> M -> O -> R
        
        //Lista.Asignaciondeindice();
        boolean bExistePalabra = BuscarPalabra(Lista, palabra5);
        if (!bExistePalabra)
            System.out.println("La palabra no está en la sopa de letras.");
        
        //Posicion PosicionLetra = BuscarPrimeraLetra(Lista, ListaPalabra.BuscarIndice(0));
        //System.out.println(PosicionLetra.getPosFila());
        //System.out.println(PosicionLetra.getPosColumna());
        
         //adyacentes por posicion
        
        // Lista de nodos adyacentes a fila=0,col=0
        int fila = 1;
        int col = 3;
        //Nodo (0,0) 
        NodoDoble NodoActual = Lista.BuscarIndice(col);
        //Lista.Imprimir();
        ListaDoble ListaAdy = new ListaDoble();
        if (fila==0) 
        {//a
            if (col==0 || col==3)
            {
                if (col==0)
                {
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData()); //s
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().getpFirst().getData()); //m
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().getpFirst().getData()); //e
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().getpFirst().getData()); //i
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getListaAdy().getpFirst().getData()); //p
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getData()); //o
                    ListaAdy.Imprimir();
                }
            }
            else //col = 1 || col = 2
            {
                if (col==1){ //s
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpPrev().getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                }
                else
                { //o
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());//l
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());//i
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());//p
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());//m
                    ListaAdy.Imprimir();
                    
                }
            }
        }
        if (fila==3)
        {
            if (col==0 || col==3)
            {
                if (col==0){ //u
                    ListaAdy.AgregarFinal(NodoActual.getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getListaAdy().BuscarIndice(fila-1).getData());    
                    ListaAdy.Imprimir();
                }
                else{//r
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
            else { //col 1 || col=2
                if (col==1){//n
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());            
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); 
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else{//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());            
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); 
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }            
            }   
        }

        if(fila==1)
        {
            if(col==1 ||col==2)
            {
                if(col==1){//m
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else{
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                    
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData()); //a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getData()); //s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData()); //m
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData()); //e
                    ListaAdy.AgregarFinal(NodoActual.getpNext().getData()); //s
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                } 
            }
        }

        if(fila==2)
        {
            if(col==1 ||col==2)
            {
                if(col==1)
                {//e
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());//a
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());//s
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
            else 
            { //col=0 || col=3
                if(col==0)
                {//s del lado
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col+1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.Imprimir();
                }
                else
                {
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila-2).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col).getListaAdy().BuscarIndice(fila).getData());
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila).getData());        
                    ListaAdy.AgregarFinal(Lista.BuscarIndice(col-1).getListaAdy().BuscarIndice(fila-1).getData());
                    ListaAdy.Imprimir();
                }
            }
        }   
       
    
         
//          //dfs

        int contadorprincipal = 0; //contador que me hace moverme en la lista principal
        int contadorv = 1; //contador que me hace moverme en las listad ady
        int contadorletraoficial = 0; // contador en la palabra1 o 2 o 3
        int contadorinady = 0; // para usar la otra forma y no confundir contadores
        
        if(Lista.BuscarIndice(0).getData().equals(palabra1.charAt(0))){ //comienzo en "a" como primer elemento y la comparo con mi letra e la posicion 0 de la palabra 1 que es amor, le digo el nodo en el que comienza
            while(Lista.getSize()<=4 && Lista.BuscarIndice(contadorprincipal).getListaAdy().getSize()<=3){
            if(Lista.BuscarIndice(0).getListaAdy().BuscarIndice(contadorv).getData().equals(palabra1.charAt(contadorletraoficial))){
                System.out.println("letra coincide");
                contadorv++;
                contadorletraoficial++;
            } else if(!((Lista.BuscarIndice(0).getListaAdy().BuscarIndice(contadorv).equals(palabra1.charAt(contadorv))))){
                contadorprincipal++;
                contadorletraoficial++;
                Lista.BuscarIndice(contadorprincipal).getData().equals(palabra1.charAt(contadorletraoficial));
                System.out.println("letra coincide");
                
            }else{
                contadorprincipal++;
                Lista.BuscarIndice(contadorprincipal).getListaAdy().BuscarIndice(contadorinady).getData().equals(palabra1.charAt(contadorletraoficial));
                System.out.println("letra coincide");
                contadorv++;
                contadorprincipal++;
            }
            
        }
        }
        
    }
}
    
    


