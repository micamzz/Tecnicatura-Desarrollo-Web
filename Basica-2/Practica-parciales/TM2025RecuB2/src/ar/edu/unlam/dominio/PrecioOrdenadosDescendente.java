package ar.edu.unlam.dominio;

import java.util.Comparator;

public class PrecioOrdenadosDescendente implements Comparator <Double>{

	  @Override
	    public int compare(Double o1, Double o2) {
	        return  o1.compareTo(o2) * (-1); // o2.compareTo(o1); 
	    }
}
